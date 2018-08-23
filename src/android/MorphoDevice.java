package com.jcarraca.cordova.plugin;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.ArrayList;
import java.util.Observer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;

@SuppressLint({"UseValueOf"})
public class MorphoDevice implements Cloneable {
    public static String ACTION_SCREEN_RECEIVER = "com.morpho.android.local.RECEIVER";
    public static final int CONFIG_SENSOR_WIN_POSITION_TAG = 3600;
    public static final int CONFIG_UI_CONFIG_TAG = 5136;
    public static final int CONFIG_UI_RESET_TAG = 5137;
    private static final /* synthetic */ StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_10 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_11 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_12 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_2 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_3 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_4 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_5 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_6 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_7 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_8 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_9 = null;
    private static MorphoDeviceNative morphoDeviceNative = new MorphoDeviceNative();
    private ResumeConnectionThread _reboot = null;
    private Context context = null;
    protected boolean cppMemOwn = false;
    private int deviceAddress = -1;
    private int deviceBus = -1;
    private int deviceFD = -1;
    private boolean deviceOpenedWithFD = false;
    private String deviceSN = "";
    private Long morphoDevicePointerCPP = new Long(0);
    private ScreenBroadcastReceiver screenReceiver = null;

    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        private MorphoDevice device = null;

        /* renamed from: com.jcarraca.cordova.plugin.MorphoDevice$ScreenBroadcastReceiver$1 */
        class C00821 extends Thread {
            C00821() {
            }

            public void run() {
                if (ScreenBroadcastReceiver.this.device != null) {
                    ScreenBroadcastReceiver.this.device.cancelLiveAcquisition();
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            intent.getAction();
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                USBManager.getInstance();
                if (USBManager.WakeLockEnabled) {
                    new C00821().start();
                }
            }
        }

