package org.myproject.daoTests;

import org.junit.Test;
import org.myproject.repository.dao.JdbcDao.ProductJdbcDao;
import org.myproject.repository.entity.Product;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ProductJdbcDaoTest {

    private ProductJdbcDao productJdbcDao = ProductJdbcDao.getInstance();

    @Test
    public void addProduct() {
        Product product = Product
                .builder()
                .phoneModel("MyProduct")
                .dateOfIssue(LocalDate.of(2016, Month.JANUARY, 31))
                .productCharacteristic("3 GB,Camera Is absent")
                .price(15.43)
                //.brand(Brand.builder()
                  //      .id(7L)
                //        .build())
                .build();
        productJdbcDao.add(product);
        assertNotNull(product);

    }

    @Test
    public void deleteProduct() {
        Product product = Product.builder()
                .id(51L)
                .build();
        assertTrue(productJdbcDao.delete(product));
    }

    @Test
    public void getById(){
        Optional<Product> product = productJdbcDao.getById(3L);
        System.out.println(product);
    }

    //    @Test
//    public void updateTest(){
//        Product product = Product.builder()
//                .id(3L)
//                .phoneModel("XS")
//                .build();
//        System.out.println(product);
//    }
    @Test
    public void getAll(){
        List<Product> productList = productJdbcDao.getAll();
        System.out.println(productList);
        // assertNotNull(productList);
    }
}

