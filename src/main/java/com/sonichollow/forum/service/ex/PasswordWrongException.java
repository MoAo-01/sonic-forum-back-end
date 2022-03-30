package com.sonichollow.forum.service.ex;


public class PasswordWrongException extends ServiceException {
    public PasswordWrongException() {
    }

    public PasswordWrongException(String message) {
        super(message);
    }

    public PasswordWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordWrongException(Throwable cause) {
        super(cause);
    }

    public PasswordWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return getClass() + "::" + "PasswordWrongException{" + getMessage() + "}";
    }
}
