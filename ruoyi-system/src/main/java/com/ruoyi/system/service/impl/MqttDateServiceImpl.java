package com.ruoyi.system.service.impl;


import com.ruoyi.system.domain.DateTime;
import com.ruoyi.system.domain.MqttDate;
import com.ruoyi.system.mapper.MqttDateMapper;
import com.ruoyi.system.service.MqttDateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MqttDateServiceImpl implements MqttDateService {
    private Logger logger = LoggerFactory.getLogger(MqttDateServiceImpl.class);
    @Autowired
    private MqttDateMapper mqttDateMapper;
    @Override
    public void insert(String str){
        DateTime dt=new DateTime();
        System.out.println(dt);
        MqttDate md=new MqttDate();
        md.setMqtt_time(dt.getTimetime());
        md.setMqtt_baowen1(str.substring(0, 2));
        md.setMqtt_baowen2(str.substring(3, 4));
        mqttDateMapper.insert(md);
    }
}
