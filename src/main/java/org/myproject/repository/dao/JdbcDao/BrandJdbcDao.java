package org.myproject.repository.dao.JdbcDao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.myproject.repository.entity.Brand;
import org.myproject.repository.exception.DaoException;
import org.myproject.repository.daoUtil.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
@SuppressWarnings("Duplicates")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandJdbcDao {
    private static final BrandJdbcDao INSTANCE = new BrandJdbcDao();

    private static final String ADD = "insert into brand (name, country) values (?,?)";

    private static final String DELETE_BRAND_ID = "DELETE FROM product WHERE brand_id = ?";
    private static final String DELETE = "DELETE FROM brand WHERE id = ?";

    private static final String GET_BY_ID = "SELECT id ,name,country from brand where id = ?";

    public static BrandJdbcDao getInstance() {
        return INSTANCE;
    }

    public Optional<Brand> getById(Long id){
        Brand brand = null;
        try (Connection connection = DataBaseUtil.getDataSource().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                brand = Brand.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .country(resultSet.getString("country"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(brand);
    }

    public Long add(Brand brand) {
        Long id = null;
        try (Connection connection = DataBaseUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD,
                     RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,brand.getName());
            preparedStatement.setString(2, brand.getCountry());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
                brand.setId(id);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return id;
    }

    public boolean delete(Brand brand) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement deleteBrandIdPs = null;
        PreparedStatement deletePs = null;
        try  {
            connection = DataBaseUtil.getDataSource().getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            deleteBrandIdPs = connection.prepareStatement(DELETE_BRAND_ID);
            deleteBrandIdPs.setLong(1, brand.getId());
            deleteBrandIdPs.executeUpdate();

            deletePs = connection.prepareStatement(DELETE);
            deletePs.setLong(1,brand.getId());
            deletePs.executeUpdate();
            connection.commit();

            result = true;
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new DaoException(e);
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();

                }
                if (deleteBrandIdPs != null) {
                    deleteBrandIdPs.close();

                }
                if (deletePs != null) {
                    deletePs.close();

                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
        return result;
    }
}
