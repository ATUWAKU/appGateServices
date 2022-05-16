package com.appgate.prueba.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ToolsTime {

    public static String consultTime(String timezoneId) {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm");
        formatter.setCalendar(Calendar.getInstance(TimeZone.getTimeZone(timezoneId)));
        return formatter.format(new Date());
    }
}
