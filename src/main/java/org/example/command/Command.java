package org.example.command;

import org.example.exception.ExecuteScriptException;
import org.example.exception.FileException;
import org.example.exception.ValidException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

//Интерфейс для команд
public interface Command {
    void execute() throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ValidException, ExecuteScriptException, FileException;

    String descr();

}
