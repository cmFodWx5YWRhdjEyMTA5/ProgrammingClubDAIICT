// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.adapter:
//            Home_Gridview_Adapter

class val.in_fo
    implements Runnable
{

    final  this$1;
    private final DownloadMovieItem val$in_fo;

    public void run()
    {
        try
        {
            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(val$in_fo.getId()).append("&from=google").toString());
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    l.has_apk()
    {
        this$1 = final_has_apk;
        val$in_fo = DownloadMovieItem.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/adapter/Home_Gridview_Adapter$2

/* anonymous class */
    class Home_Gridview_Adapter._cls2
        implements android.view.View.OnClickListener
    {

        final Home_Gridview_Adapter this$0;
        private final String val$has_apk;
        private final DownloadMovieItem val$in_fo;

        public void onClick(View view)
        {
            ((Button)view).setBackgroundResource(0x7f0200f8);
            Log.e("www", (new StringBuilder("app=")).append(in_fo.getTitle()).toString());
            Home_Gridview_Adapter.access$2(Home_Gridview_Adapter.this).edit().putString("appname", in_fo.getTitle()).commit();
            if (!has_apk.equals("1")) goto _L2; else goto _L1
_L1:
            (new Thread(new Home_Gridview_Adapter._cls2._cls1())).start();
            if (!Home_Gridview_Adapter.access$4(Home_Gridview_Adapter.this).getBoolean("isopen", false) || NetWorkUtil.getAPNType(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this)) == 1) goto _L4; else goto _L3
_L3:
            Home_Gridview_Adapter.access$5(Home_Gridview_Adapter.this);
_L6:
            return;
_L4:
            if (Home_Gridview_Adapter.access$6(Home_Gridview_Adapter.this).queryfile(in_fo.getId()) == null)
            {
                MydownloadApk(in_fo.getId(), in_fo.getTitle(), in_fo.getIcon(), in_fo.getSerial());
                return;
            }
            try
            {
                Toast.makeText(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this), "It has been in downloading list already.", 1).show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return;
            }
_L2:
            if (has_apk.equals("0"))
            {
                (new Thread(in_fo. new Home_Gridview_Adapter._cls2._cls2())).start();
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(in_fo.getId()).toString()));
                Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this).startActivity(view);
                return;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

            
            {
                this$0 = final_home_gridview_adapter;
                in_fo = downloadmovieitem;
                has_apk = String.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/adapter/Home_Gridview_Adapter$2$1

/* anonymous class */
        class Home_Gridview_Adapter._cls2._cls1
            implements Runnable
        {

            final Home_Gridview_Adapter._cls2 this$1;
            private final DownloadMovieItem val$in_fo;

            public void run()
            {
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(in_fo.getId()).append("&from=apk").toString());
            }

                    
                    {
                        this$1 = Home_Gridview_Adapter._cls2.this;
                        in_fo = downloadmovieitem;
                        super();
                    }
        }

    }

}
