package command;


public class InfoCommand implements Command {
    private CollectionController cc;

    public InfoCommand(CollectionController cc) {
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    @Override
    public void execute() {
        cc.info();
    }

    //Возвращаем информацию о команде для команды help
    public String descr() {
        return "info - вывести информацию о коллекции";
    }
}
