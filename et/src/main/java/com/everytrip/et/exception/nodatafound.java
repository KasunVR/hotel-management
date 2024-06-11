package com.everytrip.et.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class nodatafound extends RuntimeException{

    public nodatafound(String message)
    {
        super(message);

    }
}
