package Estoque_CRUD.core.infra;

import Estoque_CRUD.core.exception.EmptyListException;
import Estoque_CRUD.core.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageRestError> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)
    {
        String errorMessage =ex.getBindingResult().getFieldErrors().stream().map(error->error.getDefaultMessage()).findFirst().orElse("Erro de validação");
        MessageRestError messageRestError = new MessageRestError(HttpStatus.BAD_REQUEST,errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageRestError);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<MessageRestError>IdNotFoundExceptionHandler(IdNotFoundException ex)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageRestError);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<MessageRestError> EmptyListExceptionHandler(EmptyListException ex)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageRestError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageRestError>GlobalExceptionHandler()
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.INTERNAL_SERVER_ERROR,"Erro interno, tente novamente mais tarde");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageRestError);
    }
}
