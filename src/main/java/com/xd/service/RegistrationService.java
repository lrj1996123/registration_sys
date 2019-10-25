package com.xd.service;

import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {
    String addRegistration(String tel,int c_id);
    int cancelRegistration(String tel);
}
