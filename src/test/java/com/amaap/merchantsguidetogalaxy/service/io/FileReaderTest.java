package com.amaap.merchantsguidetogalaxy.service.io;

import com.amaap.merchantsguidetogalaxy.service.io.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;

import java.nio.file.FileSystemException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void shouldThrowExceptionIfFileDonNotHaveData() {
        // arrange
        FileReader fileReader = new FileReader();
        String path = "D:\\MerchantsGuideToGalaxy\\src\\main\\resources\\EmptyData.txt";

        // act & assert
        assertThrows(DataNotFoundException.class, () -> {
            fileReader.read(path);
        });

    }

    @Test
    void shouldBeAbleToReadTheDataAnExtractAsListOfString() throws DataNotFoundException, FileSystemException {
        // arrange
        FileReader fileReader=new FileReader();
        String path="D:\\MerchantsGuideToGalaxy\\src\\main\\resources\\Tradedata.txt";

        // act
        List<String> dataInFile =fileReader.read(path);

        System.out.println(dataInFile);

        // assert
        assertEquals(12,dataInFile.size());


    }

}