package com.demo.capstone.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorResponseTest {

    private String message = "Hello";
    private int statusCode = 500;

    @Test
    public void testForErrorResponse() {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message)
                .statusCode(500)
                .build();

        ErrorResponse errorResponse1 = new ErrorResponse(statusCode, message);

        ErrorResponse errorResponse2 = new ErrorResponse();
        errorResponse2.setMessage(message);
        errorResponse2.setStatusCode(statusCode);

        assertEquals(message, errorResponse.getMessage());
        assertEquals(statusCode, errorResponse.getStatusCode());

        assertEquals(message, errorResponse1.getMessage());
        assertEquals(statusCode, errorResponse1.getStatusCode());

        assertEquals(message, errorResponse2.getMessage());
        assertEquals(statusCode, errorResponse2.getStatusCode());
    }
}
