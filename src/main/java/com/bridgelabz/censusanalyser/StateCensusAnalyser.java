package com.bridgelabz.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

    //To method load census CSV
    public int loadCensusCSV(String csvPath) throws CensusAnalyserException  {
        int counter = 0;
        int lastIndexOf = csvPath.lastIndexOf(".");
        String fileExtension = (lastIndexOf == -1) ? "" : csvPath.substring(lastIndexOf);
        if (!fileExtension.equals(".csv"))
            throw new CensusAnalyserException (CensusAnalyserException .ExceptionType.INCORRECT_FILE_TYPE, "File Type Incorrect");
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvPath));
        ) {

            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
                Iterator<CSVStateCensus> csvUserIterator = csvToBean.iterator();

            if (csvUserIterator.hasNext()) {
                do {
                    counter++;
                    CSVStateCensus csvUser = csvUserIterator.next();
                    /*System.out.println("State : " + csvUser.getState());
                    System.out.println("Population : " + csvUser.getPopulation());
                    System.out.println("Area : " + csvUser.getAreaInSqKm());
                    System.out.println("Density : " + csvUser.getDensityPerSqKm());*/
                } while (csvUserIterator.hasNext());
            }
        } catch (NoSuchFileException e) {
            throw new CensusAnalyserException (CensusAnalyserException .ExceptionType.NO_SUCH_FILE, "No Such File Exists");
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(CensusAnalyserException .ExceptionType.DELIMITER_OR_HEADER_INCORRECT, "Delimiter Or Header Incorrect");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    //To method load state code CSV
    public int loadStateCodeCSV(String csvPath) throws CensusAnalyserException {
        int counter = 0;
        int lastIndexOf = csvPath.lastIndexOf(".");
        String fileExtension = (lastIndexOf == -1) ? "" : csvPath.substring(lastIndexOf);
        if (!fileExtension.equals(".csv"))
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE, "File Type Incorrect");
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvPath));
        ) {

            CsvToBean<CSVStates> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStates.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStates> csvStatesIterator = csvToBean.iterator();

            while (csvStatesIterator.hasNext()) {
                counter++;
                CSVStates csvStates = csvStatesIterator.next();
            }
        } catch (NoSuchFileException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, "No Such File Exists");
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.DELIMITER_OR_HEADER_INCORRECT, "Delimiter Or Header Incorrect");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }


    public static void main(String[] args) {
        System.out.println("Welcome To Census Analyser Problem");
    }
}