package org.grow90.finmlapi.exceptionutility;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class DatabaseException  extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DatabaseException(String exception) {
        super(exception);
    }
}
