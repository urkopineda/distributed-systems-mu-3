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
// Generated from file `Exam.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package chat;

/**
 * Provides type-specific helper functions.
 **/
public final class ChatEnginePrxHelper extends Ice.ObjectPrxHelperBase implements ChatEnginePrx
{
    private static final String __publish_name = "publish";

    public void publish(String message)
    {
        publish(message, null, false);
    }

    public void publish(String message, java.util.Map<String, String> __ctx)
    {
        publish(message, __ctx, true);
    }

    private void publish(String message, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_publish(begin_publish(message, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_publish(String message)
    {
        return begin_publish(message, null, false, false, null);
    }

    public Ice.AsyncResult begin_publish(String message, java.util.Map<String, String> __ctx)
    {
        return begin_publish(message, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_publish(String message, Ice.Callback __cb)
    {
        return begin_publish(message, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_publish(String message, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_publish(message, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_publish(String message, Callback_ChatEngine_publish __cb)
    {
        return begin_publish(message, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_publish(String message, java.util.Map<String, String> __ctx, Callback_ChatEngine_publish __cb)
    {
        return begin_publish(message, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_publish(String message, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_publish(message, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_publish(String message, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_publish(message, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_publish(String message, 
                                         java.util.Map<String, String> __ctx, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_publish(message, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_publish(String message, 
                                         java.util.Map<String, String> __ctx, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_publish(message, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_publish(String message, 
                                          java.util.Map<String, String> __ctx, 
                                          boolean __explicitCtx, 
                                          boolean __synchronous, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_publish(message, 
                             __ctx, 
                             __explicitCtx, 
                             __synchronous, 
                             new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_publish(String message, 
                                          java.util.Map<String, String> __ctx, 
                                          boolean __explicitCtx, 
                                          boolean __synchronous, 
                                          IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__publish_name, __cb);
        try
        {
            __result.prepare(__publish_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
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

    public void end_publish(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __publish_name);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static ChatEnginePrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), ChatEnginePrx.class, ChatEnginePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static ChatEnginePrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), ChatEnginePrx.class, ChatEnginePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static ChatEnginePrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), ChatEnginePrx.class, ChatEnginePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static ChatEnginePrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), ChatEnginePrx.class, ChatEnginePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static ChatEnginePrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, ChatEnginePrx.class, ChatEnginePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static ChatEnginePrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, ChatEnginePrx.class, ChatEnginePrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::chat::ChatEngine"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, ChatEnginePrx v)
    {
        __os.writeProxy(v);
    }

    public static ChatEnginePrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ChatEnginePrxHelper result = new ChatEnginePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
