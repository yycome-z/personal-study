package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author zhangyaoyuan
 * @date 2022/05/23
 */
public class TestSelfEncrypt {
    public static void main(String[] args) {
        // 获取原始数据
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddHHmm");
        String srcData = dateFormat.format(new Date());
        System.out.println("srcData = " + srcData);
        // 加密
        String enCode = enCodeByRandom(getRandomNumber(), enCodeByRandom(getRandomNumber(), srcData));
        System.out.println("enCode = " + enCode);
        // 解密授权码
        String deCode = deCode(deCode(enCode));
        System.out.println("deCode = " + deCode);
        // 验证是否正确，是否过期
        boolean result = checkCode(deCode);
        System.out.println("result = " + result);
    }

    /**
     * 获取随机数1-9（生成0则换成9）
     *
     * @return
     */
    public static int getRandomNumber() {
        // 生成随机数
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber == 0 ? 9 : randomNumber;
    }

    /**
     * 根据随机数加密，加密一次在数据前面补一位
     *
     * @param randomNumber 随机数
     * @param srcData      需要加密数据
     * @return
     */
    public static String enCodeByRandom(int randomNumber, String srcData) {
        char[] srcChars = srcData.toCharArray();
        char[] dstChars = new char[srcChars.length + 1];
        dstChars[0] = (char) (((5 + randomNumber) % 10) + '0');
        for (int i = 0; i < srcChars.length; i++) {
            dstChars[i + 1] = (char) ((((int) srcChars[i] - (int) '0') + (i + 1) * randomNumber) % 10 + '0');
        }
        // 第一位根据最后一位做出改变,修改最后一位可以随便改变的bug
        dstChars[0] = (char) ((((int) dstChars[0] - (int) '0') + ((int) dstChars[dstChars.length - 1] - (int) '0')) % 10 + '0');
        return String.valueOf(dstChars);
    }

    /**
     * 对应解密，解密一次去掉数据第一位
     *
     * @param code 待解密数据
     * @return
     */
    public static String deCode(String code) {
        if (code == null || code.isEmpty()) {
            return "";
        }
        char[] srcChars = code.toCharArray();
        // 第一位是密钥，单独处理

        int privateKey = ((int) srcChars[0] - (int) '0') - ((int) srcChars[srcChars.length - 1] - (int) '0') - 5;
        while (privateKey < 0) {
            privateKey += 10;
        }
        char[] dstChars = new char[srcChars.length - 1];
        // 解密还原
        for (int i = 1; i < srcChars.length; i++) {
            int deCode = ((int) srcChars[i] - (int) '0') - i * privateKey;
            while (deCode < 0) {
                deCode += 10;
            }
            dstChars[i - 1] = (char) (deCode + '0');
        }

        return String.valueOf(dstChars);
    }

    /**
     * 验证是否正确，是否过期
     *
     * @param deCode 解密后的数据
     * @return
     */
    public static boolean checkCode(String deCode) {
        if (null == deCode || deCode.length() != 6) {
            return false;
        }
        SimpleDateFormat checkTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat nowTimeFormat = new SimpleDateFormat("2022-05-dd HH:mm:00");
        String day = deCode.substring(0, 2);
        String hour = deCode.substring(2, 4);
        String min = deCode.substring(4);
        String checkTime = "2022-05-" + day + " " + hour + ":" + min + ":" + "00";
        // 传进来的时间
        long checkTimeMs;
        // 当前时间
        long nowTimeMs;
        try {
            checkTimeMs = checkTimeFormat.parse(checkTime).getTime();
            nowTimeMs = checkTimeFormat.parse(nowTimeFormat.format(new Date())).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return (nowTimeMs >= checkTimeMs) && (nowTimeMs - checkTimeMs) <= 5 * 60 * 1000L;
    }
}
