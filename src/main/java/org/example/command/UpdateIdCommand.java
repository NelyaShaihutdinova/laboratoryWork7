package org.example.command;

import org.example.entities.CollectionController;
import org.example.exception.ValidException;

public class UpdateIdCommand implements Command {
    private CollectionController cc;
    private String param;
    private String personData;

    public UpdateIdCommand() {
    }

    public UpdateIdCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    public UpdateIdCommand(String param, CollectionController cc, String personData) {
        this.param = param;
        this.cc = cc;
        this.personData = personData;
    }

    public void execute() throws ValidException {
        if (personData != null) {
            cc.updateIdScript(personData, param);
        } else {
            cc.updateId(param);
        }
    }

    @Override
    public String descr() {
        return "update id - обновить значение элемента коллекции, id которого равен заданному";
    }

}
