package org.ligi.fahrplan;

public class ValidationError extends Error {

    private static final long serialVersionUID = 1L;

    public ValidationError(String message) {
        super(message);
    }

}
