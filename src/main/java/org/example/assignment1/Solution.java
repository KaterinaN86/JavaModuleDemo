package org.example.assignment1;


import java.util.ArrayList;

public class Solution {

    /**
     * the word that is being searched for
     */
    private String word;

    /**
     * constructor
     * @param word
     */
    public Solution(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    /**
     * helper method that checks if the input string contains a letter
     * @param letter (one of the letters in the specified word (ex. B)
     * @param s (input String)
     * @return (int -1 is returned if the letter is not found or the index of character that matches the letter
     *
     */
    private int findIndexOfLetter(char letter, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter)
                //once the letter is found the index is returned an execution stops
                return i;
        }

        return -1;
    }

    /**
     * helper method that trims the input string by removing a letter
     * @param s (string to be trimmed)
     * @param index (index of element to be removed)
     * @return (new string
     */

    private String trimInputString(String s, int index) {

        ArrayList<Character> list = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        list.remove(index);
        String result = "";
        for (Character temp : list) {
            result += temp + "";
        }

        return result;
    }

    private String performSearch(String word, String in) {

        for (int i = 0; i < word.length(); i++) {
            int index = findIndexOfLetter(word.charAt(i), in);
            if (index != -1) {
                in = trimInputString(in, index);
            }
        }
        System.out.println(in);
        return in;
    }

    public int solution(String S) {

        String remainingLetters = performSearch(this.word, S);

        if (remainingLetters.length() > S.length() - this.word.length())
            return 0;
        if ((remainingLetters.length() < 7) && (remainingLetters.length() == S.length() - this.word.length()))
            return 1;

        int result = 1;

      if(remainingLetters.length() == (S.length() - this.word.length())&&remainingLetters.length()>=7){


          result += solution(remainingLetters);


      }

        return result;
    }
}
