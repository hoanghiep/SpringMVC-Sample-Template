/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Đây là service đặc biệt, phụ trách việc quản lý quyền và phân quyền đối với các action trên controller
 * xem thêm mở MainController.java
 * @author hieptran
 */
public interface ActionPermitService {

    public boolean allow();

    public boolean deny();
    
    public boolean allowFoo(String foo);

    @Component(value = "actionPermitService")
    @Service
    @Configuration
    public class ActionPermitServiceImpl implements ActionPermitService {

        @Override
        public boolean allow() {
            return true;
        }

        @Override
        public boolean deny() {
            return false;
        }

        @Override
        public boolean allowFoo(String foo) {
            return "foo".equals(foo);
        }
    }
}
