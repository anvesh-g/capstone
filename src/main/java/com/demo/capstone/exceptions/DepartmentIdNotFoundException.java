package com.demo.capstone.exceptions;

public class DepartmentIdNotFoundException extends RuntimeException {

    private String message;

    public DepartmentIdNotFoundException() {}

    public DepartmentIdNotFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}
