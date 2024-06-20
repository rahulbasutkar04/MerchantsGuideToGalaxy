package com.amaap.merchantsguidetogalaxy.controller;

import com.amaap.merchantsguidetogalaxy.controller.dto.Http;
import com.amaap.merchantsguidetogalaxy.controller.dto.Response;

public class MerchantGuideController {
    public Response calculateTrade(String path) {
        return new Response(Http.Ok,"Trade Successful");
    }
}
