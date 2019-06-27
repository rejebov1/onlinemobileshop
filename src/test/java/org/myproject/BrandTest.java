package org.myproject;

import org.hibernate.Session;
import org.junit.Test;
import org.myproject.daoTests.HibernateUtils;
import org.myproject.repository.dao.daoImpl.BrandDaoImpl;
import org.myproject.repository.dao.daoImpl.ProductDaoImpl;
import org.myproject.repository.entity.Brand;
import org.myproject.repository.entity.Product;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class BrandTest {

    //  private static SessionFactory SESSION_FACTORY;

//
//    @Before
//    public void init() {
//        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
//    }

    @Test
    public void addBrandAndProduct() {
//        Session session = SESSION_FACTORY.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Brand brand = new Brand();
//        brand.setName("BrandHiber");
//        brand.setCountry("CountryTest");
//        session.persist(brand);
//
//        Product product = new Product();
//        product.setPhoneModel("model");
//        product.setBrand(brand);
//        product.setDateOfIssue(LocalDate.now());
//        product.setPrice(1.1);
//        product.setProductCharacteristic("TestChar");
//        product.setId(product.getId());
//        session.save(brand);
//
//        transaction.commit();
//        session.close();

        Session session = HibernateUtils.getSessionFactory().openSession();

        ProductDaoImpl productDao = new ProductDaoImpl() {
            {
                this.sessionFactory = HibernateUtils.getSessionFactory();
            }
        };
        BrandDaoImpl userDao = new BrandDaoImpl() {{
            this.sessionFactory = HibernateUtils.getSessionFactory();
        }};


        Brand brand = new Brand();
        brand.setName("BrandHiber");
        brand.setCountry("CountryTest");
        session.persist(brand);

        Product product = new Product();
        product.setPhoneModel("model");
        product.setProductCharacteristic("testchar");
        product.setPrice(1.1);
        product.setDateOfIssue(LocalDate.now());
        product.setBrand(Brand.builder()
                .name("Name")
                .country("country")
                .build());

        session.beginTransaction();
        try {
            productDao.delete(product);
            assertTrue(productDao.getAll().contains(product));

            userDao.delete(brand);
            assertTrue(session.contains(brand));

        } finally {
            session.getTransaction().rollback();
        }
    }
}

//    @After
//    public void close() {
//        SESSION_FACTORY.close();
//    }

