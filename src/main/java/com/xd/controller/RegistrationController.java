package com.xd.controller;

import com.google.gson.Gson;
import com.xd.dao.ConsultInfoMapper;
import com.xd.pojo.ConsultDoctor;
import com.xd.pojo.ConsultInfo;
import com.xd.service.ConsultService;
import com.xd.service.RegistrationService;
import com.xd.service.impl.ConsultServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RegistrationController {

    Gson gson = new Gson();


    private ConsultService consultService;

    private RegistrationService registrationService;

    @Autowired
    public void setConsultService(ConsultService consultService){
        this.consultService = consultService;
    }
    @Autowired
    public void setRegistrationService(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@Param("date") String date, @Param("group") String group){
        List<ConsultDoctor> list = consultService.listByDateAndGroup(date,group);
        String resJson = gson.toJson(list);
        return resJson;
    }

    @RequestMapping(value="register",method = RequestMethod.POST)
    public String registration(@Param("tel")String tel,@Param("c_id")int c_id){
        Map map = new HashMap<String,String>();
        try{
            String res = registrationService.addRegistration(tel,c_id);
            map.put("message","预约成功");
            map.put("id",res);
        }catch (Exception e){
            map.put("message",e.getMessage());
        }finally {
            return gson.toJson(map);
        }
    }

    @RequestMapping(value="cancel",method = RequestMethod.POST)
    public String cancel(@Param("tel")String tel){
        Map map = new HashMap<String,String>();
        try{
            int res = registrationService.cancelRegistration(tel);
            if(res == 1)
                map.put("message","取消成功");
            else
                map.put("message","该手机号未预约过");
        }catch (RuntimeException e){
            map.put("message",e.getMessage());
        }finally {
            return gson.toJson(map);
        }
    }
}
