package com.forezp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.forezp.entity.Account;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public interface AccountMapper2 {
   int update( @Param("money123") double money, @Param("id") int  id);
   //UPDATE account set money=#{money123} WHERE id=#{id}
   
   List<Account> findAccountInfo();
   
}
