/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.controllers;

import com.viettel.calendar.auth.AuthUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hieptran
 */
@Controller
@ComponentScan("com.viettel.calendar.services")
public class CustomErrorController {
    static Log logger = LogFactory.getLog(CustomErrorController.class.getName());
    @RequestMapping(value = {"/405"}, method = RequestMethod.GET)
    @Transactional
    public String page405() {
        if (AuthUtils.getAuthentication().isAuthenticated()) {
        }
        return "405";
    }
    @RequestMapping(value = {"/500"}, method = RequestMethod.GET)
    @Transactional
    public String page500() {
        if (AuthUtils.getAuthentication().isAuthenticated()) {
        }
        return "500";
    }
    @RequestMapping(value = {"/404"}, method = RequestMethod.GET)
    @Transactional
    public String page404() {
        if (AuthUtils.getAuthentication().isAuthenticated()) {
        }
        return "404";
    }
}
