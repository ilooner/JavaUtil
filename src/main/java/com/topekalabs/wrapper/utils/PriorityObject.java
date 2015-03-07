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
public class PriorityObject<OBJECT> implements Comparable<PriorityObject<OBJECT>>
{
    private long priority;
    private OBJECT object;
    
    public PriorityObject(OBJECT object,
                          long priority)
    {
        setObject(object);
        setPriority(priority);
    }
    
    private void setObject(OBJECT object)
    {
        ExceptionUtils.isNullException(object, "object");
        this.object = object;
    }
    
    public OBJECT getObject()
    {
        return object;
    }
    
    private void setPriority(long priority)
    {
        this.priority = priority;
    }
    
    public long getPriority()
    {
        return priority;
    }
    
    @Override
    public int compareTo(PriorityObject<OBJECT> o)
    {
        if(priority < o.getPriority())
        {
            return -1;
        }
        else if(priority == o.getPriority())
        {
            return 0;
        }
        
        return 1;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 89 * hash + (int) (this.priority ^ (this.priority >>> 32));
        hash = 89 * hash + Objects.hashCode(this.object);
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
        final PriorityObject<?> other = (PriorityObject<?>) obj;
        if(this.priority != other.priority)
        {
            return false;
        }
        if(!Objects.equals(this.object, other.object))
        {
            return false;
        }
        
        return true;
    }
}
