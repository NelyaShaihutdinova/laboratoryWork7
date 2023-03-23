package org.example.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Invoker {
    private CollectionManager cm = new CollectionManager();
    private Map<String,Command> commands = new HashMap<>();
    public void readCommands(){
        commands.put("add", new AddCommand(cm));
        commands.put("show", new ShowCommand(cm));
        commands.put("clear", new ClearCommand(cm));
        commands.put("info", new InfoCommand(cm));
        commands.put("help", new HelpCommand(cm));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.next();
            String[] tokens = line.split(" ");
            Command command = commands.get(tokens[0]);
            command.execute();
        }
    }
}
