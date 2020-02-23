package com.altersoftware.hotel.service.impl;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.CheckInWithDAO;
import com.altersoftware.hotel.entity.CheckInWithDO;
import com.altersoftware.hotel.entity.ResultDO;

import com.altersoftware.hotel.service.CheckInWithService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Iszychen@win10
 * @date 2020/2/23 15:49
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("checkInWithService")
public class CheckInWithServiceImpl implements CheckInWithService {
	private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

	@Resource
	private CheckInWithDAO checkInWithDAO;

	@Override
	public ResultDO<CheckInWithDO> getCheckInWithId(long id) {
		CheckInWithDO checkInWithDOById = null;
		try {
			checkInWithDOById=checkInWithDAO.getCheckInWithDOById(id);
			LOG.info("getCheckInWithId success, checkInWithDO={}" ,checkInWithDOById);
			return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,checkInWithDOById);
		} catch (Exception e) {
			LOG.error("getCheckInWithId error, id={}", id, e);
			return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
					ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
		}
	}

	@Override
	public ResultDO<CheckInWithDO> getCheckInWithPhone(String phone) {
		CheckInWithDO checkInWithDOByPhone = null;
		try {
			checkInWithDOByPhone=checkInWithDAO.getCheckInWithDOByPhone(phone);
			LOG.info("getCheckInWithPhone success, checkInWithDOByPhone={}" ,checkInWithDOByPhone);
			return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,checkInWithDOByPhone);
		} catch (Exception e) {
			LOG.error("getCheckInWithPhone error, phone={}", phone, e);
			return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
					ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
		}
	}

	@Override
	public ResultDO<Void> insert(CheckInWithDO checkInWithDO) {
		try {
			checkInWithDAO.insert(checkInWithDO);
			LOG.info("insert success, checkInWithDO={}" ,checkInWithDO);
			return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
		} catch (Exception e) {
			LOG.error("insert error, checkInWithDOS={}", checkInWithDO, e);
			return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
					ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
		}
	}

	@Override
	public ResultDO<List<CheckInWithDO>> getAllcheckInWith() {
		List<CheckInWithDO> checkInWithDOS = new ArrayList();
		try {
			checkInWithDOS = checkInWithDAO.getCheckInList();
					LOG.info("getAllcheckInWith success, checkInWithDOS={}", checkInWithDOS);
			return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, checkInWithDOS);
		} catch (Exception e) {
			LOG.error("getAllcheckInWith error, checkInWithDOS={}", checkInWithDOS, e);
			return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
					ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
		}
	}

	@Override
	public ResultDO<Void> updateCheckInWithDO(CheckInWithDO checkInWithDO) {
		int update = checkInWithDAO.update(checkInWithDO);
		if (update == 1) {
			LOG.info("updateCheckInWithDO success, checkInWithDO={}", checkInWithDO);
			return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
		} else {
			LOG.error("updateCheckInWithDO error, checkInWithDO={}", checkInWithDO);
			return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
					ResultCode.MSG_UPDATE_FAILD);
		}
	}

	@Override
	public ResultDO<Void> deleteById(long id) {
		try {
			checkInWithDAO.deleteById(id);
			LOG.info("deleteById success, id={}", id);
			return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
		} catch (Exception e) {
			LOG.error("deleteById error, id={}", id, e);
			return new ResultDO<>(false, ResultCode.DELETE_FAILD,
					ResultCode.MSG_DELETE_FAILD);
		}
	}

	@Override
	public ResultDO<Void> deleteList(List<Long> numbers) {
		try {
			for (int i = 0; i < numbers.size(); i++) {
				checkInWithDAO.deleteById(numbers.get(i));
			}
			LOG.info("deleteList success, numbers={}", numbers);
			return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
		} catch (Exception e) {
			LOG.error("deleteList error, numbers={}", numbers, e);
			return new ResultDO<>(false, ResultCode.DELETE_FAILD,
					ResultCode.MSG_DELETE_FAILD);
		}
	}

	@Override
	public ResultDO<List<CheckInWithDO>> getBycheckInWithRoomNumber(int roomNumber) {
		List<CheckInWithDO> numbersByRoom=null;
		try {
			numbersByRoom= checkInWithDAO.getNumbersByRoom(roomNumber);
			LOG.info("deleteLoseEfficacy success, numbersByRoom={}", numbersByRoom);
			return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,numbersByRoom);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("deleteLoseEfficacy error, numbersByRoom={}", numbersByRoom, e);

			return new ResultDO<>(false, ResultCode.DELETE_FAILD,
					ResultCode.MSG_DELETE_FAILD);
		}
	}

	@Override
	public ResultDO<Void> deleteLoseEfficacy() {
		List<CheckInWithDO> checkInList=null;
		try {
			 checkInList= checkInWithDAO.getCheckInList();
			for (int i = 0; i < checkInList.size(); i++) {
				Date lastTime = checkInList.get(i).getLastTime();
				Date now=new Date();
				if (lastTime.before(now)){
					checkInWithDAO.deleteById(checkInList.get(i).getId());
				}
			}
			LOG.info("deleteLoseEfficacy success, checkInList={}", checkInList);
			return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("deleteLoseEfficacy error, checkInList={}", checkInList, e);

			return new ResultDO<>(false, ResultCode.DELETE_FAILD,
					ResultCode.MSG_DELETE_FAILD);
		}

	}
}
