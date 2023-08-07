package command;


import builders.ResponseShaper;
import exception.ValidException;

public class AddCommand implements Command {
    private CollectionController cc;
    private String param;

    private String ownerId;

    public AddCommand(String ownerId, CollectionController cc) {
        this.ownerId = ownerId;
        this.cc = cc;
    }

    public AddCommand(String ownerId, String param, CollectionController cc) {
        this.ownerId = ownerId;
        this.cc = cc;
        this.param = param;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    @Override
    public ResponseShaper execute() throws ValidException {
        return cc.addNewHuman(ownerId, param);
    }
}
