package com.demo.capstone.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {

    private String message = "Hello";

    @Test
    public void testForStatus() {
        Status status = Status.builder()
                .message(message)
                .build();
        Status status1 = new Status(message);
        Status status2 = new Status();
        status2.setMessage(message);

        assertEquals(message, status.getMessage());
        assertEquals(message, status1.getMessage());
        assertEquals(message, status2.getMessage());
    }
}
