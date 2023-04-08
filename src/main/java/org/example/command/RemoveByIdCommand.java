package org.example.command;

import org.example.entities.CollectionController;

public class RemoveByIdCommand implements Command {
    private CollectionController cc;
    private String param;

    public RemoveByIdCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    public void execute() {
        cc.removeId(param);
    }

    @Override
    public String descr() {
        return "remove_by_id id - удалить элемент из коллекции по его id";
    }

}
