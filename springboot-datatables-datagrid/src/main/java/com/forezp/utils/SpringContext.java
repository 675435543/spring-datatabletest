package com.forezp.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component
public class SpringContext implements ApplicationContextAware
{
    private static ApplicationContext context;
    
    public static void setContext(ApplicationContext context)
    {
        SpringContext.context = context;
    }

    /**
     * 设置上下文对象
     * @param arg0 上下文对象
     */
    @Override
    public void setApplicationContext(ApplicationContext arg0)
    {
        setContext(arg0);
    }
    
    /**
     * 获得spring对象
     * @param cls 类对象
     * @return T 对象
     */
    public static <T> T getBean(Class<T> cls)
    {
        return context.getBean(cls);
    }
    
    public static ApplicationContext getContext()
    {
        return context;
    }
}


