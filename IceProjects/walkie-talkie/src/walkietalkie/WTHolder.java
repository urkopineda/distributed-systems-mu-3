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

public final class WTHolder extends Ice.ObjectHolderBase<WT>
{
    public
    WTHolder()
    {
    }

    public
    WTHolder(WT value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        if(v == null || v instanceof WT)
        {
            value = (WT)v;
        }
        else
        {
            IceInternal.Ex.throwUOE(type(), v);
        }
    }

    public String
    type()
    {
        return _WTDisp.ice_staticId();
    }
}
