package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by xl on 2018/7/9 0009.
 */
public class Distribution implements Serializable{

    private String name;
    private Integer value;

    public Distribution(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
