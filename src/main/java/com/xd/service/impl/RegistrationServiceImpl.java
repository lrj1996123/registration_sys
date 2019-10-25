package com.xd.service.impl;

import com.xd.dao.ConsultInfoMapper;
import com.xd.dao.RegistrationInfoMapper;
import com.xd.pojo.ConsultInfo;
import com.xd.pojo.RegistrationInfo;
import com.xd.service.RegistrationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Resource
    private RegistrationInfoMapper registrationInfoMapper;

    @Resource
    private ConsultInfoMapper consultInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addRegistration(String tel, int c_id) {
        //查询该就诊信息
        ConsultInfo consultInfo = consultInfoMapper.selectByPrimaryKey(c_id);
        //判断该手机号是否已经预约
        int res0 = registrationInfoMapper.checkByTel(tel);
        if(res0 == 1){
            throw new RuntimeException("该手机号已经预约，请重新输入");
        }
        Random rand = new Random();
        Date date = new Date();
        String r_id = "";
        if(consultInfo.getcNum() > 0){
            //调整该号已被占
            consultInfo.setcNum(consultInfo.getcNum() - 1);
            int res1 = consultInfoMapper.updateByPrimaryKeySelective(consultInfo);
            RegistrationInfo registrationInfo = new RegistrationInfo();

            //添加就诊记录
            registrationInfo.setrCId(c_id);
            registrationInfo.setrDId(consultInfo.getcDId());
            int ran1 = rand.nextInt(1000);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String dateString = simpleDateFormat.format(date);
            r_id = "" + ran1 + dateString;
            registrationInfo.setrId(r_id);
            registrationInfo.setrTel(tel);
            res1 = consultInfoMapper.updateByPrimaryKeySelective(consultInfo);
            int res2 = registrationInfoMapper.insert(registrationInfo);
            if(!(res1 == 1&&res2 == 1)){
                throw new RuntimeException("数据库操作异常");
            }
        }else{
            throw new RuntimeException("该专家号已满员");
        }
        return r_id;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int cancelRegistration(String tel) {
         //consultInfoMapper
         RegistrationInfo registrationInfo = registrationInfoMapper.selectByTel(tel);
        System.out.println(registrationInfo);
         int res = 1;
         if(registrationInfo !=null){
             //删除预约记录
             int res0 = registrationInfoMapper.deleteByPrimaryKey(registrationInfo.getId());
             ConsultInfo consultInfo = consultInfoMapper.selectByPrimaryKey(registrationInfo.getrCId());
             consultInfo.setcNum(consultInfo.getcNum()+1);
             //可挂号数+1
             int res1 =  consultInfoMapper.updateByPrimaryKeySelective(consultInfo);
             System.out.println(res0+" "+res1);
             if(!(res0 == 1 && res1 == 1)){
                throw new RuntimeException("数据库操作异常");
             }
         }else{
             res = 0;
         }
         return res;
    }
}
