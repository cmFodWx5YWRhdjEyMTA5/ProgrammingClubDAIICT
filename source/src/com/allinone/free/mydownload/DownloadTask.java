// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.mydownload;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.utils.MD5;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.TipsToast;
import com.stericson.RootTools.RootTools;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import net.tsz.afinal.http.AjaxCallBack;

// Referenced classes of package com.allinone.free.mydownload:
//            ContentValue, DownloadMovieItem, DownloadFile, MyApplcation

public class DownloadTask
    implements ContentValue
{
    class CallBackFuc extends AjaxCallBack
    {

        private int cu;
        private TextView current_progress;
        private DownloadMovieItem down;
        private TextView kb;
        private TextView movie_name_item;
        private ProgressBar p;
        private Button stop_download_bt;
        final DownloadTask this$0;
        private TextView totalSize;
        private View view;

        public void onFailure(Throwable throwable, String s)
        {
            (new Thread(new Runnable() {

                final CallBackFuc this$1;

                public void run()
                {
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&action=retry_fail&id=")).append(down.getFile_id()).append("&size=").append(down.getCurrentProgress()).toString());
                }

            
            {
                this$1 = CallBackFuc.this;
                super();
            }
            })).start();
            if (TextUtils.isEmpty(down.getFileSize()))
            {
                down.setFileSize("0.0B");
            }
            down.setDownloadState(Integer.valueOf(5));
            throwable = db;
            String s1 = down.getMovieName();
            DownloadMovieItem downloadmovieitem = down;
            throwable.updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                s1
            }, downloadmovieitem);
            if (!TextUtils.isEmpty(s) && s.contains("416"))
            {
                throwable = new Intent();
                throwable.putExtra("downloadType", 6);
                throwable.setAction("downloadType");
                ((MyApplcation)mContext.getApplicationContext()).setDownloadSuccess(down);
                mContext.sendBroadcast(throwable);
                throwable = Formatter.formatFileSize(mContext, (new File(down.getFilePath())).length());
                if (view != null)
                {
                    kb.setVisibility(4);
                    totalSize.setText(throwable);
                    current_progress.setText(mContext.getString(0x7f0b0030));
                    p.setMax(100);
                    p.setProgress(100);
                    stop_download_bt.setVisibility(0);
                    stop_download_bt.setBackgroundResource(0x7f0201ae);
                    stop_download_bt.setOnClickListener(new MyOnClick(6, down, stop_download_bt));
                }
            } else
            if (view != null)
            {
                kb.setVisibility(4);
                if (stop_download_bt.getVisibility() == 4)
                {
                    stop_download_bt.setVisibility(0);
                }
                stop_download_bt.setBackgroundResource(0x7f020098);
                stop_download_bt.setText(mContext.getString(0x7f0b0031));
                stop_download_bt.setTextColor(Color.parseColor("#333333"));
                current_progress.setTextColor(Color.parseColor("#f39801"));
                current_progress.setText(mContext.getString(0x7f0b0032));
                throwable = new MyOnClick(5, down, stop_download_bt);
                throwable.setCurrent_progress(current_progress);
                stop_download_bt.setOnClickListener(throwable);
                throwable = DownloadTask.this;
                throwable.click_time = ((DownloadTask) (throwable)).click_time + 1;
                if (click_time < 4)
                {
                    stop_download_bt.performClick();
                    Toast.makeText(mContext, (new StringBuilder("Failed to download '")).append(down.getMovieName()).append("'. Please try again.").toString(), 0).show();
                    return;
                } else
                {
                    click_time = 0;
                    throwable = new Notification();
                    throwable.flags = 16;
                    throwable.icon = 0x7f020115;
                    s = new Intent(mContext, com/allinone/free/activity/DownloadsActivity);
                    s.setFlags(0x10000000);
                    throwable.contentIntent = PendingIntent.getActivity(mContext, down.getSerial(), s, 0x8000000);
                    s = new RemoteViews(mContext.getPackageName(), 0x7f03007a);
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
                    s.setTextViewText(0x7f0601f9, "Incomplete Task");
                    s.setTextViewText(0x7f0601fa, DateFormat.format("kk:mm", System.currentTimeMillis()));
                    s.setImageViewBitmap(0x7f0601f8, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(down.getMovieHeadImagePath())).toString()));
                    throwable.contentView = s;
                    DownloadTask.mNotificationManager.notify(down.getSerial(), throwable);
                    return;
                }
            }
        }

        public void onLoading(long l, long l1)
        {
            int i = 0;
            if (l1 > (long)cu)
            {
                i = (int)(l1 - (long)cu);
                cu = (int)l1;
            }
            Object obj = (new StringBuilder(String.valueOf(Formatter.formatFileSize(mContext, i)))).append("/s").toString();
            i = (int)((100L * l1) / l);
            if (view != null)
            {
                String s = Formatter.formatFileSize(mContext, l1);
                current_progress.setText((new StringBuilder(String.valueOf(i))).append("%").toString());
                down.setPercentage((new StringBuilder(String.valueOf(i))).append("%").toString());
                down.setProgressCount(Long.valueOf(l));
                down.setCurrentProgress(Long.valueOf(l1));
                Object obj1 = Formatter.formatFileSize(mContext, l);
                down.setFileSize(String.valueOf(l));
                totalSize.setText((new StringBuilder(String.valueOf(s))).append("/").append(((String) (obj1))).toString());
                kb.setText(((CharSequence) (obj)));
                if (kb.getVisibility() == 4)
                {
                    kb.setVisibility(0);
                }
                p.setMax((int)l);
                p.setProgress((int)l1);
                if (stop_download_bt.getVisibility() == 4)
                {
                    stop_download_bt.setVisibility(0);
                    stop_download_bt.setText("");
                    stop_download_bt.setBackgroundResource(0x7f0201a9);
                }
                down.setDownloadState(Integer.valueOf(2));
                obj = db;
                s = down.getMovieName();
                obj1 = down;
                ((FinalDBChen) (obj)).updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                    s
                }, obj1);
            }
        }

        public void onStart()
        {
            down.setDownloadState(Integer.valueOf(7));
            Object obj = db;
            String s = down.getMovieName();
            DownloadMovieItem downloadmovieitem = down;
            ((FinalDBChen) (obj)).updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                s
            }, downloadmovieitem);
            obj = new Intent();
            ((Intent) (obj)).putExtra("downloadType", 7);
            ((Intent) (obj)).setAction("downloadType");
            ((MyApplcation)mContext.getApplicationContext()).setDownloadSuccess(down);
            mContext.sendBroadcast(((Intent) (obj)));
            super.onStart();
        }

        public void onSuccess(File file)
        {
label0:
            {
                {
                    (new Thread(new Runnable() {

                        final CallBackFuc this$1;

                        public void run()
                        {
                            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id=")).append(down.getFile_id()).append("&status=success&size=").append(down.getFileSize()).toString());
                        }

            
            {
                this$1 = CallBackFuc.this;
                super();
            }
                    })).start();
                    if (view != null)
                    {
                        kb.setVisibility(4);
                        current_progress.setText(mContext.getString(0x7f0b0030));
                        stop_download_bt.setBackgroundResource(0x7f0201ae);
                        stop_download_bt.setOnClickListener(new MyOnClick(6, down, stop_download_bt));
                    }
                    down.setDownloadState(Integer.valueOf(6));
                    Object obj = db;
                    Object obj1 = down.getMovieName();
                    Object obj2 = down;
                    ((FinalDBChen) (obj)).updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                        obj1
                    }, obj2);
                    obj = new Intent();
                    Myutils.getInstance();
                    Myutils.successItem = down;
                    Log.v("erer", (new StringBuilder("11111111")).append(down.getType()).append(down.getFile_id()).toString());
                    obj2 = (MyApplcation)mContext.getApplicationContext();
                    ((Intent) (obj)).setAction("successful");
                    obj1 = new Intent();
                    if (down.getType().equals("mp3"))
                    {
                        ((Intent) (obj1)).setAction("mp3successful");
                    } else
                    if (down.getType().equals("ringtone"))
                    {
                        ((Intent) (obj1)).setAction("ringtonesuccessful");
                    } else
                    if (down.getType().equals("app"))
                    {
                        ((Intent) (obj1)).setAction("appsuccessful");
                    } else
                    if (down.getType().equals("video"))
                    {
                        ((Intent) (obj1)).setAction("videosuccessful");
                    }
                    if (!is_valid_file().booleanValue())
                    {
                        break label0;
                    }
                    ((MyApplcation) (obj2)).setDownloadSuccess(down);
                    obj2 = (LinearLayout)view.getParent();
                    IOException ioexception;
                    try
                    {
                        ((LinearLayout) (obj2)).removeView(view);
                    }
                    catch (Exception exception) { }
                    mContext.sendBroadcast(((Intent) (obj)));
                    mContext.sendBroadcast(((Intent) (obj1)));
                    if (down.getType().equals("app"))
                    {
                        publicTools.toptoast = false;
                        publicTools.openimgpath = down.getMovieHeadImagePath();
                        publicTools.opentitle = down.getTitle();
                        publicTools.openid = down.getFile_id();
                        if (RootTools.isRootAvailable())
                        {
                            (new Thread(new Runnable() {

                                final CallBackFuc this$1;

                                public void run()
                                {
                                    String s = (new StringBuilder(String.valueOf("pm install -r "))).append(down.getFilePath()).toString();
                                    excuteSuCMD(s);
                                }

            
            {
                this$1 = CallBackFuc.this;
                super();
            }
                            })).start();
                        } else
                        {
                            obj = new Intent("android.intent.action.VIEW");
                            ((Intent) (obj)).setDataAndType(Uri.parse((new StringBuilder("file://")).append(down.getFilePath()).toString()), "application/vnd.android.package-archive");
                            mContext.startActivity(((Intent) (obj)));
                        }
                        showTips(0x7f020115, (new StringBuilder("'")).append(down.getTitle()).append("' Download Complete. Click to install").toString());
                        obj = new Intent();
                        ((Intent) (obj)).setAction("jingmoanzhuang");
                        mContext.sendBroadcast(((Intent) (obj)));
                        (new AsyncTask() {

                            final CallBackFuc this$1;

                            protected volatile transient Object doInBackground(Object aobj[])
                            {
                                return doInBackground((Void[])aobj);
                            }

                            protected transient Void doInBackground(Void avoid[])
                            {
                                try
                                {
                                    Thread.sleep(2000L);
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
                                void1 = new Notification();
                                void1.flags = 16;
                                void1.icon = 0x7f020115;
                                Object obj = new Intent(mContext, com/allinone/free/activity/DownloadsActivity);
                                ((Intent) (obj)).setFlags(0x10000000);
                                void1.contentIntent = PendingIntent.getActivity(mContext, 110, ((Intent) (obj)), 0x8000000);
                                obj = new RemoteViews(mContext.getPackageName(), 0x7f030079);
                                ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
                                ((RemoteViews) (obj)).setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(ds.size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
                                ((RemoteViews) (obj)).setTextViewText(0x7f0601f6, DateFormat.format("kk:mm", System.currentTimeMillis()));
                                void1.contentView = ((RemoteViews) (obj));
                                DownloadTask.mNotificationManager.notify(110, void1);
                            }

            
            {
                this$1 = CallBackFuc.this;
                super();
            }
                        }).execute(new Void[0]);
                    }
                }
                super.onSuccess(file);
                return;
            }
            obj2 = new Message();
            obj2.what = 1212;
            ((Message) (obj2)).getData().putString("type", down.getType());
            ((Message) (obj2)).getData().putString("id", down.getFile_id());
            ((Message) (obj2)).getData().putString("size", down.getFileSize());
            obj = "";
            obj1 = BufferedReader(down.getFilePath());
            obj = obj1;
            Log.v("tyty", (new StringBuilder("content===")).append(((String) (obj1))).toString());
            obj = obj1;
_L4:
            if (((String) (obj)).length() > 100)
            {
                ((Message) (obj2)).getData().putString("content", ((String) (obj)).substring(1, 100));
            } else
            {
                ((Message) (obj2)).getData().putString("content", ((String) (obj)));
            }
            if (!down.getType().equals("app")) goto _L2; else goto _L1
_L1:
            Myutils.getInstance();
            if (!Myutils.type_current.equals("app_recent")) goto _L2; else goto _L3
_L3:
            publicTools.app_recent_handler.sendMessage(((Message) (obj2)));
_L5:
            current_progress.setText("Invalid");
            current_progress.setTextColor(Color.parseColor("#f39801"));
            kb.setVisibility(0);
            kb.setText("0KB/s");
            break MISSING_BLOCK_LABEL_478;
            ioexception;
            ioexception.printStackTrace();
              goto _L4
_L2:
label1:
            {
                if (!down.getType().equals("app"))
                {
                    break label1;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("app_popular"))
                {
                    break label1;
                }
                publicTools.app_popular_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
label2:
            {
                if (!down.getType().equals("app"))
                {
                    break label2;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("app_search"))
                {
                    break label2;
                }
                publicTools.app_search_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
label3:
            {
                if (!down.getType().equals("app"))
                {
                    break label3;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("app_detail"))
                {
                    break label3;
                }
                publicTools.app_detail_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
label4:
            {
                if (!down.getType().equals("game"))
                {
                    break label4;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("game_recent"))
                {
                    break label4;
                }
                publicTools.game_recent_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
label5:
            {
                if (!down.getType().equals("game"))
                {
                    break label5;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("game_popular"))
                {
                    break label5;
                }
                publicTools.game_popular_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
label6:
            {
                if (!down.getType().equals("mp3"))
                {
                    break label6;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("mp3_recent"))
                {
                    break label6;
                }
                publicTools.mp3_recent_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
label7:
            {
                if (!down.getType().equals("mp3"))
                {
                    break label7;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("mp3_popular"))
                {
                    break label7;
                }
                publicTools.mp3_popular_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
label8:
            {
                if (!down.getType().equals("mp3"))
                {
                    break label8;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("mp3_search"))
                {
                    break label8;
                }
                publicTools.mp3_search_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
label9:
            {
                if (!down.getType().equals("ringtone"))
                {
                    break label9;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("ringtone_recent"))
                {
                    break label9;
                }
                publicTools.ringtone_recent_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
label10:
            {
                if (!down.getType().equals("ringtone"))
                {
                    break label10;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("ringtone_popular"))
                {
                    break label10;
                }
                publicTools.ringtone_popular_handler.sendMessage(((Message) (obj2)));
            }
              goto _L5
            if (down.getType().equals("ringtone"))
            {
                Myutils.getInstance();
                if (Myutils.type_current.equals("ringtone_search"))
                {
                    publicTools.ringtone_search_handler.sendMessage(((Message) (obj2)));
                }
            }
              goto _L5
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((File)obj);
        }



        public CallBackFuc(View view1, DownloadMovieItem downloadmovieitem)
        {
            this$0 = DownloadTask.this;
            super();
            down = downloadmovieitem;
            view = view1;
            if (view1 != null)
            {
                p = (ProgressBar)view1.findViewById(0x7f060196);
                screenWidth = mContext.getResources().getDisplayMetrics().widthPixels;
                if (screenWidth < 500)
                {
                    android.view.ViewGroup.LayoutParams layoutparams = p.getLayoutParams();
                    layoutparams.width = 186;
                    p.setLayoutParams(layoutparams);
                }
                kb = (TextView)view1.findViewById(0x7f060197);
                totalSize = (TextView)view1.findViewById(0x7f060195);
                stop_download_bt = (Button)view1.findViewById(0x7f060199);
                stop_download_bt.setBackgroundResource(0x7f0201a9);
                current_progress = (TextView)view1.findViewById(0x7f060198);
                movie_name_item = (TextView)view1.findViewById(0x7f060194);
                stop_download_bt.setVisibility(4);
                stop_download_bt.setBackgroundResource(0x7f0201a9);
                movie_name_item.setText(downloadmovieitem.getMovieName());
                movie_name_item.setTypeface(typeFace);
                current_progress.setTextColor(Color.parseColor("#cccccc"));
                current_progress.setText(mContext.getString(0x7f0b002c));
                mc = new MyOnClick(7, downloadmovieitem, stop_download_bt);
                mc.setCurrent_progress(current_progress);
                stop_download_bt.setOnClickListener(mc);
            }
        }
    }

    class DeleteClick
        implements android.view.View.OnClickListener
    {

        final DownloadTask this$0;

        public void onClick(View view1)
        {
            if (onDeleteTaskListener != null)
            {
                onDeleteTaskListener.onDelete(view, down, Boolean.valueOf(false));
            }
        }

        DeleteClick()
        {
            this$0 = DownloadTask.this;
            super();
        }
    }

    public class MyOnClick
        implements android.view.View.OnClickListener
    {

        private Button button;
        public boolean clickState;
        private TextView current_progress;
        private DownloadMovieItem downItem;
        public int state;
        final DownloadTask this$0;

        public TextView getCurrent_progress()
        {
            return current_progress;
        }

        public void onClick(View view1)
        {
            view1 = downItem.getMovieName();
            switch (state)
            {
            case 6: // '\006'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            default:
                return;

            case 5: // '\005'
                button.setVisibility(4);
                current_progress.setTextColor(Color.parseColor("#cccccc"));
                current_progress.setText("Waiting in queue");
                gotoDownload(down, view);
                try
                {
                    DownloadTask.mNotificationManager.cancel(down.getSerial());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view1)
                {
                    return;
                }

            case 7: // '\007'
                if (clickState)
                {
                    gotoDownload(down, view);
                    Toast.makeText(mContext, (new StringBuilder("'")).append(view1).append("' starts downloading.").toString(), 0).show();
                    if (button != null)
                    {
                        button.setVisibility(4);
                        current_progress.setTextColor(Color.parseColor("#cccccc"));
                        current_progress.setText(mContext.getString(0x7f0b002c));
                    }
                    clickState = false;
                    return;
                }
                down.getDownloadFile().stopDownload();
                Toast.makeText(mContext, (new StringBuilder("'")).append(view1).append("' is paused.").toString(), 0).show();
                if (button != null)
                {
                    button.setBackgroundResource(0x7f0201ae);
                }
                clickState = true;
                return;

            case 13: // '\r'
                view1 = down.getDownloadUrl();
                String s = down.getFilePath();
                down.setDownloadFile((new DownloadFile()).startDownloadFileByUrl(view1, s, new CallBackFuc(view, down)));
                return;
            }
        }

        public void setCurrent_progress(TextView textview)
        {
            current_progress = textview;
        }

        public MyOnClick(int i, DownloadMovieItem downloadmovieitem, Button button1)
        {
            this$0 = DownloadTask.this;
            super();
            clickState = false;
            state = i;
            downItem = downloadmovieitem;
            button = button1;
        }
    }

    public static interface OnDeleteTaskListener
    {

        public abstract void onDelete(View view1, DownloadMovieItem downloadmovieitem, Boolean boolean1);
    }


    public static NotificationManager mNotificationManager;
    public static List nolist = new ArrayList();
    private static TipsToast tipsToast;
    private int click_time;
    private boolean comeDb;
    private FinalDBChen db;
    private DownloadMovieItem down;
    private DownloadFile downloadFile;
    BroadcastReceiver downloadingbBroadcastReceiver;
    private List ds;
    private Context mContext;
    private MyOnClick mc;
    private OnDeleteTaskListener onDeleteTaskListener;
    private int screenWidth;
    private Typeface typeFace;
    private View view;

    public DownloadTask(Context context, View view1, DownloadMovieItem downloadmovieitem, boolean flag)
    {
        typeFace = null;
        click_time = 0;
        downloadingbBroadcastReceiver = new BroadcastReceiver() {

            final DownloadTask this$0;

            public void onReceive(Context context1, Intent intent)
            {
                context1 = intent.getStringExtra("type");
                Log.v("mjmj", (new StringBuilder("*******")).append(context1).toString());
                if (context1.equals("pause"))
                {
                    if (mc != null)
                    {
                        context1 = (Button)view.findViewById(0x7f060199);
                        down.getDownloadFile().stopDownload();
                        if (context1 != null)
                        {
                            context1.setBackgroundResource(0x7f0201ae);
                        }
                        mc.clickState = true;
                    }
                } else
                {
                    if (context1.equals("resume"))
                    {
                        context1 = (Button)view.findViewById(0x7f060199);
                        intent = (TextView)view.findViewById(0x7f060198);
                        if (context1 != null)
                        {
                            context1.setBackgroundResource(0x7f0201ae);
                            context1.setVisibility(4);
                            intent.setTextColor(Color.parseColor("#cccccc"));
                            intent.setText(mContext.getString(0x7f0b002c));
                        }
                        context1 = down.getDownloadUrl();
                        intent = down.getFilePath();
                        down.setDownloadFile((new DownloadFile()).startDownloadFileByUrl(context1, intent, new CallBackFuc(view, down)));
                        return;
                    }
                    if (context1.equals("delete"))
                    {
                        onDeleteTaskListener.onDelete(view, down, Boolean.valueOf(true));
                        return;
                    }
                }
            }

            
            {
                this$0 = DownloadTask.this;
                super();
            }
        };
        mContext = context;
        view = view1;
        down = downloadmovieitem;
        comeDb = flag;
        ((ImageView)view1.findViewById(0x7f060192)).setOnClickListener(new DeleteClick());
        db = new FinalDBChen(context, context.getDatabasePath("download2.db").getAbsolutePath());
        gotoDownload(downloadmovieitem, view1);
        view1 = new IntentFilter();
        view1.addAction("downloadingbBroadcastReceiver");
        context.registerReceiver(downloadingbBroadcastReceiver, view1);
        mNotificationManager = (NotificationManager)context.getSystemService("notification");
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    private void showTips(int i, String s)
    {
        if (tipsToast != null)
        {
            if (android.os.Build.VERSION.SDK_INT < 14)
            {
                tipsToast.cancel();
            }
        } else
        {
            tipsToast = TipsToast.makeText(mContext, s, 0);
        }
        tipsToast.show();
        tipsToast.setIcon(i);
        tipsToast.setText(s);
    }

    public String BufferedReader(String s)
        throws IOException
    {
        s = new File(s);
        if (!s.exists() || s.isDirectory())
        {
            throw new FileNotFoundException();
        }
        BufferedReader bufferedreader = new BufferedReader(new FileReader(s));
        StringBuffer stringbuffer = new StringBuffer();
        s = bufferedreader.readLine();
        do
        {
            if (s == null)
            {
                bufferedreader.close();
                return stringbuffer.toString();
            }
            stringbuffer.append((new StringBuilder(String.valueOf(s))).append(" ").toString());
            s = bufferedreader.readLine();
        } while (stringbuffer.toString().length() <= 100);
        return stringbuffer.toString();
    }

    protected int excuteSuCMD(String s)
    {
        int i;
        try
        {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream dataoutputstream = new DataOutputStream(process.getOutputStream());
            dataoutputstream.writeBytes("export LD_LIBRARY_PATH=/vendor/lib:/system/lib\n");
            dataoutputstream.writeBytes((new StringBuilder(String.valueOf(String.valueOf(s)))).append("\n").toString());
            dataoutputstream.flush();
            dataoutputstream.writeBytes("exit\n");
            dataoutputstream.flush();
            process.waitFor();
            i = Integer.valueOf(process.exitValue()).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return -1;
        }
        return i;
    }

    public OnDeleteTaskListener getOnDeleteTaskListener()
    {
        return onDeleteTaskListener;
    }

    public void gotoDownload(DownloadMovieItem downloadmovieitem, View view1)
    {
        String s = downloadmovieitem.getDownloadUrl();
        String s1 = downloadmovieitem.getFilePath();
        if (comeDb)
        {
            view1 = (Button)view1.findViewById(0x7f060199);
            view1.setBackgroundResource(0x7f0201ae);
            view1.setOnClickListener(new MyOnClick(13, downloadmovieitem, view1));
            return;
        } else
        {
            downloadFile = (new DownloadFile()).startDownloadFileByUrl(s, s1, new CallBackFuc(view1, downloadmovieitem));
            downloadmovieitem.setDownloadFile(downloadFile);
            return;
        }
    }

    public Boolean is_valid_file()
    {
        Long long1 = Long.valueOf(Long.parseLong(down.getFileSize()));
        Log.v("sdsd", (new StringBuilder("file_size")).append(long1).toString());
        if (long1.longValue() < 2000L)
        {
            Log.v("abcd", "\u5C0F\u4E8E2kb");
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(true);
        }
    }

    public void setOnDeleteTaskListener(OnDeleteTaskListener ondeletetasklistener)
    {
        onDeleteTaskListener = ondeletetasklistener;
    }
















}
