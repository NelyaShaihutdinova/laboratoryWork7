package command;


import exception.ValidException;

public class RemoveGreaterCommand implements Command {
    private CollectionController cc;
    private String param;

    public RemoveGreaterCommand(CollectionController cc) {
        this.cc = cc;
    }

    public RemoveGreaterCommand(CollectionController cc, String param) {
        this.cc = cc;
        this.param = param;
    }

    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
    public void execute() throws ValidException {
        cc.removeGreater(param);
    }

    //Возвращаем информацию о команде для команды help
    @Override
    public String descr() {
        return "remove_greater - удалить из коллекции все элементы, превышающие заданный";
    }

}
