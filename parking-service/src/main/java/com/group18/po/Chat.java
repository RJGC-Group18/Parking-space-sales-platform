package com.group18.po;

import java.sql.Timestamp;

public class Chat {
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    private String sender;
    private String message;
    private String receiver;
    private Timestamp time;
    public Chat(String sender, String receiver,String message,  Timestamp time) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.time = time;
    }
}
