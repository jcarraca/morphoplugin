package com.jcarraca.cordova.plugin;

public enum CallbackMask {
    MORPHO_CALLBACK_COMMAND_CMD(1),
    MORPHO_CALLBACK_IMAGE_CMD(2),
    MORPHO_CALLBACK_ENROLLMENT_CMD(4),
    MORPHO_CALLBACK_LAST_IMAGE_FULL_RES_CMD(8),
    MORPHO_CALLBACK_CODEQUALITY(64),
    MORPHO_CALLBACK_DETECTQUALITY(128);
    
    private int value;

    private CallbackMask(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
