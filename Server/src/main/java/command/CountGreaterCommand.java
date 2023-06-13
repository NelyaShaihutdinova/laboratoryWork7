package command;


import builders.ResponseShaper;
import exception.ValidException;

public class CountGreaterCommand implements Command {
    private CollectionController cc;
    private String param;

    public CountGreaterCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    public ResponseShaper execute() throws ValidException {
        return cc.countGreater(param);
    }
}
