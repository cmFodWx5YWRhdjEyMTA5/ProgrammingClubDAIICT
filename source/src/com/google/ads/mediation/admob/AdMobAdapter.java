// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.admob;

import android.app.Activity;
import android.view.View;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.util.AdUtil;

// Referenced classes of package com.google.ads.mediation.admob:
//            AdMobAdapterExtras, AdMobAdapterServerParameters

public class AdMobAdapter
    implements MediationBannerAdapter, MediationInterstitialAdapter
{
    private class a
        implements AdListener
    {

        final AdMobAdapter a;

        public void onDismissScreen(Ad ad)
        {
            AdMobAdapter.a(a).onDismissScreen(a);
        }

        public void onFailedToReceiveAd(Ad ad, com.google.ads.AdRequest.ErrorCode errorcode)
        {
            AdMobAdapter.a(a).onFailedToReceiveAd(a, errorcode);
        }

        public void onLeaveApplication(Ad ad)
        {
            AdMobAdapter.a(a).onLeaveApplication(a);
        }

        public void onPresentScreen(Ad ad)
        {
            AdMobAdapter.a(a).onClick(a);
            AdMobAdapter.a(a).onPresentScreen(a);
        }

        public void onReceiveAd(Ad ad)
        {
            AdMobAdapter.a(a).onReceivedAd(a);
        }

        private a()
        {
            a = AdMobAdapter.this;
            super();
        }

    }

    private class b
        implements AdListener
    {

        final AdMobAdapter a;

        public void onDismissScreen(Ad ad)
        {
            AdMobAdapter.b(a).onDismissScreen(a);
        }

        public void onFailedToReceiveAd(Ad ad, com.google.ads.AdRequest.ErrorCode errorcode)
        {
            AdMobAdapter.b(a).onFailedToReceiveAd(a, errorcode);
        }

        public void onLeaveApplication(Ad ad)
        {
            AdMobAdapter.b(a).onLeaveApplication(a);
        }

        public void onPresentScreen(Ad ad)
        {
            AdMobAdapter.b(a).onPresentScreen(a);
        }

        public void onReceiveAd(Ad ad)
        {
            AdMobAdapter.b(a).onReceivedAd(a);
        }

        private b()
        {
            a = AdMobAdapter.this;
            super();
        }

    }


    private MediationBannerListener a;
    private MediationInterstitialListener b;
    private AdView c;
    private InterstitialAd d;

    public AdMobAdapter()
    {
    }

    private AdRequest a(Activity activity, AdMobAdapterServerParameters admobadapterserverparameters, MediationAdRequest mediationadrequest, AdMobAdapterExtras admobadapterextras)
    {
        admobadapterextras = new AdMobAdapterExtras(admobadapterextras);
        admobadapterextras.addExtra("_norefresh", "t");
        admobadapterextras.addExtra("gw", Integer.valueOf(1));
        if (admobadapterserverparameters.allowHouseAds != null)
        {
            admobadapterextras.addExtra("mad_hac", admobadapterserverparameters.allowHouseAds);
        }
        admobadapterserverparameters = (new AdRequest()).setBirthday(mediationadrequest.getBirthday()).setGender(mediationadrequest.getGender()).setKeywords(mediationadrequest.getKeywords()).setLocation(mediationadrequest.getLocation()).setNetworkExtras(admobadapterextras);
        if (mediationadrequest.isTesting())
        {
            admobadapterserverparameters.addTestDevice(AdUtil.a(activity));
        }
        return admobadapterserverparameters;
    }

    static MediationBannerListener a(AdMobAdapter admobadapter)
    {
        return admobadapter.a;
    }

    private void a()
    {
        if (b())
        {
            throw new IllegalStateException("Adapter has already been destroyed");
        } else
        {
            return;
        }
    }

    static MediationInterstitialListener b(AdMobAdapter admobadapter)
    {
        return admobadapter.b;
    }

    private boolean b()
    {
        return c == null && d == null;
    }

    protected AdView a(Activity activity, AdSize adsize, String s)
    {
        return new AdView(activity, adsize, s);
    }

    protected InterstitialAd a(Activity activity, String s)
    {
        return new InterstitialAd(activity, s);
    }

    public void destroy()
    {
        a();
        if (c != null)
        {
            c.stopLoading();
            c.destroy();
            c = null;
        }
        if (d != null)
        {
            d.stopLoading();
            d = null;
        }
    }

    public Class getAdditionalParametersType()
    {
        return com/google/ads/mediation/admob/AdMobAdapterExtras;
    }

    public View getBannerView()
    {
        return c;
    }

    public Class getServerParametersType()
    {
        return com/google/ads/mediation/admob/AdMobAdapterServerParameters;
    }

    public volatile void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, MediationServerParameters mediationserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestBannerAd(mediationbannerlistener, activity, (AdMobAdapterServerParameters)mediationserverparameters, adsize, mediationadrequest, (AdMobAdapterExtras)networkextras);
    }

    public void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, AdMobAdapterServerParameters admobadapterserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, AdMobAdapterExtras admobadapterextras)
    {
        AdSize adsize1;
        a = mediationbannerlistener;
        adsize1 = adsize;
        if (adsize.isAutoHeight()) goto _L2; else goto _L1
_L1:
        if (!adsize.isFullWidth()) goto _L4; else goto _L3
_L3:
        adsize1 = adsize;
_L2:
        c = a(activity, adsize1, admobadapterserverparameters.adUnitId);
        c.setAdListener(new a());
        c.loadAd(a(activity, admobadapterserverparameters, mediationadrequest, admobadapterextras));
        return;
_L4:
        if (admobadapterextras == null)
        {
            break; /* Loop/switch isn't completed */
        }
        adsize1 = adsize;
        if (admobadapterextras.getUseExactAdSize()) goto _L2; else goto _L5
_L5:
        adsize = adsize.findBestSize(new AdSize[] {
            AdSize.BANNER, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_MRECT, AdSize.IAB_WIDE_SKYSCRAPER
        });
        adsize1 = adsize;
        if (adsize == null)
        {
            mediationbannerlistener.onFailedToReceiveAd(this, com.google.ads.AdRequest.ErrorCode.NO_FILL);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public volatile void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, MediationServerParameters mediationserverparameters, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestInterstitialAd(mediationinterstitiallistener, activity, (AdMobAdapterServerParameters)mediationserverparameters, mediationadrequest, (AdMobAdapterExtras)networkextras);
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, AdMobAdapterServerParameters admobadapterserverparameters, MediationAdRequest mediationadrequest, AdMobAdapterExtras admobadapterextras)
    {
        b = mediationinterstitiallistener;
        d = a(activity, admobadapterserverparameters.adUnitId);
        d.setAdListener(new b());
        d.loadAd(a(activity, admobadapterserverparameters, mediationadrequest, admobadapterextras));
    }

    public void showInterstitial()
    {
        d.show();
    }
}
