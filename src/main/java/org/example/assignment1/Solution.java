package org.example.assignment1;


import java.util.ArrayList;

public class Solution {

    private String word;

    public Solution(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private int findIndexOfLetter(char letter, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter)
                return i;
        }

        return -1;
    }

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
