package org.example.command;

import java.io.IOException;


public interface Command {
    void execute() throws IOException;

    String descr();

}
