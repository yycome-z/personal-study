package main.java;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;


public class TestIp2 {

    public static void main(String[] args) {
        System.out.println("本机IP:" + getIpAddress());
    }

    public static String getIpAddress() {
        String ip = "", mac = "", hostName = "";
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress inetAddress = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                // 判断当前的网络接口是否为回环接口、虚拟子接口、正常工作
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                }
                List<InterfaceAddress> addressList = netInterface.getInterfaceAddresses();
                for (InterfaceAddress interfaceAddress : addressList) {
                    inetAddress = interfaceAddress.getAddress();
                    if (inetAddress instanceof Inet4Address) {
                        // 名称
                        hostName = inetAddress.getHostName();
                        // ip
                        ip = inetAddress.getHostAddress();
                        StringBuilder sb = new StringBuilder();
                        // mac
                        NetworkInterface network = NetworkInterface.getByInetAddress(inetAddress);
                        if (network == null) {
                            continue;
                        }
                        byte[] macBytes = network.getHardwareAddress();
                        if (macBytes == null) {
                            continue;
                        }
                        sb.delete(0, sb.length());
                        for (int i = 0; i < macBytes.length; i++) {
                            sb.append(String.format("%02X%s", macBytes[i], (i < macBytes.length - 1) ? "-" : ""));
                        }
                        mac = sb.toString();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        System.out.println("ip----->" + ip);
        System.out.println("mac----->" + mac);
        System.out.println("name----->" + hostName);
        return "";
    }

}