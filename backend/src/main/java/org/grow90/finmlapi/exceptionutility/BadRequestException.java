package org.grow90.finmlapi.exceptionutility;

import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BadRequestException(String exception) {
        super(exception);
    }
}