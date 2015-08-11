/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.auth;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 * Object chứa thông tin đăng nhập của người dùng nếu cần thêm trường gì thì mở rộng ở đây (xem ví dụ trường user)
 * sau đó tìm đến LoginUserDetailsService.java rồi truyền giá trị cho phần mở rộng qua hàm khởi tạo
 * Muốn lấy giá trị ở jsp thì dùng <sec:authentication property="principal.user"/>
 * với sec là <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 * @author hieptran
 */
public class LoginUser extends org.springframework.security.core.userdetails.User{

    private LoginUserInfo loginUserInfo;
    
    public LoginUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, LoginUserInfo user) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.loginUserInfo = user;
    }

    public LoginUserInfo getLoginUserInfo() {
        return loginUserInfo;
    }

    public void setLoginUserInfo(LoginUserInfo loginUserInfo) {
        this.loginUserInfo = loginUserInfo;
    }
    
}
