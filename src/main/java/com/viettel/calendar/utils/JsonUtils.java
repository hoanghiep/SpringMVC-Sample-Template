/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author hiepth6
 */
public final class JsonUtils {

    /**
     * Chyển từ string sang object
     * @param <T>
     * @param jsonData
     * @param typeOfT
     * @return 
     * @throws java.io.IOException 
     */
    public static <T> T deserialize(String jsonData, Class<T> typeOfT) throws IOException{
        if(jsonData == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonData, typeOfT);
    }
    
    /**
     * Chuyển từ object sang string
     * @param <T>
     * @param objData
     * @param typeOfT
     * @return 
     * @throws java.io.UnsupportedEncodingException 
     */
    public static <T> String serialize(Object objData, Class<T> typeOfT) throws UnsupportedEncodingException, IOException{
        String output;
        if(objData == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        mapper.writeValue(os, typeOfT );
        output = new String(os.toByteArray(),"UTF-8");
        return output;
    }
}
