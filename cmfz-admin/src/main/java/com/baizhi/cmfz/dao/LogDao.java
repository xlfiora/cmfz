package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Page;

import java.util.List;

/**
 * Created by xl on 2018/7/9 0009.
 */
public interface LogDao {

    public Integer insertLog(Log log);

    public Integer countTotalRows();

    public List<Log> selectLogByPage(Page page);

}
