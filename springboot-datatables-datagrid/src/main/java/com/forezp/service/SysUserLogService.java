package com.forezp.service;

import com.forezp.entity.SysUserLog;
import com.forezp.entity.SysUserLogQuery;
import com.github.pagehelper.PageInfo;

public interface SysUserLogService {

    /**
     * 添加系统用户日志
     *
     * @param sysUserLog 日志信息
     */
    void addUserLog(SysUserLog sysUserLog);

    /**
     * 分页获取日志列表
     *
     * @param query  查询参数
     * @param start  页数
     * @param length 每页个数
     * @return
     */
    PageInfo queryPage(SysUserLogQuery query, Integer start, Integer length) throws Exception;
}