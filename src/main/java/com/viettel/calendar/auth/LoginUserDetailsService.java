/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.auth;

import com.viettel.calendar.beans.Users;
import com.viettel.calendar.repositories.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class nắm giữ thông tin người dùng để spring thực hiện công việc đăng nhập
 * @author hieptran
 */
@Configuration
@ComponentScan("com.viettel.calendar.repositories")
@Service("userDetailsService")
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        Users user = userRepo.getByUserName(username);
        if(user == null || user.getStatus().intValue() == 0){
            return null;
        }
        List roles = new ArrayList<>();
        roles.add("ROLE_USER");
        List<GrantedAuthority> authorities = buildUserAuthority(roles);
                
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        // Thêm thông tin user ở đây
        return buildUserForAuthentication(user, authorities, loginUserInfo);
        
    }

    private UserDetails buildUserForAuthentication(Users user, List<GrantedAuthority> authorities, LoginUserInfo loginUserInfo) {
        
        return new LoginUser(user.getUserName(), user.getUserName() + "|" + user.getPassword(), true, true, true, true, authorities, loginUserInfo);
    }

    private List<GrantedAuthority> buildUserAuthority(List<String> roles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();
        // Build user's authorities
        for (String role : roles) {
            setAuths.add(new SimpleGrantedAuthority(role));
        }
        List<GrantedAuthority> result = new ArrayList<>(setAuths);
        return result;
    }

}
