package com.blueicehunter.ui06;

/**
 * 用户信息类，也就是Spinner内的数据类。
 *
 * Created by Administrator on 2014/7/22.
 */
public class UserInfo {

    private String mName;
    private String mAdd;
    private int mPic;


    public UserInfo(String name, String add, int pic){
        this.mName = name;
        this.mAdd = add;
        this.mPic = pic;
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getAdd() {
        return mAdd;
    }

    public void setAdd(String mAdd) {
        this.mAdd = mAdd;
    }

    public int getPic() {
        return mPic;
    }

    public void setPic(int mPic) {
        this.mPic = mPic;
    }


}
