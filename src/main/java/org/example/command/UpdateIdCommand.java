package org.example.command;

import org.example.entities.CollectionController;

public class UpdateIdCommand implements Command {
    //    public UpdateIdCommand(CollectionController cc) {
//        this.cc = cc;
//    }
    private CollectionController cc;
    private String param;

    public UpdateIdCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    //    public UpdateIdCommand(Invoker inv){
//        this.inv=inv;
//    }
//    private Invoker inv;
    public void execute() {
//        for (HumanBeing humanBeing : CollectionController cc){
//
//        }
        cc.updateId(param);
    }

    @Override

    public String descr() {
        return "update id - обновить значение элемента коллекции, id которого равен заданному";
    }

}
