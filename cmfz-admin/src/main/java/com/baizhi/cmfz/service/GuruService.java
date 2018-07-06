package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Page;

import java.util.Map;

/**
 * Created by xl on 2018/7/6 0006.
 */
public interface GuruService {

    public Integer addGuru(Guru guru);

    public Integer removeGuru(String guruId);

    public Integer modifyGuru(Guru guru);

    public Map<String,Object> queryGuruByPage(Page page);

    public Map<String,Object> queryGuruByKey(Page page,String key,String value);

}
