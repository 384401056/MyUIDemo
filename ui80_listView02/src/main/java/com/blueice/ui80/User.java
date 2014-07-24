package com.blueice.ui80;

/**
 * 用户数据类。
 *
 * Created by ServerAdmin on 2014/7/24.
 */
public class User {

    private String mName;
    private Boolean isOpen;

    public User(String name){

        mName = name;
        isOpen = false;
    }




    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isopen) {
        this.isOpen = isopen;
    }

    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        this.mName = Name;
    }

}
