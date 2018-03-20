package com.training.homework.servlet;

import com.training.homework.util.LocalUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GlobalListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("locale", LocalUtil.getInstance());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
