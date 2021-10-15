package com.weatherPage.dto;

public class Error {

    private String errorMessage;
    private String errorCode;

    public Error(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Error setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Error setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @Override
    public String toString() {
        return "Error{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
