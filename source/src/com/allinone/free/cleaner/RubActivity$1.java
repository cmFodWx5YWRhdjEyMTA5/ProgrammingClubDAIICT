// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;

import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.allinone.free.dialog.CleanerDialog1;
import com.allinone.free.utils.ProgressWheel;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

// Referenced classes of package com.allinone.free.cleaner:
//            RubActivity

class this._cls0 extends Handler
{

    final RubActivity this$0;

    public void handleMessage(Message message)
    {
        RubActivity.access$0(RubActivity.this).setVisibility(8);
        RubActivity.access$1(RubActivity.this).setVisibility(8);
        RubActivity.access$2(RubActivity.this).setVisibility(0);
        RubActivity.access$2(RubActivity.this).performClick();
        switch (message.what)
        {
        case 2: // '\002'
        case 3: // '\003'
        default:
            return;

        case 1: // '\001'
            RubActivity.access$3(RubActivity.this, new skInfoAdapter(RubActivity.this));
            message = new SwingBottomInAnimationAdapter(RubActivity.access$4(RubActivity.this));
            message.setListView(RubActivity.access$5(RubActivity.this));
            RubActivity.access$5(RubActivity.this).setAdapter(message);
            message = new mInfo(RubActivity.this);
            long l = RubActivity.getmem_TOLAL();
            long l1 = message.getmem_UNUSED(getApplicationContext());
            RubActivity.access$6(RubActivity.this, l - l1);
            Log.e("www", (new StringBuilder("getmem_UNUSED=")).append(l1).append("getmem_TOLAL=").append(l).toString());
            Log.e("www", (new StringBuilder("handler=")).append(total_wyc).toString());
            RubActivity.access$7((int)total_wyc / 1024);
            if (total_wyc / 1024L / 1024L >= 1L)
            {
                RubActivity.access$8(RubActivity.this).setText("GB");
                RubActivity.access$9(RubActivity.this, RubActivity.roundDouble((double)total_wyc / 1024D / 1024D, 2));
                RubActivity.access$10(RubActivity.this).setText((new StringBuilder()).append(RubActivity.access$11(RubActivity.this)).toString());
                return;
            } else
            {
                RubActivity.access$8(RubActivity.this).setText("MB");
                RubActivity.access$9(RubActivity.this, RubActivity.roundDouble((double)total_wyc / 1024D, 2));
                RubActivity.access$10(RubActivity.this).setText((new StringBuilder()).append(RubActivity.access$11(RubActivity.this)).toString());
                return;
            }

        case 200: 
            RubActivity.access$12(RubActivity.this).setVisibility(0);
            RubActivity.access$12(RubActivity.this).startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 0x7f04001d));
            RubActivity.access$13(RubActivity.this).setVisibility(0);
            (new AsyncTask() {

                final RubActivity._cls1 this$1;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        avoid.printStackTrace();
                    }
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    java.io.File _tmp = RubActivity.access$14(this$0);
                    void1 = new CleanerDialog1(this$0, 0x7f0c0064);
                    void1.setCanceledOnTouchOutside(false);
                    void1.show();
                    Button button = (Button)void1.findViewById(0x7f0600e5);
                    Button button1 = (Button)void1.findViewById(0x7f0600e7);
                    ((TextView)void1.findViewById(0x7f060081)).setText(Html.fromHtml("Boost your phone up to 50% by<font color='#3261b4'> <b>AIO Cleaner</b></font> , Continue? "));
                    button.setOnClickListener(void1. new android.view.View.OnClickListener() {

                        final _cls1 this$2;
                        private final CleanerDialog1 val$dialog1;

                        public void onClick(View view)
                        {
                            dialog1.dismiss();
                        }

            
            {
                this$2 = final__pcls1;
                dialog1 = CleanerDialog1.this;
                super();
            }
                    });
                    button1.setOnClickListener(void1. new android.view.View.OnClickListener() {

                        final _cls1 this$2;
                        private final CleanerDialog1 val$dialog1;

                        public void onClick(View view)
                        {
                            view = null;
                            android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                            view = packageinfo;
_L1:
                            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                            if (view == null)
                            {
                                RubActivity.access$15(this$0);
                            } else
                            {
                                view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                                startActivity(view);
                            }
                            dialog1.dismiss();
                            return;
                            namenotfoundexception;
                            namenotfoundexception.printStackTrace();
                              goto _L1
                        }

            
            {
                this$2 = final__pcls1;
                dialog1 = CleanerDialog1.this;
                super();
            }
                    });
                }


            
            {
                this$1 = RubActivity._cls1.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }


    _cls1.this._cls1()
    {
        this$0 = RubActivity.this;
        super();
    }
}
