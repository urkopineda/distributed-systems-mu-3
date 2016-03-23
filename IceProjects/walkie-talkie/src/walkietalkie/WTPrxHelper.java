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
// Generated from file `WalkieTalkie.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package walkietalkie;

public final class WTPrxHelper extends Ice.ObjectPrxHelperBase implements WTPrx
{
    private static final String __pushMessage_name = "pushMessage";

    public void pushMessage(String message)
    {
        pushMessage(message, null, false);
    }

    public void pushMessage(String message, java.util.Map<String, String> __ctx)
    {
        pushMessage(message, __ctx, true);
    }

    private void pushMessage(String message, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_pushMessage(begin_pushMessage(message, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_pushMessage(String message)
    {
        return begin_pushMessage(message, null, false, false, null);
    }

    public Ice.AsyncResult begin_pushMessage(String message, java.util.Map<String, String> __ctx)
    {
        return begin_pushMessage(message, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_pushMessage(String message, Ice.Callback __cb)
    {
        return begin_pushMessage(message, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_pushMessage(String message, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_pushMessage(message, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_pushMessage(String message, Callback_WT_pushMessage __cb)
    {
        return begin_pushMessage(message, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_pushMessage(String message, java.util.Map<String, String> __ctx, Callback_WT_pushMessage __cb)
    {
        return begin_pushMessage(message, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_pushMessage(String message, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_pushMessage(message, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_pushMessage(String message, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_pushMessage(message, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_pushMessage(String message, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_pushMessage(message, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_pushMessage(String message, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_pushMessage(message, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_pushMessage(String message, 
                                              java.util.Map<String, String> __ctx, 
                                              boolean __explicitCtx, 
                                              boolean __synchronous, 
                                              IceInternal.Functional_VoidCallback __responseCb, 
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                              IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_pushMessage(message, 
                                 __ctx, 
                                 __explicitCtx, 
                                 __synchronous, 
                                 new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_pushMessage(String message, 
                                              java.util.Map<String, String> __ctx, 
                                              boolean __explicitCtx, 
                                              boolean __synchronous, 
                                              IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__pushMessage_name, __cb);
        try
        {
            __result.prepare(__pushMessage_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
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

    public void end_pushMessage(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __pushMessage_name);
    }

    public static WTPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), WTPrx.class, WTPrxHelper.class);
    }

    public static WTPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), WTPrx.class, WTPrxHelper.class);
    }

    public static WTPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), WTPrx.class, WTPrxHelper.class);
    }

    public static WTPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), WTPrx.class, WTPrxHelper.class);
    }

    public static WTPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, WTPrx.class, WTPrxHelper.class);
    }

    public static WTPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, WTPrx.class, WTPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::walkietalkie::WT"
    };

    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, WTPrx v)
    {
        __os.writeProxy(v);
    }

    public static WTPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            WTPrxHelper result = new WTPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
