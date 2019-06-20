package com.ignited;

import com.ignited.Letter.Letter;

public class DefaultQuestionSetter implements QuestionSetter{

    private Letter letter;

    @Override
    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    @Override
    public String getQuestion() {
        return "다음 한자의 음을 적으시오. : " + letter.getChinese();
    }

    @Override
    public String getAnswer() {
        return String.valueOf(letter.getSound());
    }

    @Override
    public String getResult(boolean b, long ms) {
        StringBuilder ret = new StringBuilder();
        if(b){
            ret.append("정답입니다. ");
        }else {
            ret.append("오답입니다. ");
        }
        ret.append("음:'").append(letter.getSound()).append("', 뜻:'").append(letter.getMeaning()).append("', 걸린 시간 (초):").append(ms/1000).append("\n");
        return ret.toString();
    }
}
