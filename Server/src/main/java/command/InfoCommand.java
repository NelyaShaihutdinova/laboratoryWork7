package command;


import builders.ResponseShaper;

public class InfoCommand implements Command {
    private CollectionController cc;

    public InfoCommand(CollectionController cc) {
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    @Override
    public ResponseShaper execute() {
        return cc.info();
    }
}
