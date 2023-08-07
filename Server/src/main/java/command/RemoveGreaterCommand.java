package command;


import builders.ResponseShaper;
import exception.ValidException;

public class RemoveGreaterCommand implements Command {
    private CollectionController cc;
    private String param;
    public String ownerId;

    public RemoveGreaterCommand(String ownerId, CollectionController cc) {
        this.ownerId = ownerId;
        this.cc = cc;
    }

    public RemoveGreaterCommand(String ownerId, CollectionController cc, String param) {
        this.cc = cc;
        this.ownerId = ownerId;
        this.param = param;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    public ResponseShaper execute() throws ValidException {
        return cc.removeGreater(ownerId, param);
    }
}
