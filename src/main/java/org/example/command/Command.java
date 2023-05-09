package org.example.command;

import org.example.exception.ExecuteScriptException;
import org.example.exception.ValidException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Command {
    void execute() throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ValidException, ExecuteScriptException;

    String descr();

}
