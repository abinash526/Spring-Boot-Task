package com.stackroute.springBoot.exception;

public class ErrorData {
    private int code;
    private String message;

    public ErrorData() {
    }

    @Override
    public String toString() {
        return "ErrorData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public ErrorData setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorData setMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorData(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
