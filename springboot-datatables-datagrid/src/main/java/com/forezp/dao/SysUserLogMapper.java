package com.forezp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.forezp.entity.SysUserLog;
import com.forezp.entity.SysUserLogQuery;

public interface SysUserLogMapper {

    /**
     * 新增日志记录
     * @param sysUserLog
     * @return
     */
    int insert(SysUserLog sysUserLog);
    /**
     * 添加日志到指定数据库
     * @param tableName
     * @param sysUserLog
     * @return
     */
    int insertToTable(@Param("tableName") String tableName,@Param("log") SysUserLog sysUserLog);
    /**
     * 查询所有
     * @return
     */
    List<SysUserLog> selectAll(SysUserLogQuery query);


    List<SysUserLog> selectAllByTables(@Param("table") String table,@Param("query") SysUserLogQuery query);
}