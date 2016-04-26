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

public interface ChatManagerPrx extends Ice.ObjectPrx
{
    public void sendMessage(Message m);

    public void sendMessage(Message m, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendMessage(Message m);

    public Ice.AsyncResult begin_sendMessage(Message m, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendMessage(Message m, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendMessage(Message m, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendMessage(Message m, Callback_ChatManager_sendMessage __cb);

    public Ice.AsyncResult begin_sendMessage(Message m, java.util.Map<String, String> __ctx, Callback_ChatManager_sendMessage __cb);

    public Ice.AsyncResult begin_sendMessage(Message m, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_sendMessage(Message m, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_sendMessage(Message m, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_sendMessage(Message m, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public void end_sendMessage(Ice.AsyncResult __result);
}
