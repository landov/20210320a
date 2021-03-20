package hu.landov.moka.db;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class TextMessage implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String text;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime timeStamp;

    public TextMessage(){}

    public TextMessage(String message){
        this.setText(message);
        this.timeStamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
