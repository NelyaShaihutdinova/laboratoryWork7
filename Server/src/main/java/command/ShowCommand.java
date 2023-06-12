package command;

public class ShowCommand implements Command {
    private CollectionController cc;

    public ShowCommand(CollectionController cc) {
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    @Override
    public void execute() {
        cc.show();
    }

    //Возвращаем информацию о команде для команды help
    public String descr() {
        return "show - вывести все элементы коллекции";
    }
}
