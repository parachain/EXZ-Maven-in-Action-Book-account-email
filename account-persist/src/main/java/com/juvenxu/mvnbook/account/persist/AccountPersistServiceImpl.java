package com.juvenxu.mvnbook.account.persist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;


@Service
public class AccountPersistServiceImpl implements AccountPersistService
{
    @Value("${persist.file}")
    private String file;

    @Override
    public Account createAccount(Account account) throws AccountPersistException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Account readAccount(String id) throws AccountPersistException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Account updateAccount(Account account) throws AccountPersistException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAccount(String id) throws AccountPersistException
    {
        // TODO Auto-generated method stub
        
    }
    
    private Document readDocument() throws AccountPersistException
    {
        return null;
    }
    
    private void writeDocument(Document doc) throws AccountPersistException
    {
        
    }

    public String getFile()
    {
        return file;
    }

    public void setFile(String file)
    {
        this.file = file;
    }

}
