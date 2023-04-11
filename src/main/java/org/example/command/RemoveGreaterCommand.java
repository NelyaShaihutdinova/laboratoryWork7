package org.example.command;

import org.example.entities.CollectionController;

public class RemoveGreaterCommand implements Command {
    private CollectionController cc;

    public RemoveGreaterCommand(CollectionController cc) {
        this.cc = cc;
    }

    public void execute() {
        cc.removeGreater();
    }

    @Override
    public String descr() {
        return "remove_greater - удалить из коллекции все элементы, превышающие заданный";
    }

}
