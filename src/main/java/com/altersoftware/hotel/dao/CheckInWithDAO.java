package com.altersoftware.hotel.dao;

import com.altersoftware.hotel.entity.CheckInWithDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Iszychen@win10
 * @date 2020/2/23 15:32
 */
@Mapper
public interface CheckInWithDAO {
	/**
	 * 插入一条入住人员信息信息
	 *
	 *
	 */
	@Insert(" INSERT INTO tb_checkin_with (id, phone, name, idcard, room_number, picture, last_time, create_time, modify_time ) "
			+
			"VALUES(#{id}, #{phone}, #{name}, #{idCard}, #{roomNumber}, #{idPiture}, #{lastTime}, now(), now()) ")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void insert(CheckInWithDO checkInWithDO);

	/**
	 * id查找入住人员信息消息
	 *
	 * @param id
	 */
	@Select("select id, phone, name, idcard, room_number, picture, last_time, create_time, modify_time from tb_checkin_with where id=#{id}  ")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "phone", column = "phone"),
			@Result(property = "name", column = "name"),
			@Result(property = "idCard", column = "idcard"),
			@Result(property = "roomNumber", column = "room_number"),
			@Result(property = "idPiture", column = "picture"),
			@Result(property = "lastTime", column = "last_time"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time")
	})
	CheckInWithDO getCheckInWithDOById(long id);

	/**
	 * 入住人员信息List消息
	 *
	 */
	@Select("select id, phone, name, idcard, room_number, picture, last_time, create_time, modify_time from tb_checkin_with ")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "phone", column = "phone"),
			@Result(property = "name", column = "name"),
			@Result(property = "idCard", column = "idcard"),
			@Result(property = "roomNumber", column = "room_number"),
			@Result(property = "idPiture", column = "picture"),
			@Result(property = "lastTime", column = "last_time"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time")
	})
	List<CheckInWithDO> getCheckInList();

	/**
	 * 更新入住人员信息消息
	 *
	 * @param checkInWithDO
	 */
	@Update("update tb_checkin_with  set phone=#{phone}, name=#{name}, idcard=#{idCard}, room_number=#{roomNumber}, picture=#{idPiture}, last_time=#{lastTime}, modify_time=now()  where id=#{id}")
	int update(CheckInWithDO checkInWithDO);

	/**
	 * 根据id删除一条入住人员信息消息
	 *
	 * @param id
	 */
	@Delete("DELETE FROM tb_checkin_with WHERE id=#{id}")
	int deleteById(long id);

	/**
	 * 根据id删除一条入住人员信息消息
	 *
	 * @param name
	 */
	@Delete("DELETE FROM tb_checkin_with WHERE name=#{name}")
	int deleteByName(long name);


	/**
	 * 返回某一房间的入住人信息
	 *
	 * @param roomNumber
	 * @return
	 */
	@Select("select id, phone, name, idcard, room_number, picture, last_time, create_time, modify_time from tb_checkin_with where room_number=#{roomNumber}  ")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "phone", column = "phone"),
			@Result(property = "name", column = "name"),
			@Result(property = "idCard", column = "idcard"),
			@Result(property = "roomNumber", column = "room_number"),
			@Result(property = "idPiture", column = "picture"),
			@Result(property = "lastTime", column = "last_time"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time")
	})
	List<CheckInWithDO> getNumbersByRoom(int roomNumber);

	@Select("select id, phone, name, idcard, room_number, picture, last_time, create_time, modify_time from tb_checkin_with where phone=#{phone}  ")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "phone", column = "phone"),
			@Result(property = "name", column = "name"),
			@Result(property = "idCard", column = "idcard"),
			@Result(property = "roomNumber", column = "room_number"),
			@Result(property = "idPiture", column = "picture"),
			@Result(property = "lastTime", column = "last_time"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time")
	})
	CheckInWithDO getCheckInWithDOByPhone(String phone);
}
