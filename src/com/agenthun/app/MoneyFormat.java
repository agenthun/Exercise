package com.agenthun.app;

import java.text.NumberFormat;
import java.util.HashMap;

/**
 * Created by Agent Henry on 2015/8/4.
 */
public class MoneyFormat {
    private static final String EMPTY = "";
    private static final String ZERO = "零";
    private static final String ONE = "壹";
    private static final String TWO = "贰";
    private static final String THREE = "叁";
    private static final String FOUR = "肆";
    private static final String FIVE = "伍";
    private static final String SIX = "陆";
    private static final String SEVEN = "柒";
    private static final String EIGHT = "捌";
    private static final String NINE = "玖";
    private static final String TEN = "拾";
    private static final String HUNDRED = "佰";
    private static final String THOUSAND = "仟";
    private static final String TEN_THOUSAND = "万";
    private static final String HUNDRED_MILLION = "亿";
    private static final String YUAN = "元";
    private static final String JIAO = "角";
    private static final String FEN = "分";
    private static final String DOT = ".";

    private static MoneyFormat formatter = null;
    private HashMap chineseNumberMap = new HashMap();
    private HashMap chineseMoneyPattern = new HashMap();
    private NumberFormat numberFormat = NumberFormat.getInstance();

    private MoneyFormat() {
        numberFormat.setMaximumFractionDigits(4);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setGroupingUsed(false);

        chineseNumberMap.put("0", ZERO);
        chineseNumberMap.put("1", ONE);
        chineseNumberMap.put("2", TWO);
        chineseNumberMap.put("3", THREE);
        chineseNumberMap.put("4", FOUR);
        chineseNumberMap.put("5", FIVE);
        chineseNumberMap.put("6", SIX);
        chineseNumberMap.put("7", SEVEN);
        chineseNumberMap.put("8", EIGHT);
        chineseNumberMap.put("9", NINE);
        chineseNumberMap.put(DOT, DOT);
        chineseMoneyPattern.put("1", TEN);
        chineseMoneyPattern.put("2", HUNDRED);
        chineseMoneyPattern.put("3", THOUSAND);
        chineseMoneyPattern.put("4", TEN_THOUSAND);
        chineseMoneyPattern.put("5", TEN);
        chineseMoneyPattern.put("6", HUNDRED);
        chineseMoneyPattern.put("7", THOUSAND);
        chineseMoneyPattern.put("8", HUNDRED_MILLION);
    }

    public static MoneyFormat getInstance() {
        if (formatter == null) {
            formatter = new MoneyFormat();
        }
        return formatter;
    }

    public String format(String moneyStr) {
        checkPrecision(moneyStr);
        String result;
        result = convertToChineseNumber(moneyStr);
        result = addUnitsToChineseMoneyString(result);
        return result;
    }

    public String format(double moneyDouble) {
        return format(numberFormat.format(moneyDouble));
    }

    public String format(int moneyInt) {
        return format(numberFormat.format(moneyInt));
    }

    public String format(long moneyLong) {
        return format(numberFormat.format(moneyLong));
    }

    public String format(Number moneyNum) {
        return format(numberFormat.format(moneyNum));
    }

    private String addUnitsToChineseMoneyString(String moneyStr) {
        String result;
        StringBuffer cMoneyStringBuffer = new StringBuffer(moneyStr);
        int indexOfDot = cMoneyStringBuffer.indexOf(DOT);
        cMoneyStringBuffer.replace(indexOfDot, indexOfDot + 1, YUAN);
        cMoneyStringBuffer.insert(cMoneyStringBuffer.length() - 1, JIAO);
        cMoneyStringBuffer.insert(cMoneyStringBuffer.length(), FEN);
        if (cMoneyStringBuffer.indexOf("零角零分") != -1)
            cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零角零分"), cMoneyStringBuffer.length(), "整");
        else if (cMoneyStringBuffer.indexOf("零分") != -1)
            cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零分"), cMoneyStringBuffer.length(), "整");
        else {
            if (cMoneyStringBuffer.indexOf("零角") != -1)
                cMoneyStringBuffer.delete(cMoneyStringBuffer.indexOf("零角"), cMoneyStringBuffer.indexOf("零角") + 2);
        }
        result = cMoneyStringBuffer.toString();
        return result;
    }

    private String convertToChineseNumber(String moneyStr) {
        String result;
        StringBuffer cMoneyStringBuffer = new StringBuffer();
        for (int i = 0; i < moneyStr.length(); i++) {
            cMoneyStringBuffer.append(chineseNumberMap.get(moneyStr.substring(i, i + 1)));
        }

        int indexOfDot = cMoneyStringBuffer.indexOf(DOT);
        int moneyPatternCursor = 1;
        for (int i = indexOfDot - 1; i > 0; i--) {
            cMoneyStringBuffer.insert(i, chineseMoneyPattern.get(EMPTY + moneyPatternCursor));
            moneyPatternCursor = moneyPatternCursor == 8 ? 1 : moneyPatternCursor + 1;
        }

        String fractionPart = cMoneyStringBuffer.substring(cMoneyStringBuffer.indexOf("."));
        cMoneyStringBuffer.delete(cMoneyStringBuffer.indexOf("."), cMoneyStringBuffer.length());

        while (cMoneyStringBuffer.indexOf("零拾") != -1) {
            cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零拾"), cMoneyStringBuffer.indexOf("零拾") + 2, ZERO);
        }
        while (cMoneyStringBuffer.indexOf("零佰") != -1) {
            cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零佰"), cMoneyStringBuffer.indexOf("零佰") + 2, ZERO);
        }
        while (cMoneyStringBuffer.indexOf("零仟") != -1) {
            cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零仟"), cMoneyStringBuffer.indexOf("零仟") + 2, ZERO);
        }
        while (cMoneyStringBuffer.indexOf("零万") != -1) {
            cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零万"), cMoneyStringBuffer.indexOf("零万") + 2, ZERO);
        }
        while (cMoneyStringBuffer.indexOf("零亿") != -1) {
            cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零亿"), cMoneyStringBuffer.indexOf("零亿") + 2, ZERO);
        }
        while (cMoneyStringBuffer.indexOf("零零") != -1) {
            cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零零"), cMoneyStringBuffer.indexOf("零零") + 2, ZERO);
        }
        if (cMoneyStringBuffer.lastIndexOf(ZERO) == cMoneyStringBuffer.length() - 1) {
            cMoneyStringBuffer.delete(cMoneyStringBuffer.length() - 1, cMoneyStringBuffer.length());
        }
        cMoneyStringBuffer.append(fractionPart);
        result = cMoneyStringBuffer.toString();
        return result;
    }

    private void checkPrecision(String moneyStr) {
        int fractionDigits = moneyStr.length() - moneyStr.indexOf(DOT) - 1;
        if (fractionDigits > 2) throw new RuntimeException("金额" + moneyStr + "的小数位多于两位");
    }

    public static void main(String[] args) {
        System.out.println(getInstance().format(new Double(256897.23)));
    }
}
