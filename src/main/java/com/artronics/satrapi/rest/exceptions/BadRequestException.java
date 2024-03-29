package com.artronics.satrapi.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Chris on 6/30/14.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException
{
    public BadRequestException()
    {
    }

    public BadRequestException(String message)
    {
        super(message);
    }

    public BadRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BadRequestException(Throwable cause)
    {
        super(cause);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
