package com.tainnt.awsdemo.fileUtils;

import java.net.*;
import java.util.Enumeration;

public class ServerInfoUtil {
    public static String getLocalIp() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                if (!ni.isUp() || ni.isLoopback() || ni.isVirtual()) continue;

                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (addr instanceof Inet4Address && !addr.isLoopbackAddress() && !addr.isLinkLocalAddress()) {
                        return addr.getHostAddress(); // ✅ IP hợp lệ
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "Không tìm thấy IP hợp lệ";
    }
}
