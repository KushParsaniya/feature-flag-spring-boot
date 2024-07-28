package dev.kush.featureflagdemo.exception;

import dev.kush.featureflagdemo.service.FlagService;

public class FlagException extends RuntimeException {

    public FlagException() {
        super("Flag Exception");
    }

    public FlagException(String flag) {
        super("Flag %s toggled off".formatted(flag));
    }
}
