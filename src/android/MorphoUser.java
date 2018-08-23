package com.jcarraca.cordova.plugin;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.Observer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;

@SuppressLint({"UseValueOf"})
public class MorphoUser implements Cloneable {
    private static final /* synthetic */ StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_2 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_3 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_4 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_5 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_6 = null;
    private static MorphoUserNative morphoUserNative = new MorphoUserNative();
    protected boolean cppMemOwn = false;
    private Long morphoUserPointerCPP = new Long(0);
    private String userID;

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("MorphoUser.java", MorphoUser.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "dbDelete", "com.jcarraca.cordova.plugin.MorphoUser", "", "", "", "int"), 204);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "dbStore", "com.jcarraca.cordova.plugin.MorphoUser", "", "", "", "int"), 239);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "enroll", "com.jcarraca.cordova.plugin.MorphoUser", "int:int:int:com.jcarraca.cordova.plugin.CompressionAlgorithm:int:boolean:int:com.jcarraca.cordova.plugin.TemplateType:com.jcarraca.cordova.plugin.TemplateFVPType:boolean:com.jcarraca.cordova.plugin.Coder:int:com.jcarraca.cordova.plugin.TemplateList:int:java.util.Observer", "timeout:acquisitionThreshold:advancedSecurityLevelsRequired:compressAlgo:compressRate:exportMinutiae:fingerNumber:templateType:templateFVPType:saveRecord:coder:detectModeChoice:templateList:callbackCmd:callback", "", "int"), 351);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "enroll", "com.jcarraca.cordova.plugin.MorphoUser", "int:int:int:com.jcarraca.cordova.plugin.CompressionAlgorithm:int:int:int:com.jcarraca.cordova.plugin.TemplateType:com.jcarraca.cordova.plugin.TemplateFVPType:boolean:com.jcarraca.cordova.plugin.Coder:int:com.jcarraca.cordova.plugin.TemplateList:int:java.util.Observer", "timeout:acquisitionThreshold:advancedSecurityLevelsRequired:compressAlgo:compressRate:exportMinutiae:fingerNumber:templateType:templateFVPType:saveRecord:coder:detectModeChoice:templateList:callbackCmd:callback", "", "int"), 458);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "verify", "com.jcarraca.cordova.plugin.MorphoUser", "int:int:com.jcarraca.cordova.plugin.Coder:int:com.jcarraca.cordova.plugin.MatchingStrategy:int:java.util.Observer:com.jcarraca.cordova.plugin.ResultMatching", "timeout:far:coder:detectModeChoice:matchingStrategy:callbackCmd:callback:resultMatching", "", "int"), 519);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "dbUpdatePublicFields", "com.jcarraca.cordova.plugin.MorphoUser", "", "", "", "int"), 580);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "dbVerifyAndUpdate", "com.jcarraca.cordova.plugin.MorphoUser", "int:int:com.jcarraca.cordova.plugin.Coder:int:com.jcarraca.cordova.plugin.MatchingStrategy:int:java.util.Observer", "timeout:far:coder:detectModeChoice:matchingStrategy:callbackCmd:callback", "", "int"), 628);
    }

    @WakeLockabble
    public int dbDelete() {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_0, this, this);
        return Conversions.intValue(dbDelete_aroundBody1$advice(this, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int dbStore() {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_1, this, this);
        return Conversions.intValue(dbStore_aroundBody3$advice(this, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int dbUpdatePublicFields() {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_5, this, this);
        return Conversions.intValue(dbUpdatePublicFields_aroundBody11$advice(this, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int dbVerifyAndUpdate(int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_6, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeout), Conversions.intObject(far), coder, Conversions.intObject(detectModeChoice), matchingStrategy, Conversions.intObject(callbackCmd), callback});
        return Conversions.intValue(dbVerifyAndUpdate_aroundBody13$advice(this, timeout, far, coder, detectModeChoice, matchingStrategy, callbackCmd, callback, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int enroll(int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, CompressionAlgorithm compressAlgo, int compressRate, int exportMinutiae, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, boolean saveRecord, Coder coder, int detectModeChoice, TemplateList templateList, int callbackCmd, Observer callback) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_3, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeout), Conversions.intObject(acquisitionThreshold), Conversions.intObject(advancedSecurityLevelsRequired), compressAlgo, Conversions.intObject(compressRate), Conversions.intObject(exportMinutiae), Conversions.intObject(fingerNumber), templateType, templateFVPType, Conversions.booleanObject(saveRecord), coder, Conversions.intObject(detectModeChoice), templateList, Conversions.intObject(callbackCmd), callback});
        return Conversions.intValue(enroll_aroundBody7$advice(this, timeout, acquisitionThreshold, advancedSecurityLevelsRequired, compressAlgo, compressRate, exportMinutiae, fingerNumber, templateType, templateFVPType, saveRecord, coder, detectModeChoice, templateList, callbackCmd, callback, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int enroll(int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, CompressionAlgorithm compressAlgo, int compressRate, boolean exportMinutiae, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, boolean saveRecord, Coder coder, int detectModeChoice, TemplateList templateList, int callbackCmd, Observer callback) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_2, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeout), Conversions.intObject(acquisitionThreshold), Conversions.intObject(advancedSecurityLevelsRequired), compressAlgo, Conversions.intObject(compressRate), Conversions.booleanObject(exportMinutiae), Conversions.intObject(fingerNumber), templateType, templateFVPType, Conversions.booleanObject(saveRecord), coder, Conversions.intObject(detectModeChoice), templateList, Conversions.intObject(callbackCmd), callback});
        return Conversions.intValue(enroll_aroundBody5$advice(this, timeout, acquisitionThreshold, advancedSecurityLevelsRequired, compressAlgo, compressRate, exportMinutiae, fingerNumber, templateType, templateFVPType, saveRecord, coder, detectModeChoice, templateList, callbackCmd, callback, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int verify(int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, ResultMatching resultMatching) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_4, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeout), Conversions.intObject(far), coder, Conversions.intObject(detectModeChoice), matchingStrategy, Conversions.intObject(callbackCmd), callback, resultMatching});
        return Conversions.intValue(verify_aroundBody9$advice(this, timeout, far, coder, detectModeChoice, matchingStrategy, callbackCmd, callback, resultMatching, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    static {
        ajc$preClinit();
    }

    public MorphoUser() {
        long cppPtr = morphoUserNative.getCPPInstance();
        if (cppPtr != 0) {
            this.cppMemOwn = true;
            this.morphoUserPointerCPP = Long.valueOf(cppPtr);
            return;
        }
        try {
            throw new MorphoSmartException("classe non instantiÃƒÂ©");
        } catch (MorphoSmartException e) {
            e.printStackTrace();
        }
    }

    public MorphoUser(String userID) {
        if (userID == null) {
            try {
                throw new MorphoSmartException("USer ID object is null");
            } catch (MorphoSmartException e) {
                e.printStackTrace();
                return;
            }
        }
        long cppPtr = morphoUserNative.getCPPInstance(userID);
        if (cppPtr != 0) {
            this.cppMemOwn = true;
            this.morphoUserPointerCPP = Long.valueOf(cppPtr);
            this.userID = userID;
            return;
        }
        try {
            throw new MorphoSmartException("cppPtr is null");
        } catch (MorphoSmartException e2) {
            e2.printStackTrace();
        }
    }

    private static final /* synthetic */ Object dbDelete_aroundBody1$advice(MorphoUser ajc$this, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(dbDelete_aroundBody0(ajc$this, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object dbStore_aroundBody3$advice(MorphoUser ajc$this, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(dbStore_aroundBody2(ajc$this, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object dbUpdatePublicFields_aroundBody11$advice(MorphoUser ajc$this, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(dbUpdatePublicFields_aroundBody10(ajc$this, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object dbVerifyAndUpdate_aroundBody13$advice(MorphoUser ajc$this, int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(dbVerifyAndUpdate_aroundBody12(ajc$this, timeout, far, coder, detectModeChoice, matchingStrategy, callbackCmd, callback, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object enroll_aroundBody5$advice(MorphoUser ajc$this, int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, CompressionAlgorithm compressAlgo, int compressRate, boolean exportMinutiae, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, boolean saveRecord, Coder coder, int detectModeChoice, TemplateList templateList, int callbackCmd, Observer callback, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(enroll_aroundBody4(ajc$this, timeout, acquisitionThreshold, advancedSecurityLevelsRequired, compressAlgo, compressRate, exportMinutiae, fingerNumber, templateType, templateFVPType, saveRecord, coder, detectModeChoice, templateList, callbackCmd, callback, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object enroll_aroundBody7$advice(MorphoUser ajc$this, int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, CompressionAlgorithm compressAlgo, int compressRate, int exportMinutiae, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, boolean saveRecord, Coder coder, int detectModeChoice, TemplateList templateList, int callbackCmd, Observer callback, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(enroll_aroundBody6(ajc$this, timeout, acquisitionThreshold, advancedSecurityLevelsRequired, compressAlgo, compressRate, exportMinutiae, fingerNumber, templateType, templateFVPType, saveRecord, coder, detectModeChoice, templateList, callbackCmd, callback, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object verify_aroundBody9$advice(MorphoUser ajc$this, int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, ResultMatching resultMatching, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(verify_aroundBody8(ajc$this, timeout, far, coder, detectModeChoice, matchingStrategy, callbackCmd, callback, resultMatching, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    public MorphoUser(MorphoUser user) {
        if (user == null) {
            try {
                throw new MorphoSmartException("MorphoUser object is null");
            } catch (MorphoSmartException e) {
                e.printStackTrace();
            }
        } else if (user.cppMemOwn) {
            try {
                throw new MorphoSmartException("cppMemOwn is true");
            } catch (MorphoSmartException e2) {
                e2.printStackTrace();
            }
        } else {
            long cppPtr = morphoUserNative.getCPPInstance(user.morphoUserPointerCPP.longValue());
            if (cppPtr != 0) {
                this.cppMemOwn = true;
                this.morphoUserPointerCPP = Long.valueOf(cppPtr);
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
            morphoUserNative.deleteInstance(this.morphoUserPointerCPP.longValue());
            this.cppMemOwn = false;
        }
    }

    public Object clone() {
        return new MorphoUser(this);
    }

    public void setMorphoUserPointerCPP(long morphoUserPointerCPP) {
        this.morphoUserPointerCPP = Long.valueOf(morphoUserPointerCPP);
        this.cppMemOwn = true;
    }

    public String getUserID() {
        return this.userID;
    }

    public long getMorphoUserPointerCPP() {
        return this.morphoUserPointerCPP.longValue();
    }

    public int cancelLiveAcquisition() {
        if (this.cppMemOwn) {
            return morphoUserNative.cancelLiveAcquisition(this.morphoUserPointerCPP.longValue());
        }
        return -98;
    }

    private static final /* synthetic */ int dbDelete_aroundBody0(MorphoUser ajc$this, JoinPoint joinPoint) {
        if (ajc$this.cppMemOwn) {
            return morphoUserNative.dbDelete(ajc$this.morphoUserPointerCPP.longValue());
        }
        return -98;
    }

    private static final /* synthetic */ int dbStore_aroundBody2(MorphoUser ajc$this, JoinPoint joinPoint) {
        if (ajc$this.cppMemOwn) {
            return morphoUserNative.dbStore(ajc$this.morphoUserPointerCPP.longValue());
        }
        return -98;
    }

    public int setNoCheckOnTemplateForDBStore(boolean noCheckOnTemplate) {
        if (this.cppMemOwn) {
            return morphoUserNative.setNoCheckOnTemplateForDBStore(this.morphoUserPointerCPP.longValue(), noCheckOnTemplate);
        }
        return -98;
    }

    public int putField(int fieldIndex, String fieldData) {
        if (this.cppMemOwn) {
            return morphoUserNative.putField(this.morphoUserPointerCPP.longValue(), fieldIndex, fieldData);
        }
        return -98;
    }

    public int putBufferField(int fieldIndex, byte[] fieldData) {
        if (this.cppMemOwn) {
            return morphoUserNative.putBufferField(this.morphoUserPointerCPP.longValue(), fieldIndex, fieldData);
        }
        return -98;
    }

    public String getField(int fieldIndex) throws MorphoSmartException {
        MorphoString fieldData = new MorphoString();
        int ret = morphoUserNative.getField(this.morphoUserPointerCPP.longValue(), fieldIndex, fieldData);
        if (ret == 0) {
            return fieldData.getData();
        }
        throw new MorphoSmartException(ErrorCodes.getError(ret, 0));
    }

    public byte[] getBufferField(int fieldIndex) throws MorphoSmartException {
        MorphoString fieldData = new MorphoString();
        int ret = morphoUserNative.getBufferField(this.morphoUserPointerCPP.longValue(), fieldIndex, fieldData);
        if (ret == 0) {
            return fieldData.getBufferData();
        }
        throw new MorphoSmartException(ErrorCodes.getError(ret, 0));
    }

    private static final /* synthetic */ int enroll_aroundBody4(MorphoUser ajc$this, int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, CompressionAlgorithm compressAlgo, int compressRate, boolean exportMinutiae, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, boolean saveRecord, Coder coder, int detectModeChoice, TemplateList templateList, int callbackCmd, Observer callback, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (compressAlgo == null || templateType == null || templateFVPType == null || coder == null || templateList == null) {
            return -5;
        }
        int exportMinutiaeInt = 0;
        if (exportMinutiae) {
            exportMinutiaeInt = 1;
        }
        return morphoUserNative.enroll(ajc$this.morphoUserPointerCPP.longValue(), timeout, acquisitionThreshold, advancedSecurityLevelsRequired, compressAlgo.getCode(), compressRate, exportMinutiaeInt, fingerNumber, templateType.getCode(), templateFVPType.getCode(), saveRecord, coder.getCode(), detectModeChoice, templateList, callbackCmd, callback);
    }

    private static final /* synthetic */ int enroll_aroundBody6(MorphoUser ajc$this, int timeout, int acquisitionThreshold, int advancedSecurityLevelsRequired, CompressionAlgorithm compressAlgo, int compressRate, int exportMinutiae, int fingerNumber, TemplateType templateType, TemplateFVPType templateFVPType, boolean saveRecord, Coder coder, int detectModeChoice, TemplateList templateList, int callbackCmd, Observer callback, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (compressAlgo == null || templateType == null || templateFVPType == null || coder == null || templateList == null) {
            return -5;
        }
        return morphoUserNative.enroll(ajc$this.morphoUserPointerCPP.longValue(), timeout, acquisitionThreshold, advancedSecurityLevelsRequired, compressAlgo.getCode(), compressRate, exportMinutiae, fingerNumber, templateType.getCode(), templateFVPType.getCode(), saveRecord, coder.getCode(), detectModeChoice, templateList, callbackCmd, callback);
    }

    private static final /* synthetic */ int verify_aroundBody8(MorphoUser ajc$this, int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, ResultMatching resultMatching, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (coder == null || matchingStrategy == null) {
            return -5;
        }
        return morphoUserNative.verify(ajc$this.morphoUserPointerCPP.longValue(), timeout, far, coder.getCode(), detectModeChoice, matchingStrategy.getValue(), callbackCmd, callback, resultMatching);
    }

    public int putTemplate(Template template, Integer templateIndex) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (template == null || templateIndex == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(templateIndex).booleanValue()) {
            return -94;
        }
        return morphoUserNative.putTemplate(this.morphoUserPointerCPP.longValue(), template, templateIndex);
    }

    private static final /* synthetic */ int dbUpdatePublicFields_aroundBody10(MorphoUser ajc$this, JoinPoint joinPoint) {
        if (ajc$this.cppMemOwn) {
            return morphoUserNative.dbUpdatePublicFields(ajc$this.morphoUserPointerCPP.longValue());
        }
        return -98;
    }

    private static final /* synthetic */ int dbVerifyAndUpdate_aroundBody12(MorphoUser ajc$this, int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (coder == null || matchingStrategy == null) {
            return -5;
        }
        return morphoUserNative.dbVerifyAndUpdate(ajc$this.morphoUserPointerCPP.longValue(), timeout, far, coder.getCode(), detectModeChoice, matchingStrategy.getValue(), callbackCmd, callback);
    }

    public int getEnrollmentType() {
        if (this.cppMemOwn) {
            return morphoUserNative.getEnrollmentType(this.morphoUserPointerCPP.longValue());
        }
        return -98;
    }

    public int setEnrollmentType(EnrollmentType enrollmentType) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (enrollmentType == null) {
            return -5;
        }
        return morphoUserNative.setEnrollmentType(this.morphoUserPointerCPP.longValue(), enrollmentType.getValue());
    }

    public int getUserTemplateQuality(int indexDB, String userID, int userIdSize, long userIndex, TemplateQuality templateQuality, FingerNumber fingerNumber) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (userID == null || templateQuality == null || fingerNumber == null) {
            return -5;
        }
        return morphoUserNative.getUserTemplateQuality(this.morphoUserPointerCPP.longValue(), indexDB, userID, userIdSize, userIndex, templateQuality, fingerNumber);
    }

    public int putFVPTemplate(TemplateFVP templateFVP, Integer templateFVPIndex) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (templateFVP == null || templateFVPIndex == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(templateFVPIndex).booleanValue()) {
            return -94;
        }
        return morphoUserNative.putFVPTemplate(this.morphoUserPointerCPP.longValue(), templateFVP, templateFVPIndex);
    }

    public int getTemplate(int templateIndex, Template template) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (template == null) {
            return -5;
        }
        return morphoUserNative.getTemplate(this.morphoUserPointerCPP.longValue(), templateIndex, template);
    }

    public int getFVPTemplate(int templateIndex, TemplateFVP templateFVP) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (templateFVP == null) {
            return -5;
        }
        return morphoUserNative.getFVPTemplate(this.morphoUserPointerCPP.longValue(), templateIndex, templateFVP);
    }

    public int getNbTemplate(Integer nbTemplate) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (nbTemplate == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(nbTemplate).booleanValue()) {
            return -94;
        }
        return morphoUserNative.getNbTemplate(this.morphoUserPointerCPP.longValue(), nbTemplate);
    }

    public int getNbTemplateFVP(Integer nbTemplateFVP) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (nbTemplateFVP == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(nbTemplateFVP).booleanValue()) {
            return -94;
        }
        return morphoUserNative.getNbTemplateFVP(this.morphoUserPointerCPP.longValue(), nbTemplateFVP);
    }

    public int setTemplateUpdateMask(boolean[] fingerprintUpdateMask) {
        if (this.cppMemOwn) {
            return morphoUserNative.setTemplateUpdateMask(this.morphoUserPointerCPP.longValue(), fingerprintUpdateMask);
        }
        return -98;
    }
}
