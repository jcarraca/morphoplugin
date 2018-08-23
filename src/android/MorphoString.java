package com.jcarraca.cordova.plugin;

public class MorphoString {
    private byte[] bufferData = null;
    private String data = new String();

    public String getData() {
        return this.data;
    }

    public byte[] getBufferData() {
        return this.bufferData;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setBufferData(byte[] bufferData) {
        this.bufferData = bufferData;
    }
}
