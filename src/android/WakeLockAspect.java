package com.jcarraca.cordova.plugin;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class WakeLockAspect {
    private static final String TAG = WakeLockAspect.class.getSimpleName();
    private static /* synthetic */ Throwable ajc$initFailureCause;
    public static final /* synthetic */ WakeLockAspect ajc$perSingletonInstance = null;
    private WakeLock wakeLock = null;

    public static WakeLockAspect aspectOf() {
        if (ajc$perSingletonInstance != null) {
            return ajc$perSingletonInstance;
        }
        throw new NoAspectBoundException("com.jcarraca.cordova.plugin.WakeLockAspect", ajc$initFailureCause);
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    static {
        try {
            ajc$perSingletonInstance = new WakeLockAspect();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    void acquireWakeLock() {
        USBManager.getInstance();
        if (USBManager.WakeLockEnabled) {
            try {
                this.wakeLock = ((PowerManager) USBManager.context.getSystemService("power")).newWakeLock(1, "CaptureWakelockTag");
                this.wakeLock.acquire();
                Log.e(TAG, "Creates and Acquires a new wake lock.");
                return;
            } catch (Exception e) {
                Log.e(TAG, "Failed to acquire wakelock : " + e.getMessage());
                return;
            }
        }
        Log.e(TAG, "Wakelock not used");
    }

    void releaseWakeLock() {
        USBManager.getInstance();
        if (!USBManager.WakeLockEnabled) {
            Log.e(TAG, "Wakelock not used");
        } else if (this.wakeLock != null) {
            try {
                this.wakeLock.release();
                Log.e(TAG, "Releases the wake lock.");
            } catch (Exception e) {
                Log.e(TAG, "Failed to release wakelock : " + e.getMessage());
            }
            this.wakeLock = null;
        }
    }

    @Pointcut("@annotation(WakeLockabble)")
    public /* synthetic */ void annotationPointCutDefinition() {
    }

    @Pointcut("execution(* *(..))")
    public /* synthetic */ void atExecution() {
    }

    @Around("@annotation(WakeLockabble) && execution(* *(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnObject = null;
        try {
            acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = joinPoint.proceed();
            return returnObject;
        } catch (Throwable th) {
        } finally {
            releaseWakeLock();
        }
    }
}
