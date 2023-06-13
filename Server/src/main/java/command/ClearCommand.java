package command;


import builders.ResponseShaper;

public class ClearCommand implements Command {

    private CollectionController cc;

    public ClearCommand(CollectionController cc) {
        this.cc = cc;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    @Override
    public ResponseShaper execute() {
        return cc.clear();
    }
}
