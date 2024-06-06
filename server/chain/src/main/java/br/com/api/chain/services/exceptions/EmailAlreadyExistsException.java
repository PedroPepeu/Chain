package br.com.api.chain.services.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EmailAlreadyExistsException(String email){
        super("This email is already being used, email = " + email);
    }
}
