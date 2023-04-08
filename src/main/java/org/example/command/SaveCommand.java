package org.example.command;

import org.example.entities.CollectionController;

public class SaveCommand implements Command {
    private CollectionController cc;

    public SaveCommand(CollectionController cc) {
        this.cc = cc;
    }

    @Override
    public void execute() {
        cc.save();
    }

    public String descr() {
        return "save - сохранить коллекцию в файл";
    }

}
