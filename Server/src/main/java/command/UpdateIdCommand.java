//package command;
//
//import org.example.exception.ValidException;
//
//public class UpdateIdCommand implements Command {
//    private CollectionController cc;
//    private String param;
//    private String personData;
//
//    public UpdateIdCommand() {
//    }
//
//    public UpdateIdCommand(String param, CollectionController cc) {
//        this.param = param;
//        this.cc = cc;
//    }
//
//    public UpdateIdCommand(String param, CollectionController cc, String personData) {
//        this.param = param;
//        this.cc = cc;
//        this.personData = personData;
//    }
//
//    //Смотря, выполняется ли команда execute_script, выполняется метод из CollectionController
//    public void execute() throws ValidException {
//        if (personData != null) {
//            cc.updateIdScript(personData, param);
//        } else {
//            cc.updateId(param);
//        }
//    }
//
//    //Возвращаем информацию о команде для команды help
//    @Override
//    public String descr() {
//        return "update id - обновить значение элемента коллекции, id которого равен заданному";
//    }
//
//}
