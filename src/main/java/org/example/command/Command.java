package org.example.command;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Command {
    void execute() throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    String descr();

}
