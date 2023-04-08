package org.example.command;

import org.example.entities.CollectionController;

public class FilterContainsCommand implements Command {
    private CollectionController cc;
    private String param;

    public FilterContainsCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    public void execute() {
        cc.filterContains(param);
    }


    @Override
    public String descr() {
        return "filter_contains_soundtrack_name soundtrackName - вывести элементы, значение поля soundtrackName которых содержит заданную подстроку";
    }

}
