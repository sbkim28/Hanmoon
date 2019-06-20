package com.ignited.Letter;

import java.util.Objects;

public class Letter {
    private char chinese;
    private String meaning;
    private char sound;

    public Letter(char chinese, String meaning, char sound) {
        this.chinese = chinese;
        this.sound = sound;
        this.meaning = meaning;
    }

    public char getChinese() {
        return chinese;
    }

    public char getSound() {
        return sound;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "chinese=" + chinese +
                ", sound=" + sound +
                ", meaning='" + meaning + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return chinese == letter.chinese &&
                sound == letter.sound &&
                Objects.equals(meaning, letter.meaning);
    }
}
