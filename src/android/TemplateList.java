package com.jcarraca.cordova.plugin;

import java.util.ArrayList;

public class TemplateList {
    private boolean activateFullImageRetrieving = false;
    private ArrayList<MorphoImage> morphoImages = new ArrayList();
    private ArrayList<TemplateFVP> templateFVPList = new ArrayList();
    private ArrayList<Template> templateList = new ArrayList();

    public void putTemplate(Template template) {
        this.templateList.add(template);
    }

    public void setImage(MorphoImage morphoImage) {
        this.morphoImages.add(morphoImage);
    }

    public MorphoImage getImage(int imageIndex) {
        if (imageIndex < this.morphoImages.size()) {
            return (MorphoImage) this.morphoImages.get(imageIndex);
        }
        return null;
    }

    public int getNbTemplate() {
        return this.templateList.size();
    }

    public Template getTemplate(int templateIndex) {
        if (templateIndex < this.templateList.size()) {
            return (Template) this.templateList.get(templateIndex);
        }
        return null;
    }

    public void putFVPTemplate(TemplateFVP templateFVP) {
        this.templateFVPList.add(templateFVP);
    }

    public int getNbFVPTemplate() {
        return this.templateFVPList.size();
    }

    public TemplateFVP getFVPTemplate(int templateFVPIndex) {
        if (templateFVPIndex < this.templateFVPList.size()) {
            return (TemplateFVP) this.templateFVPList.get(templateFVPIndex);
        }
        return null;
    }

    public boolean isActivateFullImageRetrieving() {
        return this.activateFullImageRetrieving;
    }

    public void setActivateFullImageRetrieving(boolean activateFullImageRetrieving) {
        this.activateFullImageRetrieving = activateFullImageRetrieving;
    }
}
