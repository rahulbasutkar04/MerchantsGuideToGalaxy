package com.amaap.merchantsguidetogalaxy.service;

import com.amaap.merchantsguidetogalaxy.service.exception.EmptyFilePathException;
import com.amaap.merchantsguidetogalaxy.service.io.FileReader;
import com.amaap.merchantsguidetogalaxy.service.io.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;

import java.nio.file.FileSystemException;

import static org.junit.jupiter.api.Assertions.*;

class TradeServiceTest {

 private FileReader fileReader=new FileReader();
    @Test
    void shouldBeAbleToReturnTrueIfFileReadingServiceGotTriggered() throws DataNotFoundException, EmptyFilePathException, FileSystemException {
        // arrange
        TradeService tradeService=new TradeService(fileReader);
        String path="D:\\MerchantsGuideToGalaxy\\src\\main\\resources\\Tradedata.txt";
        boolean expected=true;

        // act
        boolean actual=tradeService.calculateTrade(path);

        // assert
        assertEquals(expected,actual);

        assertEquals(12,tradeService.getFileData().size());
    }

    @Test
    void shouldThrowExceptionIFProvidedPathIsEmpty()
    {
        // arrange
        TradeService tradeService=new TradeService(fileReader);
        String path="";

        // act & assert
        assertThrows(EmptyFilePathException.class,()->{
            tradeService.calculateTrade(path);
        });
    }


}