package com.ruoyi.system.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime{
    Date date = new Date();
    SimpleDateFormat timetimeT = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat yearT = new SimpleDateFormat ("yyyy");
    SimpleDateFormat monthT = new SimpleDateFormat ("MM");
    SimpleDateFormat dayT = new SimpleDateFormat ("dd");
    SimpleDateFormat timeT = new SimpleDateFormat ("hh:mm:ss");
    private String timetime=timetimeT.format(date);
    private String year=yearT.format(date);
    private String month=monthT.format(date);
    private String day=dayT.format(date);
    private String time=timeT.format(date);
    public String getTimetime() {
        return timetime;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "date=" + date +
                ", yearT=" + yearT +
                ", monthT=" + monthT +
                ", dayT=" + dayT +
                ", timeT=" + timeT +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
