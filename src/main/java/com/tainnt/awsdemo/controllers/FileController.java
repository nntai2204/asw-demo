package com.tainnt.awsdemo.controllers;

import com.tainnt.awsdemo.fileUtils.FileReadExample;
import com.tainnt.awsdemo.fileUtils.FileWriteExample;
import com.tainnt.awsdemo.models.FileRequest;
import com.tainnt.awsdemo.models.FileResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final String FILE_PATH = "data.txt";

    @PostMapping("/write")
    public String writeFile(@RequestBody FileRequest content) {
        FileWriteExample.writeToFile(
                content.getFileName(), content.getData());
        return "Write file! ";
    }

    @PostMapping("/read")
    public FileResponse readFile(@RequestBody FileRequest filePath) throws IOException {
        return FileReadExample.readFromFile(filePath.getFileName());
    }
}

