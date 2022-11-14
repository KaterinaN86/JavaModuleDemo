package org.example;

import org.example.assignment1.Solution;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution("BALLOON");
        ArrayList<String> listOfInputs = new ArrayList<String>();
        listOfInputs.add("BAONXXOLL");
        listOfInputs.add("BAOOLLNNOLOLGBAX");
        listOfInputs.add("QAWABAWONL");
        listOfInputs.add("ONLABLABLOON");
        listOfInputs.add("HEYBALLOONHOWAREYOUBALLOONMYBALLOONHEYBALLOON");

        for (String input: listOfInputs
             ) {
            System.out.println(solution.solution(input));
        }
    }
}