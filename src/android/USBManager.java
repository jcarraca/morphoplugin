package com.jcarraca.cordova.plugin;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.util.Log;
import android.widget.Toast;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class USBManager {
    public static String ACTION_USB_PERMISSION = "com.morpho.android.usb.USB_PERMISSION";
    public static final String SOFTWAREID_CBM = "CBM";
    public static final String SOFTWAREID_CBME3 = "CBM-E3";
    public static final String SOFTWAREID_CBMV3 = "CBM-V3";
    public static final String SOFTWAREID_FVP = "MSO FVP";
    public static final String SOFTWAREID_FVP_C = "MSO FVP_C";
    public static final String SOFTWAREID_FVP_CL = "MSO FVP_CL";
    public static final String SOFTWAREID_MASIGMA = "MA SIGMA";
    public static final String SOFTWAREID_MEP = "MEPUSB";
    public static final String SOFTWAREID_MSO100 = "MSO100";
    public static final String SOFTWAREID_MSO1300E3 = "MSO1300-E3";
    public static final String SOFTWAREID_MSO1300V3 = "MSO1300-V3";
    public static final String SOFTWAREID_MSO1350 = "MSO1350";
    public static final String SOFTWAREID_MSO1350E3 = "MSO1350-E3";
    public static final String SOFTWAREID_MSO1350V3 = "MSO1350-V3";
    public static final String SOFTWAREID_MSO300 = "MSO300";
    public static final String SOFTWAREID_MSO350 = "MSO350";
    public static boolean WakeLockEnabled = false;
    public static Context context = null;
    static volatile List<USBDevice> deviceList = null;
    private static USBManager instance = null;
    public static Map<Context, ScreenBroadcastReceiver> screenReceiverMap = new HashMap();
    private static final Map<USBDeviceAttributes, String> supportedDevices = new HashMap();

    public native int IsUsbDaemonStarted();

    public native String getUsbDaemonVersion();

    public native void initialize();

    static {
        System.loadLibrary("NativeMorphoSmartSDK_6.17.3.0");
        System.loadLibrary("MSO100");
        supportedDevices.put(new USBDeviceAttributes(1947, 35), "MSO100");
        supportedDevices.put(new USBDeviceAttributes(1947, 36), "MSO300");
        supportedDevices.put(new USBDeviceAttributes(1947, 38), "MSO350");
        supportedDevices.put(new USBDeviceAttributes(1947, 71), "CBM");
        supportedDevices.put(new USBDeviceAttributes(1947, 82), "MSO1350");
        supportedDevices.put(new USBDeviceAttributes(8797, 1), "MSO FVP");
        supportedDevices.put(new USBDeviceAttributes(8797, 2), "MSO FVP_C");
        supportedDevices.put(new USBDeviceAttributes(8797, 3), "MSO FVP_CL");
        supportedDevices.put(new USBDeviceAttributes(8797, 7), "MEPUSB");
        supportedDevices.put(new USBDeviceAttributes(8797, 8), "CBM-E3");
        supportedDevices.put(new USBDeviceAttributes(8797, 9), "CBM-V3");
        supportedDevices.put(new USBDeviceAttributes(8797, 10), "MSO1300-E3");
        supportedDevices.put(new USBDeviceAttributes(8797, 11), "MSO1300-V3");
        supportedDevices.put(new USBDeviceAttributes(8797, 12), "MSO1350-E3");
        supportedDevices.put(new USBDeviceAttributes(8797, 13), "MSO1350-V3");
        supportedDevices.put(new USBDeviceAttributes(8797, 14), "MA SIGMA");
    }

    public static synchronized USBManager getInstance() {
        USBManager uSBManager;
        synchronized (USBManager.class) {
            if (instance == null) {
                instance = new USBManager();
            }
            uSBManager = instance;
        }
        return uSBManager;
    }

    private USBManager() {
    }

    public int initialize(Activity context, String packagePath) {
        Log.i("MORPHO_USB", "context : " + context);
        if (context == null) {
            return -5;
        }
        return initialize(context.getApplicationContext(), packagePath);
    }

    public void checkWakeLockPermission(Context context) {
        if (context.getPackageManager().checkPermission("android.permission.WAKE_LOCK", context.getPackageName()) != 0) {
            Log.i("MORPHO_USB", "WAKE_LOCK permission was not granted");
            Toast.makeText(context.getApplicationContext(), "MorphoSmart SDK, WAKE_LOCK permission was not granted", 1).show();
            return;
        }
        Log.i("MORPHO_USB", "WAKE_LOCK permission was granted");
    }

    public static void unRegister(Context ctx, ScreenBroadcastReceiver receiver) {
        for (Context key : screenReceiverMap.keySet()) {
            if (key == ctx) {
                ctx.unregisterReceiver(receiver);
                screenReceiverMap.remove(key);
            }
        }
    }

    public int initialize(Context context, String packagePath, boolean enableWakeLock) {
        if (context == null) {
            return -5;
        }
        checkWakeLockPermission(context);
        WakeLockEnabled = enableWakeLock;
        return initialize(context, packagePath);
    }

    public int initialize(Context context, String packagePath) {
        initialize();
        if (context == null) {
            return -5;
        }
        Log.i("MORPHO_USB", "context : " + context);
        context = context;
        ACTION_USB_PERMISSION = packagePath;
        if (IsUsbDaemonStarted() == 1) {
            Log.e("MORPHO_USB", "Service started");
            return 0;
        }
        Log.e("MORPHO_USB", "Service not started");
        if (deviceList == null) {
            deviceList = new LinkedList();
        }
        clearDeviceList();
        grantePermission();
        return 0;
    }

    public int getDeviceInformations(String serialNumber, int[] bus, int[] address, int[] fd) {
        if (context == null) {
            return -1;
        }
        UsbManager usbManager = (UsbManager) context.getSystemService("usb");
        for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
            if (isSupported(new USBDeviceAttributes(usbDevice.getVendorId(), usbDevice.getProductId()))) {
                boolean hasPermission = usbManager.hasPermission(usbDevice);
                Log.i("MORPHO_USB", "hasPermission = " + hasPermission);
                if (hasPermission) {
                    UsbDeviceConnection connection = usbManager.openDevice(usbDevice);
                    if (connection == null) {
                        continue;
                    } else if (connection.getSerial().equalsIgnoreCase(serialNumber)) {
                        int sensorFileDescriptor = connection.getFileDescriptor();
                        String[] elts = usbDevice.getDeviceName().split("/");
                        if (elts.length >= 5) {
                            int sensorBus = Integer.parseInt(elts[4].toString());
                            int sensorAddress = Integer.parseInt(elts[5].toString());
                            bus[0] = sensorBus;
                            address[0] = sensorAddress;
                            fd[0] = sensorFileDescriptor;
                            return 0;
                        }
                    } else {
                        connection.close();
                    }
                } else {
                    continue;
                }
            }
        }
        return -3;
    }

    public int getFileDescriptor(int bus, int deviceAddress) {
        if (context == null) {
            return -1;
        }
        UsbManager usbManager = (UsbManager) context.getSystemService("usb");
        for (UsbDevice device : usbManager.getDeviceList().values()) {
            Log.i("getFileDescriptor", "getDeviceId : " + device.getDeviceId());
            if (isSupported(new USBDeviceAttributes(device.getVendorId(), device.getProductId()))) {
                if (!String.format("/dev/bus/usb/%03d/%03d", new Object[]{Integer.valueOf(bus), Integer.valueOf(deviceAddress)}).equalsIgnoreCase(device.getDeviceName())) {
                    continue;
                } else if (!usbManager.hasPermission(device)) {
                    return -2;
                } else {
                    UsbDeviceConnection usbDeviceConnection = usbManager.openDevice(device);
                    if (usbDeviceConnection != null) {
                        return usbDeviceConnection.getFileDescriptor();
                    }
                }
            }
        }
        return -3;
    }

    private void clearDeviceList() {
        try {
            if (deviceList != null) {
                for (int i = 0; i < deviceList.size(); i++) {
                    ((USBDevice) deviceList.get(i)).close();
                }
            }
        } catch (Exception e) {
            Log.e("USBManager clearDeviceList", e.getMessage());
        }
        if (deviceList != null) {
            deviceList.clear();
        }
    }

    private int grantePermission() {
        Context context = context;
        if (context != null) {
            UsbManager usbManager = (UsbManager) context.getSystemService("usb");
            for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
                if (isSupported(new USBDeviceAttributes(usbDevice.getVendorId(), usbDevice.getProductId())) && !usbManager.hasPermission(usbDevice)) {
                    Log.i("MORPHO_USB", "Request permission for using the device");
                    usbManager.requestPermission(usbDevice, PendingIntent.getBroadcast(context, 0, new Intent(ACTION_USB_PERMISSION), 0));
                }
            }
        }
        return 0;
    }

    public boolean isDevicesHasPermission() {
        if (IsUsbDaemonStarted() == 1) {
            return true;
        }
        Context context = context;
        if (context == null) {
            return false;
        }
        UsbManager usbManager = (UsbManager) context.getSystemService("usb");
        HashMap<String, UsbDevice> usbDeviceList = usbManager.getDeviceList();
        if (usbDeviceList.isEmpty()) {
            return true;
        }
        boolean hasPermission = true;
        for (UsbDevice usbDevice : usbDeviceList.values()) {
            if (isSupported(new USBDeviceAttributes(usbDevice.getDeviceName(), usbDevice.getVendorId(), usbDevice.getProductId(), 1)) && !usbManager.hasPermission(usbDevice)) {
                hasPermission = false;
            }
        }
        return hasPermission;
    }

    public int scanDevice() {
        if (IsUsbDaemonStarted() == 1) {
            Log.e("MORPHO_USB", "Service started");
            return 1;
        }
        Context context = context;
        if (context != null) {
            UsbManager usbManager = (UsbManager) context.getSystemService("usb");
            Log.i("MORPHO_USB", "usbDeviceList.size() = " + usbManager.getDeviceList().size());
            for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
                if (isSupported(new USBDeviceAttributes(usbDevice.getDeviceName(), usbDevice.getVendorId(), usbDevice.getProductId(), 1))) {
                    Log.i("MORPHO_USB", "Supported device : Vendor Id = " + usbDevice.getVendorId() + ", product Id = " + usbDevice.getProductId());
                    return 1;
                }
            }
        }
        return 0;
    }

    public synchronized String getDeviceModel(USBDeviceAttributes attribs) {
        String str;
        if (attribs == null) {
            str = "";
        } else {
            for (Entry<USBDeviceAttributes, String> entry : supportedDevices.entrySet()) {
                USBDeviceAttributes supportedAttribs = (USBDeviceAttributes) entry.getKey();
                if (supportedAttribs.getVendorId() == attribs.getVendorId() && supportedAttribs.getProductId() == attribs.getProductId()) {
                    str = (String) entry.getValue();
                    break;
                }
            }
            str = "";
        }
        return str;
    }

    public synchronized boolean isSupported(USBDeviceAttributes attribs) {
        boolean z = false;
        synchronized (this) {
            if (attribs != null) {
                for (USBDeviceAttributes supportedAttribs : supportedDevices.keySet()) {
                    if (supportedAttribs.getVendorId() == attribs.getVendorId() && supportedAttribs.getProductId() == attribs.getProductId()) {
                        z = true;
                        break;
                    }
                }
            }
        }
        return z;
    }

    private synchronized int addGrantedDevice(UsbDevice device, int usbInterfaceNum) {
        int ret;
        if (device == null) {
            ret = -6;
        } else {
            int ret2;
            USBDevice usbDevice = new USBDevice(new USBDeviceAttributes(device.getDeviceName(), device.getVendorId(), device.getProductId(), usbInterfaceNum), (UsbManager) context.getSystemService("usb"), device);
            try {
                ret2 = usbDevice.open();
                if (ret2 == 0) {
                    if (deviceList == null) {
                        deviceList = new LinkedList();
                    }
                    deviceList.add(usbDevice);
                }
            } catch (Exception e) {
                Log.e("MORPHO_USB", e.getMessage());
                ret2 = -6;
            }
            ret = ret2;
        }
        return ret;
    }

    public synchronized USBDeviceAttributes[] enumerate() {
        USBDeviceAttributes[] uSBDeviceAttributesArr;
        if (context == null) {
            uSBDeviceAttributesArr = null;
        } else {
            UsbManager manager = (UsbManager) context.getSystemService("usb");
            HashMap<String, UsbDevice> usbdeviceList = manager.getDeviceList();
            if (usbdeviceList.isEmpty()) {
                uSBDeviceAttributesArr = null;
            } else {
                uSBDeviceAttributesArr = new USBDeviceAttributes[usbdeviceList.size()];
                int usbInterfaceNum = -1;
                clearDeviceList();
                int i = 0;
                for (UsbDevice device : usbdeviceList.values()) {
                    int count = device.getInterfaceCount();
                    int j = 0;
                    while (j < count) {
                        if ((device.getInterface(j).getInterfaceClass() == 2 || device.getInterface(j).getInterfaceClass() == 10) && device.getInterface(j).getEndpointCount() == 2) {
                            usbInterfaceNum = j;
                            break;
                        }
                        j++;
                    }
                    if (usbInterfaceNum != -1) {
                        USBDeviceAttributes attrs = new USBDeviceAttributes(device.getDeviceName(), device.getVendorId(), device.getProductId(), usbInterfaceNum);
                        if (isSupported(attrs)) {
                            int i2;
                            if (manager.hasPermission(device)) {
                                if (addGrantedDevice(device, usbInterfaceNum) == 0) {
                                    i2 = i + 1;
                                    uSBDeviceAttributesArr[i] = attrs;
                                    attrs.setFreindlyName(getDeviceModel(attrs));
                                }
                                i2 = i;
                            } else {
                                Log.i("MORPHO_USB", "no permission for device %s" + device.getDeviceName());
                                i2 = i;
                            }
                            usbInterfaceNum = -1;
                            i = i2;
                        }
                    }
                }
            }
        }
        return uSBDeviceAttributesArr;
    }

    public synchronized void listDevices() throws Exception {
        USBDeviceAttributes[] attribsList = enumerate();
        if (!(deviceList == null || attribsList == null)) {
            for (int i = 0; i < deviceList.size(); i++) {
                ((USBDevice) deviceList.get(i)).CreateInterface(attribsList[i].getInterfaceNumber());
            }
        }
    }

    public synchronized int getNbDevices() throws Exception {
        int i;
        if (deviceList == null) {
            i = 0;
        } else {
            i = deviceList.size();
        }
        return i;
    }

    public USBDevice getDevice(int index) {
        if (deviceList != null && deviceList.size() > index) {
            return (USBDevice) deviceList.get(index);
        }
        return null;
    }
}
