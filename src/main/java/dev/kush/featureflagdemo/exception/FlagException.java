package dev.kush.featureflagdemo.exception;

public class FlagException extends RuntimeException {

    public FlagException() {
        super("Flag Exception");
    }

    public FlagException(String flag) {
        super("Flag %s toggled off".formatted(flag));
    }
}
