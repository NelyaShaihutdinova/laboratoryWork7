package command;


import client.CommandShaper;

import java.io.IOException;

public class ExecuteScriptCommand extends Throwable implements Command {
    private String param;

    private String name = "execute_script";

    public ExecuteScriptCommand(String param) {
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
