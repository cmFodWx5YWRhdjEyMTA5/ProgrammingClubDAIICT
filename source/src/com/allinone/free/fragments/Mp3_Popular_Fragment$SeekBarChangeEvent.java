// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.media.MediaPlayer;
import android.widget.SeekBar;
import com.allinone.free.utils.Player;

// Referenced classes of package com.allinone.free.fragments:
//            Mp3_Popular_Fragment

class this._cls0
    implements android.widget.rChangeEvent
{

    int progress;
    final Mp3_Popular_Fragment this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        try
        {
            progress = (Mp3_Popular_Fragment.access$2(Mp3_Popular_Fragment.this).mediaPlayer.getDuration() * i) / seekbar.getMax();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SeekBar seekbar)
        {
            return;
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        Mp3_Popular_Fragment.access$2(Mp3_Popular_Fragment.this).mediaPlayer.seekTo(progress);
    }

    I()
    {
        this$0 = Mp3_Popular_Fragment.this;
        super();
    }
}
