package org.example.command;

import org.example.entities.CollectionController;

public class FilterGreaterCommand implements Command {
    private CollectionController cc;
    private String param;


    public FilterGreaterCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    public void execute() {
        cc.filterGreater(param);
    }

    @Override
    public String descr() {
        return "filter_greater_than_impact_speed impactSpeed - вывести элементы, значение поля impactSpeed которых больше заданного";
    }
}
