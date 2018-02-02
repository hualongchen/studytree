package com.tongrong.order.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {

    /**
     * 检验数字
     */
    public static boolean isNumEx0(String str) {
        try {
            long l = Long.parseLong(str);
            return l >= 0;
        } catch (Exception ex) {
            return false;
        }
    }


    /**
     * 校验第二种数字
     *
     * @param   str str
     * @return  boolean
     */
    public static boolean isNumEx2(String str) {
        try {
            long l = Long.parseLong(str);
            return l >= 0 && l <= 100;
        } catch (Exception ex) {
            return false;
        }
    }


    /**
     * 检验double
     *
     * @param str str
     * @return boolean
     */
    public static boolean isDouble(String str) {
        try {
            Double dou = Double.parseDouble(str);
            return true ;
        } catch (Exception ex) {
            return false;
        }
    }



    /**
     * 过滤XSS
     *
     * @param str  str
     * @return  String
     */
    public static String filter(String str) {

        //去除空格
        str = str.trim();
        if (!str.equals("")) {
            str = str.replace("\\", "\\\\");
            str = str.replace("<", "&#60;");
            str = str.replace(">", "&#62;");
            str = str.replace("\"", "&#34;");
            str = str.replace("'", "&#39;");
            str = str.replace(" ", "&nbsp;");
            str = str.replace(",", "。");
            str = str.replace("，", "。");
        }
        return str;
    }

    /**
     * 匹配Luhn算法：可用于检测银行卡卡号
     * @param cardNo
     * @return boolean
     */
    public static boolean matchLuhn(String cardNo) {
        int[] cardNoArr = new int[cardNo.length()];
        for (int i=0; i<cardNo.length(); i++) {
            cardNoArr[i] = Integer.valueOf(String.valueOf(cardNo.charAt(i)));
        }
        for(int i=cardNoArr.length-2;i>=0;i-=2) {
            cardNoArr[i] <<= 1;
            cardNoArr[i] = cardNoArr[i]/10 + cardNoArr[i]%10;
        }
        int sum = 0;
        for(int i=0;i<cardNoArr.length;i++) {
            sum += cardNoArr[i];
        }
        return sum % 10 == 0;
    }


    /**
     * 邮箱校验
     * @param email  邮箱地址
     * @return  boolean
     */
    public static boolean emailFormat(String email)
    {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }

    /**
     * 校验QQ号
     * @param str  str
     * @return  boolean
     */
    public static boolean isQQCorrect(String str)
    {
        String  regex ="[1-9][0-9]{4,14}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();

    }

    /**
     * @param regex
     * 正则表达式字符串
     * @param str
     * 要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    /**
     * 验证IP地址
     *
     * @param
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean isIP(String str) {
        String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
        String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
        return match(regex, str);
    }


    public static void main(String[] args) {


        String test="10.2.2.1";

        System.out.println(isIP(test));
    }




}
