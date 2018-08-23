package com.jcarraca.cordova.plugin;

public enum MorphoTypeDeletion {
    MORPHO_ERASE_BASE(0),
    MORPHO_DESTROY_BASE(1);
    
    private int value;

    private MorphoTypeDeletion(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
