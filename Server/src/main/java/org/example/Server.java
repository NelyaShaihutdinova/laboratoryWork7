package org.example;

import builders.CommandShaper;
import builders.ResponseShaper;
import command.CollectionController;
import command.Invoker;
import entities.HumanSimpleValidator;
import server.RequestWorker;
import server.ResponseSender;
import server.SQLCollectionController;
import server.SqlUserManager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {
    private static SqlUserManager sqlUserManager;
    private static SQLCollectionController sqlCollectionController;
    private static ResponseSender responseSender;
    private static Connection connection;
    private static CollectionController cc;

    public static void main(String[] args) {
        initialize(args);
        System.out.println(cc.show().getResponse());
        try {
            DatagramSocket ds = new DatagramSocket(1050);
            while (true) {
                DatagramPacket pack = new DatagramPacket(new byte[10000000], 1000000);
                ds.receive(pack);
                RequestWorker requestWorker = new RequestWorker();
                CommandShaper commandShaper = requestWorker.deserializeRequest(pack.getData());
                Invoker invoker = new Invoker(commandShaper, cc, sqlCollectionController);
                ResponseShaper responseShaper = invoker.readCommand(connection);
                responseSender.sendResponse(responseShaper);
                System.out.println(cc.show().getResponse());
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

    public static void initialize(String[] args) {
        try {
            responseSender = new ResponseSender("localhost", 1060);
            connectionToDb(args[1], args[2]);
            sqlUserManager = new SqlUserManager(connection);
            cc = new CollectionController(new HumanSimpleValidator());
            sqlCollectionController = new SQLCollectionController(connection, cc);
            sqlCollectionController.initTableOrExecuteHumanBeings();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введите порт, бд юзер, пароль");
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Ошибка загрузки данных с бд");
            System.exit(1);
        }

    }

    public static int checkPort(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("Неверный порт");
            System.exit(1);
        }
        return 0;
    }

    public static void connectionToDb(String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studs", user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Проблемы с подключением к базе данных");
            System.exit(1);
        }
    }
}