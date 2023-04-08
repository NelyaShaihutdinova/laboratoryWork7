package org.example.command;

public class HelpCommand implements Command {
    private Invoker inv;

    public HelpCommand(Invoker inv) {
        this.inv = inv;
    }

    @Override
    public void execute() {
        for (Command c : inv.getCommands().values()) {
            System.out.println(c.descr());
        }
        System.out.println("exit - завершить программу (без сохранения в файл)");
    }

    public String descr() {
        return "help - вывести справку по доступным командам";
    }

}
