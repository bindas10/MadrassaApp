package com.example.myapplication;

public class Task_Details {

    private String id;
    private String name;
    private String range;
    private String last_para ;
    private String manzil;



    private String Date;

    public Task_Details(String Date,String id, String name, String range, String last_para, String manzil) {
        this.Date=Date;
        this.id = id;
        this.name = name;
        this.range = range;
        this.last_para = last_para;
        this.manzil = manzil;

    }
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getLast_para() {
        return last_para;
    }

    public void setLast_para(String last_para) {
        this.last_para = last_para;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }
}
