package com.rinhadebackend.q1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rinhadebackend.q1.domain.transacao.TransacaoRequestDTO;
import com.rinhadebackend.q1.domain.transacao.TransacaoResponseDTO;
import com.rinhadebackend.q1.service.ExtratoService;
import com.rinhadebackend.q1.service.TransacoesService;
import com.rinhadebackend.q1.service.ValidacaoService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ClientesController implements HttpHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private TransacoesService transacoesService;
    private ExtratoService extratoService;
    private ValidacaoService validacaoService;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String httpMethod = exchange.getRequestMethod();
        String rawRequestUrl = String.valueOf(exchange.getRequestURI());
        String operation = rawRequestUrl.split("/")[3];
        if (!operation.equalsIgnoreCase("transacoes") || !operation.equalsIgnoreCase("extrato")) {
            sendResponse(exchange, 400, "Invalid URL");
            return;
        }
        int idCliente = Integer.parseInt(rawRequestUrl.split("/")[2]);

        try {
            validacaoService.validateId(idCliente);
        } catch (NumberFormatException e) {
            sendResponse(exchange, 400, "Invalid user ID");
            return;
        }

        if (httpMethod.equalsIgnoreCase("POST") && operation.equalsIgnoreCase("transacoes")) {
            handleTransacao(exchange, idCliente);
        } else if (httpMethod.equalsIgnoreCase("GET") && operation.equalsIgnoreCase("extrato")) {
            handleExtrato(exchange, idCliente);
        }
        else {
            sendResponse(exchange, 404, "Resource not found");
        }

    }

    private void handleTransacao(HttpExchange exchange, int idCliente) throws IOException {
        String requestBody = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
        TransacaoRequestDTO transacaoRequest = objectMapper.readValue(requestBody, TransacaoRequestDTO.class);
        TransacaoResponseDTO responseDTO = transacoesService.newTransacao(transacaoRequest);
        String response = objectMapper.writeValueAsString(Map.of("limite", 100000, "saldo", -9098));
        sendResponse(exchange, 200, response);
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(statusCode, response.getBytes(StandardCharsets.UTF_8).length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }
}
