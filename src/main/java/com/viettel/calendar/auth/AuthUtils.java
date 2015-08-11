/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 
 * Class cung cấp các phương pháp xác định người dùng đã đăng nhập hay chưa và
 * nếu người dùng đã đăng nhập thì lấy thông tin cơ bản về người dùng
 * ? Vậy làm sao để bổ sung thêm thông tin cần thiết trong quá trình phát triển
 * Bước 1: Tạo trường dữ liệu trong LoginUserInfo đây là object chứa thông tin 
 * đầy đủ của người đang đăng nhập
 * Bước 2: Tìm đến file LoginUserDetailsService xem hàm loadUserByUsername và
 * lấy dữ liệu để bổ sung cho trường vừa thêm ở bước 1
 * Bước 3: Có thể vào file này để viết 1 hàm get, nếu không có thể gọi hàm
 * AuthUtils.getCurrentUserInfo() rồi get tiếp giá trị khác
 * 
 * @author hieptran
 */
public class AuthUtils {
    
    static Log logger = LogFactory.getLog(AuthUtils.class.getName());
    /**
     *
     * @return 
     */
    public static Authentication getAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth;
    }
    
    /**
     * 
     * @return 
     */
    public static String getCurrentUsername(){
        Authentication auth = getAuthentication();
        if(auth != null){
            return auth.getName();
        }
        return null;
    }
    
    /**
     * 
     * @return 
     */
    public static LoginUser getCurrentUser(){
        LoginUser user = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
    
    /**
     * Lấy thông tin về người dùng đang đăng nhập
     * @return 
     */
    public static LoginUserInfo getCurrentUserInfo(){
        LoginUser user = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user != null){
            return user.getLoginUserInfo();
        }
        return null;
    }
    
    /**
     * Lấy thông tin về người dùng đang đăng nhập
     * @return 
     */
    public static Long getCurrentUserId(){
        LoginUser user = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user != null){
            return user.getLoginUserInfo().getUserId();
        }
        return null;
    }
    
    /**
     * Lấy thông tin về người dùng đang đăng nhập
     * @return 
     */
    public static String getCurrentUserName(){
        LoginUser user = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user != null){
            return user.getLoginUserInfo().getUserName();
        }
        return null;
    }
    
    public static String getCurrentFullName(){
        LoginUser user = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user != null){
            return user.getLoginUserInfo().getFullname();
        }
        return null;
    }
    
    /**
     * 
     * @return 
     */
    public static boolean isAuthenticated(){
        Authentication auth = getAuthentication();
        if(auth == null){
            return false;
        }
        return auth.isAuthenticated();
    }
}
