package com.jcarraca.cordova.plugin;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.util.Log;
import java.io.UnsupportedEncodingException;

public class USBDevice {
    public static UsbManager mManager = null;
    public USBDeviceAttributes mAttributes = null;
    public UsbDeviceConnection mConnection = null;
    public UsbDevice mDevice = null;
    private byte[] mDeviceDescriptor = null;
    public UsbEndpoint mEndpointIn = null;
    public UsbEndpoint mEndpointOut = null;
    public String mFreindlyName = "";
    public UsbInterface mInterface = null;
    public int mMaxPacketInSize = 0;
    public int mMaxPacketOutSize = 0;

    public synchronized boolean hasPermission() {
        boolean z;
        if (this.mDevice == null || mManager == null) {
            z = false;
        } else {
            z = mManager.hasPermission(this.mDevice);
        }
        return z;
    }

    public synchronized int open() throws Exception {
        return 0;
    }

    public synchronized UsbInterface CreateInterface(int interfaceNumber) {
        return this.mDevice.getInterface(interfaceNumber);
    }

    public USBDevice(USBDeviceAttributes iAttributes, UsbManager iManager, UsbDevice iDevice) {
        this.mDevice = iDevice;
        this.mAttributes = iAttributes;
        mManager = iManager;
    }

    public synchronized String getProductString() throws Exception {
        if (getAttributes().getProduct() == null) {
            byte[] pdt = new byte[64];
            getStringDescriptor(pdt, getDeviceDescriptor()[15]);
            getAttributes().setProduct(convertDescriptorUnicodeLEToString(pdt));
        }
        return getAttributes().getProduct();
    }

    private synchronized String convertDescriptorUnicodeLEToString(byte[] buffer) {
        String str;
        try {
            int bufferLength = buffer[0];
            byte[] subStr = new byte[(bufferLength - 2)];
            System.arraycopy(buffer, 2, subStr, 0, bufferLength - 2);
            str = new String(subStr, "UTF-16LE");
        } catch (UnsupportedEncodingException e) {
            str = "not available";
        } catch (Exception ex) {
            Log.e("USBDevice.convertDescriptorUnicodeLEToString", ex.getMessage());
            str = "not available";
        }
        return str;
    }

    public synchronized int findEndPoint() {
        return 0;
    }

    public synchronized USBDeviceAttributes getAttributes() {
        return this.mAttributes;
    }

    private synchronized int getStringDescriptor(byte[] buffer, int index) throws Exception {
        return getDescriptor(buffer, 768, index);
    }

    private synchronized byte[] getDeviceDescriptor() throws Exception {
        if (this.mDeviceDescriptor == null) {
            this.mDeviceDescriptor = new byte[18];
            getDescriptor(this.mDeviceDescriptor, 256, 1);
        }
        return this.mDeviceDescriptor;
    }

    private synchronized int getDescriptor(byte[] buffer, int descType, int index) throws Exception {
        return 0;
    }

    public synchronized int close() {
        return 0;
    }

    public synchronized UsbInterface claimInterface() {
        return this.mInterface;
    }

    public synchronized int write(byte[] data, int datasize, int timeout) {
        return 0;
    }

    public synchronized int read(byte[] data, int datasize, int timeout) {
        return 0;
    }

    public synchronized int getStringSimple(byte[] buffer, int index) {
        int stringDescriptor;
        try {
            stringDescriptor = getStringDescriptor(buffer, index);
        } catch (Exception e) {
            Log.e("USBDevice getStringSimple", e.getMessage());
            stringDescriptor = -4;
        }
        return stringDescriptor;
    }

    public synchronized String getSerialNumberString() {
        String serial;
        if (this.mConnection != null) {
            serial = this.mConnection.getSerial();
        } else {
            serial = "Serial not available";
        }
        return serial;
    }

    public synchronized int getMaxPacketInSize() {
        return this.mMaxPacketInSize;
    }

    public int getMaxPacketOutSize() {
        return this.mMaxPacketOutSize;
    }
}
