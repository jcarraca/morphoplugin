package com.jcarraca.cordova.plugin;

public class MorphoSmartException extends RuntimeException {
    private static String error_msg = "";
    private static final long serialVersionUID = 1;

    public MorphoSmartException(String message) {
        super(message);
    }

    public MorphoSmartException(Throwable cause) {
        super(cause);
    }

    public MorphoSmartException(String message, Throwable cause) {
        super(message, cause);
    }

    public MorphoSmartException(int codeError, String message, Throwable cause) {
        super(message, cause);
        error_msg = ErrorCodes.getError(codeError, 0);
    }

    public String getErrorMessage() {
        return error_msg;
    }
}
