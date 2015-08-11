/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.UnsupportedEncodingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Encoder;
/**
 * Class lưu phần thông tin mở rộng của user đang đăng nhập
 * bở spring sercurity chỉ hỗ trợ lưu tài khoản và mật khẩu của user đang đăng nhập
 * nên cần class này để mở rộng thông tin đó ra
 * Cần lưu thêm thông tin gì thì khai báo ra ở đây và lấy + gán giá trị trong LoginUserDetailsService.java
 * @author hieptran
 */
public class LoginUserInfo implements  java.io.Serializable{
    
    private final Log logger = LogFactory.getLog(LoginUserInfo.class.getName()); 
    
    private Long userId;
    private String fullname;
    private String userName;
    private String positionName;
    private String userAlias;
    private String email;
    private String mobile;
  

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullName) {
        this.fullname = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Override
    public String toString(){
        try {
            if(this == null){
                return "{}";
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            String json = mapper.writeValueAsString(this);
            byte[] utf8Bytes = json.getBytes("UTF8");
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(utf8Bytes);
        } catch (UnsupportedEncodingException | JsonProcessingException ex) {
            logger.error("LoginUserInfo::toString::Exception::", ex);
        }
        return "{}";
    }
}
