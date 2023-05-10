package org.example.command;

import org.example.entities.CollectionController;
import org.example.exception.ValidException;

public class AddCommand implements Command {
    private CollectionController cc;
    private String param;

    public AddCommand(CollectionController cc) {
        this.cc = cc;
    }

    public AddCommand(String param, CollectionController cc) {
        this.cc = cc;
        this.param = param;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    @Override
    public void execute() throws ValidException {
        if (param != null) {
            cc.addNewHumanScript(param);
        } else {
            cc.addNewHuman();
        }
    }

    //Возвращаем информацию о команде для команды help
    public String descr() {
        return "add - добавить новый элемент в коллекцию";
    }
}
