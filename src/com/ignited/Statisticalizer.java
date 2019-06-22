package com.ignited;

import com.ignited.Letter.Letter;

import java.util.*;

public class Statisticalizer {

    private List<Value> values;
    private Value value;

    public Statisticalizer() {
        values = new ArrayList<>();
    }

    public void initialize(List<Letter> list){
        for (Letter l : list){
            values.add(new Value(l));
        }
    }

    public double getQSum(){
        double ret = 0;
        for (Value v : values){
            ret += (double) v.fail/ v.success;
        }

        return ret;
    }

    public Letter getLetter(double index){
        int cursor = 0;
        for (Value v : values){
            index -= (double) v.fail/ v.success;;
            if(index < 0){
                value = v;
                return v.letter;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void setResult(boolean b){
        value.result(b);
    }

    public class Value{
        Letter letter;
        int success;
        int fail;
        Value(Letter letter){
            this.letter = letter;
            success = 1;
            fail = 1;
        }

        void result(boolean b){
            if(b) ++success;
            else ++fail;
        }
    }
}
