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
     * helper method that trims the input string by removing a letter
     * @param s (string to be trimmed)
     * @param index (index of element to be removed)
     * @return (new string
     */

    private String trimInputString(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }

    private String performSearch(String word, String in) {

        for (int i = 0; i < word.length(); i++) {
            int index = in.indexOf(word.charAt(i));
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
