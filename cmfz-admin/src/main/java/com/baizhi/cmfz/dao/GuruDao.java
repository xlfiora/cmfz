package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xl on 2018/7/6 0006.
 */
public interface GuruDao {

    public Integer insertGuru(Guru guru);

    public Integer deleteGuru(String guruId);

    public Integer updateGuru(Guru guru);

    public Integer countTotalRows();

    public List<Guru> selectGuruByPage(Page page);

    public Integer countTotalRowsByKey(@Param("key")String key, @Param("value") String value);

    public List<Guru> selectGuruByKey(@Param("page")Page page, @Param("key")String key, @Param("value") String value);

}
