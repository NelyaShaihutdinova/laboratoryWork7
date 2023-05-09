package org.example;


import org.example.command.Invoker;
import org.example.entities.CollectionController;
import org.example.entities.HumanBeing;
import org.example.entities.HumanSimpleValidator;
import org.example.parser.Reader;
import org.example.parser.Writer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        File file = new File("C:\\Users\\fohad\\IdeaProjects\\LaboratoryWork5\\src\\main\\java\\org\\example\\lab5");
        Writer<HumanBeing> writer = new Writer<>();
        Reader reader = new Reader(file);
        List<HumanBeing> humanBeings = reader.getPersons();
        CollectionController cc = new CollectionController(humanBeings, writer, file, new HumanSimpleValidator());
        Invoker invoker = new Invoker(cc);
        invoker.readCommands();
    }
}
