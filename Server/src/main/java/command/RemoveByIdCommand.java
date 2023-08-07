package command;


import builders.ResponseShaper;
import exception.ValidException;

public class RemoveByIdCommand implements Command {
    private CollectionController cc;
    private String param;
    private String ownerId;

    public RemoveByIdCommand(String ownerId, String param, CollectionController cc) {
        this.param = param;
        this.ownerId = ownerId;
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    public ResponseShaper execute() throws ValidException {
        return cc.removeId(param);
    }
}
