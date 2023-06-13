package command;


import builders.ResponseShaper;
import exception.FileException;

import java.io.IOException;

public class SaveCommand implements Command {
    private CollectionController cc;

    public SaveCommand(CollectionController cc) {
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    @Override
    public ResponseShaper execute() throws IOException, FileException {
        return cc.save();
    }
}
