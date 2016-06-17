package com.juvenxu.mvnbook.account.email;

import static junit.framework.Assert.assertEquals;

import javax.mail.Message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest
{
    private GreenMail greenMail;
    
    @Before
    public void startMailServer()
    {
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("test@juvenxu.com", "123456");
        greenMail.start();
    }
    
    @Test
    public void testSendMail() throws Exception
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        
        try {
            AccountEmailService accountEmailService = ctx.getBean(AccountEmailService.class);
            
            String subject = "Test Subject";
            String htmlText = "<h3>Test</h3>";
            accountEmailService.sendMail("test@juvenxu.com", subject, htmlText);
            
            greenMail.waitForIncomingEmail(2000, 1);
            
            Message msg = greenMail.getReceivedMessages()[0];
            assertEquals(subject, msg.getSubject());
            assertEquals(htmlText, GreenMailUtil.getBody(msg).trim());
        }
        finally {
            ctx.close();
        }
    }
    
    @After
    public void stopMailServer()
    {
        greenMail.stop();
    }

}
