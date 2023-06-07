//package client;
//
//import command.*;
//import org.example.Client;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Scanner;
//
//public class ConsoleWorker {
//    private Map<String, Command> commands = new HashMap<>();
//
//
//
//
//    //конструктор класса с добавлением в HashMap commands команд и объектов соответствующего класса
////    public ConsoleWorker() {
////        commands.put("add", new AddCommand(param));
////        commands.put("show", new ShowCommand(param));
////        commands.put("clear", new ClearCommand(param));
////        commands.put("info", new InfoCommand(param));
////        commands.put("help", new HelpCommand(param));
////        commands.put("add_if_min", new AddIfMinCommand(param));
////        commands.put("remove_greater", new RemoveGreaterCommand(param));
////        commands.put("remove_lower", new RemoveLowerCommand(param));
////        commands.put("update", new UpdateIdCommand(param));
////        commands.put("remove_by_id", new RemoveByIdCommand(param));
////        commands.put("count_greater_than_impact_speed", new CountGreaterCommand(param));
////        commands.put("filter_contains_soundtrack_name", new FilterContainsCommand(param));
////        commands.put("filter_greater_than_impact_speed", new FilterGreaterCommand(param));
////        commands.put("execute_script", new ExecuteScriptCommand(param));
////    }
//
//    public Map<String, Command> getCommands() {
//        return commands;
//    }
//
//    public void readCommands(Client client) throws ValidException, IOException {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String line = sc.nextLine();
//            String[] tokens = line.split(" ");
//            Command command = commands.get(tokens[0]);
//
//            String param = String.valueOf(commands.get((tokens[1])));
//            String exit = "exit";
//            commands.put("add", new AddCommand(param));
//            commands.put("show", new ShowCommand(param));
//            commands.put("clear", new ClearCommand(param));
//            commands.put("info", new InfoCommand(param));
//            commands.put("help", new HelpCommand(param));
//            commands.put("add_if_min", new AddIfMinCommand(param));
//            commands.put("remove_greater", new RemoveGreaterCommand(param));
//            commands.put("remove_lower", new RemoveLowerCommand(param));
//            commands.put("update", new UpdateIdCommand(param));
//            commands.put("remove_by_id", new RemoveByIdCommand(param));
//            commands.put("count_greater_than_impact_speed", new CountGreaterCommand(param));
//            commands.put("filter_contains_soundtrack_name", new FilterContainsCommand(param));
//            commands.put("filter_greater_than_impact_speed", new FilterGreaterCommand(param));
//            commands.put("execute_script", new ExecuteScriptCommand(param));
//            if (exit.equals(line)) {
//                sc.close();
//            }
////            } else if (Objects.isNull(command)) {
////                throw new ValidException("Команда не найдена");
//            else {
//                command.execute();
//            }
//        }
//
//    }
//}

