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


    private String trimInputString(String s, int index) {


        return s.substring(0,index)+s.substring(index+1);
    }

    Pair<String, Boolean> shortenInputString(String input, String word){
        String result = input;
        int count = 0;
        for(char letter : word.toCharArray()){
            int index = input.indexOf(letter);
            if(index!=-1){
                result = trimInputString(input, index );
                count++;
            }
        }

        boolean shortenWholeWord = word.length()==count;

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
