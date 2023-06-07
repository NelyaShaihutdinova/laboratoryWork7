//package command;
//
//import org.example.exception.ValidException;
//
//public class FilterGreaterCommand implements Command {
//    private CollectionController cc;
//    private String param;
//
//    public FilterGreaterCommand(String param, CollectionController cc) {
//        this.param = param;
//        this.cc = cc;
//    }
//
//    //выполняется метод из CollectionController
//    public void execute() throws ValidException {
//        cc.filterGreater(param);
//    }
//
//    //Возвращаем информацию о команде для команды help
//    @Override
//    public String descr() {
//        return "filter_greater_than_impact_speed impactSpeed - вывести элементы, значение поля impactSpeed которых больше заданного";
//    }
//}
