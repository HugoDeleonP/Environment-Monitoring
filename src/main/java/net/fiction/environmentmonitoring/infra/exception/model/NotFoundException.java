package net.fiction.environmentmonitoring.infra.exception.model;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
