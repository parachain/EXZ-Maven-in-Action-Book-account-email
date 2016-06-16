package com.juvenxu.mvnbook.account.email;

import org.springframework.mail.javamail.JavaMailSender;

public class AccountEmailServiceImpl implements AccountEmailService
{
    private JavaMailSender javaMailSender;
    private String systemEmail;

    @Override
    public void sendMail(String to, String subject, String htmlText) throws AccountEmailException
    {
        System.out.println("send mail...");
    }

    public JavaMailSender getJavaMailSender()
    {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail()
    {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail)
    {
        this.systemEmail = systemEmail;
    }

}
