import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;


public class MainServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8090),0);
        server.createContext("/upload", MainServer::handleUpload);
        server.start();
        System.out.println("Server running...");
    }

    private static void handleUpload(HttpExchange exchange) throws IOException{
        try{

            ObjectInputStream in = new ObjectInputStream(exchange.getRequestBody());

            Object obj = in.readObject();

            System.out.println(obj);

            String response = "OK";

            exchange.sendResponseHeaders(200, response.length());

            exchange.getResponseBody().write(response.getBytes());

            exchange.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
