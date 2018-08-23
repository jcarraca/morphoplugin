package com.jcarraca.cordova.plugin;

public enum Coder {
    MORPHO_DEFAULT_CODER(0, "Default"),
    MORPHO_MSO_V9_CODER(3, "Standard"),
    MORPHO_MSO_V9_JUV_CODER(7, "Juvenile"),
    MORPHO_MSO_V9_THIN_FINGER_CODER(8, "Thin Finger");
    
    private int code;
    private String label;

    public int getCode() {
        return this.code;
    }

    public String getLabel() {
        return this.label;
    }

    private Coder(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public static Coder fromString(String label) {
        if (label != null) {
            for (Coder value : values()) {
                if (label.equalsIgnoreCase(value.getLabel())) {
                    return value;
                }
            }
        }
        return null;
    }
}
