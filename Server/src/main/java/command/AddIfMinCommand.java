package command;


import builders.ResponseShaper;
import exception.ValidException;

public class AddIfMinCommand implements Command {
    private CollectionController cc;
    private String param;
    private String ownerId;

    public AddIfMinCommand(String ownerId, CollectionController cc) {
        this.ownerId = ownerId;
        this.cc = cc;
    }

    public AddIfMinCommand(String ownerId, CollectionController cc, String param) {
        this.ownerId = ownerId;
        this.cc = cc;
        this.param = param;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    public ResponseShaper execute() throws ValidException {
        return cc.addIfMin(ownerId, param);
    }
}
