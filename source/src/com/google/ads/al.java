// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import android.net.Uri;

// Referenced classes of package com.google.ads:
//            ah, am, ai

public class al
{

    private String a;
    private String b;
    private String c[] = {
        ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"
    };
    private ai d;
    private ah e;

    public al(ai ai1)
    {
        a = "googleads.g.doubleclick.net";
        b = "/pagead/ads";
        e = new ah();
        d = ai1;
    }

    private Uri a(Uri uri, Context context, String s, boolean flag)
        throws am
    {
        try
        {
            if (uri.getQueryParameter("ms") != null)
            {
                throw new am("Query parameter already exists: ms");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new am("Provided Uri is not in a valid state");
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        context = d.a(context, s);
_L4:
        return a(uri, "ms", ((String) (context)));
_L2:
        context = d.a(context);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Uri a(Uri uri, String s, String s1)
        throws UnsupportedOperationException
    {
        String s2 = uri.toString();
        int j = s2.indexOf("&adurl");
        int i = j;
        if (j == -1)
        {
            i = s2.indexOf("?adurl");
        }
        if (i != -1)
        {
            return Uri.parse((new StringBuilder(s2.substring(0, i + 1))).append(s).append("=").append(s1).append("&").append(s2.substring(i + 1)).toString());
        } else
        {
            return uri.buildUpon().appendQueryParameter(s, s1).build();
        }
    }

    public Uri a(Uri uri, Context context)
        throws am
    {
        try
        {
            uri = a(uri, context, uri.getQueryParameter("ai"), true);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new am("Provided Uri is not in a valid state");
        }
        return uri;
    }

    public void a(String s)
    {
        c = s.split(",");
    }

    public boolean a(Uri uri)
    {
        boolean flag1 = false;
        if (uri == null)
        {
            throw new NullPointerException();
        }
        String as[];
        int i;
        int j;
        boolean flag;
        try
        {
            uri = uri.getHost();
            as = c;
            j = as.length;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            return false;
        }
        i = 0;
        flag = flag1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        flag = uri.endsWith(as[i]);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        flag = true;
        return flag;
        for (i++; false;)
        {
        }

        break MISSING_BLOCK_LABEL_31;
    }
}