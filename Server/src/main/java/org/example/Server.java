package org.example;

import builders.CommandShaper;
import builders.FileBuilder;
import command.CollectionController;
import command.Invoker;
import entities.HumanBeing;
import entities.HumanSimpleValidator;
import parser.Reader;
import parser.Writer;
import server.RequestWorker;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1030);
            while (true) {
                DatagramPacket pack = new DatagramPacket(new byte[10000000], 1000000);
                ds.receive(pack);
                RequestWorker requestWorker = new RequestWorker();
                CommandShaper commandShaper = requestWorker.deserializeResponse(pack.getData());
                FileBuilder fileBuilder = new FileBuilder();
                File file = new File("C:\\Users\\fohad\\IdeaProjects\\LAB6\\LaboratoryWork5\\Server\\src\\main\\java\\lab5");
                Writer<HumanBeing> writer = new Writer<>();
                Reader reader = new Reader(file);
                List<HumanBeing> humanBeings = reader.getPersons();
                CollectionController cc = new CollectionController(humanBeings, writer, file, new HumanSimpleValidator());
                Invoker invoker = new Invoker(commandShaper, cc);
                invoker.readCommand();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}