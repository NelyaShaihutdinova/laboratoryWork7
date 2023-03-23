package org.example.command;

public class ShowCommand implements Command{
    public ShowCommand(CollectionManager cm) {
        this.cm = cm;
    }

    private CollectionManager cm;
    @Override
    public void execute() {
        cm.show();
    }
    public String descr(){
        return "show - вывести все элементы коллекции";
    }
}
