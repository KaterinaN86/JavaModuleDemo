package org.example.assignment2.readers;

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
    static void setup(){
        log.info("Started testing ReadWriteFromFile class.");
    }

    @BeforeEach
    void initializeInstance(){
        rw = new ReadWriteFromFile();
    }

    @Test
    void verifyInputFileContent() {

        rw.setInputFile(new File("src\\\\main\\\\resources\\\\inputStrings.txt"));
        log.info("Testing specified words to search through are successfully read.");
        ArrayList<String> text = rw.readFromFile();
        String[] wordsArray = new String[]{"BAONXXOLL", "BAOOLLNNOLOLGBAX", "QAWABAWONL", "ONLABLABLOON", "HEYBALLOONHOWAREYOUBALLOONMYBALLOONHEYBALLOON"};
        assertArrayEquals(wordsArray, text.toArray());
    }

    @Test
    void readFromWrongFileExceptionsShouldBeHandled() {
        rw.setInputFilePath("");
       assertDoesNotThrow(() -> rw.readFromFile());
    }

    @Test
    void writeInWrongFileExceptionsShouldBeHandled() {

        String[] text = new String[]{"1", "2", "0", "1", "4"};
        rw.setOutputFile(new File("*"));
        rw.writeInFile(new ArrayList<String>(Arrays.asList(text)));
        assertDoesNotThrow(() -> rw.writeInFile(new ArrayList<String>(Arrays.asList(text))));
    }

    @Test
    void constructorShouldInitializeInputAndOutputFiles() {
        rw .setInputFilePath("C:\\Users\\kneumova\\IdeaProjects\\JavaModuleDemo\\src\\main\\resources\\inputStrings.txt");
        assertEquals("C:\\Users\\kneumova\\IdeaProjects\\JavaModuleDemo\\src\\main\\resources\\inputStrings.txt", rw.getInputFilePath());
        rw.setOutputFile(new File("src\\main\\resources\\results.txt"));
        assertEquals(new File("src\\\\main\\\\resources\\\\results.txt"), rw.getOutputFile());
    }


    @Test
    void readingFromEmptyFileExceptionShouldBeHandled() throws Exception{
        rw.setInputFilePath("C:\\Users\\kneumova\\IdeaProjects\\JavaModuleDemo\\src\\main\\resources\\empty.txt");
        rw.setInputFile(new File(rw.getInputFilePath()));
        assertDoesNotThrow(()->rw.readFromFile());
    }

    @Test
    void verifyResultsAreWritenInOutputFile(){

    }
}