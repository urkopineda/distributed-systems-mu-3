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

package voting;

/**
 * Provides type-specific helper functions.
 **/
public final class VoterPrxHelper extends Ice.ObjectPrxHelperBase implements VoterPrx
{
    private static final String __vote_name = "vote";

    public int vote(int nVoters, VoteVectorHolder votes)
    {
        return vote(nVoters, votes, null, false);
    }

    public int vote(int nVoters, VoteVectorHolder votes, java.util.Map<String, String> __ctx)
    {
        return vote(nVoters, votes, __ctx, true);
    }

    private int vote(int nVoters, VoteVectorHolder votes, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__vote_name);
        return end_vote(votes, begin_vote(nVoters, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_vote(int nVoters)
    {
        return begin_vote(nVoters, null, false, false, null);
    }

    public Ice.AsyncResult begin_vote(int nVoters, java.util.Map<String, String> __ctx)
    {
        return begin_vote(nVoters, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_vote(int nVoters, Ice.Callback __cb)
    {
        return begin_vote(nVoters, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_vote(int nVoters, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_vote(nVoters, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_vote(int nVoters, Callback_Voter_vote __cb)
    {
        return begin_vote(nVoters, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_vote(int nVoters, java.util.Map<String, String> __ctx, Callback_Voter_vote __cb)
    {
        return begin_vote(nVoters, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_vote(int nVoters, 
                                      FunctionalCallback_Voter_vote_Response __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_vote(nVoters, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_vote(int nVoters, 
                                      FunctionalCallback_Voter_vote_Response __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                      IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_vote(nVoters, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_vote(int nVoters, 
                                      java.util.Map<String, String> __ctx, 
                                      FunctionalCallback_Voter_vote_Response __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_vote(nVoters, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_vote(int nVoters, 
                                      java.util.Map<String, String> __ctx, 
                                      FunctionalCallback_Voter_vote_Response __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                      IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_vote(nVoters, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_vote(int nVoters, 
                                       java.util.Map<String, String> __ctx, 
                                       boolean __explicitCtx, 
                                       boolean __synchronous, 
                                       FunctionalCallback_Voter_vote_Response __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                       IceInternal.Functional_BoolCallback __sentCb)
    {
        class CB extends IceInternal.Functional_TwowayCallback implements _Callback_Voter_vote
        {
            public CB(FunctionalCallback_Voter_vote_Response responseCb, 
                      IceInternal.Functional_GenericCallback1<Ice.Exception> exceptionCb, 
                      IceInternal.Functional_BoolCallback sentCb)
            {
                super(responseCb != null, exceptionCb, sentCb);
                __responseCb = responseCb;
            }

            public void response(int __ret, int[] votes)
            {
                if(__responseCb != null)
                {
                    __responseCb.apply(__ret, votes);
                }
            }

            public final void __completed(Ice.AsyncResult __result)
            {
                VoterPrxHelper.__vote_completed(this, __result);
            }

            private final FunctionalCallback_Voter_vote_Response __responseCb;
        }
        return begin_vote(nVoters, __ctx, __explicitCtx, __synchronous, new CB(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_vote(int nVoters, 
                                       java.util.Map<String, String> __ctx, 
                                       boolean __explicitCtx, 
                                       boolean __synchronous, 
                                       IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__vote_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__vote_name, __cb);
        try
        {
            __result.prepare(__vote_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeInt(nVoters);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public int end_vote(VoteVectorHolder votes, Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __vote_name);
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
            votes.value = VoteVectorHelper.read(__is);
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

    static public void __vote_completed(_Callback_Voter_vote __cb, Ice.AsyncResult __result)
    {
        voting.VoterPrx __proxy = (voting.VoterPrx)__result.getProxy();
        int __ret = 0;
        VoteVectorHolder votes = new VoteVectorHolder();
        try
        {
            __ret = __proxy.end_vote(votes, __result);
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
        __cb.response(__ret, votes.value);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static VoterPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), VoterPrx.class, VoterPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static VoterPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), VoterPrx.class, VoterPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static VoterPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), VoterPrx.class, VoterPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static VoterPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), VoterPrx.class, VoterPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static VoterPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, VoterPrx.class, VoterPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static VoterPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, VoterPrx.class, VoterPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::voting::Voter"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, VoterPrx v)
    {
        __os.writeProxy(v);
    }

    public static VoterPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            VoterPrxHelper result = new VoterPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
