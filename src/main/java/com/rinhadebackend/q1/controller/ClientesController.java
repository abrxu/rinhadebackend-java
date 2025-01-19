package com.rinhadebackend.q1.controller;

import com.rinhadebackend.q1.service.ExtratoService;
import com.rinhadebackend.q1.service.TransacoesService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClientesController implements HttpHandler {

    private TransacoesService transacoesService;
    private ExtratoService extratoService;

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String httpMethod = exchange.getRequestMethod();
        String rawRequestUrl = String.valueOf(exchange.getRequestURI());
        String operation = rawRequestUrl.split("/")[3];
        int idCliente = Integer.parseInt(rawRequestUrl.split("/")[2]);
        String requestBody = convertRequestBodyIO(exchange.getRequestBody());
        System.out.println(requestBody);

    }

    public String convertRequestBodyIO(InputStream requestBody) throws IOException {
        ByteArrayOutputStream convertedRequestBody = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        for (int length; (length = requestBody.read(buffer)) != -1; ) {
            convertedRequestBody.write(buffer, 0, length);
        }
        return convertedRequestBody.toString("UTF-8");
    }
}
