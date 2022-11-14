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

    public int solution(String S) {
        S=S.toUpperCase();
        //remaining string after first search
        String remainingLetters = performSearch(this.word, S);
        // return value when not all letters are found
        if (remainingLetters.length() > S.length() - this.word.length())
            return 0;
        //return value when the specified word can only be contained once
        if ((remainingLetters.length() < this.word.length()) && (remainingLetters.length() == S.length() - this.word.length()))
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
