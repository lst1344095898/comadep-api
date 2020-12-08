package com.lst.comadep.Dao;

import com.lst.comadep.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Mapper
@Repository
public interface UserDao {
    User check(@Param("userName") String userName);
    int register(@Param("userName") String userName, @Param("password") String password, @Param("address") String address,
                 @Param("telephoneNumber") String telephoneNumber, @Param("sex") String sex,
                 @Param("age") int age, @Param("createTime")Date createTime);
    User selectUserById(@Param("id") int id);
}
