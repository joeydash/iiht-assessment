package org.grow90.finmlapi.exceptionutility;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RecordNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(String exception) {
        super(exception);
    }
}

