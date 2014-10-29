/*
 * Copyright 2014 Topeka Labs.
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
package com.topekalabs.datastruct;

import com.topekalabs.math.utils.IntUtils;
import com.topekalabs.math.utils.LongUtils;

/**
 *
 * @author Topeka Labs
 */
public abstract class AbstractJumboArray
{
    //public static LongInterval 
    
    private int subArrayLength = Integer.MAX_VALUE;
    private long length;
    
    protected AbstractJumboArray(long length,
                                 int subArrayLength)
    {
        setLength(length);
        setSubArrayLength(subArrayLength);
        initialize();
    }
    
    public AbstractJumboArray(long length)
    {
        setLength(length);
        initialize();
    }
    
    private void initialize()
    {
        
    }
    
    private void setSubArrayLength(int subArrayLength)
    {
        IntUtils.isPositiveException(subArrayLength, "subArrayLength");
        this.subArrayLength = subArrayLength;
    }
    
    private void setLength(long length)
    {
        LongUtils.isNonPositiveException(length, "length");
        this.length = length;
    }
    
    public long getLength()
    {
        return length;
    }
    
    //public 
}
