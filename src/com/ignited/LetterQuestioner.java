package com.ignited;

import com.ignited.Letter.Letter;

import java.io.IOException;
import java.util.*;

public class LetterQuestioner {

    private List<Letter> lList;
    private Statisticalizer s;
    private QuestionSetter qs;
    private String exitCode;

    public LetterQuestioner(List<Letter> lList) {
        this.lList = lList;
        s = new Statisticalizer();
        s.initialize(lList);
        exitCode = "EXIT";
        qs = new DefaultQuestionSetter();
    }

    public void loopRandomQuesion(Random random){
        while (true) {
            if (!(randomQuestion(random))) break;
        }
    }

    public boolean randomQuestion(Random random) {
        double r = s.getQSum() * random.nextDouble();
        Letter letter = s.getLetter(r);
        int info = question(letter);
        if(info == -1) return false;
        s.setResult(info != 0);
        return true;
    }
    private int question(Letter letter){
        qs.setLetter(letter);
        String q = qs.getQuestion();
        String a = qs.getAnswer();

        System.out.println(q);
        boolean b;
        long ms = System.currentTimeMillis();
        try {
            String line = SystemReader.read();
            if (exitCode.equals(line)) {
                return -1;
            }
            b = a.equals(line);
            ms = System.currentTimeMillis() - ms;
            System.out.println(qs.getResult(b, ms));
            return b ? 1 : 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void entireQuestion(Random random){

        List<Letter> list = new ArrayList<>(lList);
        int i=0;
        OUT : while (true){
            Collections.shuffle(list, random);
            System.out.println(qs.getCurcuit(++i));
            Iterator<Letter> iterator = list.iterator();
            while (iterator.hasNext()){
                int result = question(iterator.next());
                if(result == -1){
                     break OUT;
                } else if(result!= 0){
                    iterator.remove();
                }
            }
            if(list.size() == 0){
                System.out.println(qs.getDone(i));
                break;
            }
        }
    }

    public void setQuestionSetter(QuestionSetter qs){
        this.qs = qs;
    }

}
