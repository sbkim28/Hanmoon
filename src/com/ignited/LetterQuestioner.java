package com.ignited;

import com.ignited.Letter.Letter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class LetterQuestioner {

    private List<Letter> lList;
    private Statisticalizer s;
    private QuestionSetter qs;

    public LetterQuestioner(List<Letter> lList) {
        this.lList = lList;
        s = new Statisticalizer();
        s.initialize(lList);
    }

    public LetterQuestioner(List<Letter> lList, Statisticalizer statisticalizer) {
        this.lList = lList;
        this.s = statisticalizer;
    }

    public void getQuestion(Random random){
        int r = random.nextInt(s.getFailSum());
        Letter letter = s.getLetter(r);
        String q;
        String a;
        if(qs == null){
            q = String.valueOf(letter.getChinese());
            a = String.valueOf(letter.getSound());
        }else{
            qs.setLetter(letter);
            q = qs.getQuestion();
            a = qs.getAnswer();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(q);
            boolean b;
            long ms = System.currentTimeMillis();
            while (true) {
                if (br.ready()) {
                    b = a.equals(br.readLine());
                    ms = System.currentTimeMillis() - ms;
                    break;
                }
            }
            if(qs == null){
                System.out.println(b + ", " + (ms/1000));
            }else {
                System.out.println(qs.getResult(b, ms));
            }
            s.setResult(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setQuestionSetter(QuestionSetter qs){
        this.qs = qs;
    }

}
