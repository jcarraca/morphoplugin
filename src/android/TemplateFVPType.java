package com.jcarraca.cordova.plugin;

public enum TemplateFVPType implements ITemplateType {
    MORPHO_NO_PK_FVP(0, "NO PK FVP", ""),
    MORPHO_PK_FVP(1, "SAGEM PkFVP", ".fvp"),
    MORPHO_PK_FVP_MATCH(2, "SAGEM PkFVP Match", ".fvp-m");
    
    private int code;
    private String extension;
    private String label;

    public int getCode() {
        return this.code;
    }

    public String getLabel() {
        return this.label;
    }

    public String getExtension() {
        return this.extension;
    }

    private TemplateFVPType(int code, String label, String extension) {
        this.code = code;
        this.label = label;
        this.extension = extension;
    }

    protected static TemplateFVPType getValue(int id) {
        TemplateFVPType[] templateFVPTypes = values();
        for (int i = 0; i < templateFVPTypes.length; i++) {
            if (templateFVPTypes[i].code == id) {
                return templateFVPTypes[i];
            }
        }
        return MORPHO_NO_PK_FVP;
    }
}
