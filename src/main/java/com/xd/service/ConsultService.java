package com.xd.service;

import com.xd.dao.ConsultInfoMapper;
import com.xd.pojo.ConsultDoctor;
import com.xd.pojo.ConsultInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface ConsultService {

    List<ConsultDoctor> listByDateAndGroup(String date, String group);
}
