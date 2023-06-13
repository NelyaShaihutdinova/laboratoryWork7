package command;


import builders.ResponseShaper;
import exception.ValidException;

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
    public ResponseShaper execute() throws ValidException {
        return cc.addNewHuman(param);
    }
}
