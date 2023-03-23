package org.example.command;

public class InfoCommand implements Command{
    public InfoCommand(CollectionManager cm) {
        this.cm = cm;
    }

    private CollectionManager cm;
    @Override
    public void execute() {
        cm.info();
    }
    public String descr(){
        return "info - вывести информацию о коллекции";
    }
}
