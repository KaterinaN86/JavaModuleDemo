package org.example.assignment1;

import org.javatuples.Pair;

import java.util.ArrayList;

public class Solution2 {
    /**
     * the word that is being searched for
     */
    private String word;

    /**
     * constructor
     * @param word
     */
    public Solution2(String word) {
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
                //once the letter is found the index is returned an execution stops
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

    Pair<String, Boolean> shortenInputString(String input, String word){
        String result = input;
        int count = 0;
        for(char letter : word.toCharArray()){
            int index = findIndexOfLetter(letter,input);
            if(index!=-1){
                result = trimInputString(input, index );
                count++;
            }
        }

        boolean shortenWholeWord = input.length()==count?true:false;

        return new Pair<String,Boolean>(result,shortenWholeWord);
    }

   public int solution(String s){
        int result = 0;
        while(true){
            Pair<String, Boolean> solutionPair = shortenInputString(s, this.word);
            if(!solutionPair.getValue1()){
                break;
            }
            s= solutionPair.getValue0();
            result++;
        }
        return result;
    }

}
