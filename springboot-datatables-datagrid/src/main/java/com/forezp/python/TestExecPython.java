package com.forezp.python;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试java和python的调用流程
 * @author webim
 *
 */
public enum TestExecPython
{
    INSTANCE;

    public void test()
    {
        String scriptFile = "E:/github/spring-datatabletest/springboot-datatables-datagrid/src/main/java/com/forezp/python/test.py";
        Map<String,String> properties = new HashMap<String,String>();
        properties.put("userName", "Demo");

        ExecPython.INSTANCE.execute(scriptFile, properties);
    }
}
