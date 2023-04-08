package org.example.command;

import org.example.entities.CollectionController;

public class AddIfMinCommand implements Command {
    private CollectionController cc;

    public AddIfMinCommand(CollectionController cc) {
        this.cc = cc;
    }

    public void execute() {
        cc.addIfMin();
    }


    @Override
    public String descr() {
        return "add_if_min - добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
