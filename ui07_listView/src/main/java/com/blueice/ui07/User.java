package com.blueice.ui07;

/**
 * 用户数据类。
 *
 * Created by ServerAdmin on 2014/7/24.
 */
public class User {

    private String mName;

    public User(String name){

        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        this.mName = Name;
    }

}
