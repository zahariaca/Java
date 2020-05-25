package com.zahariaca.ooptest.date;

/**
 * Created by azaharia on 31.05.2016.
 */
public class Date {
    private int day;
    private int month;
    private int year;
    private String date = "";

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDate(){
        if (day >= 0 && day <= 9){
            date += "0"+day +"/";
        }else{
            date += day + "/";
        }
        if (month >=0 && month <=9){
            date+= "0"+month+"/";
        }else{
            date +=month +"/";
        }
        date += year;
    }

    public String toString(){
        return "[ " +date+ " ]";
    }
}
