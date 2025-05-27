package org.perfume.model.enums;

public enum ErrorMessage {
    NOT_FOUND("NOT_FOUND"),
    ALREADY_EXISTS("ALREADY_EXISTS"),
    METHOD_ARGUMENT_NOT_VALID("METHOD_ARGUMENT_NOT_VALID"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),
    INVALID_REQUEST("INVALID_REQUEST");


    private final String displayName;

    ErrorMessage(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
