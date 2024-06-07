package br.com.api.chain.services.exceptions;

public class InvalidDateException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public InvalidDateException(){
        super("Invalid date");
    }

}
