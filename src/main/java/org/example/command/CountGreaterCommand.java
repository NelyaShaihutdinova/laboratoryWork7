package org.example.command;

import org.example.entities.CollectionController;


public class CountGreaterCommand implements Command {
    private CollectionController cc;
    private String param;

    public CountGreaterCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    public void execute() {
        cc.countGreater(param);
    }

    @Override
    public String descr() {
        return "count_greater_than_impact_speed impactSpeed - вывести количество элементов, значение поля impactSpeed которых больше заданного";
    }


}
