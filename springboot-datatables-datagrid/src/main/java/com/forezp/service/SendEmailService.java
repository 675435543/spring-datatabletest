package com.forezp.service;

import java.util.List;

import com.forezp.entity.ProblemList;

public interface SendEmailService {
    public boolean problemListSendEmail(String[] mailToArry, String[] mailCcArry, String subject,String emailContentDetail, List<ProblemList> problemListSelected, String url,String emailType);
}
