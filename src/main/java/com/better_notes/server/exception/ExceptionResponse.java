package com.better_notes.server.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;

    public ExceptionResponse(int status, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
