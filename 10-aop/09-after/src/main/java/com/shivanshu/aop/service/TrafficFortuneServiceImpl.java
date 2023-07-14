package com.shivanshu.aop.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Road Closed!!");
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException err) {
            throw new RuntimeException(err);
        }
        return "Except Heavy Traffic this Morning";
    }
}
