package com.tongrong.order.util;

public class StringUtil {




    /**
     * @description 取得字符串的实际长度（考虑了汉字的情况）
     * @param SrcStr  源字符串
     * @return 字符串的实际长度
     * @throws
     * @author chenhualong
     * @update Feb 25, 2014 5:27:26 PM
     */
    public static int getStringLen(String SrcStr) {
        int return_value = 0;
        if (SrcStr != null) {
            char[] theChars = SrcStr.toCharArray();
            for (int i = 0; i < theChars.length; i++) {
                return_value += (theChars[i] <= 255) ? 1 : 2;
            }
        }
        return return_value;
    }


    /**
     * @description  把null转成为"",去掉字符串的空格
     * @param str
     * @return
     * @author chenhualong
     * @update Mar 11, 2014 11:24:52 AM
     */
    public static String objectToStr(Object str) {
        if (null == str) {
            return "";
        } else {
            return str.toString().trim();
        }
    }



    /**
     * HTML字符转义
     * @return String 过滤后的字符串
     */
    public static String htmlEscape(String input) {


        if(null==input || 0==input.length() || 0==input.replaceAll("\\s", "").length()){
            return input;
        }

        input = input.trim();
        input = input.replaceAll("&", "&amp;");
        input = input.replaceAll("<", "&lt;");
        input = input.replaceAll(">", "&gt;");
        input = input.replaceAll(" ", "&nbsp;");
        input = input.replaceAll("'", "&#39;");   //IE暂不支持单引号的实体名称,而支持单引号的实体编号,故单引号转义成实体编号,其它字符转义成实体名称
        input = input.replaceAll("\"", "&quot;"); //双引号也需要转义，所以加一个斜线对其进行转义
        input = input.replaceAll("\n", "<br/>");  //不能把\n的过滤放在前面，因为还要对<和>过滤，这样就会导致<br/>失效了
        return input;
    }






}
