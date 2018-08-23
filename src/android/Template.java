package com.jcarraca.cordova.plugin;

public class Template {
    private byte[] data;
    private int dataIndex = MotionEventCompat.ACTION_MASK;
    private ITemplateType iTemplateType;
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

    public TemplateType getTemplateType() {
        return (TemplateType) this.iTemplateType;
    }

    public TemplateFVPType getTemplateFVPType() {
        return (TemplateFVPType) this.iTemplateType;
    }

    private int getTemplateTypeIntValue() {
        if (this.iTemplateType != null) {
            return ((TemplateType) this.iTemplateType).getCode();
        }
        return -1;
    }

    public void setTemplateType(TemplateType templateType) {
        this.iTemplateType = templateType;
    }

    public void setTemplateFVPType(TemplateFVPType templateFVPType) {
        this.iTemplateType = templateFVPType;
    }

    public void setTemplateType(int id) {
        this.iTemplateType = TemplateType.getValue(id);
    }

    public void setTemplateFVPType(int id) {
        this.iTemplateType = TemplateFVPType.getValue(id);
    }
}
