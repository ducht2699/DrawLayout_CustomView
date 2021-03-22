package com.example.drawlayout_customview.utils;

import android.content.Context;
import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Utils {
    public static String standardizedMoney(String amount) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = amount.length() - 1; i >= 0; i--) {
            if (count % 3 == 0 && count != 0) {
                sb.append(".");
                count = 0;
            }
            sb.append(amount.charAt(i));
            count++;
        }
        sb.reverse();
        sb.append("¥");
        return sb.toString();
    }

    public static String roundTo(double number, int roundNumber) {
        double roundedOneDigitX = Math.round(number * Math.pow(10, roundNumber)) / Math.pow(10.0, roundNumber);
        return String.valueOf(roundedOneDigitX);
    }

    public static void setImageURL(Context context, ImageView imv, String url) {
        Glide.with(context).load(url).into(imv);
    }

    public static void setStrikeTextView(TextView textView) {
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
