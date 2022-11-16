package org.example.assignment2.readers;

import org.example.assignment2.exceptions.IncorrectFilePathException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteFromFileTest {

    @Test
    void contentReadFromFileShouldBeSameAsWritten() {
        ReadWriteFromFile rw = new ReadWriteFromFile("C:\\Users\\kneumova\\IdeaProjects\\JavaModuleDemo\\src\\main\\resources\\inputStrings.txt");
        ArrayList<String> text = rw.readFromFile();
        String[] wordsArray = new String[]{"BAONXXOLL", "BAOOLLNNOLOLGBAX", "QAWABAWONL", "ONLABLABLOON", "HEYBALLOONHOWAREYOUBALLOONMYBALLOONHEYBALLOON"};
        assertArrayEquals(wordsArray, text.toArray());
    }

    @Test
    void readFromFileshouldNotThrowException() {
        ReadWriteFromFile rw = new ReadWriteFromFile("Strings.txt");
        assertDoesNotThrow(()->rw.readFromFile());
    }

    @Test
    void writeInFileshouldNotThrowException() {
        String[] text = new String[]{"1", "2", "0", "1", "4"};
        ReadWriteFromFile rw = new ReadWriteFromFile();
        rw.setOutputFile(new File("*"));
        rw.writeInFile(new ArrayList<String>(Arrays.asList(text)));
        assertDoesNotThrow(()->rw.writeInFile(new ArrayList<String>(Arrays.asList(text))));
    }


}