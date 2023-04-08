package org.example.command;

import org.example.entities.CollectionController;


public class ClearCommand implements Command {

    private CollectionController cc;

    public ClearCommand(CollectionController cc) {
        this.cc = cc;
    }

    @Override
    public void execute() {
        cc.clear();
    }

    public String descr() {
        return "clear - очистить коллекцию";
    }
}
