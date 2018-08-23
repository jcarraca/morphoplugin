package com.jcarraca.cordova.plugin;

public enum MorphoLogMode {
    MORPHO_LOG_ENABLE(0, "Enable"),
    MORPHO_LOG_DISABLE(1, "Disable");
    
    private int code;
    private String label;

    public int getCode() {
        return this.code;
    }

    private MorphoLogMode(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static MorphoLogMode fromString(String label) {
        if (label != null) {
            for (MorphoLogMode value : values()) {
                if (label.equalsIgnoreCase(value.getLabel())) {
                    return value;
                }
            }
        }
        return null;
    }
}
