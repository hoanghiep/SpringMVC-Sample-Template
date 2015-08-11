/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.utils;

import com.viettel.calendar.viewmodels.Selector;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author hieptran
 * Sử dụng để mã hóa và giải mã các dữ liệu không muốn để clear text trong tệp cấu hình
 */
public class Encrypt {

    private final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    String decodeUTF8(byte[] bytes) {
        return new String(bytes, UTF8_CHARSET);
    }

    byte[] encodeUTF8(String string) {
        return string.getBytes(UTF8_CHARSET);
    }

//    private static final String PASSWORD = "workbench";

    /**
     * Đưa mật khẩu vào đây để mã hóa trước khi triển khai ứng dụng
     *
     * @param args
     * @throws java.lang.Exception
     */
//    public static void main(String[] args) throws Exception {
//        System.out.println("-----------------------------");
//        System.out.println(BCrypt.checkpw("123456", "$2a$10$CNgNYfVnGyXVoiSY5J3j0.foSrt7fUlhyDZmrcokjDiFn8DIaAl/W"));
//        System.out.println("-----------------------------");
//        String jsonBill = "[{\"id\":13,\"name\":\"billid3\"}]";
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<Selector> bills = null;
//        try {
//            bills = mapper.readValue(jsonBill, new TypeReference<List<Selector>>() {});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("bills = " + bills.size());
//
//        String encryptedData = RSAEncrypt.encrypt(PASSWORD);
//        System.out.println("OUTPUT: " + encryptedData);
//        String decryptedData = RSAEncrypt.decrypt(encryptedData);
//        System.out.println("DECRYPT TEST: " + decryptedData);
//
//        FileUtils.getFileExtension("sdadasd.sdsad");
//    }
}
