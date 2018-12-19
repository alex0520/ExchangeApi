package com.colpatria.alozano.exchange.exception;

public class ExchangeException extends RuntimeException {

    private static final long serialVersionUID = -7100172815005092057L;

    private final String message;

    public ExchangeException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
