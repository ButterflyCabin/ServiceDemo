package com.yehu.servicedemo.Event;

/**
 * 创建日期：2018/2/13 16:45
 *
 * @author yehu
 *         类说明：
 */
public class FrontEvent {
    public String msg;
    public String tag;

    public FrontEvent() {

    }

    public FrontEvent(String tag,String msg) {
        this.msg = msg;
        this.tag = tag;
    }

}
