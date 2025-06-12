package br.com.olik.asigntest.domain.exception;

public class TransactionBadRequestException extends RuntimeException {

    public TransactionBadRequestException(String message){
        super(message);
    }

}
