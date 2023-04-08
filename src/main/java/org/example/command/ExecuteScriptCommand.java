package org.example.command;

import org.example.entities.CollectionController;

import java.io.IOException;

public class ExecuteScriptCommand implements Command {
    private CollectionController cc;
    private String param;

    public ExecuteScriptCommand(String param, CollectionController cc) {
        this.param = param;
        this.cc = cc;
    }

    public void execute() throws IOException {
//        try {
//            File script = new File(param);
//            FileReader fr = new FileReader(script);
//            BufferedReader reader = new BufferedReader(fr);
//            String line = reader.readLine();
//
//            while (line != null) {
//                line = reader.readLine();
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        cc.executeScript(param);
    }

    @Override
    public String descr() {
        return "execute_script file_name - считать и выполнить команды из указанного файла";
    }
}
