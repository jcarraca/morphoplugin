package com.jcarraca.cordova.plugin;

public enum LatentDetection {
    LATENT_DETECT_DISABLE(0),
    LATENT_DETECT_ENABLE(1);
    
    private int value;

    private LatentDetection(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
