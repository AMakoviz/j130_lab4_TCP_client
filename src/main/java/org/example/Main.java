package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите хост сервера");
        String host = scanner.nextLine().trim();
        System.out.println("Введите порт сервера");
        String port = scanner.nextLine().trim();
        AppProperties properties = new AppProperties(host, port);
        MessageExchangeSender sender = new MessageExchangeSender();
        System.out.println("Введите сообщение");
        String message = scanner.nextLine();
        (new Thread(() -> {
            sender.send(message, properties);
        })).start();


    }
}