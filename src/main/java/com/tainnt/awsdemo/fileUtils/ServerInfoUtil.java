package com.tainnt.awsdemo.fileUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerInfoUtil {
    public static String getLocalIp() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Không thể lấy IP";
        }
    }
}
