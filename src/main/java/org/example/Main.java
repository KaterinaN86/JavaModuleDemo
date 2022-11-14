package org.example;

import org.example.assignment1.Solution;
import org.example.assignment1.Solution2;

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
            System.out.println(solution.solution(input));
        }


        Solution2 solution2 = new Solution2("KATE");
        ArrayList<String> listOfInputs2 = new ArrayList<String>();
        listOfInputs2.add("KATERINA");
        listOfInputs2.add("MYNAMEIS KATE KATE IS MY NAME");
        listOfInputs2.add("SOMETHING");
        listOfInputs2.add("ONLABLABLOON");
        listOfInputs2.add("HEYBKATEALLOONHOWAREYOUBKATEALLOONMYBALLOONHEYBKATEALLOON");
        System.out.println("Looking for KATE");
        for (String input: listOfInputs2
        ) {
            System.out.println(solution2.solution(input));
        }
    }


}