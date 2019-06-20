package com.ignited;

import com.ignited.Letter.Letter;
import com.ignited.Letter.LetterReader;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class RUN {
    public static void main(String[] args){
        Random random = new Random();
        List<Letter> lList = null;
        try {
            lList = LetterReader.read("LetterList.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        LetterQuestioner lq = new LetterQuestioner(lList);
        lq.setQuestionSetter(new DefaultQuestionSetter());
        while (true) {
            lq.getQuestion(random);
        }
    }
}
