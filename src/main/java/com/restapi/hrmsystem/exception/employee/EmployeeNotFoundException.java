package com.restapi.hrmsystem.exception.employee;

import com.restapi.hrmsystem.exception.BaseException;

// Handle Exception
public class EmployeeNotFoundException extends BaseException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    // Any specific handling will be handled here
}
