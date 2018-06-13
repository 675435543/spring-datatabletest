package com.forezp.service.impl;

import java.util.List;

import com.forezp.email.MailSenderInfo;
import com.forezp.email.SimpleMailSender;
import com.forezp.entity.ProblemList;
import com.forezp.service.SendEmailService;
import com.forezp.utils.AppendHtmlMail;

public class SendEmailServiceImpl implements SendEmailService{
	
    @Override
    public boolean problemListSendEmail(String[] mailToArry, String[] mailCcArry, String subject,
        String emailContentDetail, List<ProblemList> problemListSelected, String url,String emailType)
    {
        boolean sendResult = false;
        //发邮件
        //这个类主要是设置邮件   
        MailSenderInfo mailInfo = new MailSenderInfo();
        if (mailCcArry != null)
        {
            mailInfo.setCcAddress(mailCcArry);
        }
        if(mailToArry != null)
        {
            mailInfo.setToAddress(mailToArry);
            mailInfo.setSubject(subject);
            mailInfo.setContent(AppendHtmlMail.getHtmlMail(emailContentDetail, problemListSelected, url, null,emailType));
            sendResult = SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式 的邮件
        }
        else
        {
            sendResult = false;
        }
        return sendResult;

    }
}
