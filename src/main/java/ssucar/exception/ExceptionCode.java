package ssucar.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    REPORT_NOT_FOUND(404, "Report not found"),
    SCENARIO_NOT_FOUND(404, "Scenario not found"),
    INVALID_DATE_FORMAT(400, "Invalid date format");

    private final int status;
    private final String message;

    ExceptionCode(int statusCode, String message){
        this.status = statusCode;
        this.message = message;
    }
}
