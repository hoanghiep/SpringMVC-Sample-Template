/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.controllers;

import com.viettel.calendar.auth.AuthUtils;
import com.viettel.calendar.extensions.AjaxUtils;
import com.viettel.calendar.utils.Constants;
import com.viettel.calendar.utils.MultipleDateEditor;
import com.viettel.calendar.utils.MultipleSelectorEditor;
import com.viettel.calendar.utils.SelectorEditor;
import com.viettel.calendar.viewmodels.GridTable;
//import com.viettel.calendar.viewmodels.GridTable;
//import com.viettel.calendar.viewmodels.Selector;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.WebRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 *
 * @author sytv
 */
@Controller
@ComponentScan("com.viettel.calendar.services")
public class BaseController {
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MultipleDateEditor());
//        binder.registerCustomEditor(Selector.class, new SelectorEditor());
//        binder.registerCustomEditor(Selector[].class, new MultipleSelectorEditor());
    }
    
    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
        model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }

    private static final Logger logger =LoggerFactory.getLogger(BaseController.class);
    protected MessageSource messageSource;

    protected static final String RESULT_STATUS = "status";
    protected static final String RESULT_MESSAGE = "message";
    protected static final String RESULT_DATA = "data";
    private static final String RESULT_GRID_TOTAL_ROW = "totalRow";
    private static final String RESULT_GRID_ROWS = "rowsPerPage";
    private static final String RESULT_GRID_CURRENT = "currentPage";
    private static final String RESULT_GRID_TOTAL_PAGE = "totalPage";

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Load language key
     *
     * @param request
     * @param key
     * @return
     */
    public String getMessage(HttpServletRequest request, String key) {
        try {
            Cookie[] cookies = request.getCookies();
            String locale = "en";
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if ("workbenchLocaleCookie".equals(name)) {
                        locale = cookie.getValue();
                        break;
                    }
                }
            }
            return messageSource.getMessage(key, null, Locale.forLanguageTag(locale));

        } catch (Exception e) {
            logger.warn("Not found key:" + key);
            return key;
        }
    }

    public Long getUserId() {
        return AuthUtils.getCurrentUserId();
    }

    public String getFullname() {
        return AuthUtils.getCurrentUserInfo().getFullname();
    }
    
    public String getRoleCode(){
        return "";
    }

    //set error result of server
    public void setResultError(HashMap result, HttpServletRequest request) {
        result.put(RESULT_STATUS, Constants.HTTP_STATUS_CODE.SERVER_ERROR);
        result.put(RESULT_MESSAGE, getMessage(request, "message.error"));
    }

    // set return for grid table

    public void setResultGrid(HashMap result, GridTable grid, int status, String message) {
        result.put(RESULT_STATUS, status);
        result.put(RESULT_MESSAGE, message);
        if (grid != null) {
            result.put(RESULT_DATA, grid.getLstResult());
            result.put(RESULT_GRID_TOTAL_ROW, grid.getnTotal());
            result.put(RESULT_GRID_ROWS, grid.getRowsPerPage());
            result.put(RESULT_GRID_CURRENT, grid.getCurrentPage());
            result.put(RESULT_GRID_TOTAL_PAGE, grid.getTotalPage());
        }
    }
}
