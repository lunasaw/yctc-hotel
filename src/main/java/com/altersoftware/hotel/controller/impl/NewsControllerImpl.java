package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.NewsController;

@Controller
@ComponentScan({"edu.yctc.hotel.service"})
@RequestMapping("/news")
/**
 * newsController接口实现
 *
 * @author 15272
 */
public class NewsControllerImpl implements NewsController {

    @Override
    @GetMapping("news")
    public String showNewsList() {
        return TemplatePath.NEWS_LIST;
    }

    @Override
    @GetMapping("news-detail")
    public String showNewsDetail() {
        return TemplatePath.NEWS_DETAIL;
    }
}
