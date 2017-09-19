package com.brookmanholmes.bma.domain.model.turn;

/**
 * Created by Brookman Holmes on 11/5/2015.
 */
public class InvalidBallException extends RuntimeException {
    public InvalidBallException() {
    }

    public InvalidBallException(String message) {
        super(message);
    }

    public InvalidBallException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBallException(Throwable cause) {
        super(cause);
    }
}
