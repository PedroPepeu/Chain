package br.com.api.chain.services.exceptions;

public class EmailNotFoundException extends RuntimeException{
    
    public EmailNotFoundException(Object email){
        super("Email not found, email = " + email);
    }
}
