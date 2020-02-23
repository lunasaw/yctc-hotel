package com.altersoftware.hotel.checkIn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;

/**
 * @author Iszychen@win10
 * @date 2020/2/22 20:07
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/checkin")
public class CommonController {

    @GetMapping("step_a")
    public String checkInStepA() {
        return TemplatePath.USER_CHECK_IN_A;
    }

    @GetMapping("step_input")
    public String checkInStepInput() {
        return TemplatePath.USER_CHECK_IN_A_INPUT;
    }

    @GetMapping("step_b")
    public String checkInStepB() {
        return TemplatePath.USER_CHECK_IN_B;
    }


    @GetMapping("step_c")
    public String checkInStepC() {
        return TemplatePath.USER_CHECK_IN_C;
    }

    @GetMapping("step_success")
    public String checkInStepSuccess() {
        return TemplatePath.USER_CHECK_IN_SUCCESS;
    }

    @GetMapping("step_a_input_table")
    public String checkInStepInputTable() {
        return TemplatePath.USER_CHECK_IN_A_INPUT_TABLE;
    }
}
