// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.exception;


// Referenced classes of package net.tsz.afinal.exception:
//            AfinalException

public class DbException extends AfinalException
{

    private static final long serialVersionUID = 1L;

    public DbException()
    {
    }

    public DbException(String s)
    {
        super(s);
    }

    public DbException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public DbException(Throwable throwable)
    {
        super(throwable);
    }
}
