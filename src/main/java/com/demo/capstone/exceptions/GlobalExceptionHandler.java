package com.demo.capstone.exceptions;

import com.demo.capstone.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = DepartmentIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ErrorResponse departmentIdNotFoundException(DepartmentIdNotFoundException departmentIdNotFoundException) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), departmentIdNotFoundException.getMessage());
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ErrorResponse employeeNotFoundException(EmployeeNotFoundException employeeNotFoundException) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), employeeNotFoundException.getMessage());
    }

    @ExceptionHandler(value = DepartmentAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody
    ErrorResponse deptAlreadyExists(DepartmentAlreadyExistsException departmentAlreadyExistsException) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), departmentAlreadyExistsException.getMessage());
    }


}
