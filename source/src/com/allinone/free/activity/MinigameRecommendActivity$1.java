// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.allinone.free.model.SearchkeywordModel;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            MinigameRecommendActivity, MinigamesSearchResultActivity

class this._cls0
    implements android.widget.ner
{

    final MinigameRecommendActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(MinigameRecommendActivity.this, com/allinone/free/activity/MinigamesSearchResultActivity);
        adapterview.putExtra("searchkeywords", ((SearchkeywordModel)MinigameRecommendActivity.access$2(MinigameRecommendActivity.this).get(i)).getKeyword());
        startActivity(adapterview);
    }

    y()
    {
        this$0 = MinigameRecommendActivity.this;
        super();
    }
}
