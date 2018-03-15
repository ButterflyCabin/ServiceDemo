package com.yehu.servicedemo.Event;

/**
 * 创建日期：2018/2/13 16:45
 *
 * @author yehu
 *         类说明：
 */
public class Front2Event {
    public String msg;
    public String tag;

    public Front2Event() {

    }

    public Front2Event(String tag, String msg) {
        this.msg = msg;
        this.tag = tag;
    }

}
