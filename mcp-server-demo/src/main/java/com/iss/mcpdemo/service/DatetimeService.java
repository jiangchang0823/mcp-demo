package com.iss.mcpdemo.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DatetimeService implements IMcpProviderService {

//    @Tool(name = "当前时间", description = "获取当前时间")
//    public String formatCurrentDatetime() {
//        System.out.println("get current date timem string");
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return formatter.format(date);
//    }

    @Tool(name = "天气", description = "获取天气情况")
    public String getWeather() {
        return "晴天，微风";
    }
}
