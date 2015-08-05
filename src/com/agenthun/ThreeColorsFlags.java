package com.agenthun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Agent Henry on 2015/8/5.
 */
public class ThreeColorsFlags {
    private void swap(char[] flags, int x, int y) {
        char temp;
        temp = flags[x];
        flags[x] = flags[y];
        flags[y] = temp;
    }

    public String move(char[] flags) {
        int wFlag = 0;
        int bFlag = 0;
        int rFlag = flags.length - 1;
        while (wFlag <= rFlag) {
            if (flags[wFlag] == 'W') {
                wFlag++;
            } else if (flags[wFlag] == 'B') {
                swap(flags, bFlag, wFlag);
                bFlag++;
                wFlag++;
            } else {
                while (wFlag < rFlag && flags[rFlag] == 'R') rFlag--;
                swap(flags, rFlag, wFlag);
                rFlag--;
            }
        }
        return new String(flags);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入三色旗顺序(ex. RWBBWRWR): ");
        String flags = buf.readLine();
        ThreeColorsFlags threeColorsFlags = new ThreeColorsFlags();
        flags = threeColorsFlags.move(flags.toUpperCase().toCharArray());
        System.out.println("移动后顺序: " + flags);
    }
}
