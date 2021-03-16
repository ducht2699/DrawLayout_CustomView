package com.example.drawlayout_customview;

public class Utils {
    public static String standardizedMoney(String amount) {
        StringBuffer sb = new StringBuffer("");
        int count = 0;
        for (int i = amount.length() - 1; i >= 0; i--) {
            if (count % 3 == 0 && count != 0) {
                sb.append(".");
                count = 0;
            }
            sb.append(String.valueOf(amount.charAt(i)));
            count++;
        }
        sb.reverse();
        return sb.toString();
    }

    public static String roundTo(double number, int roundNumber) {
        double roundedOneDigitX = Math.round(number * Math.pow(10, roundNumber)) / Math.pow(10.0, roundNumber);
        return String.valueOf(roundedOneDigitX);
    }
}
