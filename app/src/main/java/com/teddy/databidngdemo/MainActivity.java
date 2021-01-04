package com.teddy.databidngdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;

import com.teddy.databidngdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User mUser;
    private ActivityMainBinding  mMainBinding;

    private Handler mHandler   = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mUser = new User("11111","123456");
        mMainBinding.setUser(mUser);
        // 可以单独赋值。
//        mMainBinding.tvName.setText("326356");

        mMainBinding.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mUser.setName("33333");
            }
        });



    }
}