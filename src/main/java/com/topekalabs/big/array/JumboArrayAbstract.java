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

import com.google.common.collect.Lists;
import com.topekalabs.java.utils.ArrayFactory;
import com.topekalabs.java.utils.ExceptionUtils;
import com.topekalabs.math.utils.IntUtils;
import com.topekalabs.math.utils.LongIntervalU;
import com.topekalabs.math.utils.LongUtils;
import java.util.List;

/**
 *
 * @author Topeka Labs
 */
public abstract class JumboArrayAbstract<T>
{
    private long index1Count = -1L;
    
    private long index2Count = -1L;
    private int partialArrayLength2 = Integer.MIN_VALUE;
    private boolean hasPartialArray2 = false;
    
    private long subArrayLength = Integer.MAX_VALUE;
    private long length;
    
    private long firstOrderArrayLength;
    
    private LongIntervalU indexInterval;
    private ArrayFactory<T> arrayFactory;
    
    protected List<List<T>> data;

    protected JumboArrayAbstract(ArrayFactory<T> arrayFactory,
                                 long length,
                                 int subArrayLength)
    {
        setArrayFactory(arrayFactory);
        setLength(length);
        setSubArrayLength(subArrayLength);
        initialize();
    }
    
    protected JumboArrayAbstract(ArrayFactory<T> arrayFactory,
                                 long length)
    {
        setArrayFactory(arrayFactory);
        setLength(length);
        initialize();
    }
    
    protected JumboArrayAbstract(ArrayFactory<T> arrayFactory,
                                 LongIntervalU longInterval)
    {
        setArrayFactory(arrayFactory);
        setIndexInterval(longInterval);
        this.length = longInterval.getNumVals();
        initialize();
    }
    
    protected JumboArrayAbstract(ArrayFactory<T> arrayFactory,
                                 LongIntervalU longInterval,
                                 int subArrayLength)
    {
        setArrayFactory(arrayFactory);
        setIndexInterval(longInterval);
        setSubArrayLength(subArrayLength);
        initialize();
    }
    
    private void initialize()
    {
        this.firstOrderArrayLength = LongUtils.INTEGER_MAX * subArrayLength;
        
        calcIndex1Count();
        
        calcIndex2Count();
        calcPartialArrayLength2();
        calcHasPartialArray2();
        
        data = Lists.newArrayList();
        long listCounter2 = 0;
        
        for(long listCounter1 = 0;
            listCounter1 < getIndex1Count() - 1;
            listCounter1++)
        {
            List<T> longLists = Lists.newArrayList();
            
            for(;
                listCounter2 < Integer.MAX_VALUE;
                listCounter2++)
            {
                longLists.add(arrayFactory.createArray((int) subArrayLength));
            }
            
            data.add(longLists);
        }
        
        {
            
            List<T> longLists = Lists.newArrayList();
            
            for(;
                listCounter2 < getIndex2Count();
                listCounter2++)
            {

                longLists.add(arrayFactory.createArray((int) subArrayLength));

            }

            if(getHasPartialArray2())
            {
                longLists.add(arrayFactory.createArray(this.getPartialArrayLength2()));
            }
        
            data.add(longLists);
        }
        
        List<T> longLists = Lists.newArrayList();
    }
    
    private void setArrayFactory(ArrayFactory<T> arrayFactory)
    {
        ExceptionUtils.isNullException(arrayFactory, "arrayFactory");
        this.arrayFactory = arrayFactory;
    }
    
    private void calcIndex1Count()
    {
        index1Count = LongUtils.uDivCeil(index2Count, firstOrderArrayLength);
    }
    
    public final long getIndex1Count()
    {
        return index1Count;
    }
    
    private void calcIndex2Count()
    {
        index2Count = LongUtils.uDivCeil(length, subArrayLength);
    }
    
    public final long getIndex2Count()
    {
        return index2Count;
    }
    
    private void calcHasPartialArray2()
    {
        hasPartialArray2 = LongUtils.uMod(length, subArrayLength) != 0L;
    }
    
    public final boolean getHasPartialArray2()
    {
        return hasPartialArray2;
    }
    
    private void calcPartialArrayLength2()
    {
        partialArrayLength2 = (int) LongUtils.uMod(length, subArrayLength);
    }
    
    public final int getPartialArrayLength2()
    {
        return partialArrayLength2;
    }
    
    private void setIndexInterval(LongIntervalU indexInterval)
    {
        ExceptionUtils.isNullException(indexInterval, "indexInterval");
        this.indexInterval = indexInterval;
    }
    
    public LongIntervalU getIndexInterval()
    {
        return indexInterval;
    }
    
    public int getSubArrayLength()
    {
        return (int) subArrayLength;
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
    
    protected void notInIntervalException(long index)
    {
        if(!indexInterval.isInIntervalInclusive(index))
        {
            throw new JumboArrayIndexOutOfBoundsException(index);
        }
    }
    
    protected int calcIndex1(long index)
    {
        index = index - indexInterval.getStartInterval();
        
        return (int) LongUtils.uDiv(index, firstOrderArrayLength);
    }
    
    protected int calcIndex2(long index)
    {
        index = index - indexInterval.getStartInterval();
        
        return (int) LongUtils.uMod(LongUtils.uDiv(index, subArrayLength),
                                    LongUtils.INTEGER_MAX);
    }
    
    protected int calcIndex3(long index)
    {
        index = index - indexInterval.getStartInterval();
        
        return (int) LongUtils.uMod(index, subArrayLength);
    }
}
