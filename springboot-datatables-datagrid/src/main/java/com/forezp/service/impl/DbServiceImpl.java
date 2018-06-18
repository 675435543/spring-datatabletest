package com.forezp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forezp.dao.DbMapper;
import com.forezp.service.DbService;
import com.forezp.utils.DateUtil;

@Service("dbService")
public class DbServiceImpl implements DbService{
    @Autowired
    private DbMapper dbMapper;

    @Override
    public void createTable(String preName, Boolean sufTime) {
        if (sufTime) {
            dbMapper.createUserLogTable(preName + "_" + getSufName());
        } else {
            dbMapper.createUserLogTable(preName);
        }
    }

    /**
     * 获取名称后缀<br>
     * 格式: 20170301
     *
     * @return
     */
    private String getSufName() {
        Date d = new Date();
        String s = DateUtil.date2String(d, false);
        return s.replace("-", "");
    }
}
