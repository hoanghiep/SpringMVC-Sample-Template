/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author hieptran
 */
public final class DateUtils {

    /**
     * Lấy giờ hiện tại của hệ thống
     *
     * @return
     */
    public static Date now() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    /**
     * Ngày đầu tiên của tuần chứa ngày truyền vào
     *
     * @param date
     * @return
     */
    public static Date startOfWeek(Date date) {
        if (date == null) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        System.out.println("Today:  " + c.getTime());
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date start = c.getTime();
        return newDate(start.getYear(), start.getMonth(), start.getDay(), 0, 0, 0);
    }

    /**
     * Ngày cuối tuần của tuần chứa ngày truyền vào
     *
     * @param date
     * @return
     */
    public static Date endOfWeek(Date date) {
        if (date == null) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        System.out.println("Today:  " + c.getTime());
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date start = c.getTime();
        return newDate(start.getYear(), start.getMonth(), start.getDay(), 23, 59, 59);
    }

    /**
     * Ngày đầu tiên của tháng có chứa ngày truyền vào
     *
     * @param date
     * @return
     */
    public static Date startOfMonth(Date date) {
        if (date == null) {
            return date;
        }
        return newDate(date.getYear(), date.getMonth(), 1, 0, 0, 0);
    }

    /**
     * Ngày cuối cùng của tháng có chứa ngày truyền vào
     *
     * @param date
     * @return
     */
    public static Date endOfMonth(Date date) {
        if (date == null) {
            return date;
        }
        Date start = newDate(date.getYear(), date.getMonth(), 1, 0, 0, 0);
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.SECOND, -1);
        return cal.getTime();
    }

    /**
     * Chuyển ngày tháng sang string
     *
     * @param format
     * @param date
     * @return
     */
    public static String toString(String format, Date date) {
        if (format == null || format.isEmpty()) {
            return format;
        }
        if (date == null) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * Lấy ngày giờ hiện tại của hệ thống
     *
     * @param format
     * @return
     */
    public static String currentDateStr(String format) {
        return toString(format, now());
    }

    /**
     * Lấy thứ ở trong tuần
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    /**
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param sencond
     * @return
     */
    public static Date newDate(int year, int month, int day, int hour, int minute, int sencond) {
        if (month >= 1) {
            month = month - 1;
        }
        return new Date(year + 1900, month, day, hour, minute, sencond);
    }

    /**
     *
     * @param date
     * @return
     */
    public static Date truncDateTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     *
     * @param date
     * @return
     */
    public static Date truncDateTimeAndAddOneDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        
        cal.add(Calendar.DAY_OF_MONTH, 1);
        
        return cal.getTime();
    }

    /**
     * Chuyển string sang date
     *
     * @param formatDate
     * @param stringDate
     * @return
     * @throws ParseException
     */
    public static Date toDate(String formatDate, String stringDate) throws ParseException {
        if (stringDate == null || stringDate.isEmpty()) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(formatDate);
        return format.parse(stringDate);
    }

    /**
     * Convet string date truyền từ client lên server
     *
     * @param stringDate
     * @return
     * @throws java.text.ParseException
     */
    public static Date toServerDate(String stringDate) throws ParseException {
        if (stringDate == null || stringDate.isEmpty()) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT_DATE_TIME_SYSTEM);
        return format.parse(stringDate);
    }

    /**
     * Chuyển ngày tháng sang string
     *
     * @param format
     * @param date
     * @return
     */
    public static String toString(Date date, String format) {
        if (format == null || format.isEmpty()) {
            return format;
        }
        if (date == null) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * Thêm năm vào cho ngày tháng hiện tại
     *
     * @param date
     * @param numberOfYear
     * @return
     */
    public static Date addYear(Date date, int numberOfYear) {
        if (numberOfYear == 0) {
            return date;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, numberOfYear);
        date = cal.getTime();
        return date;
    }

    /**
     * Thêm ngày tháng
     *
     * @param date
     * @param numberOfMonth
     * @return
     * @deprecated
     */
    public static Date addMonth(Date date, int numberOfMonth) {
        if (numberOfMonth == 0) {
            return date;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, numberOfMonth);
        date = cal.getTime();
        return date;
    }

    /**
     *
     * @param date
     * @param numberOfDay
     * @return
     * @deprecated
     */
    public static Date addDay(Date date, int numberOfDay) {
        if (numberOfDay == 0) {
            return date;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, numberOfDay);
        date = cal.getTime();
        return date;
    }

    /**
     *
     * @param date
     * @param numberOfHour
     * @return
     * @deprecated
     */
    public static Date addHour(Date date, int numberOfHour) {
        if (numberOfHour == 0) {
            return date;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, numberOfHour);
        date = cal.getTime();
        return date;
    }

    /**
     *
     * @param date
     * @param numberOfMinute
     * @return
     * @deprecated
     */
    public static Date addMinute(Date date, int numberOfMinute) {
        if (numberOfMinute == 0) {
            return date;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, numberOfMinute);
        date = cal.getTime();
        return date;
    }

    /**
     *
     * @param date
     * @param numberOfSecond
     * @return
     * @deprecated
     */
    public static Date addSecond(Date date, int numberOfSecond) {
        if (numberOfSecond == 0) {
            return date;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, numberOfSecond);
        date = cal.getTime();
        return date;
    }
}
