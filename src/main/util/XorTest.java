package main.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhangyaoyuan
 * @date 2022/10/27
 */
public class XorTest {
    public static void main(String[] args) {
        File srcFile = new File("E:\\projects\\Java\\person\\java_test_0317\\test.txt");
        File dstFile = new File("E:\\projects\\Java\\person\\java_test_0317\\test_out.txt");
        File preFile = new File("E:\\projects\\Java\\person\\java_test_0317\\out_out.txt");
        String key = "60DD3DC0";
        try {
            XORUtils.encryptFile(srcFile, dstFile, Util.hexToByte("60DD3DC0"));
            XORUtils.encryptFile(dstFile, preFile, Util.hexToByte("60DD3DC0"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = 0X60DD3DC0;
        System.out.println(String.valueOf(i));
        int parseInt = Integer.parseInt(String.valueOf("60DD3DC0"), 16);
        System.out.println("parseInt = " + parseInt);
        byte[] bytes = "60DD3DC0".getBytes();
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = Util.hexToByte("60DD3DC0");
        System.out.println("bytes1 = " + Arrays.toString(bytes1));
        String s = Util.hexStringToString("60DD3DC0", 2);
        System.out.println("s = " + s);
        byte[] bytes2 = Util.hexStringToBytes("60DD3DC0");
        System.out.println("bytes2 = " + Arrays.toString(bytes2));

    }
}
