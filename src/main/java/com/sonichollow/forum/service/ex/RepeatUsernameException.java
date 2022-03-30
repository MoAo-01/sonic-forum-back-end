package com.sonichollow.forum.service.ex;

public class RepeatUsernameException extends ServiceException {
    public RepeatUsernameException() {
    }

    public RepeatUsernameException(String message) {
        super(message);
    }

    public RepeatUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatUsernameException(Throwable cause) {
        super(cause);
    }

    public RepeatUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return getClass() + "::" + "RepeatUsernameException{" + getMessage() + "}";
    }
}
