package com.altersoftware.hotel.checkIn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/22 17:44
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/checkin")
public class CheckInControllerImpl implements CheckInController {

    @Override
    public ResultDO<UserDO> checkFaceToken(String number) {
        return null;
    }

    @Override
    public ResultDO<Boolean> checkIdCard(String id64, long customerId) {
        return null;
    }

    @Override
    public ResultDO<RecordDO> nowToLive(long customerId) {
        return null;
    }

    @Override
    public ResultDO<Boolean> checkFace(String face64) {
        return null;
    }
}
