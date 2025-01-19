package com.rinhadebackend.q1;

import com.rinhadebackend.q1.controller.ClientesController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(9092), 0);

        server.createContext("/clientes", new ClientesController());

        server.setExecutor(null);
        server.start();
        System.out.println("Server is running");

    }
}
