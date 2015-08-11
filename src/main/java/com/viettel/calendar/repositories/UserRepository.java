/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.repositories;

import com.viettel.calendar.beans.Users;
import com.viettel.calendar.repositories.GenericRepository;
import com.viettel.calendar.repositories.GenericRepositoryImpl;
import com.viettel.calendar.utils.Constants;
import com.viettel.calendar.utils.StringUtils;
import com.viettel.calendar.viewmodels.GridTable;
import com.viettel.calendar.viewmodels.UsersViewModel;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hieptran
 */
public interface UserRepository extends GenericRepository<Users, Long> {

    List<Users> getActiveUser();

    public Users getByUserName(String username);
    @Repository
    public class UserRepositoryImpl extends GenericRepositoryImpl<Users, Long> implements UserRepository {

        private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

        @Override
        public List<Users> getActiveUser() {
            try {
                String sql = "SELECT u FROM Users u WHERE u.status = 1";
                return getSession().createQuery(sql).list();
            } catch (Exception e) {
                logger.error("UserRepositoryImpl::getActiveUser::" + e.getMessage(), e.getMessage());
            }
            return null;
        }

        @Override
        public Users getByUserName(String username) {
            try {
                String sql = "SELECT u FROM Users u WHERE u.userName = ?";
                List list = getSession().createQuery(sql).setParameter(0, username).list();
                if(list != null && !list.isEmpty()){
                    return (Users)list.get(0);
                }
            } catch (Exception e) {
                logger.error("UserRepositoryImpl::getByUserName::" + e.getMessage(), e.getMessage());
            }
            return null;
        }
    }
}
