// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdSize;
import com.google.ads.ak;
import com.google.ads.n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.g;
import com.google.ads.util.h;
import java.lang.ref.WeakReference;

public class AdWebView extends WebView
{

    protected final n a;
    private WeakReference b;
    private AdSize c;
    private boolean d;
    private boolean e;
    private boolean f;

    public AdWebView(n n1, AdSize adsize)
    {
        super((Context)n1.f.a());
        a = n1;
        c = adsize;
        b = null;
        d = false;
        e = false;
        f = false;
        setBackgroundColor(0);
        AdUtil.a(this);
        adsize = getSettings();
        adsize.setSupportMultipleWindows(false);
        adsize.setJavaScriptEnabled(true);
        adsize.setSavePassword(false);
        setDownloadListener(new DownloadListener() {

            final AdWebView a;

            public void onDownloadStart(String s, String s1, String s2, String s3, long l)
            {
                try
                {
                    s1 = new Intent("android.intent.action.VIEW");
                    s1.setDataAndType(Uri.parse(s), s3);
                    s2 = a.i();
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    com.google.ads.util.b.a((new StringBuilder()).append("Couldn't find an Activity to view url/mimetype: ").append(s).append(" / ").append(s3).toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    com.google.ads.util.b.b((new StringBuilder()).append("Unknown error trying to start activity to view URL: ").append(s).toString(), s1);
                    return;
                }
                if (s2 == null)
                {
                    break MISSING_BLOCK_LABEL_46;
                }
                if (AdUtil.a(s1, s2))
                {
                    s2.startActivity(s1);
                }
            }

            
            {
                a = AdWebView.this;
                super();
            }
        });
        if (AdUtil.a < 17) goto _L2; else goto _L1
_L1:
        com.google.ads.util.h.a(adsize, n1);
_L8:
        setScrollBarStyle(0x2000000);
        if (AdUtil.a < 14) goto _L4; else goto _L3
_L3:
        setWebChromeClient(new com.google.ads.util.IcsUtil.a(n1));
_L6:
        return;
_L2:
        if (AdUtil.a >= 11)
        {
            com.google.ads.util.g.a(adsize, n1);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (AdUtil.a < 11) goto _L6; else goto _L5
_L5:
        setWebChromeClient(new com.google.ads.util.g.a(n1));
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            setOnTouchListener(new android.view.View.OnTouchListener() {

                final AdWebView a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return motionevent.getAction() == 2;
                }

            
            {
                a = AdWebView.this;
                super();
            }
            });
            return;
        } else
        {
            setOnTouchListener(null);
            return;
        }
    }

    public void destroy()
    {
        try
        {
            super.destroy();
        }
        catch (Throwable throwable)
        {
            com.google.ads.util.b.d("An error occurred while destroying an AdWebView:", throwable);
        }
        try
        {
            setWebViewClient(new WebViewClient());
            return;
        }
        catch (Throwable throwable1)
        {
            return;
        }
    }

    public void f()
    {
        AdActivity adactivity = i();
        if (adactivity != null)
        {
            adactivity.finish();
        }
    }

    public void g()
    {
        if (AdUtil.a >= 11)
        {
            com.google.ads.util.g.a(this);
        }
        e = true;
    }

    public void h()
    {
        if (e && AdUtil.a >= 11)
        {
            com.google.ads.util.g.b(this);
        }
        e = false;
    }

    public AdActivity i()
    {
        if (b != null)
        {
            return (AdActivity)b.get();
        } else
        {
            return null;
        }
    }

    public boolean j()
    {
        return f;
    }

    public boolean k()
    {
        return e;
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        try
        {
            super.loadDataWithBaseURL(s, s1, s2, s3, s4);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.ads.util.b.d("An error occurred while loading data in AdWebView:", s);
        }
    }

    public void loadUrl(String s)
    {
        try
        {
            super.loadUrl(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.ads.util.b.d("An error occurred while loading a URL in AdWebView:", s);
        }
    }

    protected void onMeasure(int l, int i1)
    {
        int k1 = 0x7fffffff;
        this;
        JVM INSTR monitorenter ;
        if (!isInEditMode()) goto _L2; else goto _L1
_L1:
        super.onMeasure(l, i1);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (c != null && !d)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        super.onMeasure(l, i1);
          goto _L3
        Exception exception;
        exception;
        throw exception;
        float f1;
        int j1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        l2 = android.view.View.MeasureSpec.getMode(l);
        j1 = android.view.View.MeasureSpec.getSize(l);
        i2 = android.view.View.MeasureSpec.getMode(i1);
        l1 = android.view.View.MeasureSpec.getSize(i1);
        f1 = getContext().getResources().getDisplayMetrics().density;
        j2 = (int)((float)c.getWidth() * f1);
        k2 = (int)((float)c.getHeight() * f1);
        break MISSING_BLOCK_LABEL_116;
_L4:
        com.google.ads.util.b.b((new StringBuilder()).append("Not enough space to show ad! Wants: <").append(j2).append(", ").append(k2).append(">, Has: <").append(j1).append(", ").append(l1).append(">").toString());
        setVisibility(8);
        setMeasuredDimension(j1, l1);
          goto _L3
_L5:
        setMeasuredDimension(j2, k2);
          goto _L3
        if (l2 != 0x80000000 && l2 != 0x40000000)
        {
            l = 0x7fffffff;
        } else
        {
            l = j1;
        }
        if (i2 != 0x80000000)
        {
            i1 = k1;
            if (i2 != 0x40000000)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        i1 = l1;
        if ((float)j2 - f1 * 6F <= (float)l && k2 <= i1) goto _L5; else goto _L4
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        ak ak1 = (ak)a.r.a();
        if (ak1 != null)
        {
            ak1.a(motionevent);
        }
        return super.onTouchEvent(motionevent);
    }

    public void setAdActivity(AdActivity adactivity)
    {
        b = new WeakReference(adactivity);
    }

    public void setAdSize(AdSize adsize)
    {
        this;
        JVM INSTR monitorenter ;
        c = adsize;
        requestLayout();
        this;
        JVM INSTR monitorexit ;
        return;
        adsize;
        throw adsize;
    }

    public void setCustomClose(boolean flag)
    {
        f = flag;
        if (b != null)
        {
            AdActivity adactivity = (AdActivity)b.get();
            if (adactivity != null)
            {
                adactivity.setCustomClose(flag);
            }
        }
    }

    public void setIsExpandedMraid(boolean flag)
    {
        d = flag;
    }

    public void stopLoading()
    {
        try
        {
            super.stopLoading();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.ads.util.b.d("An error occurred while stopping loading in AdWebView:", throwable);
        }
    }
}
