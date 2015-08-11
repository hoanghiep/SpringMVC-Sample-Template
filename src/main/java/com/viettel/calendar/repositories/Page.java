/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.repositories;

import java.util.List;

/**
 * Hỗ trợ phân trang
 * @author hieptran
 * @param <T>
 */
public class Page<T>  {
    
    private int pageNumber;
    private int pageSize;
    private int total;
    private List<T> list;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    
    public static int getStartIndex(int pageNumber, int pageSize, int totalSize) {
        return pageNumber * pageSize;
    }

    /**
     * ctor
     */
    public Page(){
        
    }
    
    /**
     * ctor
     * @param pageNumber
     * @param pageSize
     * @param total
     * @param list 
     */
    public Page(int pageNumber, int pageSize, int total, List<T> list){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }
}
