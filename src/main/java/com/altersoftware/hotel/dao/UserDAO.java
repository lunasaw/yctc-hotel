package com.altersoftware.hotel.dao;

import java.util.List;

import com.altersoftware.hotel.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface UserDAO {

    /**
     * 插入一个用户
     *
     * @param userDO
     */
    public void insert(UserDO userDO);

    /**
     * id查询用户
     *
     * @param id
     * @return
     */
    public UserDO getUserDOById(long id);

    /**
     * 用户名和密码验证用户
     *
     * @param name
     * @param password
     * @return
     */
    public UserDO getUserDOByNumberAndPassword(@Param("number") String number, @Param("password") String password);

    /**
     * 更新用户信息
     *
     * @param userDO
     */
    public void update(UserDO userDO);

    /**
     * id删除用户
     *
     * @param id
     */
    public void deleteById(long id);

    /**
     * 学号/教师工号查询用户
     *
     * @param number
     * @return
     */
    public UserDO getUserDOByNumber(String number);

    /**
     * 邮箱查找用户
     *
     * @param mail
     * @return
     */
    public UserDO getUserDOByMail(String mail);

    /**
     * faceToken查找学生
     *
     * @param faceToken
     * @return
     */
    public UserDO getUserDOByFaceToken(String faceToken);

    /**
     * phone查找用户
     *
     * @param phone
     * @return
     */
    public UserDO getUserDOByPhone(String phone);

    /**
     * 通过学院返回教师集
     *
     * @param academyId
     * @return
     */
    public List<UserDO> getTeacherDOByAcademyId(long academyId);

    /**
     * 返回库中学院id集
     *
     * @return
     */
    public List<Long> getAcademies();

    /**
     * 通过学院返回班级集
     *
     * @param academyId
     * @return
     */
    public List<Long> getClassIdsByAcademyId(long academyId);

    /**
     * 通过学院和班级返回学生集
     *
     * @param academyId
     * @param classId
     * @return
     */
    public List<UserDO> getStudentDOByAcademyIdAndClassId(@Param("academyId") long academyId, @Param("classId") long classId);

    /**
     * 返回库中班级id集
     *
     * @return
     */
    public List<Long> getClasses();

    /**
     * 通过userNumber查询userId
     *
     * @param userNumber
     * @return
     */
    public long getIdByNumber(String userNumber);

    /**
     * 通过userDO返回学院id
     * 
     * @param userDO
     * @return
     */
    public long getAcademyIdByUserDO(UserDO userDO);

    /**
     * 判断classId是否存在
     * 
     * @param classId
     * @return
     */
    public Long checkByClassId(long classId);

}
