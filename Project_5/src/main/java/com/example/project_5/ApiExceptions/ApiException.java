package com.example.project_5.ApiExceptions;

public class ApiException extends RuntimeException{
    public ApiException(String msg){
        super(msg);
    }
}
