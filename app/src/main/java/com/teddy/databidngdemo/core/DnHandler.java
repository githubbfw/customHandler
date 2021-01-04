package com.teddy.databidngdemo.core;

import android.os.Message;

import androidx.annotation.NonNull;

/**
 * author : Teddy
 * date   : 2021/1/3
 * desc   :todo:手写的handler，在test进行测试的。
 */
public class DnHandler {
    private DnLooper mDnLooper;
    private DnMessageQueue mDnMessageQueue;

    public DnHandler() {
        mDnLooper = DnLooper.myLooper();
        if (mDnLooper == null) {
            throw new RuntimeException(
                    "Can't create handler inside thread " + Thread.currentThread()
                            + " that has not called Looper.prepare()");
        }
        mDnMessageQueue = mDnLooper.mQueue;
    }

    public void handleMessage(@NonNull DnMessage msg) {

    }

    public void sendMessage(DnMessage message) {
        // 讲消息放入消息队列
        enqueueMessage(message);
    }

    private void enqueueMessage(DnMessage message) {
        // 赋值当前消息
        message.target = this;
        // 使用dnMesssageQueue,将消息传入
        mDnMessageQueue.enqueueMessage(message);

    }


    public void dispatchMessage(DnMessage message) {
        handleMessage(message);
    }
}
