package org.example;

import builders.CommandShaper;
import client.ConsoleWorker;
import client.RequestSender;

import java.io.IOException;
import java.util.Scanner;


public class Client {
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Client() {
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 1030);
        client.readCommands();

    }


    public void readCommands() throws IOException {
        Scanner sc = new Scanner(System.in);
        try {

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                String name = tokens[0];
                String exit = "exit";
                if (exit.equals(line)) {
                    sc.close();
                } else if (name.equals("add") || name.equals("add_if_min") || name.equals("update") || name.equals("remove_greater") || name.equals("remove_lower")) {
                    ConsoleWorker consoleWorker = new ConsoleWorker();
                    String param = consoleWorker.buildParam();
                    CommandShaper commandShaper = new CommandShaper(name, param);
                    RequestSender requestSender = new RequestSender(host, port);
                    requestSender.sendRequest(commandShaper);
                } else if (tokens.length == 2) {
                    String param = tokens[1];
                    CommandShaper commandShaper = new CommandShaper(name, param);
                    RequestSender requestSender = new RequestSender(host, port);
                    requestSender.sendRequest(commandShaper);
                } else {
                    String param = "no";
                    CommandShaper commandShaper = new CommandShaper(name, param);
                    RequestSender requestSender = new RequestSender(host, port);
                    requestSender.sendRequest(commandShaper);
                }
                if (exit.equals(line)) {
                    sc.close();
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Bye");
        }
    }
}




