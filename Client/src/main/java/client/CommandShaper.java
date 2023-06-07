package client;

import java.io.Serializable;

public class CommandShaper implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String param;

    public CommandShaper(String name, String param) {
        this.name = name;
        this.param = param;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }


}
