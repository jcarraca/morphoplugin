package com.jcarraca.cordova.plugin;

public final class CallbackMessage {
    private Object message;
    private int messageType;

    public int getMessageType() {
        return this.messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public Object getMessage() {
        return this.message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
