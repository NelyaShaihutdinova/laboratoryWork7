package command;


import builders.ResponseShaper;
import exception.ValidException;

public class FilterGreaterCommand implements Command {
    private CollectionController cc;
    private String param;

    public FilterGreaterCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    public ResponseShaper execute() throws ValidException {
        return cc.filterGreater(param);
    }
}
