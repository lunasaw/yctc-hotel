package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.UserDO;

@Mapper
public interface UserDAO {

    /**
     * 插入一个用户
     *
     * @param userDO
     */
    @Insert(" INSERT INTO tb_user (id, number, department_id, account, age, password, name, type, sex, id_card_number, phone, mail, picture, face_token, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{number}, #{departmentId}, #{account}, #{age}, #{password}, #{name}, #{type}, #{sex},  #{idCardNumber}, #{contactPhone}, #{email}, #{faceId}, #{faceToken},  NOW(), NOW()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(UserDO userDO);

    /**
     * id查询用户
     *
     * @param id
     * @return
     */

    @Select(" select id, number, department_id, face_token, name, type, id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where id=#{id} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "name", column = "name"),
        @Result(property = "type", column = "type"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserDO getUserDOById(long id);

    /**
     * 通过手机和密码验证用户
     *
     * @param contactPhone
     * @param password
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where phone=#{contactPhone} and password=#{password}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "name", column = "name"),
        @Result(property = "type", column = "type"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserDO getUserDOByMobileAndPassword(@Param("contactPhone") String contactPhone, @Param("password") String password);

    /**
     * 通过邮箱和密码验证用户
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where mail=#{email} and password=#{password} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "name", column = "name"),
        @Result(property = "type", column = "type"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserDO getUserDOByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    /**
     * 更新用户
     * 
     * @param staffDO
     * @return
     */
    @Update("update tb_user  set name=#{name},number=#{number}, department_id=#{departmentId}, type=#{type}, id_card_number=#{idCardNumber}, sex=#{sex}, age=#{age}, phone=#{contactPhone}, account=#{account}, password=#{password}, picture=#{faceId},face_token=#{faceToken},  mail=#{email}, modify_time=now()"
        +
        "where id=#{id}")
    int update(UserDO staffDO);

    /**
     * id删除用户
     *
     * @param id
     */
    @Delete("DELETE FROM tb_user WHERE id=#{id}")
    void deleteById(long id);

    /**
     * id删除用户
     *
     * @param userNumber
     */
    @Delete("DELETE FROM tb_user WHERE number=#{userNumberid}")
    void deleteByuserNumber(String userNumber);

    /**
     * 会员号/员工工号查询用户
     *
     * @param number
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where number=#{number} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "name", column = "name"),
        @Result(property = "type", column = "type"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserDO getUserDOByNumber(String number);

    /**
     * 会员号/员工号和密码查询用户
     *
     * @param number
     * @param password
     * @return UserDO
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where number=#{number} and password=#{password}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "name", column = "name"),
        @Result(property = "type", column = "type"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserDO getUserDOByNumberAndPassword(@Param("number") String number, @Param("password") String password);

    /**
     * 邮箱查找用户
     *
     * @param mail
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where mail=#{email} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "name", column = "name"),
        @Result(property = "type", column = "type"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserDO getUserDOByMail(String mail);

    /**
     * faceToken查找用户
     *
     * @param faceToken
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where face_token=#{faceToken} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "name", column = "name"),
        @Result(property = "type", column = "type"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserDO getUserDOByFaceToken(String faceToken);

    /**
     * phone查找用户
     *
     * @param phone
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where phone=#{contactPhone} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "name", column = "name"),
        @Result(property = "type", column = "type"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserDO getUserDOByPhone(String phone);

    /**
     * 通过部门返回员工集
     *
     * @param departmentId
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where face_token=#{faceToken} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "type", column = "type"),
        @Result(property = "name", column = "name"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<UserDO> getStaffDOBydepartmentId(long departmentId);

    /**
     * 返回库中前台集
     *
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where type=100002 ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "type", column = "type"),
        @Result(property = "name", column = "name"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<UserDO> getReception();

    /**
     * 返回库中保洁集
     *
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where type=100003 ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "type", column = "type"),
        @Result(property = "name", column = "name"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<UserDO> getClean();

    /**
     * 返回库中保安集
     *
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where type=100004 ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "type", column = "type"),
        @Result(property = "name", column = "name"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<UserDO> getRroctect();

    /**
     * 返回库中客户集
     *
     * @return
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where type=100000 ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "type", column = "type"),
        @Result(property = "name", column = "name"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<UserDO> getCustomer();

    /**
     * 通过faceId查找用户
     *
     * @param faceId
     */
    @Select(" select id, number, department_id, face_token ,  name, type,  id_card_number, sex, age, phone, account, password, picture, mail, create_time, modify_time"
        +
        " from tb_user where picture=#{faceId} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "number", column = "number"),
        @Result(property = "type", column = "type"),
        @Result(property = "name", column = "name"),
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "idCardNumber", column = "id_card_number"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "age", column = "age"),
        @Result(property = "contactPhone", column = "phone"),
        @Result(property = "account", column = "account"),
        @Result(property = "password", column = "password"),
        @Result(property = "faceId", column = "picture"),
        @Result(property = "faceToken", column = "face_token"),
        @Result(property = "email", column = "mail"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserDO getUserDOByfaceId(@Param("faceId") String faceId);

}
