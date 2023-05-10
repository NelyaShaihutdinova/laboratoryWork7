package org.example.command;

import org.example.entities.CollectionController;
import org.example.exception.FileException;

import java.io.IOException;

public class SaveCommand implements Command {
    private CollectionController cc;

    public SaveCommand(CollectionController cc) {
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    @Override
    public void execute() throws IOException, FileException {
        cc.save();
    }

    //Возвращаем информацию о команде для команды help
    public String descr() {
        return "save - сохранить коллекцию в файл";
    }

}
