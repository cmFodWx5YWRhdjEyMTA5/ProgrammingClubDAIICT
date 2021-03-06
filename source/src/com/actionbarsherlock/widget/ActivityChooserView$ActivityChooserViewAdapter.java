// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.actionbarsherlock.widget:
//            ActivityChooserView, ActivityChooserModel

private class <init> extends BaseAdapter
{

    private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
    private static final int ITEM_VIEW_TYPE_COUNT = 3;
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;
    public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
    public static final int MAX_ACTIVITY_COUNT_UNLIMITED = 0x7fffffff;
    private ActivityChooserModel mDataModel;
    private boolean mHighlightDefaultActivity;
    private int mMaxActivityCount;
    private boolean mShowDefaultActivity;
    private boolean mShowFooterView;
    final ActivityChooserView this$0;

    public int getActivityCount()
    {
        return mDataModel.getActivityCount();
    }

    public int getCount()
    {
        int j = mDataModel.getActivityCount();
        int i = j;
        if (!mShowDefaultActivity)
        {
            i = j;
            if (mDataModel.getDefaultActivity() != null)
            {
                i = j - 1;
            }
        }
        j = Math.min(i, mMaxActivityCount);
        i = j;
        if (mShowFooterView)
        {
            i = j + 1;
        }
        return i;
    }

    public ActivityChooserModel getDataModel()
    {
        return mDataModel;
    }

    public ResolveInfo getDefaultActivity()
    {
        return mDataModel.getDefaultActivity();
    }

    public int getHistorySize()
    {
        return mDataModel.getHistorySize();
    }

    public Object getItem(int i)
    {
        int j;
        switch (getItemViewType(i))
        {
        default:
            throw new IllegalArgumentException();

        case 1: // '\001'
            return null;

        case 0: // '\0'
            j = i;
            break;
        }
        if (!mShowDefaultActivity)
        {
            j = i;
            if (mDataModel.getDefaultActivity() != null)
            {
                j = i + 1;
            }
        }
        return mDataModel.getActivity(j);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return !mShowFooterView || i != getCount() - 1 ? 0 : 1;
    }

    public int getMaxActivityCount()
    {
        return mMaxActivityCount;
    }

    public boolean getShowDefaultActivity()
    {
        return mShowDefaultActivity;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        getItemViewType(i);
        JVM INSTR tableswitch 0 1: default 28
    //                   0 107
    //                   1 36;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException();
_L3:
        if (view == null) goto _L5; else goto _L4
_L4:
        View view1 = view;
        if (view.getId() == 1) goto _L6; else goto _L5
_L5:
        view1 = LayoutInflater.from(getContext()).inflate(com.actionbarsherlock.dapter.getItemViewType, viewgroup, false);
        view1.setId(1);
        ((TextView)view1.findViewById(com.actionbarsherlock.dapter.getItemViewType)).setText(ActivityChooserView.access$4(ActivityChooserView.this).getString(com.actionbarsherlock.dapter.this._fld0));
_L6:
        return view1;
_L2:
        if (view == null) goto _L8; else goto _L7
_L7:
        view1 = view;
        if (view.getId() == com.actionbarsherlock.dapter.this._fld0) goto _L9; else goto _L8
_L8:
        view1 = LayoutInflater.from(getContext()).inflate(com.actionbarsherlock.dapter.this._fld0, viewgroup, false);
_L9:
        view = ActivityChooserView.access$4(ActivityChooserView.this).getPackageManager();
        viewgroup = (ImageView)view1.findViewById(com.actionbarsherlock.dapter.this._fld0);
        ResolveInfo resolveinfo = (ResolveInfo)getItem(i);
        viewgroup.setImageDrawable(resolveinfo.loadIcon(view));
        ((TextView)view1.findViewById(com.actionbarsherlock.dapter.getItem)).setText(resolveinfo.loadLabel(view));
        if (ActivityChooserView.access$11())
        {
            if (mShowDefaultActivity && i == 0 && mHighlightDefaultActivity)
            {
                mHighlightDefaultActivity(view1, true);
            } else
            {
                mHighlightDefaultActivity(view1, false);
            }
        }
        return view1;
    }

    public int getViewTypeCount()
    {
        return 3;
    }

    public int measureContentWidth()
    {
        int k = mMaxActivityCount;
        mMaxActivityCount = 0x7fffffff;
        int j = 0;
        View view = null;
        int l = android.view.oserViewAdapter.mMaxActivityCount(0, 0);
        int i1 = android.view.oserViewAdapter.mMaxActivityCount(0, 0);
        int j1 = getCount();
        int i = 0;
        do
        {
            if (i >= j1)
            {
                mMaxActivityCount = k;
                return j;
            }
            view = getView(i, view, null);
            view.measure(l, i1);
            j = Math.max(j, view.getMeasuredWidth());
            i++;
        } while (true);
    }

    public void setDataModel(ActivityChooserModel activitychoosermodel)
    {
        ActivityChooserModel activitychoosermodel1 = ActivityChooserView.access$0(ActivityChooserView.this).getDataModel();
        if (activitychoosermodel1 != null && isShown())
        {
            try
            {
                activitychoosermodel1.unregisterObserver(ActivityChooserView.access$10(ActivityChooserView.this));
            }
            catch (IllegalStateException illegalstateexception) { }
        }
        mDataModel = activitychoosermodel;
        if (activitychoosermodel != null && isShown())
        {
            try
            {
                activitychoosermodel.registerObserver(ActivityChooserView.access$10(ActivityChooserView.this));
            }
            // Misplaced declaration of an exception variable
            catch (ActivityChooserModel activitychoosermodel) { }
        }
        notifyDataSetChanged();
    }

    public void setMaxActivityCount(int i)
    {
        if (mMaxActivityCount != i)
        {
            mMaxActivityCount = i;
            notifyDataSetChanged();
        }
    }

    public void setShowDefaultActivity(boolean flag, boolean flag1)
    {
        if (mShowDefaultActivity != flag || mHighlightDefaultActivity != flag1)
        {
            mShowDefaultActivity = flag;
            mHighlightDefaultActivity = flag1;
            notifyDataSetChanged();
        }
    }

    public void setShowFooterView(boolean flag)
    {
        if (mShowFooterView != flag)
        {
            mShowFooterView = flag;
            notifyDataSetChanged();
        }
    }

    private Q()
    {
        this$0 = ActivityChooserView.this;
        super();
        mMaxActivityCount = 4;
        mShowDefaultActivity = true;
    }

    mShowDefaultActivity(mShowDefaultActivity mshowdefaultactivity)
    {
        this();
    }
}
