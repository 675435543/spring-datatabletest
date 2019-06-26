package com.forezp.jdksource;


import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
/*
        map.put("000"," 部门1 | 部门2 | 部门3 | 部门4 | 部门5 | 部门6");
        map.put("001"," 部门1 | 部门2 | 部门3 | 部门4  | 部门5");
        map.put("002"," 部门1 | 部门2 | 部门3 | 部门4 ");
        map.put("003"," 部门1 | 部门2 | 部门3 ");
*/
        //去掉path里面部门和|之间的空格
        //将path和collection以键值对的形式保存到map
        String path = "部门1 | 部门2 | 部门3 | 部门4 | 部门5 | 部门6 ";
        String path1 = "|||||";
        String path2 = " ";
        String pathn = processPath(path1);
        System.out.println("test");
    }

    /**
     * 删除path里面部门和|之间的空格
     * @param path String
     * @return String
     */
    public static String processPath(String path)
    {
        if (StringUtils.isEmpty(path))
        {
            return path;
        }
        String [] dep = path.split("\\|");
        StringBuilder s = new StringBuilder();
        for (int i=0; i<dep.length; i++)
        {
            String temp = dep[i].trim();
            s.append(temp).append("|");
        }
        String str = s.toString();
        str = str.substring(0, s.length() - 1);
        return str;
    }

    /**
     * 根据path获取所有的父级部门的path信息
     * @param path String
     * @return List
     */
    public static List<String> getParentList(String path)
    {
        return null;
    }

}
