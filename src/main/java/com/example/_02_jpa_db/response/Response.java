package com.example._02_jpa_db.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response<T> {
    private final String message;
    private final T data;
    private final int status;

    private Response(Builder<T> builder) {
        this.message = builder.message;
        this.data = builder.data;
        this.status = builder.status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public static class Builder<T> {
        private String message;
        private T data;
        private int status;

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> status(int status) {
            this.status = status;
            return this;
        }

        public ResponseEntity<Object> build() {
            Response<T> response = new Response<>(this);
            return new ResponseEntity<>(response, HttpStatus.valueOf(this.status));
        }
    }
}
