package com.juvenxu.mvnbook.account.email;


public class AccountEmailException extends Exception 
{
    private static final long serialVersionUID = 4328490377315937930L;

    public AccountEmailException()
    {
        super();
    }

    public AccountEmailException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public AccountEmailException(String message)
    {
        super(message);
    }

    public AccountEmailException(Throwable cause)
    {
        super(cause);
    }
}
