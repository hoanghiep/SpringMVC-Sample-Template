/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.services;

import com.viettel.calendar.beans.Users;
import com.viettel.calendar.repositories.UserRepository;
import com.viettel.calendar.viewmodels.GridTable;
import com.viettel.calendar.viewmodels.UsersViewModel;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hieptran
 */
public interface UserService {

    List<Users> getActiveUser();
    @Service
    @Configuration
    @ComponentScan("com.viettel.calendar.repositories")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public class UserServiceImpl implements UserService {

        private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
        
        @Autowired
        UserRepository userRepo;
        
        @Override
        public List<Users> getActiveUser(){
            return userRepo.getActiveUser();
        }
    }
}
