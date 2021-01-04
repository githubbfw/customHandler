package com.teddy.databidngdemo.core;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * author : Teddy
 * date   : 2021/1/3
 * desc   :
 */
public class DnMessageQueue {

    //用一种简单的方法--- 阻塞队列
    BlockingQueue<DnMessage> blockingQueue = new ArrayBlockingQueue<DnMessage>(50);
    public void enqueueMessage(DnMessage message){
        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 从消息队列中取出消息
    public  DnMessage next(){
        try {
          return   blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  null;
    };

}
