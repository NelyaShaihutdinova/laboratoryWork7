package command;

import builders.ResponseShaper;
import exception.ExecuteScriptException;
import exception.FileException;
import exception.ValidException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

//Интерфейс для команд
public interface Command {
    ResponseShaper execute(String ownerId) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ValidException, ExecuteScriptException, FileException;

}
