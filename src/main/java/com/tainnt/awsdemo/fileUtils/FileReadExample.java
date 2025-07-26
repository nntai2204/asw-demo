package com.tainnt.awsdemo.fileUtils;

import com.tainnt.awsdemo.models.FileResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReadExample {

    public static FileResponse readFromFile(String fileName) throws IOException {
        String content = Files.readString(Paths.get(fileName));
        FileResponse fileResponse = new FileResponse();
        fileResponse.setData(content);
        fileResponse.setIp(ServerInfoUtil.getLocalIp());
        return fileResponse;
    }
}
