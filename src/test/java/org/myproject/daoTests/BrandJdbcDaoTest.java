package org.myproject.daoTests;

import org.junit.Assert;
import org.junit.Test;
import org.myproject.repository.dao.JdbcDao.BrandJdbcDao;
import org.myproject.repository.entity.Brand;

public class BrandJdbcDaoTest {
    private static final Long BRAND_ID = 4L;
    private BrandJdbcDao brandJdbcDao = BrandJdbcDao.getInstance();


    @Test
    public void addBrand(){
        Brand brand = Brand.builder()
                .name("Samsung")
                .country("North Korea")
                .build();
        BrandJdbcDao.getInstance().add(brand);
        System.out.println(brand);

    }
    @Test
    public void deleteBrand(){
        Brand brand = Brand.builder()
                .id(11L)
                .build();
        Assert.assertTrue(brandJdbcDao.delete(brand));
    }

    @Test
    public void getById(){
        System.out.println(BrandJdbcDao.getInstance().getById(BRAND_ID));

    }
}
