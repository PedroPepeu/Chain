package br.com.api.chain.services.exceptions;

public class EmailNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public EmailNotFoundException(String email){
        super("Email not found, email = " + email);
    }
}
