package com.forezp.utils;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
public final class PropertiesUtils
{
    /**
     * 同步锁
     */
    private static final Object LOCK = new Object();
    
    private static final Environment ENVIRONMENT = SpringContext.getBean(Environment.class);
    
    private PropertiesUtils()
    {
    }
    
    /**
     * 获取系统配置文件的键值
     * @param key key
     * @return key对应的配置内容
     */
    public static String getConfig(String key)
    {
        synchronized (LOCK)
        {
            if (ENVIRONMENT != null)
            {
                return ENVIRONMENT.getProperty(key);
            }
            return null;
        }
    } 
}
