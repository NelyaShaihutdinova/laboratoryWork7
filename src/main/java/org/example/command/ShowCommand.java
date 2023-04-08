package org.example.command;

import org.example.entities.CollectionController;

public class ShowCommand implements Command {
    private CollectionController cc;


    public ShowCommand(CollectionController cc) {
        this.cc = cc;
    }

    @Override
    public void execute() {
        cc.show();
    }

    public String descr() {
        return "show - вывести все элементы коллекции";
    }
}
