package com.inditex.price.infrastructure.config;

import com.inditex.price.application.ApplicationException;
import com.inditex.price.application.ApplicationNotFoundException;
import com.inditex.price.domain.DomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class SpringHandlerErrors extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {DomainException.class, ApplicationException.class})
    protected ResponseEntity<Object> handleDomainAccessError(RuntimeException ex, WebRequest request) {
        var message = ex.getMessage();
        log.error(message, ex);
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ApplicationNotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundError(RuntimeException ex, WebRequest request) {
        var message = ex.getMessage();
        log.error(message, ex);
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
