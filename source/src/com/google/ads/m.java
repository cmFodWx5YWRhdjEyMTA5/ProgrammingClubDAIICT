// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.ads.util.i;

public class m extends i
{
    public static final class a extends i
    {

        public final com.google.ads.util.i.c a = new com.google.ads.util.i.c(this, "ASDomains", null);
        public final com.google.ads.util.i.c b = new com.google.ads.util.i.c(this, "minHwAccelerationVersionBanner", Integer.valueOf(18));
        public final com.google.ads.util.i.c c = new com.google.ads.util.i.c(this, "minHwAccelerationVersionOverlay", Integer.valueOf(18));
        public final com.google.ads.util.i.c d = new com.google.ads.util.i.c(this, "minHwAccelerationVersionOverlay", Integer.valueOf(14));
        public final com.google.ads.util.i.c e = new com.google.ads.util.i.c(this, "mraidBannerPath", "http://media.admob.com/mraid/v1/mraid_app_banner.js");
        public final com.google.ads.util.i.c f = new com.google.ads.util.i.c(this, "mraidExpandedBannerPath", "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
        public final com.google.ads.util.i.c g = new com.google.ads.util.i.c(this, "mraidInterstitialPath", "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
        public final com.google.ads.util.i.c h = new com.google.ads.util.i.c(this, "badAdReportPath", "https://badad.googleplex.com/s/reportAd");
        public final com.google.ads.util.i.c i = new com.google.ads.util.i.c(this, "appCacheMaxSize", Long.valueOf(0L));
        public final com.google.ads.util.i.c j = new com.google.ads.util.i.c(this, "appCacheMaxSizePaddingInBytes", Long.valueOf(0x20000L));
        public final com.google.ads.util.i.c k = new com.google.ads.util.i.c(this, "maxTotalAppCacheQuotaInBytes", Long.valueOf(0x500000L));
        public final com.google.ads.util.i.c l = new com.google.ads.util.i.c(this, "maxTotalDatabaseQuotaInBytes", Long.valueOf(0x500000L));
        public final com.google.ads.util.i.c m = new com.google.ads.util.i.c(this, "maxDatabaseQuotaPerOriginInBytes", Long.valueOf(0x100000L));
        public final com.google.ads.util.i.c n = new com.google.ads.util.i.c(this, "databaseQuotaIncreaseStepInBytes", Long.valueOf(0x20000L));
        public final com.google.ads.util.i.c o = new com.google.ads.util.i.c(this, "isInitialized", Boolean.valueOf(false));

        public a()
        {
        }
    }


    private static final m d = new m();
    public final com.google.ads.util.i.c a = new com.google.ads.util.i.c(this, "marketPackages", null);
    public final com.google.ads.util.i.b b = new com.google.ads.util.i.b(this, "constants", new a());
    public final com.google.ads.util.i.b c = new com.google.ads.util.i.b(this, "uiHandler", new Handler(Looper.getMainLooper()));

    private m()
    {
    }

    public static m a()
    {
        return d;
    }

}
