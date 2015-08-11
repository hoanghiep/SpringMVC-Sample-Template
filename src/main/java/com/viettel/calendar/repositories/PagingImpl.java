/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.repositories;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

/**
 * https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/querycriteria.html
 * Criteria crit = sess.createCriteria(Cat.class);
 * @author hieptran
 * @param <T> 
 */
public class PagingImpl<T> implements Paging<T> {

    @Override
    public Page<T> getPage(int pageNumber, int pageSize, Criteria criteria) {
        return getPage(pageNumber, pageSize, criteria, null, null);
    }

    @Override
    public Page<T> getPage(int pageNumber, int pageSize, Criteria criteria, Projection projection) {
        return getPage(pageNumber, pageSize, criteria, projection, null);
    }

    @Override
    public Page<T> getPage(int pageNumber, int pageSize, Criteria criteria, OrderList orderList) {
        return getPage(pageNumber, pageSize, criteria, null, orderList);
    }

    @Override
    public Page<T> getPage(int pageNumber, int pageSize, Criteria criteria, Projection projection, OrderList orderList) {
        
        int totalSize = 0;
        if (pageSize > 0) {
            criteria.setProjection(Projections.rowCount());
            totalSize = ((Long) criteria.uniqueResult()).intValue();
            int startIndex = Page.getStartIndex(pageNumber, pageSize, totalSize);
            criteria.setFirstResult(startIndex);
            criteria.setMaxResults(pageSize);
        }
        if (projection != null) {
            criteria.setProjection(projection);
        } else {
            criteria.setProjection(null);
            criteria.setResultTransformer(Criteria.ROOT_ENTITY);
        }
        if (orderList != null) {
            for(Order order : orderList.getOrders()) {
                criteria.addOrder(order);              
            }
        }
        List<T> list = criteria.list();
        return new Page<>(pageNumber, pageSize, totalSize, list);
        
    }
    
}
