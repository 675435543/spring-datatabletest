package com.forezp.service;

public interface DbService {
    /**
     * 创建数据表
     *
     * @param preName   名称前缀
     * @param isSufTime 是否显示 时间后缀
     */
    void createTable(String preName, Boolean isSufTime);
}
