package com.tainnt.awsdemo.fileUtils;

import java.net.*;
import java.util.Enumeration;

public class ServerInfoUtil {
    public static String getLocalIp() {
        String defaultIp = "9.9.9.9";
        try {
            NetworkInterface netInterface = NetworkInterface.getByName("enp0s3");
            if (netInterface == null) {
                return defaultIp;
            }

            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                if (!addr.isLoopbackAddress() && addr instanceof Inet4Address) {
                    return "IP: " + addr.getHostAddress();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return defaultIp;
    }
}
