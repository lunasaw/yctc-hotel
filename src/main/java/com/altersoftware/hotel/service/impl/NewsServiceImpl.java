package com.altersoftware.hotel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.constant.entity.news.NewsState;
import com.altersoftware.hotel.dao.NewsDAO;
import com.altersoftware.hotel.dao.UserNewsDAO;
import com.altersoftware.hotel.entity.NewsDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserNewsDO;
import com.altersoftware.hotel.service.NewsIService;



/**
 * 发送通知业务接口实现
 *
 * @author 15272
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("newsService")
public class NewsServiceImpl implements NewsIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    NewsDAO newsDAO;//消息
    @Resource
    UserNewsDAO userNewsDAO;//向用户写入消息

    //发送通知给用户
    @Override
    public ResultDO<Void> sendNewsToUser(List<Long> userIdList, List<Long> newsIdList) {
        // 参数核验
        if (userIdList.isEmpty() == true || newsIdList.isEmpty() == true) {
            LOG.error("send news to user fail, parameter invalid, userIdList={}, newsIdList={}", userIdList,
                newsIdList);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        // userId合法性检查
        for (long userId : userIdList) {
            if (userId <= 0) {
                LOG.error("send news to user fail, userId <= 0, userId={}, userIdList={}, newsIdList={}", userId,
                    userIdList, newsIdList);
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
        }
        // newsId合法性存在性检查
        NewsDO newsDO = new NewsDO();
        for (long newsId : newsIdList) {
            // 合法性判断
            if (newsId <= 0) {
                LOG.error("send news to user fail, newsId <= 0, newsId={}, userIdList={}, newsIdList={}", newsId,
                    userIdList, newsIdList);
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
            // 存在性判断
            newsDO = newsDAO.getNewsDOById(newsId);
            // 数据库找不到这条消息
            if (newsDO == null) {
                LOG.error("send news to user fail, no such news in DB, userIdList={}, newsId={}, newsIdList={}",
                    userIdList, newsId, newsIdList);
                return new ResultDO<>(false, ResultCode.UNKNOW_NEWS, ResultCode.MSG_UNKNOW_NEWS);
            }
        }
        try {
            UserNewsDO userNewsDO = new UserNewsDO();
            for (long newsId : newsIdList) {
                userNewsDO.setNewsId(newsId);
                userNewsDO.setState(NewsState.UNREAD);// 都是未读的
                // 依次发送
                for (long userId : userIdList) {
                    userNewsDO.setUserId(userId);
                    userNewsDAO.insert(userNewsDO);
                }
            }
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("send news to user fail, parameter invalid, userIdList={}, newsIdList={}", userIdList, newsIdList,
                e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //插入信息 到数据库
    @Override
    public ResultDO<Long> putNewsToDB(String title, String content) {
        try {
            if (StringUtils.isBlank(title) || StringUtils.isBlank(content)) {
                LOG.error("put news to db fail, parameter invalid, title={}, content={}", title, content);
                return new ResultDO<Long>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
            }
            // 插入信息
            NewsDO newsDO = new NewsDO();
            newsDO.setTitle(title);
            newsDO.setContent(content);
            newsDAO.insert(newsDO);
            LOG.info("put news to DB success, title={}, content={}, newsId={}", title, content, newsDO.getId());
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, newsDO.getId());
        } catch (Exception e) {
            LOG.error("put news to db error, title={}, content={}", title, content, e);
            return new ResultDO<Long>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //根据id删除消息
    @Override
    public ResultDO<Void> removeUserNews(List<Long> userIdList, List<Long> newsIdList) {
        if (userIdList.isEmpty() == true || newsIdList.isEmpty() == true) {
            LOG.error("remove news fail, parameter invalid, useridList={], newsIdList={}", userIdList, newsIdList);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        // userId合法性检验
        for (long userId : userIdList) {
            if (userId <= 0) {
                // 用户id非法
                LOG.error("remove news fail, userId <= 0, userId={}, userIdList={}, newsIdList={}", userId, userIdList,
                    newsIdList);
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
        }
        // newsId合法性检验
        for (long newsId : newsIdList) {
            if (newsId <= 0) {
                LOG.error("remove news fail, newId <= 0, userId={}, userIdList={}, newsIdList={}", newsId, userIdList,
                    newsIdList);
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
        }
        try {
            for (long userId : userIdList) {
                for (long newsId : newsIdList) {
                    // 根据userId和newsId删除消息
                    userNewsDAO.deletByUserIdAndNewsId(userId, newsId);
                }
            }
            LOG.info("remove news success, userIdList={}, newsIdList={}", userIdList, newsIdList);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("remove news error, userIdList={}, newsIdList={}", userIdList, newsIdList, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //通过id获取用户通知
    @Override
    public ResultDO<Map<Integer, List<NewsDO>>> getUserNews(long userId) {
        // 检验参数
        if (userId <= 0) {
            LOG.error("get user news error, parameter invalid, userId={}", userId);
            return new ResultDO<Map<Integer, List<NewsDO>>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        // 通过用户id，得到消息列表
        try {
            // 未读消息id集合
            List<Long> noReadNewsIdList = userNewsDAO.getNoReadNewsIdByUserId(userId);
            // 已读消息id集合
            List<Long> readedNewsIdList = userNewsDAO.getReadedNewsIdByUserId(userId);
            if (noReadNewsIdList.isEmpty() == true && readedNewsIdList.isEmpty() == true) {
                LOG.info("get user news fail, no news, userId={}", userId);
                return new ResultDO<Map<Integer, List<NewsDO>>>(false, ResultCode.NO_NEWS, ResultCode.MSG_NO_NEWS,
                    null);
            }
            // 未读信息集合
            List<NewsDO> noReadNewsDOList = new ArrayList<>();
            // 已读消息集合
            List<NewsDO> readedNewsDOList = new ArrayList<>();
            // 未读信息插入集合
            for (long id : noReadNewsIdList) {
                NewsDO newsDO = newsDAO.getNewsDOById(id);
                if (newsDO == null) {
                    LOG.error("get NewsDO by id fail,no read newsDO is null, newsId={}, userId={}", id, userId);
                    return new ResultDO<Map<Integer, List<NewsDO>>>(false, ResultCode.UNKNOW_NEWS,
                        ResultCode.MSG_UNKNOW_NEWS, null);
                }
                noReadNewsDOList.add(newsDO);
            }
            // 已读消息插入集合
            for (long id : readedNewsIdList) {
                NewsDO newsDO = newsDAO.getNewsDOById(id);
                if (newsDO == null) {
                    LOG.error("get NewsDO by id fail, readed newsDO is null, newsId={}, userId={}", id, userId);
                    return new ResultDO<Map<Integer, List<NewsDO>>>(false, ResultCode.UNKNOW_NEWS,
                        ResultCode.MSG_UNKNOW_NEWS, null);
                }
                readedNewsDOList.add(newsDO);
            }
            Map<Integer, List<NewsDO>> newsMap = new HashMap<>();
            newsMap.put(NewsState.UNREAD, noReadNewsDOList);
            newsMap.put(NewsState.READED, readedNewsDOList);
            return new ResultDO<Map<Integer, List<NewsDO>>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, newsMap);
        } catch (Exception e) {
            LOG.error("get user news error, parameter invalid, userId={}", userId, e);
            return new ResultDO<Map<Integer, List<NewsDO>>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }

    }

    //通过id设置消息
    @Override
    public ResultDO<Void> setNewsStateByUserIdAndNewsId(long userId, long newsId, int state) {
        if (userId <= 0 || newsId <= 0 || (state != NewsState.UNREAD && state != NewsState.READED)) {
            LOG.error("set news state fail, parameter invalid, userId={}, newsId={}, state={}", userId, newsId, state);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            userNewsDAO.updateStateByUserIdAndNewsId(userId, newsId, state);
            LOG.info("set news state success, userId={}, newsId={}. state={}", userId, newsId, state);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("set news state error, userId={}, newsId={}, state={}", userId, newsId, state, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //发送消息给一类用户
    @Override
    public ResultDO<Void> sendNewsTOUserList(List<Long> userIdList, String title, String content) {
        // 参数检验
        if (CollectionUtils.isEmpty(userIdList) || StringUtils.isBlank(title) || StringUtils.isBlank(content)) {
            LOG.error("send news to user list fail, parameter invalid, userIdList={}, title={}, content={}", userIdList,
                title, content);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        // userId合法性核验
        for (long userId : userIdList) {
            if (userId <= 0) {
                LOG.error(
                    "send news to user list fail, parameter invalid, userId={}, userIdList={}, title={}, content={}",
                    userId, userIdList, title, content);
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
        }
        try {
            // 先把消息存入数据库
            ResultDO<Long> putNewsToDBResultDO = putNewsToDB(title, content);
            // 返回值判断
            if (putNewsToDBResultDO.isSuccess() == false) {
                LOG.error("put news to db fail, resultDO={}, userIdList={}, title={}, content={}", putNewsToDBResultDO,
                    userIdList, title, content);
                return new ResultDO<>(false, putNewsToDBResultDO.getCode(), putNewsToDBResultDO.getMsg());
            }
            if (putNewsToDBResultDO.getModule() <= 0) {
                LOG.error(
                    "put news to db error, newsId <= 0, userId={}, newsId={}, userIdList={}, title={}, content={}, resultDO={}",
                    putNewsToDBResultDO.getModule(), userIdList, title, content, putNewsToDBResultDO);
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
            // 拿到newsId
            Long newsId = putNewsToDBResultDO.getModule();
            // 把newsId放到list里去
            List<Long> newsIdList = new ArrayList<>();
            newsIdList.add(newsId);
            // 分发消息
            ResultDO<Void> sendNewsToUserResultDO = sendNewsToUser(userIdList, newsIdList);
            // 返回值判断
            if (sendNewsToUserResultDO.isSuccess() == false) {
                LOG.error("send news to user fail, resultDO={}, userIdList={}, newsIdList={}", sendNewsToUserResultDO,
                    userIdList, newsIdList);
                return new ResultDO<>(false, sendNewsToUserResultDO.getCode(), sendNewsToUserResultDO.getMsg());
            }
            // 发送成功
            LOG.info("send news to user success, resultDO={}, userIdList={}, newsIdList={}", sendNewsToUserResultDO,
                userIdList, newsIdList);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("send news to user list error, userIdList={}, title={}, content={}", userIdList, title, content,
                e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //设置消息已读
    @Override
    public ResultDO<Void> turnTOReaded(long userId, long newsId) {
        if (userId <= 0 || newsId <= 0) {
            LOG.error("turn to readed fail, userId={}, newsId={}", userId, newsId);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            userNewsDAO.updateStateByUserIdAndNewsId(userId, newsId, NewsState.READED);
            LOG.info("turn to readed success, userId={}, newsId={}", userId, newsId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("turn to readed success, userId={}, newsId={}", userId, newsId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //设置消息未读
    @Override
    public ResultDO<Void> turnToUnread(long userId, long newsId) {
        if (userId <= 0 || newsId <= 0) {
            LOG.error("turn to unread fail, userId={}, newsId={}", userId, newsId);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            userNewsDAO.updateStateByUserIdAndNewsId(userId, newsId, NewsState.UNREAD);
            LOG.info("turn to unread success, userId={}, newsId={}", userId, newsId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("turn to unread success, userId={}, newsId={}", userId, newsId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //通过id设置全部已读
    @Override
    public ResultDO<Void> turnAllToReaded(long userId) {
        // 入参核验
        if (userId <= 0) {
            LOG.error("turn all to readed fail, userId <= 0, userId={}", userId);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        List<Long> unreadList = userNewsDAO.getNoReadNewsIdByUserId(userId);
        // 全部已读
        if (unreadList.isEmpty() == true) {
            LOG.info("turn all to readed success, unreadList={}, userId={}", unreadList, userId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
        // 有未读消息
        // 合法性,存在性核验
        NewsDO newsDO = new NewsDO();
        for (long newsId : unreadList) {
            if (newsId <= 0) {
                LOG.error("turn all to readed fail, newsId <= 0, newsId={}, userId={}", newsId, userId);
                return new ResultDO<>(false, ResultCode.UNKNOW_NEWS, ResultCode.MSG_UNKNOW_NEWS);
            }
            newsDO = newsDAO.getNewsDOById(newsId);
            if (newsDO == null) {
                LOG.error("turn all to readed fail, newsDO is null, newsId={}, userId={}", newsId, userId);
                return new ResultDO<>(false, ResultCode.UNKNOW_NEWS, ResultCode.MSG_UNKNOW_NEWS);
            }
        }
        try {
            // 标记为已读
            for (long newsId : unreadList) {
                userNewsDAO.updateStateByUserIdAndNewsId(userId, newsId, NewsState.READED);
            }
            LOG.info("turn all to readed success, userId={}", userId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("turn all to readed error, userId={}", userId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> turnAlltoUnread(long userId) {
        // 入参核验
        if (userId <= 0) {
            LOG.error("turn all to readed fail, userId <= 0, userId={}", userId);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        List<Long> readedList = userNewsDAO.getReadedNewsIdByUserId(userId);
        // 全部未读
        if (readedList.isEmpty() == true) {
            LOG.info("turn all to unread success, readedList={}, userId={}", readedList, userId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
        // 有已读消息
        // 合法性,存在性核验
        NewsDO newsDO = new NewsDO();
        for (long newsId : readedList) {
            if (newsId <= 0) {
                LOG.error("turn all to unread fail, newsId <= 0, newsId={}, userId={}", newsId, userId);
                return new ResultDO<>(false, ResultCode.UNKNOW_NEWS, ResultCode.MSG_UNKNOW_NEWS);
            }
            newsDO = newsDAO.getNewsDOById(newsId);
            if (newsDO == null) {
                LOG.error("turn all to unread fail, newsDO is null, newsId={}, userId={}", newsId, userId);
                return new ResultDO<>(false, ResultCode.UNKNOW_NEWS, ResultCode.MSG_UNKNOW_NEWS);
            }
        }
        try {
            // 标记为未读
            for (long newsId : readedList) {
                userNewsDAO.updateStateByUserIdAndNewsId(userId, newsId, NewsState.UNREAD);
            }
            LOG.info("turn all to readed success, userId={}", userId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("turn all to unread error, userId={}", userId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //通过id查找消息
    @Override
    public ResultDO<NewsDO> getNewsDOById(long id) {
        if (id <= 0) {
            LOG.error("get newsDO by id fail, parameter invalid, id={}", id);
            return new ResultDO<NewsDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            NewsDO newsDO = newsDAO.getNewsDOById(id);
            LOG.info("get newsDO by id success, id={}, newsDO={}", id, newsDO);
            return new ResultDO<NewsDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, newsDO);
        } catch (Exception e) {
            LOG.error("get newsDO by id error, id={}", id, e);
            return new ResultDO<NewsDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //删除所有已读通知
    @Override
    public ResultDO<Void> deleteAllReadedNewsByUserId(long userId) {
        if (userId <= 0) {
            LOG.error("delete all readed news by userId fail, parameter invalid, userId={}", userId);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 删除已读通知
            userNewsDAO.deleteAllReadedNewsByUserId(userId);
            LOG.info("delete all readed news by userId success, userId={}", userId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("delete all readed news by userId error, userId={}", userId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }
}
