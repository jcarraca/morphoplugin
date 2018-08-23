package com.jcarraca.cordova.plugin;

import android.util.Log;
import java.util.Observer;

/* compiled from: MorphoDevice */
class ResumeConnectionThread extends Thread {
    private static final int DEFAULT_REBOOT_TIMEOUT = 30000;
    private static final int INFINITE = 65535000;
    private MorphoDevice device = null;
    private String deviceName = "";
    private boolean deviceOpenedWithFD = false;
    private Observer observer = null;
    private boolean openDeviceStat = false;
    private int timeOut = DEFAULT_REBOOT_TIMEOUT;

    ResumeConnectionThread() {
    }

    public void run() {
        if (this.device != null && (this.deviceName != "" || this.deviceOpenedWithFD)) {
            int ret = this.device.ping();
            Log.i("MORPHO_USB", "ping : ret " + ret);
            if (ret != 0) {
                long timeStart = System.currentTimeMillis();
                long timecurrent = System.currentTimeMillis();
                while (timecurrent - timeStart < ((long) this.timeOut)) {
                    try {
                        Thread.sleep(1000);
                        ret = USBManager.getInstance().scanDevice();
                        Log.i("MORPHO_USB", "Scan for Grant : ret " + ret);
                        if (ret == 1) {
                            USBManager.getInstance().initialize(USBManager.context, USBManager.ACTION_USB_PERMISSION);
                            break;
                        }
                        timecurrent = System.currentTimeMillis();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        if (this.observer != null) {
                            this.observer.update(null, Boolean.valueOf(false));
                        }
                    }
                }
                while (timecurrent - timeStart < ((long) this.timeOut)) {
                    try {
                        if (!this.deviceOpenedWithFD || USBManager.getInstance().IsUsbDaemonStarted() == 1) {
                            ret = this.device.openUsbDevice(this.deviceName, 0);
                            Log.i("MORPHO_USB", "openUsbDevice " + this.deviceName + " : ret" + ret);
                        } else {
                            int[] bus = new int[1];
                            int[] address = new int[1];
                            int[] fd = new int[]{-1};
                            address[0] = -1;
                            fd[0] = -1;
                            ret = USBManager.getInstance().getDeviceInformations(this.deviceName, bus, address, fd);
                            Log.i("MORPHO_USB", "getDeviceInformations ret " + ret + " deviceName" + this.deviceName + ", bus:" + bus[0] + ", address:" + address[0] + ", fd:" + fd[0]);
                            if (fd[0] != -1) {
                                ret = this.device.openUsbDeviceFD(bus[0], address[0], fd[0], 0);
                                Log.i("MORPHO_USB", "openUsbDeviceFD bus:" + bus[0] + ", address:" + address[0] + ", fd:" + fd[0] + " : ret" + ret);
                            }
                        }
                        if (ret == 0) {
                            this.openDeviceStat = true;
                            if (this.observer != null) {
                                this.observer.update(null, Boolean.valueOf(true));
                            }
                            if (!this.openDeviceStat && this.observer != null) {
                                this.observer.update(null, Boolean.valueOf(false));
                                return;
                            }
                        }
                        Thread.sleep(1000);
                        timecurrent = System.currentTimeMillis();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                        if (this.observer != null) {
                            this.observer.update(null, Boolean.valueOf(false));
                        }
                    }
                }
                if (!this.openDeviceStat) {
                }
            } else if (this.observer != null) {
                this.observer.update(null, Boolean.valueOf(true));
            }
        } else if (this.observer != null) {
            this.observer.update(null, Boolean.valueOf(false));
        }
    }

    public void setDevice(MorphoDevice device) {
        this.device = device;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setDeviceOpenWithFD(boolean openfd) {
        this.deviceOpenedWithFD = openfd;
    }

    public void setTimeOut(int timeOut) {
        if (timeOut != 0) {
            if (timeOut * USBConstants.TIMEOUT > DEFAULT_REBOOT_TIMEOUT) {
                this.timeOut = timeOut * USBConstants.TIMEOUT;
            } else {
                this.timeOut = DEFAULT_REBOOT_TIMEOUT;
            }
        }
    }
}
