package com.xd.dao;

import com.xd.pojo.RegistrationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface RegistrationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegistrationInfo record);

    int insertSelective(RegistrationInfo record);

    RegistrationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RegistrationInfo record);

    int updateByPrimaryKey(RegistrationInfo record);

    int checkByTel(String tel);

    int deleteByTel(String tel);

    RegistrationInfo selectByTel(String tel);
}