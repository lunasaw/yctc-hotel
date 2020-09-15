package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.MenuDO;

/**
 * @author czy@win10
 * @date 2020/1/30 14:46
 */
@Mapper
public interface MenuDAO {
    /**
     * 插入一条菜单信息
     *
     *
     */
    @Insert(" INSERT INTO tb_menu (id, name, picture, numbers,  price,  create_time, modify_time ) "
        +
        "VALUES(#{id}, #{name}, #{picture}, #{numbers}, #{price},  now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(MenuDO menuDO);

    /**
     * id查找菜单消息
     *
     * @param id
     */
    @Select("select id, name, picture, numbers,  price,  create_time, modify_time from tb_menu where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "picture", column = "picture"),
        @Result(property = "numbers", column = "numbers"),
        @Result(property = "price", column = "price"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    MenuDO getMenuDOById(long id);

    /**
     * 更新菜单消息
     *
     * @param menuDO
     */
    @Update("update tb_menu  set name=#{name}, picture=#{picture}, numbers=#{numbers}, price=#{price} where id=#{id}")
    int update(MenuDO menuDO);

    /**
     * 根据id删除一条菜单消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_menu WHERE id=#{id}")
    int deleteById(long id);

    /**
     * 返回菜单list
     *
     * @return
     */
    @Select("select id, name, picture, numbers,  price,  create_time, modify_time from tb_menu  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "picture", column = "picture"),
        @Result(property = "numbers", column = "numbers"),
        @Result(property = "price", column = "price"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<MenuDO> getMenuDOList();

}
