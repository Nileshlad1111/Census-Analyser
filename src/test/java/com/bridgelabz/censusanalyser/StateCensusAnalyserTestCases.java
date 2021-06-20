package com.bridgelabz.censusanalyser;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTestCases  {
    //csv file path
    private static final String SAMPLE_CSV_FILE_PATH = "src/test/resources/IndiaStateCensusData.csv";
    private static String STATE_CODE_CSV_FILE_PATH = "src/test/resources/StateCode.csv";
    private static String STATE_CODE_CSV_INCORRECT_DATA_FILE_PATH = "src/resources/StateCodeInvalidData.csv";
    private static final String SAMPLE_CSV_INCORRECT_FILE_PATH = "src/test/resources/IndiaStateCensusDataInvalid.csv";

    //object
    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

    //Test Case 1.1
    @Test
    public void givenCSVFile_WhenFileCorrect_ThenReturnTrueData() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            int counter = stateCensusAnalyser.loadCensusCSV(SAMPLE_CSV_FILE_PATH);
            Assert.assertEquals(29, counter);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    //Test Case 1.2
    @Test
    public void givenCSVFile_WhenFileNameIncorrect_ThenThrowException() {
        try {
            int counter = stateCensusAnalyser.loadCensusCSV("src/test/resources/IncorrectName.csv");
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    //Test Case 1.3
    @Test
    public void givenCSVFile_WhenFileTypeIncorrect_ThenThrowException() {
        try {
            int counter = stateCensusAnalyser.loadCensusCSV("src/test/resources/StateCensusData.pdf");
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE, e.type);
        }
    }

    //Test case 1.4
    @Test
    public void givenCSVFile_WhenDelimiterIncorrect_ThenThrowException() {
        try {
            int counter = stateCensusAnalyser.loadCensusCSV(SAMPLE_CSV_INCORRECT_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_OR_HEADER_INCORRECT, e.type);
        }
    }

    //Test Case 1.5
    @Test
    public void givenCSVFile_WhenHeaderIncorrect_ThenThrowException() {
        try {
            int counter = stateCensusAnalyser.loadCensusCSV(SAMPLE_CSV_INCORRECT_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_OR_HEADER_INCORRECT, e.type);
        }
    }

    //Test Case 2.1
    @Test
    public void givenStateCodeCSVFile_WhenFileCorrect_ThenReturnTrue() {
        try {
            int counter = stateCensusAnalyser.loadStateCodeCSV(STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37, counter);
        } catch (CensusAnalyserException e) {
        }
    }


    //Test Case 2.2
    @Test
    public void givenStateCodeCSVFile_WhenFileNameIncorrect_ThenThrowException() {
        try {
            int counter = stateCensusAnalyser.loadStateCodeCSV("src/test/resources/IncorrectName.csv");
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    //Test Case 2.3
    @Test
    public void givenStateCodeCSVFile_WhenFileTypeIncorrect_ThenThrowException() {
        try {
            int counter = stateCensusAnalyser.loadStateCodeCSV("src/test/resources/StateCode.pdf");
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE, e.type);
        }
    }
    //Test Case 2.4
    @Test
    public void givenStateCodeCSVFile_WhenDelimiterIncorrect_ThenThrowException() {
        try {
            int counter = stateCensusAnalyser.loadStateCodeCSV("src/test/resources/IndiaStateInvalidCodeInHeader.csv");
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_OR_HEADER_INCORRECT, e.type);
        }
    }

    //Test Case 2.5
    @Test
    public void givenStateCodeCSVFile_WhenHeaderIncorrect_ThenThrowException() {
        try {
            int counter = stateCensusAnalyser.loadStateCodeCSV("src/test/resources/IndiaStateInvalidCodeInHeader.csv" );
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_OR_HEADER_INCORRECT, e.type);
        }
    }
}
