package org.example.command;

import org.example.entities.CollectionController;

public class RemoveLowerCommand implements Command {
    private CollectionController cc;
    private String param;

    public RemoveLowerCommand(CollectionController cc) {
        this.cc = cc;
    }

    public RemoveLowerCommand(CollectionController cc, String param) {
        this.cc = cc;
        this.param = param;
    }

    public void execute() {
        if (param != null) {
            cc.removeLowerScript(param);
        } else {
            cc.removeLower();
        }
    }

    @Override
    public String descr() {
        return "remove_lower - удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
