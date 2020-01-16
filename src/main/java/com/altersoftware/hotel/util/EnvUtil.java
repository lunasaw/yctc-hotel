package com.altersoftware.hotel.util;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 判断当前的部署环境
 *
 * @author Tony
 */
@Component
public class EnvUtil {

    @Autowired
    private Environment env;

    private String isDailyString;

    @PostConstruct
    public void init() {
        isDailyString = env.getProperty("environment.isdaily");
    }

    /**
     * 判断当前是日常环境
     *
     * @return
     */
    public boolean isDaily() {
        return StringUtils.equals("true", isDailyString);
    }

    /**
     * 判断当前是线上环境
     *
     * @return
     */
    public boolean isOnline() {
        return StringUtils.equals("false", isDailyString);
    }

}
