package org.example.assignment3;

import org.example.assignment2.readers.ReadWriteFromFile;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class RefactoredSolutionForTestingTest {

    static final Logger log = Logger.getLogger(RefactoredSolutionForTestingTest.class.getName());
    static RefactoredSolutionForTesting rfSolution;
    @Mock
    private ReadWriteFromFile rw;

    @BeforeAll
    static void setup(){
        log.info("Started testing ReadWriteFromFile class.");
        rfSolution = new RefactoredSolutionForTesting("BALLOON","src\\\\main\\\\resources\\\\inputStrings.txt");
    }


    @Test
    void solutionShouldReturn1ForEl0() {
        log.info("Verifying solution for first word");
        rw = mock(ReadWriteFromFile.class);
        String[] wordsArray = new String[]{"BAONXXOLL", "BAOOLLNNOLOLGBAX", "QAWABAWONL", "ONLABLABLOON", "HEYBALLOONHOWAREYOUBALLOONMYBALLOONHEYBALLOON"};
        when(rw.readFromFile()).thenReturn((ArrayList<String>) Arrays.asList(wordsArray));
        rfSolution.setRw(rw);
        ArrayList<String> words = rw.readFromFile();
        int result = rfSolution.solution(words.get(0));
        assertEquals(1,result);
    }

    @Test
    void writeResult() {
    }
}