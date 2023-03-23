package org.example.command;

import java.util.HashMap;

public class HelpCommand implements Command{
    public HelpCommand(CollectionManager cm){
        this.cm=cm;
    }
    private CollectionManager cm;
    @Override
    public void execute() {
//        cm.help();
    }
    public String descr(){
        return "help - вывести справку по доступным командам";
    }

}
