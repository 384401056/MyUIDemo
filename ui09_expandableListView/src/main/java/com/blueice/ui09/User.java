package com.blueice.ui09;

/**
 * 用户数据类。
 *
 * Created by ServerAdmin on 2014/7/24.
 */
public class User {

    private String mName;
    private int mAge;

    public User(String name,int age){

        mName = name;
        mAge = age;
    }


    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }

    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        this.mName = Name;
    }

}
