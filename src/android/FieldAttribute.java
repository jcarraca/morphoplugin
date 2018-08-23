package com.jcarraca.cordova.plugin;

public enum FieldAttribute {
    MORPHO_PUBLIC_FIELD(0),
    MORPHO_PRIVATE_FIELD(1);
    
    private int value;

    private FieldAttribute(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
