package com.ignited;

import com.ignited.Letter.Letter;

public interface QuestionSetter {

    void setLetter(Letter letter);
    String getQuestion();
    String getAnswer();
    String getResult(boolean b, long ms);
    String getCurcuit(int i);
    String getDone(int i);

}
