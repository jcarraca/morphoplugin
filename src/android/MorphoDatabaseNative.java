package com.jcarraca.cordova.plugin;

import java.util.Observer;

/* compiled from: MorphoDatabase */
class MorphoDatabaseNative {
    public native int cancelLiveAcquisition(long j);

    public native int dbCreate(long j, int i, int i2, int i3, int i4, int i5);

    public native int dbDelete(long j, int i);

    public native int dbQueryFirst(long j, int i, String str, MorphoUser morphoUser);

    public native int dbQueryNext(long j, MorphoUser morphoUser);

    public native long deleteInstance(long j);

    public native long getCPPInstance();

    public native long getCPPInstance(long j);

    public native int getDbEncryptionStatus(long j, Integer num);

    public native int getField(long j, int i, MorphoField morphoField);

    public native int getFormatPK(long j, Integer num);

    public native int getMaxDataBase(long j, Integer num);

    public native int getMaxUser(long j, Integer num, Integer num2);

    public native int getNbField(long j, Long l);

    public native int getNbFinger(long j, Integer num);

    public native int getNbFreeRecord(long j, Long l);

    public native int getNbTotalRecord(long j, Long l);

    public native int getNbUsedRecord(long j, Long l);

    public native int getUser(long j, String str, MorphoUser morphoUser);

    public native int identify(long j, int i, int i2, int i3, int i4, int i5, int i6, Observer observer, ResultMatching resultMatching, MorphoUser morphoUser, int i7);

    public native int identifyMatch(long j, int i, TemplateList templateList, MorphoUser morphoUser, ResultMatching resultMatching);

    public native int putField(long j, MorphoField morphoField, Integer num);

    public native int readPublicFields(long j, int[] iArr, MorphoUserList morphoUserList);

    MorphoDatabaseNative() {
    }

    static {
        System.loadLibrary("NativeMorphoSmartSDK_6.17.3.0");
        System.loadLibrary("MSO100");
    }
}
