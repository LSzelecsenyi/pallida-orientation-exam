package com.greenfox.exam.Model;

public class Error {

    private String errorText;

    public Error() {
        errorText = "";
    }

    public Error(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
