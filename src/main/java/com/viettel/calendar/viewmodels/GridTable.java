/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.viewmodels;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author hieptran
 */
public class GridTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long nTotal;
    private List lstResult;
    private int currentPage;
    private int rowsPerPage;
    private int totalPage;
    private String sortField;

    public GridTable() {

    }

    public GridTable(Long nCount, List lstResult) {
        this.nTotal = nCount;
        this.lstResult = lstResult;
    }

    public GridTable(int nCount, List lstResult) {
        this.nTotal = Long.valueOf(nCount);
        this.lstResult = lstResult;
    }

    public GridTable(Long nTotal, List lstResult, int currentPage, int rowsPerPage, String sortField) {
        this.nTotal = nTotal;
        this.lstResult = lstResult;
        this.currentPage = currentPage;
        this.rowsPerPage = rowsPerPage;
        this.sortField = sortField;
//        this.totalPage = rowsPerPage == 0 ? 0 : nTotal.intValue() / rowsPerPage + 1;
        this.totalPage = rowsPerPage == 0 ? nTotal.intValue() : (nTotal.intValue() % rowsPerPage == 0 ? nTotal.intValue() / rowsPerPage : nTotal.intValue() / rowsPerPage + 1);// Hiepth6
    }

    public Long getnTotal() {
        return nTotal;
    }

    public void setnTotal(Long nTotal) {
        this.nTotal = nTotal;
    }

    public List getLstResult() {
        return lstResult;
    }

    public void setLstResult(List lstResult) {
        this.lstResult = lstResult;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
}
