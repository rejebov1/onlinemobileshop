package org.myproject.repository.dao.daoImpl;


import org.myproject.repository.dao.hibernateDao.GoodInOrderDao;
import org.myproject.repository.entity.GoodInOrder;
import org.springframework.stereotype.Repository;

@Repository("goodInOrderDao")
public class GoodInOrderDaoImpl extends GenericDaoImpl<GoodInOrder,Long> implements GoodInOrderDao {

    public GoodInOrderDaoImpl(){
        super(GoodInOrder.class);

    }
}
