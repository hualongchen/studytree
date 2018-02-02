package com.tongrong.order.util;



public class NumUtil {



    /**
     * @description 判断是否为自然数  TYPE==1自然数，， TYPE==2为正整数
     * @return true 是，false 否
     * @throws
     * @author chenhualong
     * @update Feb 25, 2014 5:33:16 PM
     */
    public static boolean  isNum(String str, int type) {
        try {
            long l = Long.parseLong(str);


            if(type ==1){
                if (l >= 0) {
                    return true;
                } else {
                    return false;
                }
            }else{

                if (l >= 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            return false;
        }
    }



}
