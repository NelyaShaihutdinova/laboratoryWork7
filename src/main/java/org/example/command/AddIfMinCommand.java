package org.example.command;


import org.example.entities.CollectionController;
import org.example.exception.ValidException;

public class AddIfMinCommand implements Command {
    private CollectionController cc;
    private String param;

    public AddIfMinCommand(CollectionController cc) {
        this.cc = cc;
    }

    public AddIfMinCommand(CollectionController cc, String param) {
        this.cc = cc;
        this.param = param;
    }

    public void execute() throws ValidException {
        if (param != null) {
            cc.addIfMinScript(param);
        } else {
            cc.addIfMin();
        }
    }

    @Override
    public String descr() {
        return "add_if_min - добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
