package org.myproject.repository.dao.daoImpl;

import org.myproject.repository.dao.hibernateDao.BrandDao;
import org.myproject.repository.entity.Brand;
import org.springframework.stereotype.Repository;

@Repository("brandDao")
public class BrandDaoImpl extends GenericDaoImpl<Brand,Long> implements BrandDao {

    public BrandDaoImpl() {
        super(Brand.class);
    }
}
