package com.bridgelabz.censusanalyser;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTestCases  {
    private static final String SAMPLE_CSV_FILE_PATH = "src/test/resources/IndiaStateCensusData.csv";
    private static final String SAMPLE_CSV_INCORRECT_FILE_NAME = "src/resources/IndiaStateCensusData.csv";
    private static final String SAMPLE_CSV_INCORRECT_FILE_TYPE = "src/test/resources/StateCensusData.pdf";


    //Test Case 1.1
    @Test
    public void givenCSVFile_WhenFileCorrect_ThenReturnTrueData() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int counter = stateCensusAnalyser.getNumberOfRecords(SAMPLE_CSV_FILE_PATH);
            Assert.assertEquals(29, counter);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    //Test Case 1.2
    @Test
    public void givenCSVFile_WhenFileNameIncorrect_ThenThrowException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int counter = stateCensusAnalyser.getNumberOfRecords(SAMPLE_CSV_INCORRECT_FILE_NAME);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    //Test Case 1.3
    @Test
    public void givenCSVFile_WhenFileTypeIncorrect_ThenThrowException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int counter = stateCensusAnalyser.getNumberOfRecords(SAMPLE_CSV_INCORRECT_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE, e.type);
        }
    }
}
