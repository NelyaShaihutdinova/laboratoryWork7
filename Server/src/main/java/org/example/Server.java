package org.example;

import builders.CommandShaper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1020);
            while (true) {
                DatagramPacket pack = new DatagramPacket(new byte[10000000], 1000000);
                System.out.println("Дожили до recieve");
                ds.receive(pack);
                System.out.println("Дожили после recieve");
                System.out.println(deserializeMessage(pack.getData()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static CommandShaper deserializeMessage(byte[] pack) throws IOException, ClassNotFoundException {
        System.out.println("Start deser..");
        try (var stream = new ObjectInputStream(new ByteArrayInputStream(pack))) {
            System.out.println("создали херню");
            CommandShaper commandShaper = (CommandShaper) stream.readObject();
            System.out.println(commandShaper.getName() + "...");
            return (CommandShaper) stream.readObject();
        }
    }
}