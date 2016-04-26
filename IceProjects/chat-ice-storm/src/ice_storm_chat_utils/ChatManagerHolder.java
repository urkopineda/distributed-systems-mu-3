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

package ice_storm_chat_utils;

public final class ChatManagerHolder extends Ice.ObjectHolderBase<ChatManager>
{
    public
    ChatManagerHolder()
    {
    }

    public
    ChatManagerHolder(ChatManager value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        if(v == null || v instanceof ChatManager)
        {
            value = (ChatManager)v;
        }
        else
        {
            IceInternal.Ex.throwUOE(type(), v);
        }
    }

    public String
    type()
    {
        return _ChatManagerDisp.ice_staticId();
    }
}
