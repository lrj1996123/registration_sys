package com.xd.service.impl;

import com.xd.dao.ConsultInfoMapper;
import com.xd.pojo.ConsultDoctor;
import com.xd.pojo.ConsultInfo;
import com.xd.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConsultServiceImpl implements ConsultService {
    @Resource
    private ConsultInfoMapper consultInfoMapper;

    @Override
    public List<ConsultDoctor> listByDateAndGroup(String date, String group) {
        System.out.println(date);
        System.out.println(group);
        String date1 = "'"+date+"'";
        String group1 = "'"+group+"'";
        List<ConsultDoctor> lists = consultInfoMapper.listByDateAndGroup(date1,group1);
        System.out.println(lists);
        return lists;
    }
}
