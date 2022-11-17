package org.example.assignment2.readers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.*;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteFromFileTest {

    ReadWriteFromFile rw;
    static final Logger log = Logger.getLogger(ReadWriteFromFileTest.class.getName());

    @BeforeAll
    static void setup() {
        log.info("Started testing ReadWriteFromFile class\n");
    }

    @BeforeEach
    void initializeInstance() {
        log.info("Initialize instance by using empty constructor");
        rw = new ReadWriteFromFile();
    }

    @Test
    void verifyInputFileContent() {
        rw.setInputFile(new File("src\\\\main\\\\resources\\\\inputStrings.txt"));
        log.info("Testing specified words to search through are successfully read.");
        ArrayList<String> text = rw.readFromFile();
        String[] wordsArray = new String[]{"BAONXXOLL", "BAOOLLNNOLOLGBAX", "QAWABAWONL", "ONLABLABLOON", "HEYBALLOONHOWAREYOUBALLOONMYBALLOONHEYBALLOON"};
        assertArrayEquals(wordsArray, text.toArray());
        log.info("Read content matches specified words. End of test\n");
    }

    @Test
    void readFromWrongFileExceptionsShouldBeHandled() {
        log.info("Setting input file path to empty string");
        rw.setInputFilePath("");
        log.info("Verifying exceptions are handled");
        assertDoesNotThrow(() -> rw.readFromFile());
        log.info("End of readFromWrongFileExceptionsShouldBeHandled test\n");
    }

    @Test
    void writeInWrongFileExceptionsShouldBeHandled() {
        String[] text = new String[]{"1", "2", "0", "1", "4"};
        rw.setOutputFile(new File("*"));
        rw.writeInFile(new ArrayList<String>(Arrays.asList(text)));
        log.info("Verifying exceptions are handled when writing in file with invalid path");
        assertDoesNotThrow(() -> rw.writeInFile(new ArrayList<String>(Arrays.asList(text))));
        log.info("End of writeInWrongFileExceptionsShouldBeHandled test\n");
    }

    @Test
    void readingFromEmptyFileExceptionShouldBeHandled() {
        log.info("Test for reading from empty file has started.");
        rw.setInputFilePath("C:\\Users\\kneumova\\IdeaProjects\\JavaModuleDemo\\src\\main\\resources\\empty.txt");
        rw.setInputFile(new File(rw.getInputFilePath()));
        assertDoesNotThrow(() -> rw.readFromFile());
        log.info("Verified reading from empty file operation. End of test\n");
    }

    @Test
    void constructorWithParametersShouldInitializeProperties() {
        log.info("Test for initialization with constructor parameters has started.");
        rw = new ReadWriteFromFile("input.txt");
        log.info("Check inputFilePath, inputFile and outputFile properties are initialized");
        assertEquals("input.txt", rw.getInputFilePath());
        assertNotEquals(null, rw.getOutputFile());
        assertNotEquals(null, rw.getInputFile());
        log.info("Verified input and output files have been initialized. End of test\n");
    }

    @Test
    void verifyDataInOutputFile() {
        log.info("Test for verifying data in output file has started");
        String[] text = new String[]{"1", "2", "0", "1", "4"};
        rw.setOutputFile(new File("src\\main\\resources\\results.txt"));
        rw.writeInFile(new ArrayList<String>(Arrays.asList(text)));
        log.info("Specified strings have been written in output file.");
        rw.setInputFile(rw.getOutputFile());
        assertEquals(Arrays.asList(text), rw.readFromFile());
        log.info("Verified data read from output file matches written data. End of test\n");
    }

    @Test
    void verifyOutputFilePathInitialization() {
        log.info("Test for output file path initialization has started");
        log.info("Verifying outputFile is null when instance is created using empty constructor");
        assertEquals(null, rw.getOutputFile());
        File output = new File("src\\main\\resources\\results.txt");
        log.info("Verifying output file path matches specified path");
        rw.setOutputFile(output);
        assertEquals(output.getPath(), rw.getOutputFile().getPath());
        log.info("End of verifyOutputFilePathInitialization test\n");
    }

    @Test
    void verifyReadersAreNullWhenReadFromFileMethodIsNotCalled() {
        log.info("Verifying FileReader and BufferedReader objects are null if file content is not read");
        log.info("Initializing input and output files with constructor with parameters");
        rw = new ReadWriteFromFile("\"src\\\\main\\\\resources\\\\inputStrings.txt\"");
        log.info("Calling method for writing in outputfile");
        rw.writeInFile(new ArrayList<>());
        assertEquals(null, rw.getFileReader());
        assertEquals(null, rw.getReader());
        log.info("End of verifyReadersAreNullWhenReadFromFileMethodIsNotCalled test\n");
    }

    @AfterAll
    static void logEndOfTestingClass() {
        log.info("Finished testing class ReadWriteFromFileTest\n");
    }

}