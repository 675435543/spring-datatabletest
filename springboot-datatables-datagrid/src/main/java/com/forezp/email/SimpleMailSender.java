package com.forezp.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.forezp.utils.CommonsConstants;
import com.forezp.utils.PropertiesUtils;


public class SimpleMailSender
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailSender.class);
    
    /**   
    * 以文本格式发送邮件   
    * @param mailInfo mailInfo
    * @param authenName authenName
    * @param authenPwd authenPwd 
    * @param senderEmail senderEmail  
    * @return boolean boolean
    */
    public static boolean sendTextMail(MailSenderInfo mailInfo, String authenName, String authenPwd, String senderEmail)
    {
		final String username = PropertiesUtils.getConfig(CommonsConstants.USER_NAME);
		final String password = PropertiesUtils.getConfig(CommonsConstants.PASSWORD);

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", PropertiesUtils.getConfig(CommonsConstants.HOST));
		props.put("mail.smtp.port", PropertiesUtils.getConfig(CommonsConstants.PORT));

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
				}
		});
        try
        {
            // 根据session创建一个邮件消息    
            Message mailMessage = new MimeMessage(session);
            // 创建邮件发送者地址    
            Address from = new InternetAddress(senderEmail);
            // 设置邮件消息的发送者    
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中    
            InternetAddress[] sendTo = new InternetAddress[mailInfo.getToAddress().length];
            for (int i = 0; i < mailInfo.getToAddress().length; i++)
            {
                sendTo[i] = new InternetAddress(mailInfo.getToAddress()[i]);
            }
            mailMessage.setRecipients(Message.RecipientType.TO, sendTo);
            
            // 创建邮件的抄送者地址，并设置到邮件消息中    
            if (mailInfo.getCcAddress() != null)
            {
                InternetAddress[] sendCc = new InternetAddress[mailInfo.getCcAddress().length];
                for (int i = 0; i < mailInfo.getCcAddress().length; i++)
                {
                    sendCc[i] = new InternetAddress(mailInfo.getCcAddress()[i]);
                }
                mailMessage.setRecipients(Message.RecipientType.CC, sendCc);
            }
            // 设置邮件消息的主题    
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间    
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容    
            String mailContent = mailInfo.getContent();
            mailMessage.setText(mailContent);
            // 发送邮件    
            Transport.send(mailMessage);
            return true;
        }
        catch (MessagingException ex)
        {
            LOGGER.error(ex.toString(), ex);
            return false;
        }
    }
        /** */
    /**   
    * 以HTML格式发送邮件   
    * @param mailInfo mailInfo
    * @return boolean boolean   
    */
    public static boolean sendHtmlMail(MailSenderInfo mailInfo)
    {
		final String username = PropertiesUtils.getConfig(CommonsConstants.USER_NAME);
		final String password = PropertiesUtils.getConfig(CommonsConstants.PASSWORD);

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", PropertiesUtils.getConfig(CommonsConstants.HOST));
		props.put("mail.smtp.port", PropertiesUtils.getConfig(CommonsConstants.PORT));

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
				}
		});
        try
        {
            // 根据session创建一个邮件消息    
            Message mailMessage = new MimeMessage(session);
            // 创建邮件发送者地址    
            Address from = new InternetAddress(PropertiesUtils.getConfig(CommonsConstants.USER_EMAIL));
            // 设置邮件消息的发送者    
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中    
            if (mailInfo.getToAddress() != null)
            {
                InternetAddress[] sendTo = new InternetAddress[mailInfo.getToAddress().length];
                for (int i = 0; i < mailInfo.getToAddress().length; i++)
                {
                    sendTo[i] = new InternetAddress(mailInfo.getToAddress()[i]);
                }
                mailMessage.setRecipients(Message.RecipientType.TO, sendTo);
            }
            
            // 创建邮件的抄送者地址，并设置到邮件消息中    
            if (mailInfo.getCcAddress() != null)
            {
                InternetAddress[] sendCc = new InternetAddress[mailInfo.getCcAddress().length];
                for (int i = 0; i < mailInfo.getCcAddress().length; i++)
                {
                    sendCc[i] = new InternetAddress(mailInfo.getCcAddress()[i]);
                }
                mailMessage.setRecipients(Message.RecipientType.CC, sendCc);
            }
            // 设置邮件消息的主题    
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间    
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象    
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart    
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容    
            html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容    
            mailMessage.setContent(mainPart);
            // 发送邮件    
            Transport.send(mailMessage);
            return true;
        }
        catch (MessagingException ex)
        {
            LOGGER.error(ex.toString(), ex);
            return false;
        }
    }
}
