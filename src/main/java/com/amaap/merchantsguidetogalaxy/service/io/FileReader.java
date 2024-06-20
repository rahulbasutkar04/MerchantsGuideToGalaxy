package com.amaap.merchantsguidetogalaxy.service.io;

import com.amaap.merchantsguidetogalaxy.service.io.exception.NoDataFoundException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private List<String> fileData=new ArrayList<>();
    public List<String> read(String path) throws NoDataFoundException {
        File file=new File(path);

        if(file.length()==0) throw new NoDataFoundException("No data present in the file");

        return null;
    }
}
