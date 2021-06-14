package com.yaopeiyun.entities;

import java.io.Serializable;
import java.util.Date;

public class DailySum implements Serializable {

    Date date;
    double sum;

    public DailySum() {
    }

    public DailySum(Date date, double sum) {
        this.date = date;
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "DailySum{" +
                "date=" + date +
                ", sum=" + sum +
                '}';
    }
}
