package org.myproject.repository.dao.daoImpl;

import org.myproject.repository.dao.hibernateDao.ProductDao;
import org.myproject.repository.entity.Product;
import org.springframework.stereotype.Repository;

@Repository("productDAO")
public class ProductDaoImpl extends GenericDaoImpl<Product,Long> implements ProductDao {

    public ProductDaoImpl(){
        super(Product.class);
    }
}
