package com.h2.db.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CashMachineException extends RuntimeException {
    public CashMachineException() {
        super();
    }

    public CashMachineException(String message, Throwable cause) {
        super(message, cause);
    }

    public CashMachineException(String message) {
        super(message);
    }

    public CashMachineException(Throwable cause) {
        super(cause);
    }
}
