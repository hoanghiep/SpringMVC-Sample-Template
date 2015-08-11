/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hiepth6
 */
public class StringUtils {
    
    /**
     * 
     * @param input
     * @return 
     */
    public static String reverse(String input){
        if(input == null || input.isEmpty()){
            return input;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = input.length() - 1; i >= 0;i--){
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
    
    public static String toLowerCase(String input) {
        if (input == null) {
            return null;
        } else {
            return input.toLowerCase();
        }
    }
    public static String convertToLikeString(String source) {
        if (source == null) {
            return "";
        }

        source = source.trim().toLowerCase();
        String des = "";
        Boolean isSpecial;

        char[] specialChar = {'%', '_', '?', '\''};
        for (int i = 0; i < source.length(); i++) {
            isSpecial = false;
            for (int j = 0; j < specialChar.length; j++) {
                if (specialChar[j] == source.charAt(i)) {
                    isSpecial = true;
                    break;

                }
            }
            if (isSpecial) {
                des = des + '!' + source.charAt(i);
            } else {
                des = des + source.charAt(i);
            }

        }
        return des;
    }

    /**
     * Split String to List of long by separator
     * @param strInput
     * @param separator
     * @return 
     */
    public static List<Long> splitStringToLong(String strInput, String separator){
        List<Long> lstResult = new ArrayList<Long>();
        if(strInput !=null && !strInput.isEmpty()){
            String[] strTemp = strInput.split(separator);
            if(strTemp!=null && strTemp.length > 0){
                for(int i =0; i<strTemp.length; i++){
                    lstResult.add(Long.valueOf(strTemp[i]));
                }
            }
            return lstResult;
        }
        return null;
    }
}
