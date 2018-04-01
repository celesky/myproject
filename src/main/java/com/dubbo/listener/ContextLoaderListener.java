package com.dubbo.listener;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;

public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener{


    /**
     * Initialize the root web application context.
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {

        super.contextInitialized(event);
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
        //EchoServiceExporter.exportService((DefaultListableBeanFactory)applicationContext.getAutowireCapableBeanFactory());
    }

}
