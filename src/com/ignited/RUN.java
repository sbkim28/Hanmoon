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
        try {
            while (true) {
                System.out.println("한문 테스트");
                System.out.println("랜덤단어테스트 : 1");
                System.out.println("전체도전 : 2");
                System.out.println("종료 : 3");

                String l = SystemReader.read();
                if(l.equals("1")) {
                    lq.loopRandomQuesion(random);
                }else if(l.equals("2")) {
                    lq.entireQuestion(random);
                }else if(l.equals("3")){
                    System.exit(0);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
