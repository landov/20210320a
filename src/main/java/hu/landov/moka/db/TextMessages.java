package hu.landov.moka.db;

import java.io.Serializable;
import java.util.List;

public class TextMessages implements Serializable {
    private List<TextMessage> messages;

    public TextMessages(){}

    public TextMessages(List<TextMessage> messages){
        this.messages = messages;
    }

    public List<TextMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<TextMessage> messages) {
        this.messages = messages;
    }
}
