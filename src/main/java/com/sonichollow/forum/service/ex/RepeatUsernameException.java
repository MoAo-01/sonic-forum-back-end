package com.sonichollow.forum.service.ex;

import lombok.ToString;

@ToString
public class RepeatUsernameException extends RuntimeException{
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
}
