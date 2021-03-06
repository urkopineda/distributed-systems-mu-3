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

public interface ChatListenerPrx extends Ice.ObjectPrx
{
    public void report(Contribution c);

    public void report(Contribution c, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_report(Contribution c);

    public Ice.AsyncResult begin_report(Contribution c, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_report(Contribution c, Ice.Callback __cb);

    public Ice.AsyncResult begin_report(Contribution c, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_report(Contribution c, Callback_ChatListener_report __cb);

    public Ice.AsyncResult begin_report(Contribution c, java.util.Map<String, String> __ctx, Callback_ChatListener_report __cb);

    public Ice.AsyncResult begin_report(Contribution c, 
                                        IceInternal.Functional_VoidCallback __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_report(Contribution c, 
                                        IceInternal.Functional_VoidCallback __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                        IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_report(Contribution c, 
                                        java.util.Map<String, String> __ctx, 
                                        IceInternal.Functional_VoidCallback __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_report(Contribution c, 
                                        java.util.Map<String, String> __ctx, 
                                        IceInternal.Functional_VoidCallback __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                        IceInternal.Functional_BoolCallback __sentCb);

    public void end_report(Ice.AsyncResult __result);
}
