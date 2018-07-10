package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Page;

import java.util.Map;

/**
 * Created by xl on 2018/7/9 0009.
 */
public interface LogService {

    public Map<String,Object> queryLogByPage(Page page);

}
