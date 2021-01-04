package com.teddy.databidngdemo;

import android.os.Message;

import androidx.annotation.NonNull;

import com.teddy.databidngdemo.core.DnHandler;
import com.teddy.databidngdemo.core.DnLooper;
import com.teddy.databidngdemo.core.DnMessage;

import org.junit.Test;

/**
 * author : Teddy
 * date   : 2021/1/3
 * desc   :
 */
public class DNActivityThread {

    //todo: 这个是一个简单的手写handler项目

    @Test
    public void main() {
        //1. 创建全局唯一的主线程 Looper对象

        DnLooper.prepare();

        //2 创建handler 对象
        final DnHandler dnHandler = new DnHandler() {
            @Override
            public void handleMessage(@NonNull DnMessage msg) {
                super.handleMessage(msg);

                System.out.println(msg.obj.toString());

            }
        };


        // 3. 发送消息
        new Thread(new Runnable() {
            @Override
            public void run() {
              DnMessage dnMessage = new DnMessage();
              dnMessage.obj = "我爱你";
              dnMessage.what = 1 ;
              dnHandler.sendMessage(dnMessage);

            }
        }).start();

        // 获取消息
       DnLooper.loop();

    }

}
