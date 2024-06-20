package com.amaap.merchantsguidetogalaxy.service;

import com.amaap.merchantsguidetogalaxy.service.exception.EmptyFilePathException;
import com.amaap.merchantsguidetogalaxy.service.io.FileReader;
import com.amaap.merchantsguidetogalaxy.service.io.exception.NoDataFoundException;

import java.util.ArrayList;
import java.util.List;

public class TradeService {
    private FileReader fileReader;

    public TradeService(FileReader fileReader) {
        this.fileReader = fileReader;
    }
    public boolean calculateTrade(String path) throws NoDataFoundException, EmptyFilePathException {

        if(path.isEmpty()) throw new EmptyFilePathException("File path can not be empty.");
        List<String> fileData = fileReader.read(path);


        return fileData.size() != 0;
    }

}
