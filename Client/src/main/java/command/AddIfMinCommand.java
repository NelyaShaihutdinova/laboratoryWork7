package command;


import client.CommandShaper;

import java.io.IOException;

public class AddIfMinCommand implements Command {
    private String param;

    private String name = "add_if_min";

    public AddIfMinCommand(String param) {
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
