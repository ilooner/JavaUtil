/*
 * Copyright 2015 Topeka Labs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.topekalabs.wrapper.utils;

import com.topekalabs.error.utils.ExceptionUtils;
import java.util.Objects;

/**
 *
 * @author Topeka Labs
 */
public class ImmutableObject<PAYLOAD>
{
    private PAYLOAD payload;
    
    public ImmutableObject(PAYLOAD payload)
    {
        setPayload(payload);
    }
    
    private void setPayload(PAYLOAD payload)
    {
        ExceptionUtils.isNullException(payload, "payload");
        this.payload = payload;
    }
    
    public PAYLOAD getPayload()
    {
        return payload;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.payload);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(getClass() != obj.getClass())
        {
            return false;
        }
        final ImmutableObject<?> other = (ImmutableObject<?>) obj;
        if(!Objects.equals(this.payload, other.payload))
        {
            return false;
        }
        return true;
    }
}
