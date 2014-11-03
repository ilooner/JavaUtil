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
package com.topekalabs.big.array;

import com.topekalabs.java.utils.ExceptionUtils;
import com.topekalabs.math.utils.IntUtils;
import com.topekalabs.math.utils.LongInterval;
import com.topekalabs.math.utils.LongUtils;

/**
 *
 * @author Topeka Labs
 */
public abstract class AbstractJumboArray
{
    private long index1Count = -1L;
    private long index2Count = -1L;
    private boolean hasPartialArray = false;
    private int partialArrayLength = Integer.MIN_VALUE;
    
    private int subArrayLength = Integer.MAX_VALUE;
    private long length;
    
    private LongInterval indexInterval;

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
    
    public AbstractJumboArray(LongInterval longInterval)
    {
        setIndexInterval(longInterval);
        this.length = longInterval.getNumVals();
    }
    
    public AbstractJumboArray(LongInterval longInterval,
                              int subArrayLength)
    {
        setIndexInterval(longInterval);
    }
    
    private void initialize()
    {
        getIndex1Count();
        getIndex2Count();
        calcHasPartialArray();
        calcPartialArrayLength();
    }
    
    private void calcIndex1Count()
    {
        
    }
    
    public final long getIndex1Count()
    {
        return index1Count;
    }
    
    private void calcIndex2Count()
    {
    }
    
    public final long getIndex2Count()
    {
        return index2Count;
    }
    
    private void calcHasPartialArray()
    {
        
    }
    
    private void calcPartialArrayLength()
    {
        
    }
    
    private void setIndexInterval(LongInterval indexInterval)
    {
        ExceptionUtils.isNullException(indexInterval, "indexInterval");
        this.indexInterval = indexInterval;
    }
    
    public LongInterval getIndexInterval()
    {
        return indexInterval;
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
