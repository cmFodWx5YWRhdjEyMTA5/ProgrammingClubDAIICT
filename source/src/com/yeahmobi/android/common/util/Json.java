// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Json
{

    public Json()
    {
    }

    public static Object getJsonValue(JSONObject jsonobject, String s, Class class1)
    {
        if (jsonobject == null || s == null || class1 == null)
        {
            throw new IllegalArgumentException("Cannot pass any null argument to getJsonValue");
        }
        jsonobject = ((JSONObject) (jsonobject.opt(s)));
        if (jsonobject == null)
        {
            Log.w("YeahMobi", (new StringBuilder()).append("Tried to get Json value with key: ").append(s).append(", but it was null").toString());
            return null;
        }
        if (!class1.isInstance(jsonobject))
        {
            Log.w("YeahMobi", (new StringBuilder()).append("Tried to get Json value with key: ").append(s).append(", of type: ").append(class1.toString()).append(", its type did not match").toString());
            return null;
        } else
        {
            return class1.cast(jsonobject);
        }
    }

    public static String[] jsonArrayToStringArray(String s)
    {
        s = (new StringBuilder()).append("{key:").append(s).append("}").toString();
        String as[];
        JSONArray jsonarray;
        jsonarray = ((JSONObject)(new JSONTokener(s)).nextValue()).getJSONArray("key");
        as = new String[jsonarray.length()];
        int i = 0;
_L2:
        s = as;
        if (i >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        as[i] = jsonarray.getString(i);
        i++;
        if (true) goto _L2; else goto _L1
        s;
        s = new String[0];
_L1:
        return s;
    }

    public static Map jsonStringToMap(String s)
        throws Exception
    {
        HashMap hashmap = new HashMap();
        if (s != null && !s.equals(""))
        {
            s = (JSONObject)(new JSONTokener(s)).nextValue();
            Iterator iterator = s.keys();
            while (iterator.hasNext()) 
            {
                String s1 = (String)iterator.next();
                hashmap.put(s1, s.getString(s1));
            }
        }
        return hashmap;
    }

    public static String mapToJsonString(Map map)
    {
        if (map == null)
        {
            return "{}";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{");
        boolean flag = true;
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (!flag)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append("\"");
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append("\":\"");
            stringbuilder.append((String)entry.getValue());
            stringbuilder.append("\"");
            flag = false;
        }

        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
