// **********************************************************************
//
// Copyright (c) 2003-2015 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.1
//
// <auto-generated>
//
// Generated from file `Chat.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package utils;

public interface ChatManagerPrx extends Ice.ObjectPrx
{
    public int subscribe(String name, ClientPrx client);

    public int subscribe(String name, ClientPrx client, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client);

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, Ice.Callback __cb);

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, Callback_ChatManager_subscribe __cb);

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, java.util.Map<String, String> __ctx, Callback_ChatManager_subscribe __cb);

    public Ice.AsyncResult begin_subscribe(String name, 
                                           ClientPrx client, 
                                           IceInternal.Functional_IntCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_subscribe(String name, 
                                           ClientPrx client, 
                                           IceInternal.Functional_IntCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_subscribe(String name, 
                                           ClientPrx client, 
                                           java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_IntCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_subscribe(String name, 
                                           ClientPrx client, 
                                           java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_IntCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb);

    public int end_subscribe(Ice.AsyncResult __result);

    public void unsubscribe(int id);

    public void unsubscribe(int id, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_unsubscribe(int id);

    public Ice.AsyncResult begin_unsubscribe(int id, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_unsubscribe(int id, Ice.Callback __cb);

    public Ice.AsyncResult begin_unsubscribe(int id, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_unsubscribe(int id, Callback_ChatManager_unsubscribe __cb);

    public Ice.AsyncResult begin_unsubscribe(int id, java.util.Map<String, String> __ctx, Callback_ChatManager_unsubscribe __cb);

    public Ice.AsyncResult begin_unsubscribe(int id, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_unsubscribe(int id, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_unsubscribe(int id, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_unsubscribe(int id, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public void end_unsubscribe(Ice.AsyncResult __result);

    public void write(int id, String message);

    public void write(int id, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_write(int id, String message);

    public Ice.AsyncResult begin_write(int id, String message, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_write(int id, String message, Ice.Callback __cb);

    public Ice.AsyncResult begin_write(int id, String message, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_write(int id, String message, Callback_ChatManager_write __cb);

    public Ice.AsyncResult begin_write(int id, String message, java.util.Map<String, String> __ctx, Callback_ChatManager_write __cb);

    public Ice.AsyncResult begin_write(int id, 
                                       String message, 
                                       IceInternal.Functional_VoidCallback __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_write(int id, 
                                       String message, 
                                       IceInternal.Functional_VoidCallback __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                       IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_write(int id, 
                                       String message, 
                                       java.util.Map<String, String> __ctx, 
                                       IceInternal.Functional_VoidCallback __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_write(int id, 
                                       String message, 
                                       java.util.Map<String, String> __ctx, 
                                       IceInternal.Functional_VoidCallback __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                       IceInternal.Functional_BoolCallback __sentCb);

    public void end_write(Ice.AsyncResult __result);
}
