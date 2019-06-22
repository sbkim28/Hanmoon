package com.ignited;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemReader {

    public static BufferedReader br;

    public static String read() throws IOException{
        if(br== null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        while (true) {
            if (br.ready()) {
                return br.readLine();
            }
        }
    }
}
