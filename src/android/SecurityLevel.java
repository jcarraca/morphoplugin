package com.jcarraca.cordova.plugin;

public enum SecurityLevel {
    FFD_SECURITY_LEVEL_LOW_HOST(0, "Low"),
    FFD_SECURITY_LEVEL_MEDIUM_HOST(1, "Medium"),
    FFD_SECURITY_LEVEL_HIGH_HOST(2, "High"),
    FFD_SECURITY_LEVEL_NONE_HOST(3, "None"),
    FFD_SECURITY_LEVEL_CRITICAL_HOST(4, "Critical"),
    MULTIMODAL_SECURITY_STANDARD(0, "Standard"),
    MULTIMODAL_SECURITY_MEDIUM(512, "Medium"),
    MULTIMODAL_SECURITY_HIGH(256, "High"),
    MULTIMODAL_SECURITY_CRITICAL(1024, "Critical"),
    FFD_SECURITY_LEVEL_DEFAULT_HOST(65535, "Default");
    
    private String label;
    private int value;

    private SecurityLevel(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    public static SecurityLevel fromInt(int value, boolean isFVP) {
        if (isFVP) {
            if (value == MULTIMODAL_SECURITY_STANDARD.value) {
                return MULTIMODAL_SECURITY_STANDARD;
            }
            if (value == MULTIMODAL_SECURITY_MEDIUM.value) {
                return MULTIMODAL_SECURITY_MEDIUM;
            }
            if (value == MULTIMODAL_SECURITY_HIGH.value) {
                return MULTIMODAL_SECURITY_HIGH;
            }
        } else if (value == FFD_SECURITY_LEVEL_LOW_HOST.value) {
            return FFD_SECURITY_LEVEL_LOW_HOST;
        } else {
            if (value == FFD_SECURITY_LEVEL_MEDIUM_HOST.value) {
                return FFD_SECURITY_LEVEL_MEDIUM_HOST;
            }
            if (value == FFD_SECURITY_LEVEL_HIGH_HOST.value) {
                return FFD_SECURITY_LEVEL_HIGH_HOST;
            }
            if (value == FFD_SECURITY_LEVEL_CRITICAL_HOST.value) {
                return FFD_SECURITY_LEVEL_CRITICAL_HOST;
            }
        }
        return FFD_SECURITY_LEVEL_DEFAULT_HOST;
    }

    public static SecurityLevel fromString(String label, boolean isFVP) {
        if (label != null) {
            if (isFVP) {
                if (label.equalsIgnoreCase(MULTIMODAL_SECURITY_STANDARD.label)) {
                    return MULTIMODAL_SECURITY_STANDARD;
                }
                if (label.equalsIgnoreCase(MULTIMODAL_SECURITY_MEDIUM.label)) {
                    return MULTIMODAL_SECURITY_MEDIUM;
                }
                if (label.equalsIgnoreCase(MULTIMODAL_SECURITY_HIGH.label)) {
                    return MULTIMODAL_SECURITY_HIGH;
                }
            } else if (label.equalsIgnoreCase(FFD_SECURITY_LEVEL_LOW_HOST.label)) {
                return FFD_SECURITY_LEVEL_LOW_HOST;
            } else {
                if (label.equalsIgnoreCase(FFD_SECURITY_LEVEL_MEDIUM_HOST.label)) {
                    return FFD_SECURITY_LEVEL_MEDIUM_HOST;
                }
                if (label.equalsIgnoreCase(FFD_SECURITY_LEVEL_HIGH_HOST.label)) {
                    return FFD_SECURITY_LEVEL_HIGH_HOST;
                }
                if (label.equalsIgnoreCase(FFD_SECURITY_LEVEL_CRITICAL_HOST.label)) {
                    return FFD_SECURITY_LEVEL_CRITICAL_HOST;
                }
            }
        }
        return null;
    }
}
