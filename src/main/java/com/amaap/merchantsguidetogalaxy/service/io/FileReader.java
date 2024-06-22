package com.amaap.merchantsguidetogalaxy.service.io;

import com.amaap.merchantsguidetogalaxy.service.io.exception.DataNotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<String> read(String path) throws DataNotFoundException, FileSystemException {
         List<String> fileData=new ArrayList<>();

        File file=new File(path);

        if(file.length()==0) throw new DataNotFoundException("No data present in the file");
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String processedLine = line.trim().replaceAll("\\s+", " ");
                if (!processedLine.isEmpty()) {
                    fileData.add(processedLine);
                }
            }
        } catch (IOException e) {
            throw new FileSystemException("Error reading the file: " + e.getMessage());
        }

        return fileData;
    }


}

