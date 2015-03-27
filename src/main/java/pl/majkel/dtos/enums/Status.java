package pl.majkel.dtos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    STATUS_OK(0),
    ERROR_INVALID_TOKEN(1000),
    ERROR_WRONG_CREDENTIALS(2001),
    ERROR_INVALID_EMAIL(3001),
    ERROR_EMAIL_TAKEN(3002),
    ERROR_INVALID_PASS(3003),
    ERROR_CANNOT_CHANGE(9001);

    protected final Integer statusCode;

    Status(final Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonValue
    public Integer getStatusCode() {
        return statusCode;
    }
}
