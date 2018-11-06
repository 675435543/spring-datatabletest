package com.forezp.service;

import com.forezp.dao.AccountMapper2;
import com.forezp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService2 {
    @Autowired
    private AccountMapper2 accountMapper2;

    @Transactional
    public void transfer() throws RuntimeException{
        accountMapper2.update(90,1);
        int i=1/0;
        accountMapper2.update(110,2);
    }

    public List<Account> findAccountInfo(){
        return accountMapper2.findAccountInfo();
    }
}
