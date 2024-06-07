package br.com.api.chain.services.exceptions;

public class InvalidAccessException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public InvalidAccessException(){
        super("Invalid access exception");
    }
}
