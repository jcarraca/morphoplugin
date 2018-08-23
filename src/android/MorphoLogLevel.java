package com.jcarraca.cordova.plugin;

public enum MorphoLogLevel {
    MORPHO_LOG_NOLOG(0, "No Log"),
    MORPHO_LOG_ERROR(1, "Error"),
    MORPHO_LOG_WARNING(2, "Warning"),
    MORPHO_LOG_INFO(3, "Info"),
    MORPHO_LOG_DEBUG(4, "Debug");
    
    private int code;
    private String label;

    public int getCode() {
        return this.code;
    }

    private MorphoLogLevel(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public static MorphoLogLevel fromString(String label) {
        if (label != null) {
            for (MorphoLogLevel value : values()) {
                if (label.equalsIgnoreCase(value.getLabel())) {
                    return value;
                }
            }
        }
        return null;
    }
}
