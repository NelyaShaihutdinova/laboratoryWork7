package org.example.command;

import org.example.entities.CollectionController;
import org.example.exception.ExecuteScriptException;
import org.example.exception.ValidException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ExecuteScriptCommand extends Throwable implements Command {
    private CollectionController cc;
    private String param;

    public ExecuteScriptCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    public void execute() throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ValidException, ExecuteScriptException {
        cc.executeScript(param);
    }

    @Override
    public String descr() {
        return "execute_script file_name - считать и выполнить команды из указанного файла";
    }
}
