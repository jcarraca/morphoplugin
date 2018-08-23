package com.jcarraca.cordova.plugin;

public enum CompressionAlgorithm {
    NO_IMAGE(-1, "NO IMAGE", ""),
    MORPHO_NO_COMPRESS(0, "RAW", ".raw"),
    MORPHO_COMPRESS_V1(1, "SAGEM_V1", ".bin"),
    MORPHO_COMPRESS_WSQ(2, "WSQ", ".wsq");
    
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

    private CompressionAlgorithm(int code, String label, String extension) {
        this.code = code;
        this.label = label;
        this.extension = extension;
    }

    public static CompressionAlgorithm GetCompressionAlgorithm(int firmwareCompressionAlgorithm) {
        switch (firmwareCompressionAlgorithm) {
            case 44:
                return MORPHO_NO_COMPRESS;
            case 60:
                return MORPHO_COMPRESS_V1;
            case 156:
                return MORPHO_COMPRESS_WSQ;
            default:
                return MORPHO_NO_COMPRESS;
        }
    }

    protected static CompressionAlgorithm getValue(int id) {
        CompressionAlgorithm[] compressionAlgorithms = values();
        for (int i = 0; i < compressionAlgorithms.length; i++) {
            if (compressionAlgorithms[i].code == id) {
                return compressionAlgorithms[i];
            }
        }
        return MORPHO_NO_COMPRESS;
    }
}
