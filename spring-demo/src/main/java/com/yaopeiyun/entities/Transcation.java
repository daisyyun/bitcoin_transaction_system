package com.yaopeiyun.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Transcation implements Serializable {

    int id;
    int fromNodeNum;
    int toNodeNum;
    double value;
    Date date;

    public Transcation(int id, int fromNodeNum, int toNodeNum, double value, Date date) {
        this.id = id;
        this.fromNodeNum = fromNodeNum;
        this.toNodeNum = toNodeNum;
        this.value = value;
        this.date = date;
    }

    public Transcation(int id, int fromNodeNum, int toNodeNum, double value, Timestamp timestamp) {
        this.id = id;
        this.fromNodeNum = fromNodeNum;
        this.toNodeNum = toNodeNum;
        this.value = value;
        this.date = timeToDate(timestamp);
//        System.out.println(timestamp);
//        System.out.println(date);
    }

    public static java.util.Date timeToDate(java.sql.Timestamp time) {
        return time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromNodeNum() {
        return fromNodeNum;
    }

    public void setFromNodeNum(int fromNodeNum) {
        this.fromNodeNum = fromNodeNum;
    }

    public int getToNodeNum() {
        return toNodeNum;
    }

    public void setToNodeNum(int toNodeNum) {
        this.toNodeNum = toNodeNum;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transcation{" +
                "id=" + id +
                ", fromNodeNum='" + fromNodeNum + '\'' +
                ", toNodeNum='" + toNodeNum + '\'' +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
