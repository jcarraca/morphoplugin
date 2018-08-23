package com.jcarraca.cordova.plugin;

public enum MatchingStrategy {
    MORPHO_STANDARD_MATCHING_STRATEGY(0),
    MORPHO_ADVANCED_MATCHING_STRATEGY(1);
    
    private int value;

    private MatchingStrategy(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String getLabel() {
        if (this.value == 0) {
            return "Default";
        }
        if (this.value == 1) {
            return "Advanced";
        }
        return "";
    }

    public static MatchingStrategy fromString(String label) {
        if (label != null) {
            for (MatchingStrategy value : values()) {
                if (label.equalsIgnoreCase(value.getLabel())) {
                    return value;
                }
            }
        }
        return null;
    }
}
