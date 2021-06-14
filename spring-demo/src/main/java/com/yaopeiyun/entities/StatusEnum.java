package com.yaopeiyun.entities;

public enum StatusEnum {

    ALL("全部",0),INDATA("收入",1),OUTDATA("支出",2);
    private String statusstr;
    private int status;

    StatusEnum(String statusstr,int status){
        this.statusstr = statusstr;
        this.status = status;
    }

    public String getStatusstr() {
        return statusstr;
    }

    public void setStatusstr(String statusstr) {
        this.statusstr = statusstr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
