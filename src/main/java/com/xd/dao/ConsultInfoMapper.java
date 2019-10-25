package com.xd.dao;

import com.xd.pojo.ConsultDoctor;
import com.xd.pojo.ConsultInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ConsultInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsultInfo record);

    int insertSelective(ConsultInfo record);

    ConsultInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsultInfo record);

    int updateByPrimaryKey(ConsultInfo record);

    List<ConsultDoctor> listByDateAndGroup(@Param("date")String date,   @Param("group")String group);
}