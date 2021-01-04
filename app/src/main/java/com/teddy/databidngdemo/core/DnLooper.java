package com.teddy.databidngdemo.core;

import java.util.TreeMap;

/**
 * author : Teddy
 * d   ate   : 2021/1/3
 * desc   :
 */
public class DnLooper {

    static final ThreadLocal<DnLooper> sThreadLocal = new ThreadLocal<DnLooper>();
    final  DnMessageQueue mQueue;

    public DnLooper() {
        mQueue =  new DnMessageQueue();
    }

    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one DnLooper may be created per thread");
        }
        sThreadLocal.set(new DnLooper());

    }

    public static DnLooper myLooper() {
        return sThreadLocal.get();
    }

    public static void loop() {
        // 从全局thredlocalmap中获取唯一的  looper对象
        DnLooper dnLooper = myLooper();
        DnMessageQueue queue = dnLooper.mQueue;

        while (true){
            DnMessage message = queue.next();
            if (message !=null){
                message.target.dispatchMessage(message);
            }
        }

    }
}
