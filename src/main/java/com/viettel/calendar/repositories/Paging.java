/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.repositories;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;

/**
 *
 * @author hieptran
 * @param <T>
 */
public interface Paging<T> {
    public Page<T> getPage(int pageNumber, int pageSize, Criteria criteria);
    public Page<T> getPage(int pageNumber, int pageSize, Criteria criteria, Projection projection);
    public Page<T> getPage(int pageNumber, int pageSize, Criteria criteria, OrderList orderList);
    public Page<T> getPage(int pageNumber, int pageSize, Criteria criteria, Projection projection, OrderList orderList);
}
