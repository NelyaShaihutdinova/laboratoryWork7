package org.example;

import client.CommandShaper;
import client.ValidException;
import command.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    private String host;
    private int port;
    private Map<String, Command> commands = new HashMap<>();

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Client() {
    }

    public static void main(String[] args) throws ValidException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Client client = new Client("localhost", 1020);
        client.readCommands(client);

    }

    private byte[] serializeObject(CommandShaper object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        }
    }

    private byte[] serializeResponse(CommandShaper object) throws IOException {
        var byteStream = new ByteArrayOutputStream();
        try (var objectStream = new ObjectOutputStream(byteStream)) {
            objectStream.writeObject(object);
            return byteStream.toByteArray();
        }
    }

    public void send(CommandShaper object) throws IOException {
        try {
            byte[] transition = serializeObject(object);
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket pack = new DatagramPacket(transition, transition.length, address, port);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
            System.out.println("send command");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void readCommands(Client client) throws ValidException, IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            String param = "null";
            String exit = "exit";
            commands.put("add", new AddCommand(param));
            commands.put("show", new ShowCommand(param));
            commands.put("clear", new ClearCommand(param));
            commands.put("info", new InfoCommand(param));
            commands.put("help", new HelpCommand(param));
            commands.put("add_if_min", new AddIfMinCommand(param));
            commands.put("remove_greater", new RemoveGreaterCommand(param));
            commands.put("remove_lower", new RemoveLowerCommand(param));
            commands.put("update", new UpdateIdCommand(param));
            commands.put("remove_by_id", new RemoveByIdCommand(param));
            commands.put("count_greater_than_impact_speed", new CountGreaterCommand(param));
            commands.put("filter_contains_soundtrack_name", new FilterContainsCommand(param));
            commands.put("filter_greater_than_impact_speed", new FilterGreaterCommand(param));
            commands.put("execute_script", new ExecuteScriptCommand(param));
            Command command = commands.get(tokens[0]);
            String param1 = tokens[1];
            if (tokens.length == 2) {
                param = tokens[1];
                Command updatedCommand = command.getClass().getConstructor(String.class).newInstance(param1);
                commands.replace(tokens[0], updatedCommand);
                if (exit.equals(line)) {
                    sc.close();
                } else {
                    updatedCommand.execute();
                }
                if (exit.equals(line)) {
                    sc.close();
                } else if (Objects.isNull(command)) {
                    throw new ValidException("Команда не найдена");
                } else {
                    client.send(command.execute());
                }
            }

        }
    }
}


