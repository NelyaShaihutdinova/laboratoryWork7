package command;


import builders.ResponseShaper;
import exception.ValidException;

public class UpdateIdCommand implements Command {
    private CollectionController cc;
    private String param;
    private String personData;
    private String ownerId;


    public UpdateIdCommand(String ownerId, String param, CollectionController cc) {
        this.param = param;
        this.ownerId = ownerId;
        this.cc = cc;
    }

    public UpdateIdCommand(String ownerId, String param, CollectionController cc, String personData) {
        this.param = param;
        this.ownerId = ownerId;
        this.cc = cc;
        this.personData = personData;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    public ResponseShaper execute() throws ValidException {
        return cc.updateIdScript(ownerId, personData, param);
    }
}
