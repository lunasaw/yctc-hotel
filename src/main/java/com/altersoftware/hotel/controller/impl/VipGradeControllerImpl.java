package com.altersoftware.hotel.controller.impl;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.VipGradeController;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 18:26
 */
public class VipGradeControllerImpl implements VipGradeController {

    @Override
    public String showGrade() {
        return TemplatePath.VIP_GRADE_INFO;
    }
}
