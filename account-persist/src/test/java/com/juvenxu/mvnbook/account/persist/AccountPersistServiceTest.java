package com.juvenxu.mvnbook.account.persist;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AccountPersistServiceTest
{
    private ClassPathXmlApplicationContext ctx;
    private AccountPersistService service;
    
    @Before
    public void prepare()
        throws Exception
    {
        File persistDataFile = new File("target/test-classes/persist-data.xml");
        if (persistDataFile.exists())
        {
            persistDataFile.delete();
        }
        
        ctx = new ClassPathXmlApplicationContext("account-persist.xml");
        service = ctx.getBean(AccountPersistService.class);
        
        Account account = new Account();
        account.setId("juven");
        account.setName("Juven Xu");
        account.setEmail("juven@changeme.com");
        account.setPassword("this_should_be_encrypted");
        account.setActivated(true);
        
        service.createAccount(account);
    }
    
    @After
    public void postpare()
    {
        if (ctx != null) {
            ctx.close();
        }
    }
    
    @Test
    public void testReadAccount()
    {
        Account account = service.readAccount("juven");
        
        assertNotNull(account);
        assertEquals("juven", account.getId());
        assertEquals("Juven Xu", account.getName());
        assertEquals("juven@changeme.com", account.getEmail());
        assertEquals("this_should_be_encrypted", account.getPassword());
        assertTrue(account.isActivated());
    }

}
