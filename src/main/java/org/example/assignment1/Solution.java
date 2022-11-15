package org.example.assignment1;


import java.util.ArrayList;

public class Solution {
    /**
     * the word that is being searched for
     */
    private String word;

    public Solution(String word) {
        this.word = word.toUpperCase();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Helper method that removes a letter from the input string by using the index
     *
     * @param s     (input String)
     * @param index (position of letter to be removed)
     * @return (String without specified letter
     */
    private String trimInputString(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }

    /**
     * helper function that trims the input string by removing letters the specified word consists of
     * @param word (searched word)
     * @param in  (input string to search through)
     * @return String (input string without found letters)
     */
    private String performSearch(String word, String in) {
        //looping over the specified word to check if each letter is found in input string
        for (char letter : word.toCharArray()) {
            int index = in.indexOf(letter);
            //if letter is not found index is -1
            if (index !=-1) {
                //input string is trimmed, found letter is removed
                in = trimInputString(in, index);
            }
        }
        //trimmed string is returned
        return in;
    }
    private boolean validateInputString(String in) {
        // the length of the string is validated first
        if (in.length() >= 0 && in.length() <= 200000) {
            //checking if the string is made up of letters only
            if (in.matches("[A-Z]+"))
                return true;
            else {
                System.out.println("String must contain only uppercase letters!");
                return false;
            }
        }
        System.out.println("String length is out of bounds!");
        return false;
    }

    /**
     * Method that counts appearances of specified word in the string received as a parameter (moves in which we can delete the specified word from the string). If the string is invalid -1 is returned.
     *
     * @param s (string that is being searched through)
     * @return int (number of times the word has been found)
     */

    public int solution(String s) {
        if (!validateInputString(s)) {
            System.out.println("The string " + s + " is not valid as input!");
            return -1;
        }
        //remaining string after first search
        String remainingLetters = performSearch(this.word, s);
        // return value when not all letters are found
        if (remainingLetters.length() > s.length() - this.word.length())
            return 0;
        //return value when the specified word can only be contained once
        if ((remainingLetters.length() < this.word.length()) && (remainingLetters.length() == s.length() - this.word.length()))
            return 1;
        //if this line is executed the specified word has already been found once
        int result = 1;
        //if there are enough letters for the word to be found again the method calls itself but with the trimmed string as input value
        if (remainingLetters.length() >= this.word.length()) {
            result += solution(remainingLetters);
        }
        return result;
    }
}
