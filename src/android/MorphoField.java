package com.jcarraca.cordova.plugin;

public class MorphoField {
    public static final int MORPHO_FIELD_NAME_LEN = 6;
    private FieldAttribute fieldAttribute;
    private int maxSize;
    private String name;

    public FieldAttribute getFieldAttribute() {
        return this.fieldAttribute;
    }

    public int getFieldAttributeIntValue() {
        return this.fieldAttribute.ordinal();
    }

    public void setFieldAttribute(FieldAttribute fieldAttribute) {
        this.fieldAttribute = fieldAttribute;
    }

    public void setFieldAttributeIntValue(int fieldAttributeInteger) {
        switch (fieldAttributeInteger) {
            case 0:
                this.fieldAttribute = FieldAttribute.MORPHO_PUBLIC_FIELD;
                return;
            case 1:
                this.fieldAttribute = FieldAttribute.MORPHO_PRIVATE_FIELD;
                return;
            default:
                return;
        }
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws MorphoSmartException {
        if (name == null) {
            throw new MorphoSmartException("Invalid parameter");
        } else if (name.length() > 6) {
            throw new MorphoSmartException("Invalid field size, field size must be less than equal to 6");
        } else {
            this.name = name;
        }
    }
}
