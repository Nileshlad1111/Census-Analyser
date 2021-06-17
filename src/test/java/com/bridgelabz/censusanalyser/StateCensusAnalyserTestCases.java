package com.bridgelabz.censusanalyser;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTestCases  {
    private static final String SAMPLE_CSV_FILE_PATH = "src/test/resources/IndiaStateCensusData.csv";

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
}
