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
public class MorphoDatabase implements Cloneable {
    public static final int MORPHO_FINGER_MAX = 2;
    public static final int MORPHO_LEN_FIELD_MAX = 128;
    public static final int MORPHO_NB_DATABASE_MAX = 5;
    public static final int MORPHO_NB_FIELD_MAX = 20;
    public static final int MORPHO_NB_RECORD_MIN = 1;
    private static final /* synthetic */ StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_2 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_3 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_4 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_5 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_6 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_7 = null;
    private static MorphoDatabaseNative morphoDatabaseNative = new MorphoDatabaseNative();
    protected boolean cppMemOwn = false;
    private Long morphoDatabasePointerCPP = new Long(0);

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("MorphoDatabase.java", MorphoDatabase.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "dbCreate", "com.jcarraca.cordova.plugin.MorphoDatabase", "int:int:com.jcarraca.cordova.plugin.TemplateType:int:boolean", "maxRecord:maxNbFinger:templateType:dataBaseIndex:encryptDB", "", "int"), 273);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "dbCreate", "com.jcarraca.cordova.plugin.MorphoDatabase", "int:int:com.jcarraca.cordova.plugin.TemplateType:int", "maxRecord:maxNbFinger:templateType:dataBaseIndex", "", "int"), 292);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "dbCreate", "com.jcarraca.cordova.plugin.MorphoDatabase", "int:int:com.jcarraca.cordova.plugin.TemplateType", "maxRecord:maxNbFinger:templateType", "", "int"), 311);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "dbDelete", "com.jcarraca.cordova.plugin.MorphoDatabase", "com.jcarraca.cordova.plugin.MorphoTypeDeletion", "morphoTypeDeletion", "", "int"), 368);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "identify", "com.jcarraca.cordova.plugin.MorphoDatabase", "int:int:com.jcarraca.cordova.plugin.Coder:int:com.jcarraca.cordova.plugin.MatchingStrategy:int:java.util.Observer:com.jcarraca.cordova.plugin.ResultMatching:int:com.jcarraca.cordova.plugin.MorphoUser", "timeout:far:coder:detectModeChoice:matchingStrategy:callbackCmd:callback:resultMatching:nbFingersToMatch:morphoUser", "", "int"), 423);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "identify", "com.jcarraca.cordova.plugin.MorphoDatabase", "int:int:com.jcarraca.cordova.plugin.Coder:int:com.jcarraca.cordova.plugin.MatchingStrategy:int:java.util.Observer:com.jcarraca.cordova.plugin.ResultMatching:com.jcarraca.cordova.plugin.MorphoUser", "timeout:far:coder:detectModeChoice:matchingStrategy:callbackCmd:callback:resultMatching:morphoUser", "", "int"), 442);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "identifyMatch", "com.jcarraca.cordova.plugin.MorphoDatabase", "int:com.jcarraca.cordova.plugin.TemplateList:com.jcarraca.cordova.plugin.MorphoUser:com.jcarraca.cordova.plugin.ResultMatching", "far:templateList:morphoUser:resultMatching", "", "int"), 479);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "identifyMatch", "com.jcarraca.cordova.plugin.MorphoDatabase", "int:com.jcarraca.cordova.plugin.TemplateList:com.jcarraca.cordova.plugin.MorphoUser", "far:templateList:morphoUser", "", "int"), 498);
    }

    @WakeLockabble
    public int dbCreate(int maxRecord, int maxNbFinger, TemplateType templateType) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_2, (Object) this, (Object) this, new Object[]{Conversions.intObject(maxRecord), Conversions.intObject(maxNbFinger), templateType});
        return Conversions.intValue(dbCreate_aroundBody5$advice(this, maxRecord, maxNbFinger, templateType, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int dbCreate(int maxRecord, int maxNbFinger, TemplateType templateType, int dataBaseIndex) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_1, (Object) this, (Object) this, new Object[]{Conversions.intObject(maxRecord), Conversions.intObject(maxNbFinger), templateType, Conversions.intObject(dataBaseIndex)});
        return Conversions.intValue(dbCreate_aroundBody3$advice(this, maxRecord, maxNbFinger, templateType, dataBaseIndex, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int dbCreate(int maxRecord, int maxNbFinger, TemplateType templateType, int dataBaseIndex, boolean encryptDB) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_0, (Object) this, (Object) this, new Object[]{Conversions.intObject(maxRecord), Conversions.intObject(maxNbFinger), templateType, Conversions.intObject(dataBaseIndex), Conversions.booleanObject(encryptDB)});
        return Conversions.intValue(dbCreate_aroundBody1$advice(this, maxRecord, maxNbFinger, templateType, dataBaseIndex, encryptDB, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int dbDelete(MorphoTypeDeletion morphoTypeDeletion) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_3, (Object) this, (Object) this, (Object) morphoTypeDeletion);
        return Conversions.intValue(dbDelete_aroundBody7$advice(this, morphoTypeDeletion, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int identify(int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, ResultMatching resultMatching, int nbFingersToMatch, MorphoUser morphoUser) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_4, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeout), Conversions.intObject(far), coder, Conversions.intObject(detectModeChoice), matchingStrategy, Conversions.intObject(callbackCmd), callback, resultMatching, Conversions.intObject(nbFingersToMatch), morphoUser});
        return Conversions.intValue(identify_aroundBody9$advice(this, timeout, far, coder, detectModeChoice, matchingStrategy, callbackCmd, callback, resultMatching, nbFingersToMatch, morphoUser, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int identify(int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, ResultMatching resultMatching, MorphoUser morphoUser) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_5, (Object) this, (Object) this, new Object[]{Conversions.intObject(timeout), Conversions.intObject(far), coder, Conversions.intObject(detectModeChoice), matchingStrategy, Conversions.intObject(callbackCmd), callback, resultMatching, morphoUser});
        return Conversions.intValue(identify_aroundBody11$advice(this, timeout, far, coder, detectModeChoice, matchingStrategy, callbackCmd, callback, resultMatching, morphoUser, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int identifyMatch(int far, TemplateList templateList, MorphoUser morphoUser) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_7, (Object) this, (Object) this, new Object[]{Conversions.intObject(far), templateList, morphoUser});
        return Conversions.intValue(identifyMatch_aroundBody15$advice(this, far, templateList, morphoUser, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    @WakeLockabble
    public int identifyMatch(int far, TemplateList templateList, MorphoUser morphoUser, ResultMatching resultMatching) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_6, (Object) this, (Object) this, new Object[]{Conversions.intObject(far), templateList, morphoUser, resultMatching});
        return Conversions.intValue(identifyMatch_aroundBody13$advice(this, far, templateList, morphoUser, resultMatching, makeJP, WakeLockAspect.aspectOf(), (ProceedingJoinPoint) makeJP));
    }

    static {
        ajc$preClinit();
    }

    public MorphoDatabase() {
        long cppPtr = morphoDatabaseNative.getCPPInstance();
        if (cppPtr != 0) {
            this.cppMemOwn = true;
            this.morphoDatabasePointerCPP = Long.valueOf(cppPtr);
            return;
        }
        try {
            throw new MorphoSmartException("cppPtr is null");
        } catch (MorphoSmartException e) {
            e.printStackTrace();
        }
    }

    public MorphoDatabase(MorphoDatabase database) {
        if (database == null) {
            try {
                throw new MorphoSmartException("MorphoDatabase object is null");
            } catch (MorphoSmartException e) {
                e.printStackTrace();
            }
        } else if (!database.cppMemOwn) {
            long cppPtr = morphoDatabaseNative.getCPPInstance(database.morphoDatabasePointerCPP.longValue());
            if (cppPtr != 0) {
                this.cppMemOwn = true;
                this.morphoDatabasePointerCPP = Long.valueOf(cppPtr);
                return;
            }
            try {
                throw new MorphoSmartException("cppPtr is null");
            } catch (MorphoSmartException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static final /* synthetic */ Object dbCreate_aroundBody1$advice(MorphoDatabase ajc$this, int maxRecord, int maxNbFinger, TemplateType templateType, int dataBaseIndex, boolean encryptDB, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(dbCreate_aroundBody0(ajc$this, maxRecord, maxNbFinger, templateType, dataBaseIndex, encryptDB, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object dbCreate_aroundBody3$advice(MorphoDatabase ajc$this, int maxRecord, int maxNbFinger, TemplateType templateType, int dataBaseIndex, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(dbCreate_aroundBody2(ajc$this, maxRecord, maxNbFinger, templateType, dataBaseIndex, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object dbCreate_aroundBody5$advice(MorphoDatabase ajc$this, int maxRecord, int maxNbFinger, TemplateType templateType, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(dbCreate_aroundBody4(ajc$this, maxRecord, maxNbFinger, templateType, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object dbDelete_aroundBody7$advice(MorphoDatabase ajc$this, MorphoTypeDeletion morphoTypeDeletion, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(dbDelete_aroundBody6(ajc$this, morphoTypeDeletion, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object identifyMatch_aroundBody13$advice(MorphoDatabase ajc$this, int far, TemplateList templateList, MorphoUser morphoUser, ResultMatching resultMatching, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(identifyMatch_aroundBody12(ajc$this, far, templateList, morphoUser, resultMatching, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object identifyMatch_aroundBody15$advice(MorphoDatabase ajc$this, int far, TemplateList templateList, MorphoUser morphoUser, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(identifyMatch_aroundBody14(ajc$this, far, templateList, morphoUser, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object identify_aroundBody11$advice(MorphoDatabase ajc$this, int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, ResultMatching resultMatching, MorphoUser morphoUser, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(identify_aroundBody10(ajc$this, timeout, far, coder, detectModeChoice, matchingStrategy, callbackCmd, callback, resultMatching, morphoUser, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    private static final /* synthetic */ Object identify_aroundBody9$advice(MorphoDatabase ajc$this, int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, ResultMatching resultMatching, int nbFingersToMatch, MorphoUser morphoUser, JoinPoint thisJoinPoint, WakeLockAspect ajc$aspectInstance, ProceedingJoinPoint joinPoint) {
        Object returnObject = null;
        try {
            ajc$aspectInstance.acquireWakeLock();
            String packageName = joinPoint.getSignature().getDeclaringTypeName();
            Log.e(WakeLockAspect.TAG, "Entering method [" + packageName + "." + joinPoint.getSignature().getName() + "]");
            returnObject = Conversions.intObject(identify_aroundBody8(ajc$this, timeout, far, coder, detectModeChoice, matchingStrategy, callbackCmd, callback, resultMatching, nbFingersToMatch, morphoUser, joinPoint));
            return returnObject;
        } catch (Throwable th) {
        } finally {
            ajc$aspectInstance.releaseWakeLock();
        }
    }

    protected void finalize() {
        if (this.cppMemOwn) {
            morphoDatabaseNative.deleteInstance(this.morphoDatabasePointerCPP.longValue());
            this.cppMemOwn = false;
        }
    }

    public Object clone() {
        return new MorphoDatabase(this);
    }

    public long getMorphoDatabasePointerCPP() {
        return this.morphoDatabasePointerCPP.longValue();
    }

    public void setMorphoDatabasePointerCPP(long morphoDatabasePointerCPP) {
        this.morphoDatabasePointerCPP = Long.valueOf(morphoDatabasePointerCPP);
        this.cppMemOwn = true;
    }

    public int getUser(String userID, MorphoUser morphoUser) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (morphoUser == null) {
            return -5;
        }
        return morphoDatabaseNative.getUser(this.morphoDatabasePointerCPP.longValue(), userID, morphoUser);
    }

    public int putField(MorphoField morphoField, Integer index) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (index == null || morphoField == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(index).booleanValue()) {
            return -94;
        }
        return morphoDatabaseNative.putField(this.morphoDatabasePointerCPP.longValue(), morphoField, index);
    }

    public int getField(int index, MorphoField morphoField) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (morphoField == null) {
            return -5;
        }
        return morphoDatabaseNative.getField(this.morphoDatabasePointerCPP.longValue(), index, morphoField);
    }

    public int getDbEncryptionStatus(Integer encryptDB) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (encryptDB == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(encryptDB).booleanValue()) {
            return -94;
        }
        return morphoDatabaseNative.getDbEncryptionStatus(this.morphoDatabasePointerCPP.longValue(), encryptDB);
    }

    private static final /* synthetic */ int dbCreate_aroundBody0(MorphoDatabase ajc$this, int maxRecord, int maxNbFinger, TemplateType templateType, int dataBaseIndex, boolean encryptDB, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (templateType == null) {
            return -5;
        }
        return morphoDatabaseNative.dbCreate(ajc$this.morphoDatabasePointerCPP.longValue(), maxRecord, maxNbFinger, templateType.getCode(), dataBaseIndex, !encryptDB ? 0 : 1);
    }

    private static final /* synthetic */ int dbCreate_aroundBody2(MorphoDatabase ajc$this, int maxRecord, int maxNbFinger, TemplateType templateType, int dataBaseIndex, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (templateType == null) {
            return -5;
        }
        return morphoDatabaseNative.dbCreate(ajc$this.morphoDatabasePointerCPP.longValue(), maxRecord, maxNbFinger, templateType.getCode(), dataBaseIndex, 0);
    }

    private static final /* synthetic */ int dbCreate_aroundBody4(MorphoDatabase ajc$this, int maxRecord, int maxNbFinger, TemplateType templateType, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (templateType == null) {
            return -5;
        }
        return morphoDatabaseNative.dbCreate(ajc$this.morphoDatabasePointerCPP.longValue(), maxRecord, maxNbFinger, templateType.getCode(), 0, 0);
    }

    public int readPublicFields(int[] fieldsIndex, MorphoUserList morphoUserList) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (morphoUserList == null || fieldsIndex == null) {
            return -5;
        }
        return morphoDatabaseNative.readPublicFields(this.morphoDatabasePointerCPP.longValue(), fieldsIndex, morphoUserList);
    }

    private static final /* synthetic */ int dbDelete_aroundBody6(MorphoDatabase ajc$this, MorphoTypeDeletion morphoTypeDeletion, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (morphoTypeDeletion == null) {
            return -5;
        }
        return morphoDatabaseNative.dbDelete(ajc$this.morphoDatabasePointerCPP.longValue(), morphoTypeDeletion.ordinal());
    }

    private static final /* synthetic */ int identify_aroundBody8(MorphoDatabase ajc$this, int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, ResultMatching resultMatching, int nbFingersToMatch, MorphoUser morphoUser, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (coder == null || matchingStrategy == null || morphoUser == null) {
            return -5;
        }
        return morphoDatabaseNative.identify(ajc$this.morphoDatabasePointerCPP.longValue(), timeout, far, coder.getCode(), detectModeChoice, matchingStrategy.getValue(), callbackCmd, callback, resultMatching, morphoUser, nbFingersToMatch);
    }

    private static final /* synthetic */ int identify_aroundBody10(MorphoDatabase ajc$this, int timeout, int far, Coder coder, int detectModeChoice, MatchingStrategy matchingStrategy, int callbackCmd, Observer callback, ResultMatching resultMatching, MorphoUser morphoUser, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (coder == null || matchingStrategy == null || morphoUser == null) {
            return -5;
        }
        return morphoDatabaseNative.identify(ajc$this.morphoDatabasePointerCPP.longValue(), timeout, far, coder.getCode(), detectModeChoice, matchingStrategy.getValue(), callbackCmd, callback, resultMatching, morphoUser, -1);
    }

    private static final /* synthetic */ int identifyMatch_aroundBody12(MorphoDatabase ajc$this, int far, TemplateList templateList, MorphoUser morphoUser, ResultMatching resultMatching, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (templateList == null || morphoUser == null) {
            return -5;
        }
        return morphoDatabaseNative.identifyMatch(ajc$this.morphoDatabasePointerCPP.longValue(), far, templateList, morphoUser, resultMatching);
    }

    private static final /* synthetic */ int identifyMatch_aroundBody14(MorphoDatabase ajc$this, int far, TemplateList templateList, MorphoUser morphoUser, JoinPoint joinPoint) {
        if (!ajc$this.cppMemOwn) {
            return -98;
        }
        if (templateList == null || morphoUser == null) {
            return -5;
        }
        return morphoDatabaseNative.identifyMatch(ajc$this.morphoDatabasePointerCPP.longValue(), far, templateList, morphoUser, null);
    }

    public int cancelLiveAcquisition() {
        if (this.cppMemOwn) {
            return morphoDatabaseNative.cancelLiveAcquisition(this.morphoDatabasePointerCPP.longValue());
        }
        return -98;
    }

    public int dbQueryFirst(int fieldIndex, String dataToFind, MorphoUser morphoUser) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (morphoUser == null || dataToFind == null) {
            return -5;
        }
        return morphoDatabaseNative.dbQueryFirst(this.morphoDatabasePointerCPP.longValue(), fieldIndex, dataToFind, morphoUser);
    }

    public int dbQueryNext(MorphoUser morphoUser) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (morphoUser == null) {
            return -5;
        }
        return morphoDatabaseNative.dbQueryNext(this.morphoDatabasePointerCPP.longValue(), morphoUser);
    }

    public int getFormatPK(Integer templateType) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (templateType == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(templateType).booleanValue()) {
            return -94;
        }
        return morphoDatabaseNative.getFormatPK(this.morphoDatabasePointerCPP.longValue(), templateType);
    }

    public int getMaxDataBase(Integer maxdataBase) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (maxdataBase == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(maxdataBase).booleanValue()) {
            return -94;
        }
        return morphoDatabaseNative.getMaxDataBase(this.morphoDatabasePointerCPP.longValue(), maxdataBase);
    }

    public int getMaxUser(Integer maxUser, Integer maxFinger) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (maxUser == null || maxFinger == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(maxUser).booleanValue() || ErrorCodes.IntegrerInitializationValueOf(maxFinger).booleanValue()) {
            return -94;
        }
        return morphoDatabaseNative.getMaxUser(this.morphoDatabasePointerCPP.longValue(), maxUser, maxFinger);
    }

    public int getMaxUser(Integer maxUser) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (maxUser == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(maxUser).booleanValue()) {
            return -94;
        }
        return morphoDatabaseNative.getMaxUser(this.morphoDatabasePointerCPP.longValue(), maxUser, null);
    }

    public int getNbField(Long nbField) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (nbField == null) {
            return -5;
        }
        if (ErrorCodes.LongInitializationValueOf(nbField).booleanValue()) {
            return -93;
        }
        return morphoDatabaseNative.getNbField(this.morphoDatabasePointerCPP.longValue(), nbField);
    }

    public int getNbFinger(Integer nbFinger) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (nbFinger == null) {
            return -5;
        }
        if (ErrorCodes.IntegrerInitializationValueOf(nbFinger).booleanValue()) {
            return -94;
        }
        return morphoDatabaseNative.getNbFinger(this.morphoDatabasePointerCPP.longValue(), nbFinger);
    }

    public int getNbFreeRecord(Long nbFreeRecord) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (nbFreeRecord == null) {
            return -5;
        }
        if (ErrorCodes.LongInitializationValueOf(nbFreeRecord).booleanValue()) {
            return -93;
        }
        return morphoDatabaseNative.getNbFreeRecord(this.morphoDatabasePointerCPP.longValue(), nbFreeRecord);
    }

    public int getNbTotalRecord(Long nbTotalRecord) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (nbTotalRecord == null) {
            return -5;
        }
        if (ErrorCodes.LongInitializationValueOf(nbTotalRecord).booleanValue()) {
            return -93;
        }
        return morphoDatabaseNative.getNbTotalRecord(this.morphoDatabasePointerCPP.longValue(), nbTotalRecord);
    }

    public int getNbUsedRecord(Long nbUsedRecord) {
        if (!this.cppMemOwn) {
            return -98;
        }
        if (nbUsedRecord == null) {
            return -5;
        }
        if (ErrorCodes.LongInitializationValueOf(nbUsedRecord).booleanValue()) {
            return -93;
        }
        return morphoDatabaseNative.getNbUsedRecord(this.morphoDatabasePointerCPP.longValue(), nbUsedRecord);
    }
}
