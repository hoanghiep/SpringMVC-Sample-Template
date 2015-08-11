/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.api;

import com.viettel.calendar.extensions.AjaxUtils;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author hieptran
 * Mô tả cách viết các api, cấu hình crossdomain trong SercurityConfig.java chú ý ở đây chưa kiểm chứng khả năng crossdomain
 */
@Controller
@RequestMapping("/api/oauth")
public class OAuthController {
    
    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
            model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }
    
    @RequestMapping(value = "/getToken", method = RequestMethod.POST, produces = "application/json")
    @Transactional
    public @ResponseBody HashMap getToken(){
        return new HashMap();
    }
    
}
