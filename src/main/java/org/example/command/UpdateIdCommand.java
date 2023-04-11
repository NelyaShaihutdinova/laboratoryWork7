package org.example.command;

import org.example.entities.CollectionController;

public class UpdateIdCommand implements Command {
    private CollectionController cc;
    private String param;

    public UpdateIdCommand() {
    }

    public UpdateIdCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    public void execute() {
        cc.updateId(param);
    }

    @Override
    public String descr() {
        return "update id - обновить значение элемента коллекции, id которого равен заданному";
    }

}
