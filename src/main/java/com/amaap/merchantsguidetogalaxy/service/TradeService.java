package com.amaap.merchantsguidetogalaxy.service;

import com.amaap.merchantsguidetogalaxy.service.exception.EmptyFilePathException;
import com.amaap.merchantsguidetogalaxy.service.io.FileReader;
import com.amaap.merchantsguidetogalaxy.service.io.exception.DataNotFoundException;

import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;

public class TradeService {
    private FileReader fileReader;
    private List<String> fileData=new ArrayList<>();

    public TradeService(FileReader fileReader) {
        this.fileReader = fileReader;
    }
    public boolean calculateTrade(String path) throws DataNotFoundException, EmptyFilePathException, FileSystemException {

        if(path.isEmpty()) throw new EmptyFilePathException("File path can not be empty.");
         fileData = fileReader.read(path);


        return fileData.size() != 0;
    }

    public List<String> getFileData() {
        return fileData;
    }
}
