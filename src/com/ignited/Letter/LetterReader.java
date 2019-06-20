package com.ignited.Letter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LetterReader {

    private static final Logger LOGGER = Logger.getLogger(LetterReader.class.getName());

    public static List<Letter> read(String name) throws IOException {
        InputStream is = LetterReader.class.getResourceAsStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String s;
        int line_number = 0;
        List<Letter> lList = new ArrayList<>();

        while((s = br.readLine()) != null){
            line_number++;
            String[] d = s.split(", ");
            if(d.length !=3){
                LOGGER.warning(s + ", invalid format. (line number:" + line_number + ")");
                continue;
            }
            if(d[0].length() != 1){
                LOGGER.warning(s + ", invalid cc. (line number:" + line_number + ")");
                continue;
            }
            if(d[2].length() != 1){
                LOGGER.warning(s + ", invalid sound. (line number:" + line_number + ")");
                continue;
            }

            Letter letter = new Letter(d[0].charAt(0), d[1], d[2].charAt(0));
            lList.add(letter);
        }

        return lList;
    }
}
