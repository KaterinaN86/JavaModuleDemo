package org.example.assignment3;

import org.example.assignment2.FileIOSolution;
import org.example.assignment2.exceptions.StringFormatException;
import org.example.assignment2.exceptions.StringLengthOutOfBoundsException;
import org.example.assignment2.readers.ReadWriteFromFile;

import java.util.ArrayList;

public class RefactoredSolutionForTesting {

    /**
     * the word that is being searched for
     */
    private String word;

    //path to file with words to be searched through
    private String inputFilePath;
    private ReadWriteFromFile rw;

    private ArrayList<String> inputText;

    private ArrayList<String> solutions;

    //constructor
    public RefactoredSolutionForTesting(String word, String inputFilePath) {
        //initializing properties
        this.word = word;
        this.inputFilePath = inputFilePath;
        this.rw = new ReadWriteFromFile(inputFilePath);
    }

    public ReadWriteFromFile getRw() {
        return rw;
    }

    public void setRw(ReadWriteFromFile rw) {
        this.rw = rw;
    }

    public ArrayList<String> getInputText() {
        return inputText;
    }

    public void setInputText(ArrayList<String> inputText) {
        this.inputText = inputText;
    }


    /**
     * Helper method that removes a letter from the input string by using the index
     *
     * @param s     (input String)
     * @param index (position of letter to be removed)
     * @return (String without specified letter
     */
     String trimInputString(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }

    Result shortenInputString(String input, String word) {
        //variable that stores the shortened string
        String result = input;
        //letters counter
        int count = 0;
        //looping over the specified word
        for (char letter : word.toCharArray()) {
            int index = result.indexOf(letter);
            //if letter is not found index is -1
            if (index < 0) {
                //return value when a letter form the specified word is not found
                return new Result(input, false);
            }
            //input string without found letter
            result = trimInputString(result, index);
            //incrementing counter of found letters
            count++;
        }
        //control variable that will be set to true if all letters have been found
        boolean shortenWholeWord = word.length() == count;
        //checking if the value of the control variable is false
        if (!shortenWholeWord) {
            //return value when the whole word has not been found
            return new Result(input, false);
        }
        //return value when specified word has been found in the string and the corresponding letters have been removed
        return new Result(result, true);
    }

    //validating string read from file by using custom exceptions
     void validateInputString(String in) {
        // the length of the string is validated first
        if (in.length() <= 0 && in.length() > 200000)
            throw new StringLengthOutOfBoundsException("Input string length is out of bounds!");
        //checking if the string is made up of letters only
        if (!in.matches("[A-Z]+"))
            throw new StringFormatException(in + " is not valid input! String must contain only uppercase letters!");
    }

    /**
     * Method that counts appearances of specified word in the string received as a parameter (moves in which we can delete the specified word from the string). If the string is invalid -1 is returned.
     *
     * @param s (string that is being searched through)
     * @return int (number of times the word has been found)
     */
    public int solution(String s) {
        try {
            validateInputString(s);
        } catch (StringFormatException | StringLengthOutOfBoundsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return -1;
        }
        //control variable for counting how many times the specified word has been found
        int result = 0;
        //the loop will run until the if statement is entered
        while (true) {
            Result r = shortenInputString(s, this.word);
            //if a letter is missing isShortened property of Result object will be false and the loop is exited
            if (!r.isShortened) {
                break;
            }
            //incrementing variable that counts how many times the word has been found
            result++;
            //input string is reinitialized to the trimmed string without found letters
            s = r.result;
        }
        //number of times the word has been found
        return result;
    }

    /**
     * Method that reads words from text file
     */
    public void readInputStrings(){
        //result from reading the file located on the specified path
        inputText = rw.readFromFile();
    }

    /**
     * Method that writes results in output file
     */
    public void writeResult() {

        //solutions for each word read from file
         this.solutions = new ArrayList<String>();
        //adding solution for each word to corresponding list
        for (String line : inputText) {
            //converting solution to string
            String solutionString = String.valueOf(solution(line));
            //adding string to ArrayList
            solutions.add("Number of moves for word " + line + " : " + solutionString);
        }
        //write operation in file results.txt
        rw.writeInFile(solutions);
    }

}
