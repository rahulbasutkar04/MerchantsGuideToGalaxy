package com.amaap.merchantsguidetogalaxy.service;

import com.amaap.merchantsguidetogalaxy.service.exception.EmptyFilePathException;
import com.amaap.merchantsguidetogalaxy.service.io.FileReader;
import com.amaap.merchantsguidetogalaxy.service.io.exception.NoDataFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradeServiceTest {

 private FileReader fileReader=new FileReader();
    @Test
    void shouldBeAbleToReturnTrueIfFileReadingServiceGotTriggered() throws NoDataFoundException, EmptyFilePathException {
        // arrange
        TradeService tradeService=new TradeService(fileReader);
        String path="D:\\MerchantsGuideToGalaxy\\src\\main\\resources\\Tradedata.txt";
        boolean expected=true;

        // act
        boolean actual=tradeService.calculateTrade(path);

        // assert
        assertEquals(expected,actual);
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