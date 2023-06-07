package command;


import client.CommandShaper;

import java.io.IOException;

public class ClearCommand implements Command {
    private String param;

    private String name = "clear";

    public ClearCommand(String param) {
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
