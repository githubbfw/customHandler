package com.teddy.databidngdemo.core;

/**
 * author : Teddy
 * date   : 2021/1/3
 * desc   :
 */
public class DnMessage {
    // 消息的标记
    public  int what;

    // 消息内容
    public Object obj;

    // handler 对象
    public  DnHandler target;
}
