package com.bridgelabz.censusanalyser;

public class CensusAnalyserException  extends Throwable {

    enum ExceptionType {
        NO_SUCH_FILE, INCORRECT_FILE_TYPE, DELIMITER_OR_HEADER_INCORRECT
    }

    ExceptionType type;

    CensusAnalyserException (ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
