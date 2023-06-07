package command;


import client.CommandShaper;

import java.io.IOException;

public class CountGreaterCommand implements Command {
    private String param;

    private String name = "count_greater_than_impact_speed";

    public CountGreaterCommand(String param) {
        this.param = param;
    }

    @Override
    public CommandShaper execute() throws IOException {
        CommandShaper object = new CommandShaper(name, param);
        return object;
    }

    @Override
    public String getName() {
        return name;
    }

}
