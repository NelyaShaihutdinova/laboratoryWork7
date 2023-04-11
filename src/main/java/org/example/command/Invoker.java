package org.example.command;

import org.example.entities.CollectionController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Invoker {
    private CollectionController cc;
    private Map<String, Command> commands = new HashMap<>();
    private Map<String, Class> classes = new HashMap<>();

    private String param;

    public Invoker(CollectionController cc) {
        this.cc = cc;

        commands.put("add", new AddCommand(cc));
        classes.put("add", AddCommand.class);
        commands.put("show", new ShowCommand(cc));
        commands.put("clear", new ClearCommand(cc));
        commands.put("info", new InfoCommand(cc));
        commands.put("help", new HelpCommand(this));
        commands.put("add_if_min", new AddIfMinCommand(cc));
        commands.put("remove_greater", new RemoveGreaterCommand(cc));
        commands.put("remove_lower", new RemoveLowerCommand(cc));
        commands.put("save", new SaveCommand(cc));
        commands.put("update", new UpdateIdCommand(param, cc));
        commands.put("remove_by_id", new RemoveByIdCommand(param, cc));
        commands.put("count_greater_than_impact_speed", new CountGreaterCommand(param, cc));
        commands.put("filter_contains_soundtrack_name", new FilterContainsCommand(param, cc));
        commands.put("filter_greater_than_impact_speed", new FilterGreaterCommand(param, cc));
        commands.put("execute_script", new ExecuteScriptCommand(param, cc));
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void readCommands() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            Command command = commands.get(tokens[0]);
            if (tokens.length == 2) {
                param = tokens[1];
                Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class).newInstance(param, cc);
                commands.replace(tokens[0], updatedCommand);
                String exit = "exit";
                if (exit.equals(line)) {
                    sc.close();
                } else {
                    updatedCommand.execute();
                }
            } else {
                String exit = "exit";
                if (exit.equals(line)) {
                    sc.close();
                } else {
                    command.execute();
                }
            }
        }
    }

    public void readCommandsScript(String newParam) {
        try {
            File script = new File(newParam);
            FileReader fr = new FileReader(script);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            if (line != null) {
                String[] tokens = line.split(" ");
                Command command = commands.get(tokens[0]);
                if (tokens.length >= 2) {
                    param = tokens[1];


                    Command updatedCommand = command.getClass().getConstructor(String.class, CollectionController.class).newInstance(param, cc);
                    commands.replace(tokens[0], updatedCommand);
                    updatedCommand.execute();
                } else {
                    String exit = "exit";
                    if (exit.equals(line)) {
                        reader.close();
                    } else {
                        command.execute();
                    }
                }
                while (line != null) {
                    line = reader.readLine();
                    if (line != null) {
                        String[] newTokens = line.split(" ");
                        Command newCommand = commands.get(newTokens[0]);
                        if (newTokens.length == 2) {
                            param = newTokens[1];
                            Command newUpdatedCommand = newCommand.getClass().getConstructor(String.class, CollectionController.class).newInstance(param, cc);
                            commands.replace(newTokens[0], newUpdatedCommand);
                            newUpdatedCommand.execute();
                        } else {
                            String newExit = "exit";
                            if (newExit.equals(line)) {
                                reader.close();
                            } else {
                                newCommand.execute();
                            }
                        }
                    }
                }
            } else {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }
    }
}
