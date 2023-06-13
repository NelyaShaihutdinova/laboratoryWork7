package command;


import builders.ResponseShaper;
import exception.ValidException;

public class RemoveLowerCommand implements Command {
    private CollectionController cc;
    private String param;

    public RemoveLowerCommand(CollectionController cc) {
        this.cc = cc;
    }

    public RemoveLowerCommand(CollectionController cc, String param) {
        this.cc = cc;
        this.param = param;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    public ResponseShaper execute() throws ValidException {
        return cc.removeLower(param);
    }
}
