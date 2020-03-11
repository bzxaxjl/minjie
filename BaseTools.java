package com.zhiyun.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Author: LinShan
 * @Date: 2019/7/26 0026 11:57
 * @Description:
 */
public class BaseTools {
    /**
     * 邀请码所用变量
     */
    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z" };

    /**
     * 生成唯一id
     * @return
     */
    public static String getRandomUUID() {
        Random random = new Random();
        String id = UUID.randomUUID().toString();
        String all = id.replaceAll("-", "") + random.nextInt(10);
        return all;
    }

    /**
     * 基于uuid的邀请码生成器
     * @return
     */
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 6; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }

    /**
     * 生成随机文件名：当前年月日时分秒+五位随机数
     *
     * @return
     */
    public static String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return str +"_"+ rannum;// 当前时间
    }




    /**
     * 日期转字符串
     *
     * @param date
     * @param formatStr
     * @return
     */
    public static String dateToString(Date date, String formatStr) {
        if (null == date) {
            return "";
        }
        DateFormat df = new SimpleDateFormat(formatStr); // formatStr设置日期格式
        return df.format(date);
    }

    /**
     * 字符串转日期
     *
     * @param str
     * @param formatStr
     * @return
     */
    public static Date stringToDate(String str, String formatStr) {
        Date date = null;
        DateFormat df = new SimpleDateFormat(formatStr); // formatStr设置日期格式
        try {
            if (!"".equals(str) && str != null) {
                date = df.parse(str);
            }
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

}
