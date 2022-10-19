package com.ssafy.mvc;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeansException;

import org.springframework.context.ApplicationContext;

import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHolder implements ApplicationContextAware {

    public static List<ApplicationContext> list = new ArrayList<ApplicationContext>();

    @Override
    public void setApplicationContext(ApplicationContext ctx)

            throws BeansException {
        System.out.println("setApplicationContext() 실행");

        list.add(ctx);

    }
}