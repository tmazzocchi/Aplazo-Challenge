package com.mazzocchitomas.simpleinterestmicroservice.exception;

import java.util.List;

public class ValidatorException extends RuntimeException {
    private static final long serialVersionUID = 7308399950910487938L;
    private List<String> violationMessages;

    public ValidatorException(String message, List<String> violationMessages) {
        super(message);
        this.violationMessages = violationMessages;
    }

    public List<String> getViolationMessages() {
        return violationMessages;
    }
}
