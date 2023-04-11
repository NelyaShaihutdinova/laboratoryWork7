package org.example.command;

import org.example.entities.CollectionController;

public class AddCommand implements Command {
    private CollectionController cc;

    public AddCommand(CollectionController cc) {
        this.cc = cc;
    }
//    public AddCommand(CollectionController cc, String personData){this.cc=cc; this.personData = personData;}

    @Override
    public void execute() {
        cc.addNewHuman();
    }

    public String descr() {
        return "add - добавить новый элемент в коллекцию";
    }
}
