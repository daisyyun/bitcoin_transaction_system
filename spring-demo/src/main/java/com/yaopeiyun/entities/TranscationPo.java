package com.yaopeiyun.entities;

import java.io.Serializable;
import java.util.Date;

public class TranscationPo implements Serializable {
    int id;
    String fromNodeNum;
    String toNodeNum;
    double value;
    Date date;

    public TranscationPo(int id, String fromNodeNum, String toNodeNum, double value, Date date) {
        this.id = id;
        this.fromNodeNum = fromNodeNum;
        this.toNodeNum = toNodeNum;
        this.value = value;
        this.date = date;
    }

    public TranscationPo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromNodeNum() {
        return fromNodeNum;
    }

    public void setFromNodeNum(String fromNodeNum) {
        this.fromNodeNum = fromNodeNum;
    }

    public String getToNodeNum() {
        return toNodeNum;
    }

    public void setToNodeNum(String toNodeNum) {
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
        return "TranscationPo{" +
                "id=" + id +
                ", fromNodeNum='" + fromNodeNum + '\'' +
                ", toNodeNum='" + toNodeNum + '\'' +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
