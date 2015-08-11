/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.controllers;

import com.viettel.calendar.auth.AuthUtils;
import com.viettel.calendar.beans.Users;
import com.viettel.calendar.services.UserService;
import com.viettel.calendar.utils.Constants;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hieptran
 */
@Controller
@ComponentScan("com.viettel.calendar.services")
public class MainController extends BaseController {
    
    @Autowired
    UserService userService;
    
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    
    @RequestMapping(value = {"/welcome", "", "/"}, method = RequestMethod.GET)
    @Transactional
    public String defaultPage() {
        if (AuthUtils.getAuthentication().isAuthenticated()) {
        }
        return "welcome";
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    @Transactional
    public String homePage(HttpServletRequest request) {
        return "home";
    }

    /**
     * Các ví dụ minh họa sử dụng @PreAuthorize
     * Đặc biệt chú ý rằng ngoài các hàm cơ bản như @PreAuthorize("hasRole('ROLE_ADMIN')") 
     * hay xem thêm ở http://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html
     * Ta hoàn toàn có thể kết hợp các điều kiện để có thể có cách check quyền đúng và phù hợp với các action có trong controller
     * ví dụ như sau @PreAuthorize(value = "hasRole('ROLE_ADMIN') and @actionPermitService.allowFoo(#foo)")
     * Tất cả các hàm phân quyền mở rộng đều phải được viết trong ActionPermitService.java
     * Dưới đây là một số ví dụ về cách sử dụng @PreAuthorize để tham khảo
     */
    
    /**
     * Không cho bất cứ ai, kể cả đối tượng đã đăng nhập request tới method này
     * @return 
     */
    @RequestMapping(value = {"/nooneAccess"}, method = RequestMethod.GET)
    @PreAuthorize(value = "@actionPermitService.deny()")
    public String nooneAccess() {
        return "welcome";
    }

    /**
     * Cho tất cả mọi người, kể cả đối tượng chưa đăng nhập request đến method này
     * @return 
     */
    @RequestMapping(value = {"/everyoneAccess"}, method = RequestMethod.GET)
    @PreAuthorize(value = "@actionPermitService.allow()")
    public String everyoneAccess() {
        return "welcome";
    }

    /**
     * Chỉ cho request của foo = "foo" đến method này
     * @param foo
     * @return 
     */
    @RequestMapping(value = {"/fooAccess/{foo}"}, method = RequestMethod.GET)
    @PreAuthorize(value = "@actionPermitService.allowFoo(#foo)")
    public String fooAccess(@PathVariable String foo) {
        return "welcome";
    }
}
