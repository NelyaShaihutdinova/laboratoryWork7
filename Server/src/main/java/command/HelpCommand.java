//package command;
//
//public class HelpCommand implements Command {
//    private Invoker invoker;
//
//    public HelpCommand(Invoker invoker) {
//        this.invoker = invoker;
//    }
//
//    //вывод всех элементов commands и их описания
//    @Override
//    public void execute() {
//        for (Command c : invoker.getCommands().values()) {
//            System.out.println(c.descr());
//        }
//        System.out.println("exit - завершить программу (без сохранения в файл)");
//    }
//
//    //Возвращаем информацию о команде для команды help
//    public String descr() {
//        return "help - вывести справку по доступным командам";
//    }
//
//}
