package org.example.assignment3;

import org.example.assignment2.readers.ReadWriteFromFile;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RefactoredSolutionForTestingTest {

    static final Logger log = Logger.getLogger(RefactoredSolutionForTestingTest.class.getName());
   // private static final Logger logger = LoggerFactory.getLogger(Slf4jUser.class);
    static RefactoredSolutionForTesting rfSolution;
    @Mock
    private ReadWriteFromFile rw;

    static ArrayList<String> wordsList;

    @BeforeAll
    static void setup() {
        log.info("Started testing ReadWriteFromFile class\n");
        rfSolution = new RefactoredSolutionForTesting("BALLOON", "src\\\\main\\\\resources\\\\inputStrings.txt");
        wordsList = new ArrayList<String>(Arrays.asList("BAONXXOLL", "BAOOLLNNOLOLGBAX", "QAWABAWONL", "ONLABLABLOON", "HEYBALLOONHOWAREYOUBALLOONMYBALLOONHEYBALLOON"));
    }

    @Test
    void solutionShouldReturn1ForEl0() {
        log.info("Starting test for verifying solution for first word");
        rw = mock(ReadWriteFromFile.class);
        when(rw.readFromFile()).thenReturn(wordsList);
        rfSolution.setRw(rw);
        ArrayList<String> words = rw.readFromFile();
        int result = rfSolution.solution(words.get(0));
        log.info("Actual result matches expected result of 1. End of test\n");
        assertEquals(1, result);
    }

    @Test
    void solutionShouldReturn2ForEl1() {
        log.info("Starting test for verifying solution for second word");
        rw = mock(ReadWriteFromFile.class);
        when(rw.readFromFile()).thenReturn(wordsList);
        rfSolution.setRw(rw);
        ArrayList<String> words = rw.readFromFile();
        int result = rfSolution.solution(words.get(1));
        log.info("Actual result matches expected result of 2. End of test\n");
        assertEquals(2, result);
    }

    @Test
    void solutionShouldReturn0ForEl2() {
        log.info("Starting test for verifying solution for third word");
        rw = mock(ReadWriteFromFile.class);
        when(rw.readFromFile()).thenReturn(wordsList);
        rfSolution.setRw(rw);
        ArrayList<String> words = rw.readFromFile();
        int result = rfSolution.solution(words.get(2));
        log.info("Actual result matches expected result of 0. End of test\n");
        assertEquals(0, result);
    }

    @Test
    void solutionShouldReturn1ForEl3() {
        log.info("Starting test for verifying solution for fourth word");
        rw = mock(ReadWriteFromFile.class);
        when(rw.readFromFile()).thenReturn(wordsList);
        rfSolution.setRw(rw);
        ArrayList<String> words = rw.readFromFile();
        int result = rfSolution.solution(words.get(3));
        log.info("Actual result matches expected result of 1, End of test\n");
        assertEquals(1, result);
    }

    @Test
    void solutionShouldReturnNegativeForInvalidString() {
        log.info("Starting test for verifying solution for invalid word");
        ArrayList<String> addWord = wordsList;
        addWord.add("myBALLOON");
        rfSolution.setInputText(addWord);
        int result = rfSolution.solution(rfSolution.getInputText().get(5));
        log.info("Actual result matches expected result of -1, End of test\n");
        assertEquals(-1, result);
    }

    @Test
    void writeResultShouldNotThrowExceptionForCorrectInput() {
        rfSolution.setInputText(wordsList);
        log.info("Verifying writing of results doesn't throw exception");
        assertDoesNotThrow(() -> rfSolution.writeResult());
        log.info("Operation verified, end of test\n");
    }

    @Test
    void verifyTrimInputString() {
        log.info("Checking if specified letter is removed from word");
        assertEquals("irthday", rfSolution.trimInputString("Birthday", 0));
        log.info("First letter removed from string\n");
    }

    @Test
    void verifyShortenString() {
        log.info("Checking method shortenInputString removes word BALLOON from word BAONXXOLL");
        Result r = rfSolution.shortenInputString("BAONXXOLL", "BALLOON");
        log.info("Verified result's isShortened property is as expected, true");
        assertEquals(true, r.isShortened);
        log.info("Verified result's result property is as expected, XX");
        assertEquals("XX", r.result);
        log.info("End of test verifyShortenString\n");
    }

    @Test
    void constructorShouldInitializeData() {
        log.info("Testing initialization of ReadWriteFromFile object with empty constructor");
        assertNotEquals(null, rfSolution.getRw());
        log.info("Finished constructorShouldInitializeData test\n");
    }

    @Test
    void readingFromEmptyFileShouldCreateEmptyInputList() {
        log.info("Starting readingFromEmptyFileShouldCreateEmptyInputList test");
        log.info("Creating instance of ReadWriteFromFile");
        ReadWriteFromFile readWrite = new ReadWriteFromFile();
        log.info("Setting input file path to empty.txt");
        readWrite.setInputFile(new File("src\\\\main\\\\resources\\\\empty.txt"));
        rfSolution.setRw(readWrite);
        log.info("Reading from file");
        rfSolution.readInputStrings();
        log.info("Verifying input list is empty");
        assertEquals(new ArrayList<String>(), rfSolution.getInputText());
        log.info("Verified data, end of readingFromEmptyFileShouldCreateEmptyInputList test\n");
    }

    @AfterAll
    static void logEndOfTestingClass(){
        log.info("Finished testing class RefactoredSolutionForTestingTest\n");
    }

}