package com.tongrong.order.util;

import com.tongrong.order.util.exception.BusinessException;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ToolsUtil {


    /**
     * 获取用户IP地址
     *
     * @param request  request
     * @return String
     */
    public static String getIp(HttpServletRequest request) {
        String remoteIp;
        remoteIp = request.getHeader("X-Forwarded-For");
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("X-Real-IP");
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("Proxy-Client-IP");
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("HTTP_CLIENT_IP");
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        // 获取到的IP可能是一个由多个IP组成的字符串，取左边第一个IP为真实IP
        if (remoteIp != null) {
            int resout = remoteIp.indexOf(",");
            if (resout != -1) {
                String[] strArray = remoteIp.split(",");
                remoteIp = strArray[0];
            }

            // 对IP地址进行效验
            Pattern pattern = Pattern.compile("^[1-9]{1,3}(\\.\\d{1,3}){3}$");
            Matcher matcher = pattern.matcher(remoteIp);
            if (matcher.matches()) {
                return remoteIp;
            }
        }
        return "unknown";
    }


    /**
     * 返回文件后缀名字
     *
     * @param fileName  fileName
     * @return String
     */
    public static String getFileLastName(String fileName) {

        int dot = fileName.lastIndexOf('.');

        if ((dot > -1) && (dot < (fileName.length()))) {

            return fileName.substring(dot, fileName.length());
        } else {

            return null;
        }

    }


    /**
     * string转换到数字
     *
     * @param str  str
     * @return  int
     */
    @SneakyThrows
    public static int stringToNum(String str) {


        try {
            int num = Integer.parseInt(str);
            if (num > 0) {

                return num;
            }
            throw new BusinessException(ErrorContent.PARAMETER_RESOLUTION_FAILURE_CDOE, ErrorContent.PARAMETER_RESOLUTION_FAILURE_MESSAGE);
        } catch (Exception ex) {

            throw new BusinessException(ErrorContent.PARAMETER_RESOLUTION_FAILURE_CDOE, ErrorContent.PARAMETER_RESOLUTION_FAILURE_MESSAGE);
        }

    }


    /**
     * 可以包含0
     * @param str str
     * @return int
     */
    public static int stringToNum2(String str) {


        try {
            int num = Integer.parseInt(str);
            if (num >= 0) {

                return num;
            }
            throw new BusinessException(ErrorContent.PARAMETER_RESOLUTION_FAILURE_CDOE, ErrorContent.PARAMETER_RESOLUTION_FAILURE_MESSAGE);
        } catch (Exception ex) {

            throw new BusinessException(ErrorContent.PARAMETER_RESOLUTION_FAILURE_CDOE, ErrorContent.PARAMETER_RESOLUTION_FAILURE_MESSAGE);
        }

    }

    /**
     * 转化成double
     */
    public static Double stringToDouble(String str) {

        try {

            Double num = Double.valueOf(str);
            if (num >= 0) {

                return num;
            }
            throw new BusinessException(ErrorContent.PARAMETER_RESOLUTION_FAILURE_CDOE, ErrorContent.PARAMETER_RESOLUTION_FAILURE_MESSAGE);
        } catch (Exception ex) {

            throw new BusinessException(ErrorContent.PARAMETER_RESOLUTION_FAILURE_CDOE, ErrorContent.PARAMETER_RESOLUTION_FAILURE_MESSAGE);
        }

    }


    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        return formatter.parse(dateString, pos);
    }


    /**
     * 获取现在时间
     *
     * @return  返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);
    }
    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(currentTime);
    }


    /**
     * 随机5位数
     * @return  int
     */
    public static int  getRadom(){

        Random rand = new Random();

        return rand.nextInt(80000) + 10000;


    }



}
