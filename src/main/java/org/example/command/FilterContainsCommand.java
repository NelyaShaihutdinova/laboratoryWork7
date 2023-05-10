package org.example.command;

import org.example.entities.CollectionController;
import org.example.exception.ValidException;

public class FilterContainsCommand implements Command {
    private CollectionController cc;
    private String param;

    public FilterContainsCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    public void execute() throws ValidException {
        cc.filterContains(param);
    }

    //Возвращаем информацию о команде для команды help
    @Override
    public String descr() {
        return "filter_contains_soundtrack_name soundtrackName - вывести элементы, значение поля soundtrackName которых содержит заданную подстроку";
    }

}
