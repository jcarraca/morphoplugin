package com.jcarraca.cordova.plugin;

public enum EnrollmentType {
    ONE_ACQUISITIONS(1),
    THREE_ACQUISITIONS(0);
    
    private int value;

    private EnrollmentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
