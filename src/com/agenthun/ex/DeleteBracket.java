package com.agenthun.ex;

/**
 * Created by Agent Henry on 2015/7/28.
 */
public class DeleteBracket {
    public static String deleteBracket(String s) {
        String result = "(";
        char[] ch = s.toCharArray();
        int bracketNum = 0;
        int i = 0;
        while (i < ch.length) {
            if (ch[i] == '(') bracketNum++;
            else if (ch[i] == ')') {
                if (bracketNum > 0) bracketNum--;
                else {
                    System.out.println("括号不配对\n");
                    return null;
                }
            } else if (ch[i] == ',') {
                result += ch[i++];
                continue;
            } else if (ch[i] >= '0' && ch[i] <= '9') {
                result += ch[i];
            } else {
                System.out.println("错误\n");
                return null;
            }
            i++;
        }
        if (bracketNum > 0) {
            System.out.println("括号不配对\n");
            return null;
        }
        result += ')';
        return result;
    }

    public static void main(String[] args) {
        String s = "(1,(2,3),(4,(5,6),7))";
        String result = deleteBracket(s);
        if (result != null) System.out.println(result);

        s = "((1,(2,3),(4,(5,6),7))";
        result = deleteBracket(s);
        if (result != null) System.out.println(result);
    }
}
