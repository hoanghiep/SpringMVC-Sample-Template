/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.repositories;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author hieptran
 * @param <T>
 * @param <ID>
 */
public interface GenericRepository<T, ID extends Serializable> {
    
    /**
     * Lấy toàn bộ các bản ghi của một bảng
     * @return 
     */
    List<T> getAll();
    
    /**
     * Lấy bản ghi bởi khóa truyền vào
     * @param id
     * @return 
     */
    T getById(ID id);
    
    /**
    * Lấy bản ghi boi 1 thuoc tinh
    * @param idName
    * @param idValue
    * @return 
    */
    T getByProperty(String idName, Object idValue);
    /**
     * Lay danh sach ban ghi theo mot thuoc tinh
     * @param idName
     * @param idValue
     * @return 
     */
    List<T> getAllByProperty(String idName, Object idValue);
    /**
     * Tạo ra một bản ghi mới
     * @param t
     * @return 
     */
    ID create(T t);
    
    /**
     * Tạo mới bản ghi hoặc update nếu bản ghi đó đã tồn tại
     * @param t
     * @return 
     */
    T createOrUpdate(T t);
    
    /**
     * Cập nhập lại thông tin bản ghi vào database
     * @param t 
     */
    void update(T t);
    
    /**
     * Xóa bản ghi
     * @param id
     * @return 
     */
    boolean deleteById(ID id);
    
    /**
     * Xóa bản ghi
     * @param t
     * @return 
     */
    boolean delete(T t);
    
    /**
     * Lấy trường sắp xếp
     * @param sortField
     * @param boAlias
     * @return 
     */
    String getSortField(String sortField, String boAlias);
    
}
