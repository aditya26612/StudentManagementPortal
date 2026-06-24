package com.project.studentmanagementportal.exception;

public class StudentAlreadyExistsException
        extends ApplicationException {

    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}