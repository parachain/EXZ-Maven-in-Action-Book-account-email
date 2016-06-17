package com.juvenxu.mvnbook.account.email;

import static java.lang.String.format;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AccountEmailServiceImpl implements AccountEmailService
{
    private JavaMailSender javaMailSender;
    private String systemEmail;

    @Override
    public void sendMail(String to, String subject, String htmlText) throws AccountEmailException
    {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
        
        try
        {
            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            msgHelper.setText(htmlText, true);
            
            javaMailSender.send(msg);
        }
        catch (MessagingException e)
        {
            throw new AccountEmailException(format("Failed to send email. Subject: [%s], To: [%s]", subject, to), e);
        }
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
