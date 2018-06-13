package com.forezp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forezp.dao.AccountMapper2;
import com.forezp.entity.Account;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@Service
public class AccountService2 {

    @Autowired
    AccountMapper2 accountMapper2;

    @Transactional
    public void transfer() throws RuntimeException{
        accountMapper2.update(90,1);//鐢ㄦ埛1鍑�10鍧� 鐢ㄦ埛2鍔�10鍧�
        int i=1/0;
        accountMapper2.update(110,2);
    }
    
    public List<Account> findAccountInfo(){
    	return accountMapper2.findAccountInfo();
    }
}
