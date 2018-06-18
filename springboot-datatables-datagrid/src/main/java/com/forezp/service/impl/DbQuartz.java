package com.forezp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.forezp.service.BaseQuartz;
import com.forezp.service.DbService;
import com.forezp.utils.SpringUtil;

@Service("dbQuartz")
public class DbQuartz implements BaseQuartz{
    private static final Logger log = LoggerFactory.getLogger(DbQuartz.class);
    /**
     * 默认表名
     */
    private static String tableName = "sys_user_log";

    @Override
    public void work() {
        try {
            //创建表
            DbService dbService = (DbService) SpringUtil.getBean("dbService");
            dbService.createTable(tableName, true);
            log.info("创建表" + tableName + "成功");
            //更新系统用户日志表表缓存
            //SysCacheUtil.flushSysUserLogTableName();
        } catch (Exception e) {
            log.error("创建表" + tableName + "失败");
            work();
        }
    }

}
