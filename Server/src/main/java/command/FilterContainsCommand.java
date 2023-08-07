package command;


import builders.ResponseShaper;
import exception.ValidException;

public class FilterContainsCommand implements Command {
    private CollectionController cc;
    private String param;
    private String ownerId;

    public FilterContainsCommand(String ownerId, String param, CollectionController cc) {
        this.ownerId = ownerId;
        this.param = param;
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    public ResponseShaper execute() throws ValidException {
        return cc.filterContains(param);
    }
}
