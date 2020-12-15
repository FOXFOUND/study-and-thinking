package localDate.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;

import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

/***
 *
 * @Project : DHCServ
 * @Package : cn.dfcx.gbpserv.common.util
 * @Class : LocalDateTimeUtil
 * @Description : 日期工具类
 * @author : LinBoWen
 * @CreateDate : 2020-11-10 11:13:25
 * @version : V1.0.0
 * @Copyright : 2019 DFCX Inc. All rights reserved.
 * @Reviewed : 
 * @UpateLog :    Name    Date    Reason/Contents
 *             ---------------------------------------
 *                ****    ****    **** 
 *
 */

public class LocalDateTimeUtil {

    public static class DateTimeFormatterConst {
        public static final DateTimeFormatter dateTimeFormatterYYYYMM = DateTimeFormatter.ofPattern("yyyyMM");


    }

    /**
     * 将LocalDateTime转为long类型的timestamp
     *
     * @param localDateTime
     * @return
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 将long类型的timestamp转为LocalDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 格式化日期
     *
     * @param localDateTime
     * @param formatter
     * @return
     */
    public static String getDateFormatterStr(LocalDateTime localDateTime, DateTimeFormatter formatter) {
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        return localDateTime.format(formatter);
    }

    /***
     *
     * @Method : getLocalDateFromStr
     * @Description : 格式化日期
     * @param dateStr : 
     * @param formatter : 
     * @return : java.time.LocalDateTime
     * @author : LinBoWen
     * @CreateDate : 2020-11-10 14:04:12
     *
     */

    public static LocalDateTime getLocalDateFromStr(String dateStr, DateTimeFormatter formatter) {
        return LocalDateTime.parse(dateStr, formatter);
    }


    /***
     *
     * @Method : localDateBeforeYYYYMM
     * @Description : 日期比较
     * @param localDateTimeA : 
     * @param localDateTimeB : 
     * @return : boolean
     * @author : LinBoWen
     * @CreateDate : 2020-11-10 14:07:30
     *
     */

    public static boolean localDateBeforeYYYYMM(LocalDateTime localDateTimeA, LocalDateTime localDateTimeB) {
        if (localDateTimeA.getYear() < localDateTimeB.getYear()) {
            return true;
        }
        if (localDateTimeA.getMonthValue() < localDateTimeB.getMonthValue()) {
            return true;
        }
        return false;

    }
}
