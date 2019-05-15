package com.jp.po;

public class Cartitem {
    private Integer cartitemid;

    private String lsbn;

    private Integer userid;

    private Integer num;

    public Integer getCartitemid() {
        return cartitemid;
    }

    public void setCartitemid(Integer cartitemid) {
        this.cartitemid = cartitemid;
    }

    public String getLsbn() {
        return lsbn;
    }

    public void setLsbn(String lsbn) {
        this.lsbn = lsbn == null ? null : lsbn.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}