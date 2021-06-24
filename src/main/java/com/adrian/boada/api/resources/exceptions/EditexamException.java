package com.adrian.boada.api.resources.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EditexamException extends Exception{
    private static final long serialVersionUID = -7717691994704695707L;

    public EditexamException(String message){
        super(message);
    }
}
