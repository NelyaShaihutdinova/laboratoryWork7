package org.example;

import builders.CommandShaper;
import client.ConsoleWorker;
import client.RequestSender;
import client.ResponseWorker;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = new Client("localhost", 1050);
        DatagramSocket ds = new DatagramSocket(1060);
        DatagramPacket pack = new DatagramPacket(new byte[10000000], 1000000);
        client.readCommands(ds, pack);
    }


    public void readCommands(DatagramSocket ds, DatagramPacket pack) throws IOException {
        Scanner sc = new Scanner(System.in);
        try {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                String name = tokens[0];
                String exit = "exit";
                if (exit.equals(line)) {
                    sc.close();
                } else if (name.equals("add") || name.equals("add_if_min") || name.equals("remove_greater") || name.equals("remove_lower")) {
                    ConsoleWorker consoleWorker = new ConsoleWorker();
                    String param = consoleWorker.buildParam();
                    CommandShaper commandShaper = new CommandShaper(name, param);
                    RequestSender requestSender = new RequestSender(host, port);
                    requestSender.sendRequest(commandShaper);
                    ds.receive(pack);
                    ResponseWorker responseWorker = new ResponseWorker();
                    System.out.println(responseWorker.deserializeResponse(pack.getData()).getResponse());
                } else if (name.equals("update")) {
                    ConsoleWorker consoleWorker = new ConsoleWorker();
                    String param = tokens[1] + " " + consoleWorker.buildParam();
                    CommandShaper commandShaper = new CommandShaper(name, param);
                    RequestSender requestSender = new RequestSender(host, port);
                    requestSender.sendRequest(commandShaper);
                    ds.receive(pack);
                    ResponseWorker responseWorker = new ResponseWorker();
                    System.out.println(responseWorker.deserializeResponse(pack.getData()).getResponse());
                } else if (tokens.length == 2) {
                    String param = tokens[1];
                    CommandShaper commandShaper = new CommandShaper(name, param);
                    RequestSender requestSender = new RequestSender(host, port);
                    requestSender.sendRequest(commandShaper);
                    ds.receive(pack);
                    ResponseWorker responseWorker = new ResponseWorker();
                    System.out.println(responseWorker.deserializeResponse(pack.getData()).getResponse());
                } else {
                    String param = "no";
                    CommandShaper commandShaper = new CommandShaper(name, param);
                    RequestSender requestSender = new RequestSender(host, port);
                    requestSender.sendRequest(commandShaper);
                    ds.receive(pack);
                    ResponseWorker responseWorker = new ResponseWorker();
                    System.out.println(responseWorker.deserializeResponse(pack.getData()).getResponse());
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Bye");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}




