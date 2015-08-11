/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.repositories;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author hieptran
 */
public class OrderList {
    
    private List<Order> orders;
    
    public OrderList add(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();            
        }
        orders.add(order);
        return this;
    }
    
    public List<Order> getOrders() {
        return orders;
    }
}
