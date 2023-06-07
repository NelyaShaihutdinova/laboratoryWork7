//package command;
//
//import org.example.exception.ValidException;
//
//public class RemoveLowerCommand implements Command {
//    private CollectionController cc;
//    private String param;
//
//    public RemoveLowerCommand(CollectionController cc) {
//        this.cc = cc;
//    }
//
//    public RemoveLowerCommand(CollectionController cc, String param) {
//        this.cc = cc;
//        this.param = param;
//    }
//
//    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
//    public void execute() throws ValidException {
//        if (param != null) {
//            cc.removeLowerScript(param);
//        } else {
//            cc.removeLower();
//        }
//    }
//
//    //Возвращаем информацию о команде для команды help
//    @Override
//    public String descr() {
//        return "remove_lower - удалить из коллекции все элементы, меньшие, чем заданный";
//    }
//}
