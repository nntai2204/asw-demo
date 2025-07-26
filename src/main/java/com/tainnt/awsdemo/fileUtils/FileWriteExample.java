package com.tainnt.awsdemo.fileUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteExample {
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Đã ghi nội dung vào file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

