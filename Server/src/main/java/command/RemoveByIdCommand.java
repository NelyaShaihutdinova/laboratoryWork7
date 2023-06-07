//package command;
//
//import org.example.exception.ValidException;
//
//public class RemoveByIdCommand implements Command {
//    private CollectionController cc;
//    private String param;
//
//    public RemoveByIdCommand(String param, CollectionController cc) {
//        this.param = param;
//        this.cc = cc;
//    }
//
//    //выполняется метод из CollectionController
//    public void execute() throws ValidException {
//        cc.removeId(param);
//    }
//
//    //Возвращаем информацию о команде для команды help
//    @Override
//    public String descr() {
//        return "remove_by_id id - удалить элемент из коллекции по его id";
//    }
//
//}
