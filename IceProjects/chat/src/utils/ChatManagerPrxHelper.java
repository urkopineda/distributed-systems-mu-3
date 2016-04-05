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

public final class ChatManagerPrxHelper extends Ice.ObjectPrxHelperBase implements ChatManagerPrx
{
    private static final String __subscribe_name = "subscribe";

    public int subscribe(String name, ClientPrx client)
    {
        return subscribe(name, client, null, false);
    }

    public int subscribe(String name, ClientPrx client, java.util.Map<String, String> __ctx)
    {
        return subscribe(name, client, __ctx, true);
    }

    private int subscribe(String name, ClientPrx client, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__subscribe_name);
        return end_subscribe(begin_subscribe(name, client, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client)
    {
        return begin_subscribe(name, client, null, false, false, null);
    }

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, java.util.Map<String, String> __ctx)
    {
        return begin_subscribe(name, client, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, Ice.Callback __cb)
    {
        return begin_subscribe(name, client, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_subscribe(name, client, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, Callback_ChatManager_subscribe __cb)
    {
        return begin_subscribe(name, client, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_subscribe(String name, ClientPrx client, java.util.Map<String, String> __ctx, Callback_ChatManager_subscribe __cb)
    {
        return begin_subscribe(name, client, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_subscribe(String name, 
                                           ClientPrx client, 
                                           IceInternal.Functional_IntCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_subscribe(name, client, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_subscribe(String name, 
                                           ClientPrx client, 
                                           IceInternal.Functional_IntCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_subscribe(name, client, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_subscribe(String name, 
                                           ClientPrx client, 
                                           java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_IntCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_subscribe(name, client, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_subscribe(String name, 
                                           ClientPrx client, 
                                           java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_IntCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_subscribe(name, client, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_subscribe(String name, 
                                            ClientPrx client, 
                                            java.util.Map<String, String> __ctx, 
                                            boolean __explicitCtx, 
                                            boolean __synchronous, 
                                            IceInternal.Functional_IntCallback __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                            IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_subscribe(name, client, __ctx, __explicitCtx, __synchronous, 
                               new IceInternal.Functional_TwowayCallbackInt(__responseCb, __exceptionCb, __sentCb)
                                   {
                                       public final void __completed(Ice.AsyncResult __result)
                                       {
                                           ChatManagerPrxHelper.__subscribe_completed(this, __result);
                                       }
                                   });
    }

    private Ice.AsyncResult begin_subscribe(String name, 
                                            ClientPrx client, 
                                            java.util.Map<String, String> __ctx, 
                                            boolean __explicitCtx, 
                                            boolean __synchronous, 
                                            IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__subscribe_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__subscribe_name, __cb);
        try
        {
            __result.prepare(__subscribe_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeString(name);
            ClientPrxHelper.__write(__os, client);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public int end_subscribe(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __subscribe_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            int __ret;
            __ret = __is.readInt();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __subscribe_completed(Ice.TwowayCallbackInt __cb, Ice.AsyncResult __result)
    {
        utils.ChatManagerPrx __proxy = (utils.ChatManagerPrx)__result.getProxy();
        int __ret = 0;
        try
        {
            __ret = __proxy.end_subscribe(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    private static final String __unsubscribe_name = "unsubscribe";

    public void unsubscribe(int id)
    {
        unsubscribe(id, null, false);
    }

    public void unsubscribe(int id, java.util.Map<String, String> __ctx)
    {
        unsubscribe(id, __ctx, true);
    }

    private void unsubscribe(int id, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_unsubscribe(begin_unsubscribe(id, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_unsubscribe(int id)
    {
        return begin_unsubscribe(id, null, false, false, null);
    }

    public Ice.AsyncResult begin_unsubscribe(int id, java.util.Map<String, String> __ctx)
    {
        return begin_unsubscribe(id, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_unsubscribe(int id, Ice.Callback __cb)
    {
        return begin_unsubscribe(id, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_unsubscribe(int id, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_unsubscribe(id, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_unsubscribe(int id, Callback_ChatManager_unsubscribe __cb)
    {
        return begin_unsubscribe(id, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_unsubscribe(int id, java.util.Map<String, String> __ctx, Callback_ChatManager_unsubscribe __cb)
    {
        return begin_unsubscribe(id, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_unsubscribe(int id, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_unsubscribe(id, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_unsubscribe(int id, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_unsubscribe(id, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_unsubscribe(int id, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_unsubscribe(id, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_unsubscribe(int id, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_unsubscribe(id, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_unsubscribe(int id, 
                                              java.util.Map<String, String> __ctx, 
                                              boolean __explicitCtx, 
                                              boolean __synchronous, 
                                              IceInternal.Functional_VoidCallback __responseCb, 
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                              IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_unsubscribe(id, 
                                 __ctx, 
                                 __explicitCtx, 
                                 __synchronous, 
                                 new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_unsubscribe(int id, 
                                              java.util.Map<String, String> __ctx, 
                                              boolean __explicitCtx, 
                                              boolean __synchronous, 
                                              IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__unsubscribe_name, __cb);
        try
        {
            __result.prepare(__unsubscribe_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeInt(id);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_unsubscribe(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __unsubscribe_name);
    }

    private static final String __write_name = "write";

    public void write(int id, String message)
    {
        write(id, message, null, false);
    }

    public void write(int id, String message, java.util.Map<String, String> __ctx)
    {
        write(id, message, __ctx, true);
    }

    private void write(int id, String message, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_write(begin_write(id, message, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_write(int id, String message)
    {
        return begin_write(id, message, null, false, false, null);
    }

    public Ice.AsyncResult begin_write(int id, String message, java.util.Map<String, String> __ctx)
    {
        return begin_write(id, message, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_write(int id, String message, Ice.Callback __cb)
    {
        return begin_write(id, message, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_write(int id, String message, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_write(id, message, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_write(int id, String message, Callback_ChatManager_write __cb)
    {
        return begin_write(id, message, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_write(int id, String message, java.util.Map<String, String> __ctx, Callback_ChatManager_write __cb)
    {
        return begin_write(id, message, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_write(int id, 
                                       String message, 
                                       IceInternal.Functional_VoidCallback __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_write(id, message, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_write(int id, 
                                       String message, 
                                       IceInternal.Functional_VoidCallback __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                       IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_write(id, message, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_write(int id, 
                                       String message, 
                                       java.util.Map<String, String> __ctx, 
                                       IceInternal.Functional_VoidCallback __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_write(id, message, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_write(int id, 
                                       String message, 
                                       java.util.Map<String, String> __ctx, 
                                       IceInternal.Functional_VoidCallback __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                       IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_write(id, message, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_write(int id, 
                                        String message, 
                                        java.util.Map<String, String> __ctx, 
                                        boolean __explicitCtx, 
                                        boolean __synchronous, 
                                        IceInternal.Functional_VoidCallback __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                        IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_write(id, 
                           message, 
                           __ctx, 
                           __explicitCtx, 
                           __synchronous, 
                           new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_write(int id, 
                                        String message, 
                                        java.util.Map<String, String> __ctx, 
                                        boolean __explicitCtx, 
                                        boolean __synchronous, 
                                        IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__write_name, __cb);
        try
        {
            __result.prepare(__write_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeInt(id);
            __os.writeString(message);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_write(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __write_name);
    }

    public static ChatManagerPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), ChatManagerPrx.class, ChatManagerPrxHelper.class);
    }

    public static ChatManagerPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), ChatManagerPrx.class, ChatManagerPrxHelper.class);
    }

    public static ChatManagerPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), ChatManagerPrx.class, ChatManagerPrxHelper.class);
    }

    public static ChatManagerPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), ChatManagerPrx.class, ChatManagerPrxHelper.class);
    }

    public static ChatManagerPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, ChatManagerPrx.class, ChatManagerPrxHelper.class);
    }

    public static ChatManagerPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, ChatManagerPrx.class, ChatManagerPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::utils::ChatManager"
    };

    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, ChatManagerPrx v)
    {
        __os.writeProxy(v);
    }

    public static ChatManagerPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ChatManagerPrxHelper result = new ChatManagerPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}