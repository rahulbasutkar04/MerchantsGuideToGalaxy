package com.amaap.merchantsguidetogalaxy.service;

import com.amaap.merchantsguidetogalaxy.service.io.FileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradeServiceTest {

 private FileReader fileReader=new FileReader();
    @Test
    void shouldBeAbleToReturnTrueIfFileReadingServiceGotTriggered(){
        // arrange
        TradeService tradeService=new TradeService(fileReader);
        String path="D:\\MerchantsGuideToGalaxy\\src\\main\\resources\\Tradedata.txt";
        boolean expected=true;

        // act
        boolean actual=tradeService.calculateTrade(path);

        // assert
        assertEquals(expected,actual);
    }

}