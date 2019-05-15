package com.jp.po;

public class OrderitemKey {
    private String orderid;

    private String lsbn;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getLsbn() {
        return lsbn;
    }

    public void setLsbn(String lsbn) {
        this.lsbn = lsbn == null ? null : lsbn.trim();
    }
}