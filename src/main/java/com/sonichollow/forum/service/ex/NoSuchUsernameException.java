package com.sonichollow.forum.service.ex;

public class NoSuchUsernameException extends ServiceException {
    public NoSuchUsernameException() {
    }

    public NoSuchUsernameException(String message) {
        super(message);
    }

    public NoSuchUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchUsernameException(Throwable cause) {
        super(cause);
    }

    public NoSuchUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return getClass() + "::" + "NoSuchUsernameException{" + getMessage() + "}";
    }
}
