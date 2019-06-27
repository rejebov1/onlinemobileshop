package org.myproject.repository.dao.daoImpl;

import org.myproject.repository.dao.hibernateDao.SellerDao;
import org.myproject.repository.entity.Seller;
import org.springframework.stereotype.Repository;

@Repository("sellerDAO")
public class SellerDaoImpl extends GenericDaoImpl<Seller,Long> implements SellerDao {

    public SellerDaoImpl(){
        super(Seller.class);
    }
}
