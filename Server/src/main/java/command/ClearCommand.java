//package command;
//
//
//public class ClearCommand implements Command {
//
//    private CollectionController cc;
//
//    public ClearCommand(CollectionController cc) {
//        this.cc = cc;
//    }
//
//    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
//    @Override
//    public void execute() {
//        cc.clear();
//    }
//
//    //Возвращаем информацию о команде для команды help
//    public String descr() {
//        return "clear - очистить коллекцию";
//    }
//}
