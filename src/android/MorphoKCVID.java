package com.jcarraca.cordova.plugin;

public enum MorphoKCVID {
    ID_KENC(0),
    ID_KSECRET(1),
    ID_KS(2);
    
    private int code;

    public int getCode() {
        return this.code;
    }

    private MorphoKCVID(int code) {
        this.code = code;
    }
}
