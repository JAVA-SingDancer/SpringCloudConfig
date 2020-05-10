package com.app.controller;

import com.app.entity.HollEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Slf4j
@CrossOrigin
public class TestController {
    @GetMapping("/test")
    public String test(HollEntity hollEntity)
    {
        log.info(hollEntity.toString());
        if ("婚假".equals(hollEntity.getType()))
        {
            //说明既是婚假且中间有休息日（查询数据库）
            if ("1".equals(hollEntity.getId()))
            {
                int result=transform(hollEntity.getStartTime(),hollEntity.getEndTime());
                return "请假天数为:"+result;
            }
            return "请假天数为:"+transform(hollEntity.getStartTime(),hollEntity.getEndTime());
        }
        return "请假天数为:"+transform(hollEntity.getStartTime(),hollEntity.getEndTime());
    }
    //获取天数
    public int transform(String startTime,String endTime)
    {
        startTime=startTime.substring(9,11);
        endTime=startTime.substring(9,11);
        int start=Integer.parseInt(startTime);
        int end=Integer.parseInt(endTime);
        return end-start;
    }
}
