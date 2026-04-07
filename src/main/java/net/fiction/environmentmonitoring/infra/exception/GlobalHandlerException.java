package net.fiction.environmentmonitoring.infra.exception;

import net.fiction.environmentmonitoring.dto.exception.ErrorDTOResponse;
import net.fiction.environmentmonitoring.infra.exception.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTOResponse> notFound(NotFoundException ex){
        return build(HttpStatus.NOT_FOUND, ex.getMessage(), "Not Found");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTOResponse> methodArgumentNotValid(MethodArgumentNotValidException ex){
        return build(HttpStatus.BAD_REQUEST, ex.getMessage(), "Bad Request");
    }

    private ResponseEntity<ErrorDTOResponse> build(HttpStatus status, String message, String error){
        return ResponseEntity.status(status)
                .body(new ErrorDTOResponse(
                        status.value(),
                        message,
                        error,
                        LocalDateTime.now()
                ));
    }

}
