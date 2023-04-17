package main.java;

import java.util.regex.Pattern;

/**
 * @author zhangyaoyuan
 * @date 2022/12/15
 */
public class TestIp {

    public static void main(String[] args) {
        System.out.println(isIpSegment("sdfgretgergh"));
        System.out.println(isIpSegment("1.1.1.0"));
        System.out.println(isIpSegment("1.1.1.0/241"));


    }


    public static boolean isInRange(String ip, String cidr) {
        String[] ips = ip.split("\\.");
        int ipAddr = (Integer.parseInt(ips[0]) << 24)
                | (Integer.parseInt(ips[1]) << 16)
                | (Integer.parseInt(ips[2]) << 8) | Integer.parseInt(ips[3]);
        int type = Integer.parseInt(cidr.replaceAll(".*/", ""));
        int mask = 0xFFFFFFFF << (32 - type);
        String cidrIp = cidr.replaceAll("/.*", "");
        String[] cidrIps = cidrIp.split("\\.");
        int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24)
                | (Integer.parseInt(cidrIps[1]) << 16)
                | (Integer.parseInt(cidrIps[2]) << 8)
                | Integer.parseInt(cidrIps[3]);

        return (ipAddr & mask) == (cidrIpAddr & mask);
    }

    /**
     * 判断是否是单个IPv4信息是否是IP范围 /24子网掩码格式
     * 1.1.1.1/255.0.0.0 false
     * @param ipValue 待判断的IP网段信息
     * @return 判断状态
     */
    public static boolean isIpSegment(String ipValue) {
        String ipReg = "^(?=(\\b|\\D))(((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))(?=(\\b|\\D))/([1-2][0-9]|3[0-2]|[1-9])$";
        Pattern ipPatternTemp = Pattern.compile(ipReg);
        boolean matcher = ipPatternTemp.matcher(ipValue).matches();
        return matcher;
    }
}
