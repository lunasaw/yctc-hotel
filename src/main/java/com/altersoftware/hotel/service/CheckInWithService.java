package com.altersoftware.hotel.service;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.CheckInWithDO;

import java.util.List;

/**
 * @author Iszychen@win10
 * @date 2020/2/23 15:45
 */
public interface CheckInWithService {

	/**
	 * id获取所有入住人员信息
	 *
	 * @return
	 */
	ResultDO<CheckInWithDO> getCheckInWithId(long id);

	/**
	 * 电话获取所有入住人员信息
	 *
	 * @return
	 */
	ResultDO<CheckInWithDO> getCheckInWithPhone(String phone);

	/**
	 * 添加陪同入住人信息
	 *
	 * @return
	 */
	ResultDO<Void> insert(CheckInWithDO checkInWithDO);

	/**
	 * 获取所有入住人员信息
	 *
	 * @return
	 */
	ResultDO<List<CheckInWithDO>> getAllcheckInWith();

	/**
	 * 修改入住人员信息
	 *
	 * @param checkInWithDO
	 * @return
	 */
	ResultDO<Void> updateCheckInWithDO(CheckInWithDO checkInWithDO);

	/**
	 * 删除指定入住人员信息
	 *
	 * @param id
	 * @return
	 */
	ResultDO<Void> deleteById(long id);

	/**
	 * 删除部分入住人员信息
	 *
	 * @param numbers
	 * @return
	 */
	ResultDO<Void> deleteList(List<Long> numbers);


	/**
	 * 房间搜索入住人员
	 *
	 * @param roomNumber
	 * @return
	 */
	ResultDO<List<CheckInWithDO>> getBycheckInWithRoomNumber(int roomNumber);

	/**
	 * 删除失效的纪录   TODO 用户每次入填写的时候都先删一次
	 *
	 * @return
	 */
	ResultDO<Void> deleteLoseEfficacy();
}
