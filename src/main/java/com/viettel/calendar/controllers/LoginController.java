/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.controllers;

import com.viettel.calendar.services.UserService;
import com.viettel.calendar.utils.DateUtils;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hieptran
 */
@Controller
@ComponentScan("com.viettel.calendar.services")
public class LoginController extends BaseController {
    @Autowired
    UserService userService;
    static Log logger = LogFactory.getLog(LoginController.class.getName());

    /**
     * both "normal login" and "login for update" shared this form.
     *
     * @param error
     * @param logout
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            HttpServletRequest request
    ) {
        if (request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null && !request.getUserPrincipal().getName().isEmpty()) {

            return new ModelAndView("redirect:/home");
        }
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Thông tin đăng nhập hoặc mật khẩu không đúng, hoặc tài khoản của bạn đã bị khóa!");
            //login form for update, if login error, get the targetUrl from session again.
            String targetUrl = getRememberMeTargetUrlFromSession(request);
            if (StringUtils.hasText(targetUrl)) {
                model.addObject("targetUrl", targetUrl);
                model.addObject("loginUpdate", true);
            }
        }
        if (logout != null) {
            model.addObject("msg", "Đã đăng xuất thành công.");
        }
        model.setViewName("login");
        return model;
    }

    /**
     * get targetURL from session
     */
    private String getRememberMeTargetUrlFromSession(HttpServletRequest request) {
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if (session != null) {
            targetUrl = session.getAttribute("targetUrl") == null ? "" : session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }
}
