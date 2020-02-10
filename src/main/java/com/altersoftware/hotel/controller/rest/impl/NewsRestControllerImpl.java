package com.altersoftware.hotel.controller.rest.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.constant.entity.news.NewsState;
import com.altersoftware.hotel.controller.rest.NewsRestController;
import com.altersoftware.hotel.controller.session.SessionContentHolder;
import com.altersoftware.hotel.entity.NewsDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.NewsIService;
import com.altersoftware.hotel.vo.NewsDOAndUrlVO;
import com.altersoftware.hotel.vo.SendNewsVO;


@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/restnews")
@Async
public class NewsRestControllerImpl implements NewsRestController {

    private static final String NEWS_DETAIL = "/hotel/news/news-detail?id=";

    @Autowired
    private NewsIService newsService;

    @Override
    @PostMapping("show-news")
    public ResultDO<Map<Integer, List<NewsDOAndUrlVO>>> showNews(HttpSession httpSession) {
        long id = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (id <= 0) {
            return new ResultDO<Map<Integer, List<NewsDOAndUrlVO>>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<Map<Integer, List<NewsDO>>> resultDO = newsService.getUserNews(id);
        if (resultDO.isSuccess() == false) {
            return new ResultDO<Map<Integer, List<NewsDOAndUrlVO>>>(false, resultDO.getCode(), resultDO.getMsg(), null);
        }
        Map<Integer, List<NewsDO>> newsMap = resultDO.getModule();
        Map<Integer, List<NewsDOAndUrlVO>> newsDOAndUrlVOMap = new HashMap<>();
        // 已读通知集
        List<NewsDO> readedNewsList = newsMap.get(NewsState.READED);
        List<NewsDOAndUrlVO> readedNewsDOAndUrlVOList = new ArrayList<>();
        // 未读通知集
        List<NewsDO> unreadNewsList = newsMap.get(NewsState.UNREAD);
        List<NewsDOAndUrlVO> unreadNewsDOAndUrlVOList = new ArrayList<>();
        // 构建VO
        for (NewsDO newsDO : readedNewsList) {
            NewsDOAndUrlVO newsDOAndUrlVO = new NewsDOAndUrlVO();
            newsDOAndUrlVO.setNewsDO(newsDO);
            newsDOAndUrlVO.setUrl(NEWS_DETAIL + newsDO.getId());
            readedNewsDOAndUrlVOList.add(newsDOAndUrlVO);
        }
        for (NewsDO newsDO : unreadNewsList) {
            NewsDOAndUrlVO newsDOAndUrlVO = new NewsDOAndUrlVO();
            newsDOAndUrlVO.setNewsDO(newsDO);
            newsDOAndUrlVO.setUrl(NEWS_DETAIL + newsDO.getId());
            unreadNewsDOAndUrlVOList.add(newsDOAndUrlVO);
        }
        // 添加到map
        newsDOAndUrlVOMap.put(NewsState.UNREAD, unreadNewsDOAndUrlVOList);
        newsDOAndUrlVOMap.put(NewsState.READED, readedNewsDOAndUrlVOList);
        return new ResultDO<Map<Integer, List<NewsDOAndUrlVO>>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            newsDOAndUrlVOMap);
    }

    @Override
    @PostMapping("turn-to-readed")
    public ResultDO<Void> turnTOReaded(@RequestBody String newsId, HttpSession httpSession) {
        long toChangeUserId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        long toChangeNewsId = Long.parseLong(newsId);
        if (toChangeUserId <= 0 || toChangeNewsId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return newsService.turnTOReaded(toChangeUserId, toChangeNewsId);
    }

    @Override
    @PostMapping("turn-to-unread")
    @Deprecated
    public ResultDO<Void> turnTOUnread(@RequestBody String newsId, HttpSession httpSession) {
        long toChangeUserId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        long toChangeNewsId = Long.parseLong(newsId);
        if (toChangeUserId <= 0 || toChangeNewsId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return newsService.turnToUnread(toChangeUserId, toChangeNewsId);
    }

    @Override
    @PostMapping("turn-all-to-readed")
    public ResultDO<Void> turnAllToReaded(HttpSession httpSession) {
        long toChangeUserId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (toChangeUserId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return newsService.turnAllToReaded(toChangeUserId);
    }

    @Override
    @PostMapping("turn-all-to-unread")
    @Deprecated
    public ResultDO<Void> turnAllToUnread(HttpSession httpSession) {
        long toChangeUserId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (toChangeUserId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return newsService.turnAlltoUnread(toChangeUserId);
    }

    @Override
    @PostMapping("send-news-to-user-list")
    public ResultDO<Void> sendNewsToUser(@RequestBody SendNewsVO sendNewsVO) {
        List<Long> userIdList = sendNewsVO.getUserIdList();
        String title = sendNewsVO.getTitle();
        String content = sendNewsVO.getContent();
        if (userIdList.isEmpty() == true || StringUtils.isBlank(title) || StringUtils.isBlank(content)) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        for (long userId : userIdList) {
            if (userId <= 0) {
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
        }
        return newsService.sendNewsTOUserList(userIdList, title, content);
    }

    @Override
    @PostMapping("send-news-to-staff-list")
    public ResultDO<Void> sendNewsToStaff(SendNewsVO sendNewsVO) {
        /**
         * 查出所有清洁员工的id
         * 向他们发送消息
         */
        return null;
    }

    @Override
    @PostMapping("get-newsdo-by-id")
    public ResultDO<NewsDO> getNewsDOById(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<NewsDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return newsService.getNewsDOById(id);
    }

    @Override
    @PostMapping("delete-all-readed-news")
    public ResultDO<Void> deleteAllReadedNews(HttpSession httpSession) {
        if (StringUtils.isBlank(httpSession.getId())) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        return newsService.deleteAllReadedNewsByUserId(userId);
    }
}
