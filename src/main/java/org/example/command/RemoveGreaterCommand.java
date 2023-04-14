package org.example.command;

import org.example.entities.CollectionController;

public class RemoveGreaterCommand implements Command {
    private CollectionController cc;
    private String param;

    public RemoveGreaterCommand(CollectionController cc) {
        this.cc = cc;
    }

    public RemoveGreaterCommand(CollectionController cc, String param) {
        this.cc = cc;
        this.param = param;
    }

    public void execute() {
        if (param != null) {
            cc.removeGreaterScript(param);
        } else {
            cc.removeGreater();
        }
    }

    @Override
    public String descr() {
        return "remove_greater - удалить из коллекции все элементы, превышающие заданный";
    }

}
