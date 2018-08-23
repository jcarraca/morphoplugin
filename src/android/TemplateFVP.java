package com.jcarraca.cordova.plugin;

public class TemplateFVP {
    private boolean advancedSecurityLevelsCompatibility;
    private byte[] data;
    private int dataIndex = MotionEventCompat.ACTION_MASK;
    private TemplateFVPType templateFVPType;
    private int templateQuality;

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    private void setData(Object data) {
        this.data = (byte[]) data;
    }

    public int getDataIndex() {
        return this.dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }

    public int getTemplateQuality() {
        return this.templateQuality;
    }

    public void setTemplateQuality(int templateQuality) {
        this.templateQuality = templateQuality;
    }

    public boolean getAdvancedSecurityLevelsCompatibility() {
        return this.advancedSecurityLevelsCompatibility;
    }

    public void setAdvancedSecurityLevelsCompatibility(boolean advancedSecurityLevelsCompatibility) {
        this.advancedSecurityLevelsCompatibility = advancedSecurityLevelsCompatibility;
    }

    public TemplateFVPType getTemplateFVPType() {
        return this.templateFVPType;
    }

    public void setTemplateFVPType(TemplateFVPType templateFVPType) {
        this.templateFVPType = templateFVPType;
    }

    private int getTemplateFVPTypeIntValue() {
        if (this.templateFVPType != null) {
            return this.templateFVPType.getCode();
        }
        return -1;
    }

    public void setTemplateFVPType(int id) {
        this.templateFVPType = TemplateFVPType.getValue(id);
    }
}
