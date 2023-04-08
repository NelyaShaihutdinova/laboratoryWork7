package org.example.command;

import org.example.entities.CollectionController;

public class RemoveLowerCommand implements Command {
    private CollectionController cc;

    public RemoveLowerCommand(CollectionController cc) {
        this.cc = cc;
    }

    public void execute() {
        cc.removeLower();
    }


    @Override
    public String descr() {
        return "remove_lower - удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
