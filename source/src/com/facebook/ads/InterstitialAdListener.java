// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;


// Referenced classes of package com.facebook.ads:
//            AdListener, Ad

public interface InterstitialAdListener
    extends AdListener
{

    public abstract void onInterstitialDismissed(Ad ad);

    public abstract void onInterstitialDisplayed(Ad ad);
}