package com.amaap.merchantsguidetogalaxy;

import com.amaap.merchantsguidetogalaxy.controller.MerchantGuideController;
import com.amaap.merchantsguidetogalaxy.controller.dto.Http;
import com.amaap.merchantsguidetogalaxy.controller.dto.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MerchantGuideControllerTest {

    @Test
    void shouldBeAbleToRespondWithOkWhenOperationPerformedForTheGivenFile()
    {
        // arrange
        MerchantGuideController merchantGuideController=new MerchantGuideController();
        Response expectedResponse=new Response(Http.Ok,"Trade Successful");
        String path="";

        // act
        Response actualResponse= merchantGuideController.calculateTrade(path);

        // assert
        assertEquals(expectedResponse,actualResponse);
    }
}
