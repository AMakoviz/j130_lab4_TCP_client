package org.example;

import java.io.*;
import java.net.Socket;

public class MessageExchangeSender {

    public void send(String message, AppProperties properties) {
        try (
                Socket socket = new Socket(properties.getHost(), properties.getPort());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ){
            writer.write(message);
            writer.flush();
            socket.shutdownOutput();

            String response;
            while ((response = reader.readLine()) != null) {
                System.out.println("Сообщение от сервера: " + response);
            }
            socket.shutdownInput();


        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
