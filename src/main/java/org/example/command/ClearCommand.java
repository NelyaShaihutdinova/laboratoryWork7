package org.example.command;

public class ClearCommand implements Command{

    public ClearCommand(CollectionManager cm) {
        this.cm = cm;
    }

    private CollectionManager cm;
    @Override
    public void execute() {
        cm.clear();
    }
    public String descr(){
        return "clear - очистить коллекцию";
    }
}