        public void setDevice(MorphoDevice device) {
            this.device = device;
        }
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("MorphoDevice.java", MorphoDevice.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "capture", "com.jcarraca.cordova.plugin.MorphoDevice", "int:int:int:int:com.jcarraca.cordova.plugin.TemplateType:com.jcarraca.cordova.plugin.TemplateFVPType:int:com.jcarraca.cordova.plugin.EnrollmentType:com.jcarraca.cordova.plugin.LatentDetection:com.jcarraca.cordova.plugin.Coder:int:com.jcarraca.cordova.plugin.CompressionAlgorithm:int:com.jcarraca.cordova.plugin.TemplateList:int:java.util.Observer", "timeout:acquisitionThreshold:advancedSecurityLevelsRequired:fingerNumber:templateType:templateFVPType:maxSizeTemplate:enrollType:latentDetection:coderChoice:detectModeChoice:compressAlgo:compressRate:templateList:callbackCmd:callback", "", "int"), 298);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "capture", "com.jcarraca.cordova.plugin.MorphoDevice", "int:int:int:int:com.jcarraca.cordova.plugin.TemplateType:com.jcarraca.cordova.plugin.TemplateFVPType:int:com.jcarraca.cordova.plugin.EnrollmentType:com.jcarraca.cordova.plugin.LatentDetection:com.jcarraca.cordova.plugin.Coder:int:com.jcarraca.cordova.plugin.TemplateList:int:java.util.Observer", "timeout:acquisitionThreshold:advancedSecurityLevelsRequired:fingerNumber:templateType:templateFVPType:maxSizeTemplate:enrollType:latentDetection:coderChoice:detectModeChoice:templateList:callbackCmd:callback", "", "int"), 321);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "loadKs", "com.jcarraca.cordova.plugin.MorphoDevice", "[B", "key", "", "int"), 1394);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "loadMocKey", "com.jcarraca.cordova.plugin.MorphoDevice", "[B:[B:[B", "key_enc_Ciffered_by_Certificate:key_enc_Ciffered_by_Certificate_Signature:hostCertificate", "", "int"), 1487);
        ajc$tjp_12 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "loadMocKey", "com.jcarraca.cordova.plugin.MorphoDevice", "[B", "key_enc_Ciffered_by_KencTrans", "", "int"), 1513);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "openUsbDevice", "com.jcarraca.cordova.plugin.MorphoDevice", "java.lang.String:int", "sensorName:timeOut", "", "int"), 479);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "openUsbDeviceFD", "com.jcarraca.cordova.plugin.MorphoDevice", "int:int:int:int", "bus:address:fd:timeOut", "", "int"), 513);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setConfigParam", "com.jcarraca.cordova.plugin.MorphoDevice", "int:[B", "tag:paramValue", "", "int"), 548);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getImage", "com.jcarraca.cordova.plugin.MorphoDevice", "int:int:com.jcarraca.cordova.plugin.CompressionAlgorithm:int:int:com.jcarraca.cordova.plugin.LatentDetection:com.jcarraca.cordova.plugin.MorphoImage:int:java.util.Observer", "timeOut:acquisitionThreshold:compressAlgo:compressRate:detectModeChoice:latentDetection:morphoImage:callbackCmd:callback", "", "int"), 942);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "verify", "com.jcarraca.cordova.plugin.MorphoDevice", "int:int:com.jcarraca.cordova.plugin.Coder:int:int:com.jcarraca.cordova.plugin.TemplateList:int:java.util.Observer:com.jcarraca.cordova.plugin.ResultMatching", "timeOut:far:coder:detectModeChoice:matchingStrategy:templateList:callbackCmd:callback:resultMatching", "", "int"), 1248);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "verifyMatch", "com.jcarraca.cordova.plugin.MorphoDevice", "int:com.jcarraca.cordova.plugin.TemplateList:com.jcarraca.cordova.plugin.TemplateList:java.lang.Integer", "far:templateListSearch:templateListReference:matchingScore", "", "int"), 1287);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "comSend", "com.jcarraca.cordova.plugin.MorphoDevice", "int:[B", "timeOut:data", "", "int"), 1353);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "comReceive", "com.jcarraca.cordova.plugin.MorphoDevice", "int", "timeOut", "", "[B"), 1375);
    }

    @WakeLockabble
    public int capture(int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, int maxSizeTemplate, EnrollmentType enrollType, LatentDetection latentDetection, Coder coderChoice, int detectModeChoice, CompressionAlgorithm compressAlgo, int compressRate, TemplateList templateList, int callbackCmd, Observer callback) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_0, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeout), Conversions.intObject(acquisitionThreshold), Conversions.intObject(advancedSecurityLevelsRequired), Conversions.intObject(fingerNumber), templateType, templateFVPType, Conversions.intObject(maxSizeTemplate), enrollType, latentDetection, coderChoice, Conversions.intObject(detectModeChoice), compressAlgo, Conversions.intObject(compressRate), templateList, Conversions.intObject(callbackCmd), callback});
        return Conversions.intValue(capture_aroundBody1$advice(this, timeout, acquisitionThreshold, advancedSecurityLevelsRequired, fingerNumber, templateType, templateFVPType, maxSizeTemplate, enrollType, latentDetection, coderChoice, detectModeChoice, compressAlgo, compressRate, templateList, callbackCmd, callback, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int capture(int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, int maxSizeTemplate, EnrollmentType enrollType, LatentDetection latentDetection, Coder coderChoice, int detectModeChoice, TemplateList templateList, int callbackCmd, Observer callback) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_1, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeout), Conversions.intObject(acquisitionThreshold), Conversions.intObject(advancedSecurityLevelsRequired), Conversions.intObject(fingerNumber), templateType, templateFVPType, Conversions.intObject(maxSizeTemplate), enrollType, latentDetection, coderChoice, Conversions.intObject(detectModeChoice), templateList, Conversions.intObject(callbackCmd), callback});
        return Conversions.intValue(capture_aroundBody3$advice(this, timeout, acquisitionThreshold, advancedSecurityLevelsRequired, fingerNumber, templateType, templateFVPType, maxSizeTemplate, enrollType, latentDetection, coderChoice, detectModeChoice, templateList, callbackCmd, callback, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public byte[] comReceive(int timeOut) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_9, (Object) this, (Object) this, Conversions.intObject(timeOut));
        return (byte[]) comReceive_aroundBody19$advice(this, timeOut, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @WakeLockabble
    public int comSend(int timeOut, byte[] data) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_8, this, this, Conversions.intObject(timeOut), data);
        return Conversions.intValue(comSend_aroundBody17$advice(this, timeOut, data, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int getImage(int timeOut, int acquisitionThreshold, CompressionAlgorithm compressAlgo, int compressRate, int detectModeChoice, LatentDetection latentDetection, MorphoImage morphoImage, int callbackCmd, Observer callback) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_5, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeOut), Conversions.intObject(acquisitionThreshold), compressAlgo, Conversions.intObject(compressRate), Conversions.intObject(detectModeChoice), latentDetection, morphoImage, Conversions.intObject(callbackCmd), callback});
        return Conversions.intValue(getImage_aroundBody11$advice(this, timeOut, acquisitionThreshold, compressAlgo, compressRate, detectModeChoice, latentDetection, morphoImage, callbackCmd, callback, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int loadKs(byte[] key) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_10, (Object) this, (Object) this, (Object) key);
        return Conversions.intValue(loadKs_aroundBody21$advice(this, key, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int loadMocKey(byte[] key_enc_Ciffered_by_KencTrans) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_12, (Object) this, (Object) this, (Object) key_enc_Ciffered_by_KencTrans);
        return Conversions.intValue(loadMocKey_aroundBody25$advice(this, key_enc_Ciffered_by_KencTrans, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int loadMocKey(byte[] key_enc_Ciffered_by_Certificate, byte[] key_enc_Ciffered_by_Certificate_Signature, byte[] hostCertificate) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_11, (Object) this, (Object) this, new Object[]{key_enc_Ciffered_by_Certificate, key_enc_Ciffered_by_Certificate_Signature, hostCertificate});
        return Conversions.intValue(loadMocKey_aroundBody23$advice(this, key_enc_Ciffered_by_Certificate, key_enc_Ciffered_by_Certificate_Signature, hostCertificate, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int openUsbDevice(String sensorName, int timeOut) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_2, this, this, sensorName, Conversions.intObject(timeOut));
        return Conversions.intValue(openUsbDevice_aroundBody5$advice(this, sensorName, timeOut, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int openUsbDeviceFD(int bus, int address, int fd, int timeOut) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_3, (Object) this, (Object) this, new Object[]{Conversions.intObject(bus), Conversions.intObject(address), Conversions.intObject(fd), Conversions.intObject(timeOut)});
        return Conversions.intValue(openUsbDeviceFD_aroundBody7$advice(this, bus, address, fd, timeOut, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int setConfigParam(int tag, byte[] paramValue) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_4, this, this, Conversions.intObject(tag), paramValue);
        return Conversions.intValue(setConfigParam_aroundBody9$advice(this, tag, paramValue, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int verify(int timeOut, int far, Coder coder, int detectModeChoice, int matchingStrategy, TemplateList templateList, int callbackCmd, Observer callback, ResultMatching resultMatching) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_6, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeOut), Conversions.intObject(far), coder, Conversions.intObject(detectModeChoice), Conversions.intObject(matchingStrategy), templateList, Conversions.intObject(callbackCmd), callback, resultMatching});
        return Conversions.intValue(verify_aroundBody13$advice(this, timeOut, far, coder, detectModeChoice, matchingStrategy, templateList, callbackCmd, callback, resultMatching, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int verifyMatch(int far, TemplateList templateListSearch, TemplateList templateListReference, Integer matchingScore) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_7, (Object) this, (Object) this, new Object[]{Conversions.intObject(far), templateListSearch, templateListReference, matchingScore});
        return Conversions.intValue(verifyMatch_aroundBody15$advice(this, far, templateListSearch, templateListReference, matchingScore, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    static {
        ajc$preClinit();
    }

    public MorphoDevice() {
        long cppPtr = morphoDeviceNative.getCPPInstance();
        if (cppPtr != 0) {
            this.cppMemOwn = true;
            this.morphoDevicePointerCPP = Long.valueOf(cppPtr);
            return;
        }
        try {
            throw new MorphoSmartException("cppPtr is null");
        } catch (MorphoSmartException e) {
            e.printStackTrace();
        }
    }

    private static final /* synthetic */ Object capture_aroundBody1$advice(MorphoDevice ajc$this, int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, int maxSizeTemplate, EnrollmentType enrollType, LatentDetection latentDetection, Coder coderChoice, int detectModeChoice, CompressionAlgorithm compressAlgo, int compressRate, TemplateList templateList, int callbackCmd, Observer callback, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(capture_aroundBody0(ajc$this, timeout, acquisitionThreshold, advancedSecurityLevelsRequired, fingerNumber, templateType, templateFVPType, maxSizeTemplate, enrollType, latentDetection, coderChoice, detectModeChoice, compressAlgo, compressRate, templateList, callbackCmd, callback, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object capture_aroundBody3$advice(MorphoDevice ajc$this, int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, int maxSizeTemplate, EnrollmentType enrollType, LatentDetection latentDetection, Coder coderChoice, int detectModeChoice, TemplateList templateList, int callbackCmd, Observer callback, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(capture_aroundBody2(ajc$this, timeout, acquisitionThreshold, advancedSecurityLevelsRequired, fingerNumber, templateType, templateFVPType, maxSizeTemplate, enrollType, latentDetection, coderChoice, detectModeChoice, templateList, callbackCmd, callback, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object comReceive_aroundBody19$advice(MorphoDevice ajc$this, int timeOut, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = comReceive_aroundBody18(ajc$this, timeOut, joinPoint);
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object comSend_aroundBody17$advice(MorphoDevice ajc$this, int timeOut, byte[] data, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(comSend_aroundBody16(ajc$this, timeOut, data, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object getImage_aroundBody11$advice(MorphoDevice ajc$this, int timeOut, int acquisitionThreshold, CompressionAlgorithm compressAlgo, int compressRate, int detectModeChoice, LatentDetection latentDetection, MorphoImage morphoImage, int callbackCmd, Observer callback, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(getImage_aroundBody10(ajc$this, timeOut, acquisitionThreshold, compressAlgo, compressRate, detectModeChoice, latentDetection, morphoImage, callbackCmd, callback, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object loadKs_aroundBody21$advice(MorphoDevice ajc$this, byte[] key, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(loadKs_aroundBody20(ajc$this, key, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object loadMocKey_aroundBody23$advice(MorphoDevice ajc$this, byte[] key_enc_Ciffered_by_Certificate, byte[] key_enc_Ciffered_by_Certificate_Signature, byte[] hostCertificate, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(loadMocKey_aroundBody22(ajc$this, key_enc_Ciffered_by_Certificate, key_enc_Ciffered_by_Certificate_Signature, hostCertificate, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object loadMocKey_aroundBody25$advice(MorphoDevice ajc$this, byte[] key_enc_Ciffered_by_KencTrans, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(loadMocKey_aroundBody24(ajc$this, key_enc_Ciffered_by_KencTrans, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object openUsbDeviceFD_aroundBody7$advice(MorphoDevice ajc$this, int bus, int address, int fd, int timeOut, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(openUsbDeviceFD_aroundBody6(ajc$this, bus, address, fd, timeOut, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object openUsbDevice_aroundBody5$advice(MorphoDevice ajc$this, String sensorName, int timeOut, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(openUsbDevice_aroundBody4(ajc$this, sensorName, timeOut, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object setConfigParam_aroundBody9$advice(MorphoDevice ajc$this, int tag, byte[] paramValue, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(setConfigParam_aroundBody8(ajc$this, tag, paramValue, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object verifyMatch_aroundBody15$advice(MorphoDevice ajc$this, int far, TemplateList templateListSearch, TemplateList templateListReference, Integer matchingScore, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(verifyMatch_aroundBody14(ajc$this, far, templateListSearch, templateListReference, matchingScore, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object verify_aroundBody13$advice(MorphoDevice ajc$this, int timeOut, int far, Coder coder, int detectModeChoice, int matchingStrategy, TemplateList templateList, int callbackCmd, Observer callback, ResultMatching resultMatching, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(verify_aroundBody12(ajc$this, timeOut, far, coder, detectModeChoice, matchingStrategy, templateList, callbackCmd, callback, resultMatching, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private void createScreenReceiver() {
        USBManager.getInstance();
        this.screenReceiver = new ScreenBroadcastReceiver();
        this.screenReceiver.setDevice(this);
        IntentFilter filter = new IntentFilter(ACTION_SCREEN_RECEIVER);
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.SCREEN_ON");
        this.context = USBManager.context;
        if (this.context != null) {
            this.context.registerReceiver(this.screenReceiver, filter);
            USBManager.screenReceiverMap.put(this.context, this.screenReceiver);
        }
    }

    public MorphoDevice(MorphoDevice device) {
        if (device == null) {
            try {
                throw new MorphoSmartException("MorphoDevice object is null");
            } catch (MorphoSmartException e) {
                e.printStackTrace();
            }
        } else if (device.cppMemOwn) {
            try {
                throw new MorphoSmartException("cppMemOwn is true");
            } catch (MorphoSmartException e2) {
                e2.printStackTrace();
            }
        } else {
            long cppPtr = morphoDeviceNative.getCPPInstance(device.morphoDevicePointerCPP.longValue());
            if (cppPtr != 0) {
                this.cppMemOwn = true;
                this.morphoDevicePointerCPP = Long.valueOf(cppPtr);
                return;
            }
            try {
                throw new MorphoSmartException("cppPtr is null");
            } catch (MorphoSmartException e22) {
                e22.printStackTrace();
            }
        }
    }

    protected void finalize() {
        if (this.cppMemOwn) {
            closeDevice();
            morphoDeviceNative.deleteInstance(this.morphoDevicePointerCPP.longValue());
            this.cppMemOwn = false;
        }
    }

    public int ping() {
        if (this.cppMemOwn) {
            return morphoDeviceNative.ping(this.morphoDevicePointerCPP.longValue());
        }
        return -98;
    }

    public Object clone() {
        return new MorphoDevice(this);
    }

    public void setMorphoDeviceNativePointerCPP(long morphoDevicePointerCPP) {
        this.morphoDevicePointerCPP = Long.valueOf(morphoDevicePointerCPP);
        this.cppMemOwn = true;
    }

    public int getDatabase(int databaseIndex, MorphoDatabase morphoDatabase) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (morphoDatabase == null) {
            return -5;
        }
        return morphoDeviceNative.getDatabase(this.morphoDevicePointerCPP.longValue(), databaseIndex, morphoDatabase);
    }

    public int cancelLiveAcquisition() {
        if (this.cppMemOwn) {
            return morphoDeviceNative.cancelLiveAcquisition(this.morphoDevicePointerCPP.longValue());
        }
        return -98;
    }

    private static final /* synthetic */ int capture_aroundBody0(MorphoDevice ajc$this, int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, int maxSizeTemplate, EnrollmentType enrollType, LatentDetection latentDetection, Coder coderChoice, int detectModeChoice, CompressionAlgorithm compressAlgo, int compressRate, TemplateList templateList, int callbackCmd, Observer callback, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (templateType == null || templateFVPType == null || enrollType == null || latentDetection == null || coderChoice == null || templateList == null || compressAlgo == null) {
            return -5;
        }
        return morphoDeviceNative.capture(ajc$this.morphoDevicePointerCPP.longValue(), timeout, acquisitionThreshold, advancedSecurityLevelsRequired, fingerNumber, templateType.getCode(), templateFVPType.getCode(), maxSizeTemplate, enrollType.getValue(), latentDetection.getValue(), coderChoice.getCode(), detectModeChoice, templateList, callbackCmd, callback, compressAlgo.getCode(), compressRate);
    }

    private static final /* synthetic */ int capture_aroundBody2(MorphoDevice ajc$this, int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, int maxSizeTemplate, EnrollmentType enrollType, LatentDetection latentDetection, Coder coderChoice, int detectModeChoice, TemplateList templateList, int callbackCmd, Observer callback, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (templateType == null || templateFVPType == null || enrollType == null || latentDetection == null || coderChoice == null || templateList == null) {
            return -5;
        }
        return morphoDeviceNative.capture(ajc$this.morphoDevicePointerCPP.longValue(), timeout, acquisitionThreshold, advancedSecurityLevelsRequired, fingerNumber, templateType.getCode(), templateFVPType.getCode(), maxSizeTemplate, enrollType.getValue(), latentDetection.getValue(), coderChoice.getCode(), detectModeChoice, templateList, callbackCmd, callback, CompressionAlgorithm.MORPHO_NO_COMPRESS.getCode(), 0);
    }

    public int closeDevice() {
        USBManager.getInstance();
        USBManager.unRegister(this.context, this.screenReceiver);
        if (!this.cppMemOwn) {
            return -98;
        }
        this.deviceSN = "";
        this.deviceBus = -1;
        this.deviceAddress = -1;
        this.deviceFD = -1;
        this.deviceOpenedWithFD = false;
        return morphoDeviceNative.closeDevice(this.morphoDevicePointerCPP.longValue());
    }

    public int enableCS(boolean enable) {
        if (this.cppMemOwn) {
            return morphoDeviceNative.enableCS(this.morphoDevicePointerCPP.longValue(), enable);
        }
        return -98;
    }

    public int enableDataEncryption(boolean enable, String diversificationData) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (enable && diversificationData == null) {
            return -5;
        }
        return morphoDeviceNative.enableDataEncryption(this.morphoDevicePointerCPP.longValue(), enable, diversificationData);
    }

    public int resumeConnection(int timeOut, Observer observer) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (this._reboot != null && this._reboot.isAlive()) {
            return -96;
        }
        this._reboot = new ResumeConnectionThread();
        this._reboot.setTimeOut(timeOut);
        this._reboot.setDevice(this);
        this._reboot.setObserver(observer);
        this._reboot.setDeviceName(this.deviceSN);
        this._reboot.setDeviceOpenWithFD(this.deviceOpenedWithFD);
        this._reboot.start();
        return 0;
    }

    public String getProductDescriptor() {
        return morphoDeviceNative.getProductDescriptor(this.morphoDevicePointerCPP.longValue());
    }

    public String getSensorDescriptor() {
        return morphoDeviceNative.getSensorDescriptor(this.morphoDevicePointerCPP.longValue());
    }

    public String getSoftwareDescriptor() {
        return morphoDeviceNative.getSoftwareDescriptor(this.morphoDevicePointerCPP.longValue());
    }

    private static final /* synthetic */ int openUsbDevice_aroundBody4(MorphoDevice ajc$this, String sensorName, int timeOut, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (sensorName == null) {
            return -5;
        }
        ajc$this.createScreenReceiver();
        ajc$this.deviceSN = sensorName;
        return morphoDeviceNative.openUsbDevice(ajc$this.morphoDevicePointerCPP.longValue(), sensorName, timeOut);
    }

    private static final /* synthetic */ int openUsbDeviceFD_aroundBody6(MorphoDevice ajc$this, int bus, int address, int fd, int timeOut, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        ajc$this.createScreenReceiver();
        int ret = morphoDeviceNative.openUsbDeviceFD(ajc$this.morphoDevicePointerCPP.longValue(), bus, address, fd, timeOut);
        if (ret != 0) {
            return ret;
        }
        ajc$this.deviceSN = morphoDeviceNative.getOpenedUsbDeviceName(ajc$this.morphoDevicePointerCPP.longValue());
        Log.i("MORPHO_USB", "get deviceSN : " + ajc$this.deviceSN);
        ajc$this.deviceBus = bus;
        ajc$this.deviceAddress = address;
        ajc$this.deviceFD = fd;
        ajc$this.deviceOpenedWithFD = true;
        return ret;
    }

    private static final /* synthetic */ int setConfigParam_aroundBody8(MorphoDevice ajc$this, int tag, byte[] paramValue, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (paramValue == null) {
            return -5;
        }
        return morphoDeviceNative.setConfigParam(ajc$this.morphoDevicePointerCPP.longValue(), tag, paramValue);
    }

    public int SecuReadCertificate(int index, ArrayList<Byte> devCertif) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (devCertif == null || index < 0) {
            return -5;
        }
        return morphoDeviceNative.SecuReadCertificate(this.morphoDevicePointerCPP.longValue(), index, devCertif);
    }

    public int setSecurityLevel(SecurityLevel securityLevel) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (securityLevel == null) {
            return -5;
        }
        return morphoDeviceNative.setSecurityLevel(this.morphoDevicePointerCPP.longValue(), securityLevel.getValue());
    }

    public int getSecurityLevel() {
        if (this.cppMemOwn) {
            return morphoDeviceNative.getSecurityLevel(this.morphoDevicePointerCPP.longValue());
        }
        return -98;
    }

    public int setLoggingMode(MorphoLogMode morphoLogMode) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (morphoLogMode == null) {
            return -5;
        }
        return morphoDeviceNative.setLoggingMode(this.morphoDevicePointerCPP.longValue(), morphoLogMode.getCode());
    }

    public int setLoggingLevelOfGroup(int groupID, MorphoLogLevel morphoLogLevel) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (morphoLogLevel == null) {
            return -5;
        }
        return morphoDeviceNative.setLoggingLevelOfGroup(this.morphoDevicePointerCPP.longValue(), groupID, morphoLogLevel.getCode());
    }

    public int setStrategyAcquisitionMode(StrategyAcquisitionMode strategyAcquisitionMode) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (strategyAcquisitionMode == null) {
            return -5;
        }
        return morphoDeviceNative.setStrategyAcquisitionMode(this.morphoDevicePointerCPP.longValue(), strategyAcquisitionMode.getCode());
    }

    public StrategyAcquisitionMode getStrategyAcquisitionMode() {
        if (this.cppMemOwn) {
            return StrategyAcquisitionMode.getValue(morphoDeviceNative.getStrategyAcquisitionMode(this.morphoDevicePointerCPP.longValue()));
        }
        return null;
    }

    public int getComType() {
        if (this.cppMemOwn) {
            return morphoDeviceNative.getComType(this.morphoDevicePointerCPP.longValue());
        }
        return -98;
    }

    public byte[] getConfigParam(int parameterIdentifier) {
        if (this.cppMemOwn) {
            return morphoDeviceNative.getConfigParam(this.morphoDevicePointerCPP.longValue(), parameterIdentifier);
        }
        return null;
    }

    public String getStringDescriptorBin(DescriptorID descriptorIdentifier) {
        if (descriptorIdentifier == null) {
            try {
                throw new MorphoSmartException("DescriptorID object is null");
            } catch (MorphoSmartException e) {
                e.printStackTrace();
            }
        }
        return morphoDeviceNative.getStringDescriptorBin(this.morphoDevicePointerCPP.longValue(), descriptorIdentifier.getValue());
    }

    public int getIntDescriptorBin(DescriptorID descriptorIdentifier) {
        if (descriptorIdentifier == null) {
            try {
                throw new MorphoSmartException("DescriptorID object is null");
            } catch (MorphoSmartException e) {
                e.printStackTrace();
            }
        }
        return morphoDeviceNative.getIntDescriptorBin(this.morphoDevicePointerCPP.longValue(), descriptorIdentifier.getValue());
    }

    public String getFFDLogs() {
        if (!this.cppMemOwn) {
            try {
                throw new MorphoSmartException("MorphoDevice object is null");
            } catch (MorphoSmartException e) {
                e.printStackTrace();
            }
        }
        return morphoDeviceNative.getFFDLogs(this.morphoDevicePointerCPP.longValue());
    }

    public int getInternalError() {
        if (this.cppMemOwn) {
            return morphoDeviceNative.getInternalError(this.morphoDevicePointerCPP.longValue());
        }
        return -98;
    }

    private static final /* synthetic */ int getImage_aroundBody10(MorphoDevice ajc$this, int timeOut, int acquisitionThreshold, CompressionAlgorithm compressAlgo, int compressRate, int detectModeChoice, LatentDetection latentDetection, MorphoImage morphoImage, int callbackCmd, Observer callback, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (compressAlgo == null || latentDetection == null || morphoImage == null) {
            return -5;
        }
        return morphoDeviceNative.getImage(ajc$this.morphoDevicePointerCPP.longValue(), timeOut, acquisitionThreshold, compressAlgo.getCode(), compressRate, detectModeChoice, latentDetection.getValue(), morphoImage, callbackCmd, callback);
    }

    public int getSecuConfig(SecuConfig secuConfig) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (secuConfig == null) {
            return -5;
        }
        return morphoDeviceNative.getSecuConfig(this.morphoDevicePointerCPP.longValue(), secuConfig);
    }

    public byte[] getUnlockSeed() {
        if (this.cppMemOwn) {
            return morphoDeviceNative.getUnlockSeed(this.morphoDevicePointerCPP.longValue());
        }
        return null;
    }

    public String getUsbDeviceName(int index) {
        if (this.cppMemOwn) {
            return morphoDeviceNative.getUsbDeviceName(this.morphoDevicePointerCPP.longValue(), index);
        }
        return "";
    }

    public String getOpenedUsbDeviceName() {
        if (this.cppMemOwn) {
            return morphoDeviceNative.getOpenedUsbDeviceName(this.morphoDevicePointerCPP.longValue());
        }
        return "";
    }

    public int initUsbDevicesNameEnum(Integer nbUsbDevice) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (nbUsbDevice == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(nbUsbDevice).booleanValue()) {
            return -94;
        }
        return morphoDeviceNative.initUsbDevicesNameEnum(this.morphoDevicePointerCPP.longValue(), nbUsbDevice);
    }

    public String getUsbDevicePropertie(int index) {
        if (this.cppMemOwn) {
            return morphoDeviceNative.getUsbDevicePropertie(this.morphoDevicePointerCPP.longValue(), index);
        }
        return "";
    }

    public boolean isCSEnabled() {
        if (this.cppMemOwn) {
            return morphoDeviceNative.isCSEnabled(this.morphoDevicePointerCPP.longValue());
        }
        return false;
    }

    public boolean isDataEncryptionEnabled() {
        if (this.cppMemOwn) {
            return morphoDeviceNative.isDataEncryptionEnabled(this.morphoDevicePointerCPP.longValue());
        }
        return false;
    }

    public int rebootSoft(int timeOut, Observer callback) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (this._reboot != null && this._reboot.isAlive()) {
            return -96;
        }
        int ret = morphoDeviceNative.rebootSoft(this.morphoDevicePointerCPP.longValue());
        if (ret != 0) {
            return ret;
        }
        this._reboot = new ResumeConnectionThread();
        this._reboot.setTimeOut(timeOut);
        this._reboot.setDevice(this);
        this._reboot.setObserver(callback);
        this._reboot.setDeviceName(this.deviceSN);
        this._reboot.setDeviceOpenWithFD(this.deviceOpenedWithFD);
        this._reboot.start();
        return ret;
    }

    public int unlock(byte[] secretID, byte[] cipheredSeed) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (secretID == null || cipheredSeed == null) {
            return -5;
        }
        return morphoDeviceNative.unlock(this.morphoDevicePointerCPP.longValue(), secretID, cipheredSeed);
    }

    public int unlock(String secretID, String cipheredSeed) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (secretID == null || cipheredSeed == null) {
            return -5;
        }
        return morphoDeviceNative.unlock(this.morphoDevicePointerCPP.longValue(), secretID.getBytes(), cipheredSeed.getBytes());
    }

    private static final /* synthetic */ int verify_aroundBody12(MorphoDevice ajc$this, int timeOut, int far, Coder coder, int detectModeChoice, int matchingStrategy, TemplateList templateList, int callbackCmd, Observer callback, ResultMatching resultMatching, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (coder == null || templateList == null) {
            return -5;
        }
        return morphoDeviceNative.verify(ajc$this.morphoDevicePointerCPP.longValue(), timeOut, far, coder.getCode(), detectModeChoice, matchingStrategy, templateList, callbackCmd, callback, resultMatching);
    }

    private static final /* synthetic */ int verifyMatch_aroundBody14(MorphoDevice ajc$this, int far, TemplateList templateListSearch, TemplateList templateListReference, Integer matchingScore, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (templateListSearch == null || templateListReference == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(matchingScore).booleanValue()) {
            return -94;
        }
        return morphoDeviceNative.verifyMatch(ajc$this.morphoDevicePointerCPP.longValue(), far, templateListSearch, templateListReference, matchingScore);
    }

    public byte[] getKCV(MorphoKCVID keyID, byte[] secretID) {
        if (this.cppMemOwn && keyID != null) {
            return morphoDeviceNative.getKCV(this.morphoDevicePointerCPP.longValue(), keyID.getCode(), secretID);
        }
        return null;
    }

    public String getKCV(int keyID) {
        return null;
    }

    private static final /* synthetic */ int comSend_aroundBody16(MorphoDevice ajc$this, int timeOut, byte[] data, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (data == null) {
            return -5;
        }
        return morphoDeviceNative.comSend(ajc$this.morphoDevicePointerCPP.longValue(), timeOut, data);
    }

    private static final /* synthetic */ byte[] comReceive_aroundBody18(MorphoDevice ajc$this, int timeOut, JoinPoint joinPoint) {
        if (ajc$this.cppMemOwn) {
            return morphoDeviceNative.comReceive(ajc$this.morphoDevicePointerCPP.longValue(), timeOut);
        }
        return null;
    }

    private static final /* synthetic */ int loadKs_aroundBody20(MorphoDevice ajc$this, byte[] key, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (key == null) {
            return -5;
        }
        return morphoDeviceNative.loadKs(ajc$this.morphoDevicePointerCPP.longValue(), key);
    }

    public int loadKsSecurely(byte[] key) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (key == null) {
            return -5;
        }
        return morphoDeviceNative.loadKsSecurely(this.morphoDevicePointerCPP.longValue(), key);
    }

    public int loadKsSecurely(byte[] key, byte[] signature, byte[] host_certificate) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (key == null || signature == null || host_certificate == null) {
            return -5;
        }
        return morphoDeviceNative.loadKsSecurely(this.morphoDevicePointerCPP.longValue(), key, signature, host_certificate);
    }

    private static final /* synthetic */ int loadMocKey_aroundBody22(MorphoDevice ajc$this, byte[] key_enc_Ciffered_by_Certificate, byte[] key_enc_Ciffered_by_Certificate_Signature, byte[] hostCertificate, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (key_enc_Ciffered_by_Certificate == null || key_enc_Ciffered_by_Certificate_Signature == null || hostCertificate == null) {
            return -5;
        }
        return morphoDeviceNative.loadMocKey(ajc$this.morphoDevicePointerCPP.longValue(), key_enc_Ciffered_by_Certificate, key_enc_Ciffered_by_Certificate_Signature, hostCertificate);
    }

    private static final /* synthetic */ int loadMocKey_aroundBody24(MorphoDevice ajc$this, byte[] key_enc_Ciffered_by_KencTrans, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (key_enc_Ciffered_by_KencTrans == null) {
            return -5;
        }
        return morphoDeviceNative.loadMocKey(ajc$this.morphoDevicePointerCPP.longValue(), key_enc_Ciffered_by_KencTrans);
    }

    public int offeredSecuOpen() {
        if (!this.cppMemOwn) {
            return -98;
        }
        createScreenReceiver();
        return morphoDeviceNative.OfferedSecuOpen(this.morphoDevicePointerCPP.longValue());
    }

    public int offeredSecuClose() {
        if (!this.cppMemOwn) {
            return -98;
        }
        USBManager.getInstance();
        USBManager.unRegister(this.context, this.screenReceiver);
        return morphoDeviceNative.OfferedSecuClose(this.morphoDevicePointerCPP.longValue());
    }

    public int tunnelingOpen(byte[] hostCertificate) {
        if (!this.cppMemOwn) {
            return -98;
        }
        createScreenReceiver();
        return morphoDeviceNative.TunnelingOpen(this.morphoDevicePointerCPP.longValue(), hostCertificate);
    }

    public int tunnelingClose() {
        if (!this.cppMemOwn) {
            return -98;
        }
        USBManager.getInstance();
        USBManager.unRegister(this.context, this.screenReceiver);
        return morphoDeviceNative.TunnelingClose(this.morphoDevicePointerCPP.longValue());
    }
}
