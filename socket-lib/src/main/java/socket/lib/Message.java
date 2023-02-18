package socket.lib;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 1234567L;

    private String value;

    public Message(String text) {
        this.value = text;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getValue() {
        return value;
    }
}
