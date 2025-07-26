package com.tainnt.awsdemo.fileUtils;

import com.tainnt.awsdemo.models.FileResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static FileResponse readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileResponse fileResponse = new FileResponse();
        fileResponse.setData(content.toString());
        fileResponse.setIp(ServerInfoUtil.getLocalIp());
        return fileResponse;
    }
}
