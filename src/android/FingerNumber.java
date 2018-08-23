package com.jcarraca.cordova.plugin;

public class FingerNumber {
    private byte[] fingerNumber = new byte[100];

    public byte[] getFingerNumber() {
        return this.fingerNumber;
    }

    public void setFingerNumber(byte[] fingerNumber) {
        this.fingerNumber = fingerNumber;
    }
}
