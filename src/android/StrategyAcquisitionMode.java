package com.jcarraca.cordova.plugin;

public enum StrategyAcquisitionMode {
    MORPHO_ACQ_EXPERT_MODE(0, "Expert(Default)"),
    MORPHO_ACQ_UNIVERSAL_FAST_MODE(1, "Fast(Standard)"),
    MORPHO_ACQ_UNIVERSAL_ACCURATE_MODE(2, "Slow(Accurate)"),
    MORPHO_ACQ_FULL_MULTIMODAL_MODE(3, "Full MultiModal"),
    MORPHO_ACQ_ANTI_SPOOFING_MODE(4, "Anti Spoofing");
    
    private int code;
    private String label;

    public int getCode() {
        return this.code;
    }

    public String getLabel() {
        return this.label;
    }

    private StrategyAcquisitionMode(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public static StrategyAcquisitionMode fromString(String label) {
        if (label != null) {
            for (StrategyAcquisitionMode value : values()) {
                if (label.equalsIgnoreCase(value.getLabel())) {
                    return value;
                }
            }
        }
        return null;
    }

    public static StrategyAcquisitionMode getValue(int id) {
        StrategyAcquisitionMode[] strategyAcquisitionModes = values();
        for (int i = 0; i < strategyAcquisitionModes.length; i++) {
            if (strategyAcquisitionModes[i].code == id) {
                return strategyAcquisitionModes[i];
            }
        }
        return null;
    }
}
