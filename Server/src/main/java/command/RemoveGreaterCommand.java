package command;


import builders.ResponseShaper;
import exception.ValidException;

public class RemoveGreaterCommand implements Command {
    private CollectionController cc;
    private String param;

    public RemoveGreaterCommand(CollectionController cc) {
        this.cc = cc;
    }

    public RemoveGreaterCommand(CollectionController cc, String param) {
        this.cc = cc;
        this.param = param;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    public ResponseShaper execute(String ownerId) throws ValidException {
        return cc.removeGreater(ownerId, param);
    }
}
