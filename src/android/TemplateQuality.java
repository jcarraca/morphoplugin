package com.jcarraca.cordova.plugin;

public class TemplateQuality {
    private byte[] templateQuality;

    public TemplateQuality() {
        setTemplateQuality(new byte[100]);
    }

    public byte[] getTemplateQuality() {
        return this.templateQuality;
    }

    public void setTemplateQuality(byte[] templateQuality) {
        this.templateQuality = templateQuality;
    }
}
