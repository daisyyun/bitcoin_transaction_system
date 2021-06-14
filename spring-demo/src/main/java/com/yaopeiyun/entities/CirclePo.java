package com.yaopeiyun.entities;

import java.io.Serializable;

public class CirclePo implements Serializable {

    String friend;
    double value;

    public CirclePo(String friends, double value) {
        this.friend = friends;
        this.value = value;
    }

    public CirclePo() {

    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CirclePo{" +
                "friends='" + friend + '\'' +
                ", value=" + value +
                '}';
    }
}
