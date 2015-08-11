/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.utils;

import java.util.ResourceBundle;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author hiepth6
 */
public class LocaleUtils {
    static Log logger = LogFactory.getLog(LocaleUtils.class.getName());
    /**
     * Lấy ra ngôn ngữ từ file bundle
     * @param httpServletRequest Là request hiện tại
     * @param code Là ký hiệu trong file messages_xx.properties
     * @return 
     */
    public static String getMessage(HttpServletRequest httpServletRequest, String code){
        Cookie[] cookies = httpServletRequest.getCookies();
        String locale = "en";
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("workbenchLocaleCookie".equals(name)){
                    locale = cookie.getValue();
                    break;
                }
            }
        }
        try {
            ResourceBundle resource = ResourceBundle.getBundle("messages_" + locale);
            String m = resource.getString(code);
            return m;
        } catch (Exception ex) {
            logger.error("LocaleUtils::getMessage::Exception::", ex);
            return code;
        }
    }
}
