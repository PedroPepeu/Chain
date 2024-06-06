package br.com.api.chain.services.exceptions;

public class InvalidUserDataException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public InvalidUserDataException(){
        super("Invalid data");
    }
}
