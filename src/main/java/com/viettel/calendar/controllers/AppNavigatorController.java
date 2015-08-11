/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hieptran
 */
@Controller
@ComponentScan("com.viettel.calendar.services")
public class AppNavigatorController extends BaseController{

    /*
     * Quản lý người dùng      
     */
    @RequestMapping(value = {"/admin/users"}, method = RequestMethod.GET)
    public String defaultPage() {        
        return "/admin/users";
    }
    
    /*
     * Danh mục chức vụ      
     */
    @RequestMapping(value = {"/admin/positions"}, method = RequestMethod.GET)
    public String positionPage() {        
        return "/admin/positions";
    }
    
    /*
     * Danh mục menu      
     */
    @RequestMapping(value = {"/admin/menu"}, method = RequestMethod.GET)
    public String menuPage() {
        return "/admin/menu";
    }
    
    /*
     * Danh mục độ mật văn bản      
     */
    @RequestMapping(value = {"/admin/docsecuritytype"}, method = RequestMethod.GET)
    public String docsecuritytypePage() {
        return "/admin/doc-security-type";
    }
    
    /*
     * Danh mục phòng ban      
     */
    @RequestMapping(value = {"/admin/departments"}, method = RequestMethod.GET)
    public String departmentPage() {
        return "/admin/departments";
    }
    
    /*
     * Danh mục loại văn bản     
     */
    @RequestMapping(value = {"/admin/doctype"}, method = RequestMethod.GET)
    public String docTypePage() {
        return "/admin/doc-type";
    }
    
    /*
     * Danh mục độ khẩn      
     */
    @RequestMapping(value = {"/admin/urgency"}, method = RequestMethod.GET)
    public String urgencyPage() {
        return "/admin/urgency";
    }
    
    /*
     * Danh mục đơn vị ngoài    
     */
    @RequestMapping(value = {"/admin/unit"}, method = RequestMethod.GET)
    public String unitPage() {
        return "/admin/unit";
    }
    
    /*
     * Danh mục loại phòng/ban     
     */
    @RequestMapping(value = {"/admin/depttype"}, method = RequestMethod.GET)
    public String depttypePage() {
        return "/admin/department-type";
    }
    
    /*
     * Danh mục vai trò      
     */
    @RequestMapping(value = {"/admin/roles"}, method = RequestMethod.GET)
    public String rolePage() {
        return "/admin/roles";
    }
    
    /*
     * Danh mục sổ văn bản      
     */
    @RequestMapping(value = {"/admin/books"}, method = RequestMethod.GET)
    public String booksPage() {
        return "/admin/books";
    }
    
    @RequestMapping(value = {"/admin/actions"}, method = RequestMethod.GET)
    public String actionPage(){
        return "/admin/actions";
    }
    
    @RequestMapping(value = {"/admin/menurole"}, method = RequestMethod.GET)
    public String menuRolePage(){
        return "/admin/menu-role";
    }
    
    @RequestMapping(value = {"/admin/menuroleaction"}, method = RequestMethod.GET)
    public String menuRoleActionPage(){
        return "/admin/menu-role-action";
    }
    
    @RequestMapping(value = {"/admin/menurolegraph"}, method = RequestMethod.GET)
    public String menuRoleGraphPage(){
        return "/admin/menu-role-graph";
    }
    
    @RequestMapping(value = {"/admin/actiontype"}, method = RequestMethod.GET)
    public String actionTypePage(){
        return "/admin/action-type";
    }
    
    @RequestMapping(value = {"/admin/docstatus"}, method = RequestMethod.GET)
    public String docStatusPage(){
        return "/admin/doc-status";
    }
    
    @RequestMapping(value = {"/admin/holiday"}, method = RequestMethod.GET)
    public String holidayPage(){
        return "/admin/holiday";
    }
    
    @RequestMapping(value = {"/admin/doctransfertree"}, method = RequestMethod.GET)
    public String docTransferTreePage(){
        return "/admin/doc-transfer-tree";
    }
    
    @RequestMapping(value = {"/admin/dttrole"}, method = RequestMethod.GET)
    public String dttRolePage(){
        return "/admin/doc-transfer-tree-role";
    }
    
    @RequestMapping(value = {"/admin/represention"}, method = RequestMethod.GET)
    public String representionPage(){
        return "/admin/represention";
    }
    
    /**
     * Văn bản đến
     * @return 
     */
    @RequestMapping(value = {"/home/docreceive"}, method = RequestMethod.GET)
    public String docReceivePage() {
        return "docreceive";
    }
}