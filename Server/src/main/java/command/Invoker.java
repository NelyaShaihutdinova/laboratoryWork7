package command;

import builders.CommandShaper;
import builders.ResponseShaper;
import exception.ExecuteScriptException;
import exception.FileException;
import exception.ValidException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Invoker {
    private CollectionController cc;
    private Map<String, Command> commands = new HashMap<>();
    private CommandShaper commandShaper;


    private String param;
    private String personData;


    //конструктор класса с добавлением в HashMap commands команд и объектов соответствующего класса
    public Invoker(CommandShaper commandShaper, CollectionController cc) {
        this.cc = cc;
        this.commandShaper = commandShaper;
        commands.put("add", new AddCommand(cc));
        commands.put("add", new AddCommand(param, cc));
        commands.put("show", new ShowCommand(cc));
        commands.put("clear", new ClearCommand(cc));
        commands.put("info", new InfoCommand(cc));
        commands.put("help", new HelpCommand(this));
        commands.put("add_if_min", new AddIfMinCommand(cc));
        commands.put("add_if_min", new AddIfMinCommand(cc, param));
        commands.put("remove_greater", new RemoveGreaterCommand(cc));
        commands.put("remove_greater", new RemoveGreaterCommand(cc, param));
        commands.put("remove_lower", new RemoveLowerCommand(cc));
        commands.put("remove_lower", new RemoveLowerCommand(cc, param));
        commands.put("save", new SaveCommand(cc));
        commands.put("update", new UpdateIdCommand(param, cc));
        commands.put("update", new UpdateIdCommand(param, cc, personData));
        commands.put("remove_by_id", new RemoveByIdCommand(param, cc));
        commands.put("count_greater_than_impact_speed", new CountGreaterCommand(param, cc));
        commands.put("filter_contains_soundtrack_name", new FilterContainsCommand(param, cc));
        commands.put("filter_greater_than_impact_speed", new FilterGreaterCommand(param, cc));
        commands.put("execute_script", new ExecuteScriptCommand(param, cc));
    }

    public Invoker(CollectionController cc) {
        this.cc = cc;
        commands.put("add", new AddCommand(cc));
        commands.put("add", new AddCommand(param, cc));
        commands.put("show", new ShowCommand(cc));
        commands.put("clear", new ClearCommand(cc));
        commands.put("info", new InfoCommand(cc));
        commands.put("help", new HelpCommand(this));
        commands.put("add_if_min", new AddIfMinCommand(cc));
        commands.put("add_if_min", new AddIfMinCommand(cc, param));
        commands.put("remove_greater", new RemoveGreaterCommand(cc));
        commands.put("remove_greater", new RemoveGreaterCommand(cc, param));
        commands.put("remove_lower", new RemoveLowerCommand(cc));
        commands.put("remove_lower", new RemoveLowerCommand(cc, param));
        commands.put("save", new SaveCommand(cc));
        commands.put("update", new UpdateIdCommand(param, cc));
        commands.put("update", new UpdateIdCommand(param, cc, personData));
        commands.put("remove_by_id", new RemoveByIdCommand(param, cc));
        commands.put("count_greater_than_impact_speed", new CountGreaterCommand(param, cc));
        commands.put("filter_contains_soundtrack_name", new FilterContainsCommand(param, cc));
        commands.put("filter_greater_than_impact_speed", new FilterGreaterCommand(param, cc));
        commands.put("execute_script", new ExecuteScriptCommand(param, cc));
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    //построчное чтение команд с изменением конструктора класса команды через рефлексию
    public ResponseShaper readCommand() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        try {
            String commandName = commandShaper.getName();
            Command command = commands.get(commandName);
            String line = "no";
            if (Objects.isNull(command)) {
                ResponseShaper responseShaper = new ResponseShaper(String.valueOf(new ValidException("Команда не найдена")));
                return responseShaper;
            } else if (commandShaper.getParam().equals(line)) {
                return command.execute();

            } else {
                String param = commandShaper.getParam();
                Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class).newInstance(param, cc);
                commands.replace(String.valueOf(command), updatedCommand);
                return updatedCommand.execute();
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (FileException e) {
            throw new RuntimeException(e);
        } catch (ValidException e) {
            System.out.println(e.getMessage());
        } catch (ExecuteScriptException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void saveCommand() throws FileException, IOException, ValidException, ExecuteScriptException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Command newCommand = commands.get("save");
        newCommand.execute();
    }


    //построчное чтение команд с изменением конструктора класса команды через рефлексию для execute_script
    public void readCommandsScript(String newParam) throws ValidException {
        try {
            File script = new File(newParam);
            FileReader fr = new FileReader(script);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            if (line != null) {
                String exit = "exit";
                String[] tokensCheck = line.split(" ");
                if (exit.equals(line)) {
                    reader.close();
                } else if (tokensCheck.length == 12) {
                    String[] tokens = line.split(" ", 3);
                    Command command = commands.get(tokens[0]);
                    if (Objects.isNull(command)) {
                        throw new ValidException("Комманда не найдена");
                    }
                    param = tokens[1];
                    personData = tokens[2];
                    Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class, String.class).newInstance(param, cc, personData);
                    commands.replace(tokens[0], updatedCommand);
                    updatedCommand.execute();
                } else if (tokensCheck.length == 11 || tokensCheck.length == 2) {
                    String[] tokens = line.split(" ", 2);
                    Command command = commands.get(tokens[0]);
                    if (Objects.isNull(command)) {
                        throw new ValidException("Комманда не найдена");
                    }
                    param = tokens[1];
                    Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class).newInstance(param, cc);
                    commands.replace(tokens[0], updatedCommand);
                    updatedCommand.execute();
                } else {
                    String[] tokens = line.split(" ");
                    Command command = commands.get(tokens[0]);
                    if (Objects.isNull(command)) {
                        throw new ValidException("Комманда не найдена");
                    }
                    command.execute();
                }
            }
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    String newExit = "exit";
                    String[] newTokensCheck = line.split(" ");
                    if (newExit.equals(line)) {
                        reader.close();
                    } else if (newTokensCheck.length == 12) {
                        String[] newTokens = line.split(" ", 3);
                        Command command = commands.get(newTokens[0]);
                        if (Objects.isNull(command)) {
                            throw new ValidException("Комманда не найдена");
                        }
                        param = newTokens[1];
                        personData = newTokens[2];
                        Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class, String.class).newInstance(param, cc, personData);
                        commands.replace(newTokens[0], updatedCommand);
                        updatedCommand.execute();
                    } else if (newTokensCheck.length == 2 || newTokensCheck.length == 11) {
                        String[] newTokens = line.split(" ", 2);
                        Command command = commands.get(newTokens[0]);
                        if (Objects.isNull(command)) {
                            throw new ValidException("Комманда не найдена");
                        }
                        param = newTokens[1];
                        Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class).newInstance(param, cc);
                        commands.replace(newTokens[0], updatedCommand);
                        updatedCommand.execute();
                    } else {
                        String[] tokens = line.split(" ");
                        Command command = commands.get(tokens[0]);
                        if (Objects.isNull(command)) {
                            throw new ValidException("Комманда не найдена");
                        }
                        command.execute();
                    }
                }
            }
        } catch (IOException | FileException | ExecuteScriptException | InvocationTargetException |
                 InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
    }
}
