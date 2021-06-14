package com.yaopeiyun.entities;

public class User {

    int id;
    String addr;
    double balance;

    public User(int id, String addr, double balance) {
        this.id = id;
        this.addr = addr;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", addr='" + addr + '\'' +
                ", balance=" + balance +
                '}';
    }
}
