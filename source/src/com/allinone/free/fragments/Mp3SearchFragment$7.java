// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.adapter.Mp3ListviewAdapter;
import com.allinone.free.model.Model;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.Player;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.fragments:
//            Mp3SearchFragment

class this._cls0
    implements android.widget.ickListener
{

    final Mp3SearchFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, final int arg2, long l)
    {
        adapterview = getActivity().getSharedPreferences("mp3_search_data", 0).edit();
        adapterview.putInt("mp3_search_selector", arg2);
        adapterview.commit();
        Mp3SearchFragment.access$3(Mp3SearchFragment.this).setVisibility(0);
        Mp3SearchFragment.access$10(Mp3SearchFragment.this).setText(((DownloadMovieItem)Mp3SearchFragment.access$5(Mp3SearchFragment.this).get(arg2)).getTitle());
        Mp3SearchFragment.access$11(Mp3SearchFragment.this).setBackgroundResource(0x7f020179);
        (new AsyncTask() {

            final Mp3SearchFragment._cls7 this$1;
            private final int val$arg2;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                avoid = publicTools.getUrl((new StringBuilder("http://mp3box.to/user/download/?song=")).append(((DownloadMovieItem)Mp3SearchFragment.access$5(this$0).get(arg2)).getId()).toString());
                HashMap hashmap = new HashMap();
                hashmap.put("content", avoid);
                avoid = publicTools.doHttpPost((new StringBuilder("http://android.downloadatoz.com/_201409/market/mp3_pdt_parser.php?id=")).append(((DownloadMovieItem)Mp3SearchFragment.access$5(this$0).get(arg2)).getId()).toString(), hashmap);
                try
                {
                    avoid = new JSONObject(avoid);
                    if (avoid.getInt("status") == 1)
                    {
                        Mp3SearchFragment.access$12(this$0, new Model());
                        Mp3SearchFragment.access$13(this$0).setMp3url(avoid.getString("url"));
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
                try
                {
                    Mp3SearchFragment.access$2(this$0).playUrl(Mp3SearchFragment.access$13(this$0).getMp3url());
                    Mp3SearchFragment.access$14(this$0, new Timer());
                    Mp3SearchFragment.access$15(this$0, new TimerTask() {

                        final _cls1 this$2;

                        public void run()
                        {
                            Message message = new Message();
                            message.what = 300;
                            handler.sendMessage(message);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    Mp3SearchFragment.access$16(this$0).schedule(Mp3SearchFragment.access$17(this$0), 0L, 1000L);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[]) { }
                return null;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            protected void onPostExecute(Void void1)
            {
                super.onPostExecute(void1);
                Mp3SearchFragment.access$0(this$0).setVisibility(8);
                if (void1 != null);
            }

            protected void onPreExecute()
            {
                super.onPreExecute();
                Mp3SearchFragment.access$0(this$0).setVisibility(0);
            }


            
            {
                this$1 = Mp3SearchFragment._cls7.this;
                arg2 = i;
                super();
            }
        }).execute(new Void[0]);
        Mp3SearchFragment.access$18(Mp3SearchFragment.this).notifyDataSetChanged();
    }


    _cls1.val.arg2()
    {
        this$0 = Mp3SearchFragment.this;
        super();
    }
}
