package com.summer.kotlineyepetizer.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Account {
    @Id
    public String id;

    @Generated(hash = 1836768010)
    public Account(String id) {
        this.id = id;
    }

    @Generated(hash = 882125521)
    public Account() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
