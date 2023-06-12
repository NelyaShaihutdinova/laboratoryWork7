package command;


import exception.ValidException;

public class CountGreaterCommand implements Command {
    private CollectionController cc;
    private String param;

    public CountGreaterCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    //выполняется метод из CollectionController
    public void execute() throws ValidException {
        cc.countGreater(param);
    }

    //Возвращаем информацию о команде для команды help
    @Override
    public String descr() {
        return "count_greater_than_impact_speed impactSpeed - вывести количество элементов, значение поля impactSpeed которых больше заданного";
    }


}
