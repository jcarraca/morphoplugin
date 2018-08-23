package com.jcarraca.cordova.plugin;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class MorphoImage {
    private byte[] compressedImage;
    private CompressionAlgorithm compressionAlgorithm;
    private byte[] image;
    private MorphoImageHeader morphoImageHeader = new MorphoImageHeader();

    public MorphoImageHeader getMorphoImageHeader() {
        return this.morphoImageHeader;
    }

    public void setMorphoImageHeader(MorphoImageHeader morphoImageHeader) {
        this.morphoImageHeader = morphoImageHeader;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setImage(Object image) {
        this.image = (byte[]) image;
    }

    public byte[] getCompressedImage() {
        return this.compressedImage;
    }

    public void setCompressedImage(byte[] compressedImage) {
        this.compressedImage = compressedImage;
    }

    public void setCompressedImage(Object compressedImage) {
        this.compressedImage = (byte[]) compressedImage;
    }

    public static MorphoImage getMorphoImageFromLive(byte[] imageStructure) {
        if (imageStructure == null || imageStructure.length < 12) {
            return null;
        }
        MorphoImage morphoImage = new MorphoImage();
        ByteBuffer buffer = ByteBuffer.wrap(imageStructure, 2, 2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        int nbRow = buffer.getShort();
        buffer = ByteBuffer.wrap(imageStructure, 4, 2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        int nbColumn = buffer.getShort();
        buffer = ByteBuffer.wrap(imageStructure, 6, 2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        int resX = buffer.getShort();
        buffer = ByteBuffer.wrap(imageStructure, 8, 2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        int resY = buffer.getShort();
        int nbBitsPerPixel = imageStructure[11];
        morphoImage.setCompressionAlgorithm(CompressionAlgorithm.GetCompressionAlgorithm(imageStructure[10]));
        morphoImage.morphoImageHeader.setNbRow(nbRow);
        morphoImage.morphoImageHeader.setNbColumn(nbColumn);
        morphoImage.morphoImageHeader.setResX(resX);
        morphoImage.morphoImageHeader.setResY(resY);
        morphoImage.morphoImageHeader.setNbBitsPerPixel(nbBitsPerPixel);
        morphoImage.setImage(Arrays.copyOfRange(imageStructure, 12, imageStructure.length));
        return morphoImage;
    }

    public CompressionAlgorithm getCompressionAlgorithm() {
        return this.compressionAlgorithm;
    }

    public void setCompressionAlgorithm(CompressionAlgorithm compressionAlgorithm) {
        this.compressionAlgorithm = compressionAlgorithm;
    }

    private void setCompressionAlgorithm(int id) {
        this.compressionAlgorithm = CompressionAlgorithm.GetCompressionAlgorithm(id);
    }
}
