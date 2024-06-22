package com.amaap.merchantsguidetogalaxy.controller;

import com.amaap.merchantsguidetogalaxy.controller.dto.Http;
import com.amaap.merchantsguidetogalaxy.controller.dto.Response;
import com.amaap.merchantsguidetogalaxy.service.TradeService;
import com.amaap.merchantsguidetogalaxy.service.exception.EmptyFilePathException;
import com.amaap.merchantsguidetogalaxy.service.io.FileReader;
import com.amaap.merchantsguidetogalaxy.service.io.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;

import java.nio.file.FileSystemException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MerchantGuideControllerTest {

    private FileReader fileReader=new FileReader();
    private TradeService tradeService=new TradeService(fileReader);

    @Test
    void shouldBeAbleToRespondWithOkWhenOperationPerformedForTheGivenFile() throws DataNotFoundException, EmptyFilePathException, FileSystemException {
        // arrange
        MerchantGuideController merchantGuideController=new MerchantGuideController(tradeService);
        Response expectedResponse=new Response(Http.Ok,"Trade Successful");
        String path="D:\\MerchantsGuideToGalaxy\\src\\main\\resources\\Tradedata.txt";

        // act
        Response actualResponse= merchantGuideController.calculateTrade(path);

        // assert
        assertEquals(expectedResponse,actualResponse);
    }
}
