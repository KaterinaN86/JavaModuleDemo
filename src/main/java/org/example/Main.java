package org.example;

import org.example.assignment1.Solution;
import org.example.assignment1.Solution2;
import org.example.assignment2.FileIOSolution;
import org.example.assignment3.RefactoredSolutionForTesting;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution("balloon");
        ArrayList<String> listOfInputs = new ArrayList<String>();
        listOfInputs.add("BAONXXOLL");
        listOfInputs.add("BAOOLLNNOLOLGBAX");
        listOfInputs.add("QAWABAWONL");
        listOfInputs.add("ONLABLABLOON");
        listOfInputs.add("HEYBALLOONHOWAREYOUBALLOONMYBALLOONHEYBALLOON");
        System.out.println("Looking for BALLOON");
        for (String input: listOfInputs
             ) {
            System.out.println("Number of moves for input '"+input+"': "+solution.solution(input));
        }
        System.out.println("************************************************************************");
        Solution2 solution2 = new Solution2("KATE");
        ArrayList<String> listOfInputs2 = new ArrayList<String>();
        listOfInputs2.add("KATERINA");
        listOfInputs2.add("MYNAMEIS KATE KATE IS MY NAME");
        listOfInputs2.add("SOMETHING");
        listOfInputs2.add("ONLABkateLABLOON");
        listOfInputs2.add("HEYBALLOONHOWAREYOUBKATEALLOONMYBALLOONHEYBKATEALLOON");
        System.out.println("Looking for KATE");
        for (String input: listOfInputs2
        ) {
            System.out.println("Number of moves for input '"+input+"': "+solution2.solution(input));
        }
        //Read and write operations
        FileIOSolution ioSolution = new FileIOSolution("BALLOON","src\\\\main\\\\resources\\\\inputStrings.txt");
        ioSolution.readInputAndWriteResult();
        //finding solutions with refactored class for testing
        RefactoredSolutionForTesting  newSolutions = new RefactoredSolutionForTesting("BALLOON","src\\\\main\\\\resources\\\\inputStrings.txt");
    }

}