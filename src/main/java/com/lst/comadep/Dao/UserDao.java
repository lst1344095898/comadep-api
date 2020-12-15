package com.lst.comadep.Dao;

import com.lst.comadep.Entity.OriginalUser;
import com.lst.comadep.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Mapper
@Repository
public interface UserDao {
    User check(@Param("telephoneNumber") String telephoneNumber);
    OriginalUser PropertyUserCheck(@Param("telephoneNumber") String telephoneNumber);
    int register(@Param("id") int id,@Param("userName") String userName, @Param("password") String password, @Param("address") String address,
                 @Param("telephoneNumber") String telephoneNumber,@Param("powerCode") int powerCode, @Param("sex") String sex,
                 @Param("age") int age, @Param("createTime")Date createTime,@Param("gmtModified") Date gmtModified,@Param("buildingNumber") int buildingNumber,
                 @Param("floor") String floor);
    int updateRegisterIsActivationById(@Param("id") int id);
    User selectUserById(@Param("id") int id);
    User selectUserByIdInOriginal(@Param("id") int id);
    int importUser(@Param("userName") String userName, @Param("password") String password, @Param("address") String address,
                   @Param("telephoneNumber") String telephoneNumber,@Param("sex") String sex,
                   @Param("age") int age, @Param("createTime")Date createTime,@Param("gmtModified") Date gmtModified,@Param("buildingNumber") int buildingNumber,
                   @Param("floor") String floor);

}
