// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import android.webkit.WebSettings;
import com.google.ads.n;

// Referenced classes of package com.google.ads.util:
//            g

public final class h
{

    public static void a(WebSettings websettings, n n)
    {
        g.a(websettings, n);
        websettings.setMediaPlaybackRequiresUserGesture(false);
    }
}
