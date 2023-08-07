package command;


import builders.ResponseShaper;

public class InfoCommand implements Command {
    private CollectionController cc;
    private String ownerId;

    public InfoCommand(String ownerId, CollectionController cc) {
        this.ownerId = ownerId;
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    @Override
    public ResponseShaper execute() {
        return cc.info();
    }
}
