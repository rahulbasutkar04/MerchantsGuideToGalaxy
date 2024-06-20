package com.amaap.merchantsguidetogalaxy.controller;

import com.amaap.merchantsguidetogalaxy.controller.dto.Http;
import com.amaap.merchantsguidetogalaxy.controller.dto.Response;
import com.amaap.merchantsguidetogalaxy.service.TradeService;
import com.amaap.merchantsguidetogalaxy.service.exception.EmptyFilePathException;
import com.amaap.merchantsguidetogalaxy.service.io.exception.NoDataFoundException;

public class MerchantGuideController {

    private TradeService tradeService;
    public MerchantGuideController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    public Response calculateTrade(String path) throws NoDataFoundException, EmptyFilePathException {
         if(tradeService.calculateTrade(path))
         {
             return new Response(Http.Ok,"Trade Successful");

         }
         else  return new Response(Http.Ok,"Trade Successful");

    }
}
