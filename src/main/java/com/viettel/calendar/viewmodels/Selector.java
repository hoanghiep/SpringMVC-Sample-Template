/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.viewmodels;

/**
 *
 * @author hieptran
 */
public class Selector {

    private String id;
    private String name;
    private String tags;

    public Selector() {
    }

    public Selector(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Selector(String id, String name, String tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }

    public Selector(Integer id, String name) {
        this.id = id + "";
        this.name = name;
    }
    
    public Selector(Long id, String name) {
        this.id = id + "";
        this.name = name;
    }
    
    public Selector(Long id, String name, String tags) {
        this.id = id + "";
        this.name = name;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

}
