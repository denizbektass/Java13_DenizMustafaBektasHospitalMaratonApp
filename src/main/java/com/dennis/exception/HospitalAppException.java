package com.dennis.exception;

import lombok.Getter;

@Getter
public class HospitalAppException extends RuntimeException{

    private final ErrorType errorType;
    public HospitalAppException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public HospitalAppException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
