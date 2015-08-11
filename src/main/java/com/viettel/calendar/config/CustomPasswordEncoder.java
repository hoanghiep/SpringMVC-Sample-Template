/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.config;

import org.springframework.security.crypto.password.PasswordEncoder;
/**
 *
 * @author hieptran
 */
public class CustomPasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence cs) {
        // Code mã hóa mật khẩu ở đây
        return "TRA VE MAT KHAU DA MA HOA";
    }

    @Override
    public boolean matches(CharSequence cs, String string) {
        // CS là mật khẩu người dùng nhập vào
        // string là chuỗi truyền vào 
        return false;
    }
    
}
