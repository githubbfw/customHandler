package com.teddy.databidngdemo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * author : Teddy
 * date   : 2020/12/18
 * desc   :
 */
public class User extends BaseObservable {
    @Bindable
    private String name;
    @Bindable
    private String pwd;

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
        notifyChange();
//        notifyPropertyChanged(com.teddy.databidngdemo.BR.name);
    }
}
