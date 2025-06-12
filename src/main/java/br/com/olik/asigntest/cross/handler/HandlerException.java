package br.com.olik.asigntest.cross.handler;

import br.com.olik.asigntest.domain.exception.TransactionBadRequestException;
import br.com.olik.asigntest.infra.exception.ModelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ApiException> handlerRuleNotFoundException(ModelNotFoundException ex) {
        return ResponseEntity.status(NOT_FOUND)
                .body(createResponseException(ex.getMessage(), NOT_FOUND.value()));
    }

    @ExceptionHandler(TransactionBadRequestException.class)
    public ResponseEntity<ApiException> handlerRuleBadRequestException(TransactionBadRequestException ex) {
        return ResponseEntity.status(BAD_REQUEST)
                .body(createResponseException(ex.getMessage(), BAD_REQUEST.value()));
    }

    private ApiException createResponseException(String message, int statusCode) {
        return new ApiException(message, statusCode);
    }
}
