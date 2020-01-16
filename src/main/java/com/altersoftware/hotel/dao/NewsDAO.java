package com.altersoftware.hotel.dao;

import com.altersoftware.hotel.entity.NewsDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsDAO {

    /**
     * 插入一条消息
     * 
     * @param newsDO
     */
    public void insert(NewsDO newsDO);

    /**
     * id查找消息
     * 
     * @param id
     */
    public NewsDO getNewsDOById(long id);

    /**
     * 更新消息
     * 
     * @param newsDO
     */
    public void update(NewsDO newsDO);

    /**
     * 根据id删除一条消息
     * 
     * @param id
     */
    public void deleteById(long id);
}
