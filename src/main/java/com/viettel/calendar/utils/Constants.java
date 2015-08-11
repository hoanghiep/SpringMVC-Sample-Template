/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.utils;

/**
 *
 * @author hieptran
 */
public final class Constants {

    public static final String FORMAT_DATE_SYSTEM = "dd/MM/yyyy";
    public static final String FORMAT_DATE_TIME_SYSTEM = "dd/MM/yyyy HH:mm";
    
    public interface HTTP_STATUS_CODE {

        public static final int SUCCESS = 200;      // Thành công
        public static final int NOT_SUCCESS = 0;      // Khong Thành công
        public static final int NOT_EXIST = -1;      // Du lieu khong ton tai
        public static final int NOT_MODIFIED = 304; // Dữ liệu bị trùng khi update
        public static final int BAD_REQUEST = 400;  // Validate form truyền lên lỗi
        public static final int FORBIDDEN = 403;    // Không có quyền xử lý
        public static final int NOT_FOUND = 404;    // Không tìm thấy thông tin
        public static final int SERVER_ERROR = 500; // Lỗi server - exception
    }
}
