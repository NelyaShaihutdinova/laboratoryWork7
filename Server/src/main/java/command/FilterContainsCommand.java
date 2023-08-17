package command;


import builders.ResponseShaper;
import exception.ValidException;

public class FilterContainsCommand implements Command {
    private CollectionController cc;
    private String param;

    public FilterContainsCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    public ResponseShaper execute(String ownerId) throws ValidException {
        return cc.filterContains(param);
    }
}
