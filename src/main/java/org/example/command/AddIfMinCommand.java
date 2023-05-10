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

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    public void execute() throws ValidException {
        if (param != null) {
            cc.addIfMinScript(param);
        } else {
            cc.addIfMin();
        }
    }

    //Возвращаем информацию о команде для команды help
    @Override
    public String descr() {
        return "add_if_min - добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
