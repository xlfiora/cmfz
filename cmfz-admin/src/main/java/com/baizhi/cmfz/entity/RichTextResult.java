package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by xl on 2018/7/8 0008.
 */
public class RichTextResult implements Serializable{

    private Integer errno;
    private ArrayList<String> data;

    public RichTextResult() {

    }

    @Override
    public String toString() {
        return "RichTextResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
