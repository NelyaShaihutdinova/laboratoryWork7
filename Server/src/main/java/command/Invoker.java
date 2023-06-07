//package command;
//
//import org.example.exception.ExecuteScriptException;
//import org.example.exception.FileException;
//import org.example.exception.ValidException;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Scanner;
//
//public class Invoker {
//    private CollectionController cc;
//    private Map<String, Command> commands = new HashMap<>();
//
//    private String param;
//    private String personData;
//
//    //конструктор класса с добавлением в HashMap commands команд и объектов соответствующего класса
//    public Invoker(CollectionController cc) {
//        this.cc = cc;
//
//        commands.put("add", new AddCommand(cc));
//        commands.put("add", new AddCommand(param, cc));
//        commands.put("show", new ShowCommand(cc));
//        commands.put("clear", new ClearCommand(cc));
//        commands.put("info", new InfoCommand(cc));
//        commands.put("help", new HelpCommand(this));
//        commands.put("add_if_min", new AddIfMinCommand(cc));
//        commands.put("add_if_min", new AddIfMinCommand(cc, param));
//        commands.put("remove_greater", new RemoveGreaterCommand(cc));
//        commands.put("remove_greater", new RemoveGreaterCommand(cc, param));
//        commands.put("remove_lower", new RemoveLowerCommand(cc));
//        commands.put("remove_lower", new RemoveLowerCommand(cc, param));
//        commands.put("save", new SaveCommand(cc));
//        commands.put("update", new UpdateIdCommand(param, cc));
//        commands.put("update", new UpdateIdCommand(param, cc, personData));
//        commands.put("remove_by_id", new RemoveByIdCommand(param, cc));
//        commands.put("count_greater_than_impact_speed", new CountGreaterCommand(param, cc));
//        commands.put("filter_contains_soundtrack_name", new FilterContainsCommand(param, cc));
//        commands.put("filter_greater_than_impact_speed", new FilterGreaterCommand(param, cc));
//        commands.put("execute_script", new ExecuteScriptCommand(param, cc));
//    }
//
//    public Map<String, Command> getCommands() {
//        return commands;
//    }
//
//    //построчное чтение команд с изменением конструктора класса команды через рефлексию
//    public void readCommands() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        try {
//            Scanner sc = new Scanner(System.in);
//            try {
//                while (sc.hasNext()) {
//                    String line = sc.nextLine();
//                    String[] tokens = line.split(" ");
//                    Command command = commands.get(tokens[0]);
//                    if (tokens.length == 2) {
//                        param = tokens[1];
//                        Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class).newInstance(param, cc);
//                        commands.replace(tokens[0], updatedCommand);
//                        String exit = "exit";
//                        if (exit.equals(line)) {
//                            sc.close();
//                        } else {
//                            updatedCommand.execute();
//                        }
//                    } else {
//                        String exit = "exit";
//                        if (exit.equals(line)) {
//                            sc.close();
//                        } else if (Objects.isNull(command)) {
//                            throw new ValidException("Команда не найдена");
//                        } else {
//                            command.execute();
//                        }
//                    }
//                }
//            } catch (IllegalStateException e) {
//                System.out.println(e.getMessage());
//            }
//        } catch (ValidException e) {
//            System.out.println(e.getMessage());
//            readCommands();
//        } catch (ExecuteScriptException e) {
//            System.out.println(e.getMessage());
//        } catch (FileException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    //построчное чтение команд с изменением конструктора класса команды через рефлексию для execute_script
//    public void readCommandsScript(String newParam) throws ValidException {
//        try {
//            File script = new File(newParam);
//            FileReader fr = new FileReader(script);
//            BufferedReader reader = new BufferedReader(fr);
//            String line = reader.readLine();
//            if (line != null) {
//                String exit = "exit";
//                String[] tokensCheck = line.split(" ");
//                if (exit.equals(line)) {
//                    reader.close();
//                } else if (tokensCheck.length == 12) {
//                    String[] tokens = line.split(" ", 3);
//                    Command command = commands.get(tokens[0]);
//                    if (Objects.isNull(command)) {
//                        throw new ValidException("Комманда не найдена");
//                    }
//                    param = tokens[1];
//                    personData = tokens[3];
//                    Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class, String.class).newInstance(param, cc, personData);
//                    commands.replace(tokens[0], updatedCommand);
//                    updatedCommand.execute();
//                } else if (tokensCheck.length == 11 || tokensCheck.length == 2) {
//                    String[] tokens = line.split(" ", 2);
//                    Command command = commands.get(tokens[0]);
//                    if (Objects.isNull(command)) {
//                        throw new ValidException("Комманда не найдена");
//                    }
//                    param = tokens[1];
//                    Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class).newInstance(param, cc);
//                    commands.replace(tokens[0], updatedCommand);
//                    updatedCommand.execute();
//                } else {
//                    String[] tokens = line.split(" ");
//                    Command command = commands.get(tokens[0]);
//                    if (Objects.isNull(command)) {
//                        throw new ValidException("Комманда не найдена");
//                    }
//                    command.execute();
//                }
//            }
//            while (line != null) {
//                line = reader.readLine();
//                if (line != null) {
//                    String newExit = "exit";
//                    String[] newTokensCheck = line.split(" ");
//                    if (newExit.equals(line)) {
//                        reader.close();
//                    } else if (newTokensCheck.length == 12) {
//                        String[] newTokens = line.split(" ", 3);
//                        Command command = commands.get(newTokens[0]);
//                        if (Objects.isNull(command)) {
//                            throw new ValidException("Комманда не найдена");
//                        }
//                        param = newTokens[1];
//                        personData = newTokens[3];
//                        Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class, String.class).newInstance(param, cc, personData);
//                        commands.replace(newTokens[0], updatedCommand);
//                        updatedCommand.execute();
//                    } else if (newTokensCheck.length == 2 || newTokensCheck.length == 11) {
//                        String[] newTokens = line.split(" ", 2);
//                        Command command = commands.get(newTokens[0]);
//                        if (Objects.isNull(command)) {
//                            throw new ValidException("Комманда не найдена");
//                        }
//                        param = newTokens[1];
//                        Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class).newInstance(param, cc);
//                        commands.replace(newTokens[0], updatedCommand);
//                        updatedCommand.execute();
//                    } else {
//                        String[] tokens = line.split(" ");
//                        Command command = commands.get(tokens[0]);
//                        if (Objects.isNull(command)) {
//                            throw new ValidException("Комманда не найдена");
//                        }
//                        command.execute();
//                    }
//                }
//            }
//        } catch (IOException | FileException | ExecuteScriptException | InvocationTargetException |
//                 InstantiationException | IllegalAccessException | NoSuchMethodException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
