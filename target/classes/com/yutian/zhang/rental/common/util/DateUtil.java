package com.yutian.zhang.rental.common.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * DateUtil
 *
 * @author pganssle
 * @date 2017/6/13 14:15
 */

public class DateUtil {
    /**
     * Get the date of the month after the startDate date
     *
     * @param startDate
     * @param month
     * @return
     */
    public static Date getMonthDate(Date startDate, int month) {
        LocalDateTime localDateTime = startDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime().plusMonths(month);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }

    public static int daysBetween(Date sendDate, Date startDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            sendDate = sdf.parse(sdf.format(sendDate));
            startDate = sdf.parse(sdf.format(startDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(sendDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(startDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

}
