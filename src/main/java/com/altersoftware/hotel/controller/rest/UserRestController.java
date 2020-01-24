package com.altersoftware.hotel.controller.rest;


import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.vo.UserInformationVO;

public interface UserRestController {

    /**
     * signup的rest方法
     *
     * @param userDO
     * @return
     */
    ResultDO<Void> signup(UserDO userDO);

    /**
     * signin的rest方法
     *
     * @param userDO
     * @return
     */
    ResultDO<Long> signin(UserDO userDO);

    /**
     * getUserInformationById的rest方法
     *
     * @param id
     * @return
     */
    ResultDO<UserInformationVO> getUserInformationById(long id);

}
