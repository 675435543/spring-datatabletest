package com.forezp.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
public class MyAuthenticator extends Authenticator
{
    String userName = null;
    
    String password = null;
    
    /**
     *  MyAuthenticator 无参构造方法
     */
    public MyAuthenticator()
    {
    }
    
    /**
     *  MyAuthenticator 有参构造方法
     * @param username username
     * @param password password
     */
    public MyAuthenticator(String username, String password)
    {
        this.userName = username;
        this.password = password;
    }
    
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(userName, password);
    }
}
