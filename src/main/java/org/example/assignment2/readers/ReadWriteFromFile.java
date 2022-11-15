package org.example.assignment2.readers;

import org.example.assignment2.exceptions.EmptyFileException;
import org.example.assignment2.exceptions.IncorrectFilePathException;
import org.example.assignment2.exceptions.ReaderNotInitializedException;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteFromFile {

    private String inputFilePath;
    private File inputFile;
    private File outputFile;

    public ReadWriteFromFile(String filePath) {
        this.inputFilePath = filePath;
        this.inputFile = new File(filePath);
        this.outputFile = new File("src\\main\\resources\\results.txt");
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public ArrayList<String> readFromFile() {
        BufferedReader reader = null;
        FileReader fileReader = null;
        ArrayList<String> text = new ArrayList<String>();
        String line;
        boolean isEmpty = true;
        try {
            //if fileReader is not initialized properly FileNotFoundException is thrown
            fileReader = new FileReader(this.inputFile);
            //if we don't initialize our reader properly we get NullPointerException
            reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                if (line != "")
                    isEmpty = false;
                text.add(line);
            }
            //if every line was empty this variable will still have the initial value "true"
            if (isEmpty)
                throw new EmptyFileException("Specified file is empty");
        } catch (NullPointerException | IOException | EmptyFileException e) {
            try {
                if (fileReader == null)
                    throw new IncorrectFilePathException("Error in input file path!", e);
                if (reader == null)
                    throw new ReaderNotInitializedException("Reader not initialized!", e);
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (ReaderNotInitializedException | IncorrectFilePathException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        } finally {
            try {
                if (reader != null)
                    reader.close();
                else
                    throw new ReaderNotInitializedException("Reader not initialized!");
            } catch (ReaderNotInitializedException | IOException e) {
                if (reader == null)
                    e.printStackTrace();
                else
                    System.out.println("File not closed.");
            }
        }
        return text;
    }

    public void writeInFile(ArrayList<String> text){

        BufferedWriter writer = null;
        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter(this.outputFile);
            writer = new BufferedWriter(fileWriter);
            for(String line : text){
                writer.write(line);
                writer.newLine();
            }
        }catch(NullPointerException | IOException e){
            try {
                if (fileWriter == null)
                    throw new IncorrectFilePathException("Error in input file path!", e);
                if (writer == null)
                    throw new ReaderNotInitializedException("Reader not initialized!", e);
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (ReaderNotInitializedException | IncorrectFilePathException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        finally {
            try {
                if (writer != null)
                    writer.close();
                else
                    throw new ReaderNotInitializedException("Reader not initialized!");
            } catch (ReaderNotInitializedException | IOException e) {
                if (writer == null)
                    e.printStackTrace();
                else
                    System.out.println("File not closed.");
            }
        }

    }
}
