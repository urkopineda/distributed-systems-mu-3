// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.2
//
// <auto-generated>
//
// Generated from file `chat.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package chat;

public class Contribution implements java.lang.Cloneable, java.io.Serializable
{
    public String content;

    public Contribution()
    {
        content = "";
    }

    public Contribution(String content)
    {
        this.content = content;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Contribution _r = null;
        if(rhs instanceof Contribution)
        {
            _r = (Contribution)rhs;
        }

        if(_r != null)
        {
            if(content != _r.content)
            {
                if(content == null || _r.content == null || !content.equals(_r.content))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::chat::Contribution");
        __h = IceInternal.HashUtil.hashAdd(__h, content);
        return __h;
    }

    public Contribution
    clone()
    {
        Contribution c = null;
        try
        {
            c = (Contribution)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(content);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        content = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, Contribution __v)
    {
        if(__v == null)
        {
            __nullMarshalValue.__write(__os);
        }
        else
        {
            __v.__write(__os);
        }
    }

    static public Contribution
    __read(IceInternal.BasicStream __is, Contribution __v)
    {
        if(__v == null)
        {
             __v = new Contribution();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final Contribution __nullMarshalValue = new Contribution();

    public static final long serialVersionUID = 9047513222756803869L;
}