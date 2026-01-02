package com.api.model.response;

public class AccountCreationErrorResponse {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private String solution;
    private String errorCode;

    public AccountCreationErrorResponse(){

    }

    public AccountCreationErrorResponse(String timestamp, String errorCode, String path, String solution, String message, String error, int status) {
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.path = path;
        this.solution = solution;
        this.message = message;
        this.error = error;
        this.status = status;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
