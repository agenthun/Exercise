package com.agenthun.app;

import java.io.IOException;

/**
 * Created by Agent Henry on 2015/8/6.
 */
public class Craps {
    public static void main(String[] args) throws IOException {
        final int WON = 0, LOST = 1, CONTINUE = 2;
        boolean firstRoll = true;
        int gameStatus = CONTINUE;
        int die1, die2, sumOfDice;
        int firstPoint = 0;
        System.out.print("开始投骰子游戏, 按Enter");
        while (true) {
            System.in.read();
            if (firstRoll) {
                sumOfDice = rollDice();
                System.out.println("\n点数和: " + sumOfDice);
                switch (sumOfDice) {
                    case 7:
                    case 11:
                        gameStatus = WON;
                        break;
                    case 2:
                    case 3:
                    case 12:
                        gameStatus = LOST;
                        break;
                    default:
                        firstRoll = false;
                        gameStatus = CONTINUE;
                        firstPoint = sumOfDice;
                        break;
                }
            } else {
                sumOfDice = rollDice();
                System.out.println("\n点数和: " + sumOfDice);
                if (sumOfDice == firstPoint) gameStatus = WON;
                else if (sumOfDice == 7) gameStatus = LOST;
            }

            if (gameStatus == CONTINUE) System.out.println("平局, 再来一次");
            else {
                if (gameStatus == WON) System.out.println("赢");
                else System.out.println("输");
                System.out.println("再来一次?(y/n)");
                if (System.in.read() == 'n') {
                    System.out.println("结束");
                    break;
                }
                firstRoll = true;
            }
        }
    }

    public static int rollDice() {
        int roll = ((int) (Math.random() * 6) + (int) (Math.random() * 6));
        if (roll < 2) roll = 2;
        return roll;
    }
}
