package command;


import builders.ResponseShaper;
import exception.ValidException;

public class UpdateIdCommand implements Command {
    private CollectionController cc;
    private String param;
    private String personData;

    public UpdateIdCommand() {
    }

    public UpdateIdCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    public UpdateIdCommand(String param, CollectionController cc, String personData) {
        this.param = param;
        this.cc = cc;
        this.personData = personData;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    public ResponseShaper execute() throws ValidException {
        if (personData != null) {
            return cc.updateIdScript(personData, param);
        } else {
            return cc.updateId(param);
        }
    }
}
