package com.yaopeiyun.entities;

public class Circle {

    int id;
    int friend;
    double value;

    public Circle(int id, int friends, double value) {
        this.id = id;
        this.friend = friends;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFriend() {
        return friend;
    }

    public void setFriend(int friend) {
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
        return "Circle{" +
                "id=" + id +
                ", friends=" + friend +
                ", value=" + value +
                '}';
    }
}
