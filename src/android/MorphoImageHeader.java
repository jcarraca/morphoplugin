package com.jcarraca.cordova.plugin;

public class MorphoImageHeader {
    private int compressionRatio;
    private int nbBitsPerPixel;
    private int nbColumn;
    private int nbRow;
    private int resX;
    private int resY;

    public int getNbBitsPerPixel() {
        return this.nbBitsPerPixel;
    }

    public void setNbBitsPerPixel(int nbBitsPerPixel) {
        this.nbBitsPerPixel = nbBitsPerPixel;
    }

    public int getResX() {
        return this.resX;
    }

    public void setResX(int resX) {
        this.resX = resX;
    }

    public int getResY() {
        return this.resY;
    }

    public void setResY(int resY) {
        this.resY = resY;
    }

    public int getNbColumn() {
        return this.nbColumn;
    }

    public void setNbColumn(int nbColumn) {
        this.nbColumn = nbColumn;
    }

    public int getNbRow() {
        return this.nbRow;
    }

    public void setNbRow(int nbRow) {
        this.nbRow = nbRow;
    }

    public int getCompressionRatio() {
        return this.compressionRatio;
    }

    public void setCompressionRatio(int compressionRatio) {
        this.compressionRatio = compressionRatio;
    }
}
