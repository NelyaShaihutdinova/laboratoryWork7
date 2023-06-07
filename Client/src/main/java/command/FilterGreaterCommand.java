package command;

import client.CommandShaper;

import java.io.IOException;

public class FilterGreaterCommand implements Command {
    private String param;

    private String name = "filter_greater_than_impact_speed";

    public FilterGreaterCommand(String param) {
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
