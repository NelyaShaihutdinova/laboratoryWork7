package command;

import client.CommandShaper;

import java.io.IOException;

//Интерфейс для команд
public interface Command {
    CommandShaper execute() throws IOException;

    String getName();

}
