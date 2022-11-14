package org.example.assignment1;

import org.javatuples.Pair;

import java.util.ArrayList;

public class Solution2 {

    class Result {
        public String result;
        public boolean isShortened;

        public Result(String result, boolean isShortened) {
            this.result = result;
            this.isShortened = isShortened;
        }
    }

    /**
     * the word that is being searched for
     */
    private String word;

    public Solution2(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Helper method that removes a letter from the input string by using the index of the letter in the string
     *
     * @param s     (input String)
     * @param index (position of letter to be removed)
     * @return (String without specified letter
     */
    private String trimInputString(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }

    Result shortenInputString(String input, String word) {
        String result = input;
        int count = 0;
        for (char letter : word.toCharArray()) {
            int index = result.indexOf(letter);
            if (index < 0) {
                return new Result(input, false);
            }
            result = trimInputString(result, index);
            count++;
        }
        boolean shortenWholeWord = word.length() == count;
        if (!shortenWholeWord) {
            return new Result(input, false);
        }

        return new Result(result, true);
    }

    public int solution(String s) {
        int result = 0;
        while (true) {
            Result r = shortenInputString(s, this.word);
            if (!r.isShortened) {
                break;
            }
            result++;
            s = r.result;
        }
        return result;
    }

}
