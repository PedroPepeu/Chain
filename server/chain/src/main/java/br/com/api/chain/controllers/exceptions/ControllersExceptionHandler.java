package br.com.api.chain.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.api.chain.services.exceptions.EmailAlreadyExistsException;
import br.com.api.chain.services.exceptions.EmailNotFoundException;
import br.com.api.chain.services.exceptions.InvalidUserDataException;
import br.com.api.chain.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllersExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest req){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<StandartError> emailNotFound(EmailNotFoundException e, HttpServletRequest req){
        String error = "Email not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<StandartError> emailAlreadyExists(EmailAlreadyExistsException e, HttpServletRequest req){
        String error = "Email already exists";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InvalidUserDataException.class)
    public ResponseEntity<StandartError> invalidData(InvalidUserDataException e, HttpServletRequest req){
        String error = "Invalid Data";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
