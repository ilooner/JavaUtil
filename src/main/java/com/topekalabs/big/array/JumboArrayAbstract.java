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
import com.topekalabs.array.utils.ArrayFactory;
import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.utils.IntUtils;
import com.topekalabs.math.utils.LongInterval;
import com.topekalabs.math.utils.LongUtils;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Topeka Labs
 */
public abstract class JumboArrayAbstract<T> implements JumboArray
{
    private static final Logger logger = LoggerFactory.getLogger(JumboArrayAbstract.class.getName());
    private long index1Count = -1L;
    
    private long index2Count = -1L;
    private int finalArrayLength2 = -1;
    private int finalArrayLength3 = -1;
    
    private long listLength = Integer.MAX_VALUE;
    private long subArrayLength = Integer.MAX_VALUE;
    private long length;
    
    private long firstOrderArrayLength;
    
    private ArrayFactory<T> arrayFactory;
    
    private List<JumboArrayAbstract<T>> parallelArrays = Lists.newArrayList();
    
    protected List<List<T>> data;
    protected LongInterval indexInterval;
    
    protected JumboArrayAbstract(ArrayFactory<T> arrayFactory,
                                 long length,
                                 int listLength,
                                 int subArrayLength)
    {
        setArrayFactory(arrayFactory);
        setLength(length);
        setListLength(listLength);
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
    
    private void initialize()
    {
        
        this.firstOrderArrayLength = listLength * subArrayLength;
        
        calcIndex1Count();
        calcIndex2Count();
        calcIndex3Count();
        
        data = Lists.newArrayList();
        
        logger.debug("Length: {}, index1Count: {}",
                     getLength(),
                     getIndex1Count());
        
        for(long listCounter1 = 0;
            listCounter1 < getIndex1Count() - 1;
            listCounter1++)
        {
            List<T> longLists = Lists.newArrayList();
            
            for(long listCounter2 = 0;
                listCounter2 < listLength;
                listCounter2++)
            {
                longLists.add(arrayFactory.createArray((int) subArrayLength));
            }
            
            data.add(longLists);
        }
        
        {
            List<T> longLists = Lists.newArrayList();
            
            for(long listCounter2 = 0;
                listCounter2 < getFinalArrayLength2() - 1;
                listCounter2++)
            {
                longLists.add(arrayFactory.createArray((int) subArrayLength));
            }

            longLists.add(arrayFactory.createArray(getFinalArrayLength3()));
        
            data.add(longLists);
        }
    }
    
    private void setArrayFactory(ArrayFactory<T> arrayFactory)
    {
        ExceptionUtils.isNullException(arrayFactory, "arrayFactory");
        this.arrayFactory = arrayFactory;
    }
    
    private void calcIndex1Count()
    {
        index1Count = LongUtils.divCeil(length, firstOrderArrayLength);
    }
    
    public final long getIndex1Count()
    {
        return index1Count;
    }
    
    private void calcIndex2Count()
    {
        index2Count = LongUtils.divCeil(length, subArrayLength);
        finalArrayLength2 = (int) (LongUtils.divCeil(length, subArrayLength) % listLength);
        
        if(finalArrayLength2 == 0)
        {
            finalArrayLength2 = (int) listLength;
        }
    }
    
    public final long getIndex2Count()
    {
        return index2Count;
    }
    
    public final int getFinalArrayLength2()
    {
        return finalArrayLength2;
    }
    
    private void calcIndex3Count()
    {
        finalArrayLength3 = (int) (length % subArrayLength);
        
        if(finalArrayLength3 == 0)
        {
            finalArrayLength3 = (int) subArrayLength;
        }
    }
    
    public final int getFinalArrayLength3()
    {
        return finalArrayLength3;
    }
    
    public int getSubArrayLength()
    {
        return (int) subArrayLength;
    }
    
    private void setSubArrayLength(int subArrayLength)
    {
        IntUtils.isNonPositiveException(subArrayLength, "subArrayLength");
        this.subArrayLength = subArrayLength;
    }
    
    public int getListLength()
    {
        return (int) listLength;
    }
    
    private void setListLength(int listLength)
    {
        IntUtils.isNonPositiveException(listLength, "listLength");
        this.listLength = listLength;
    }
    
    private void setLength(long length)
    {
        LongUtils.isEqualToException(0, length, "zero", "length");
        
        this.length = length;
        this.indexInterval = new LongInterval(0, length -1);
    }
    
    public long getLength()
    {
        return length;
    }
    
    protected int calcIndex1(long index)
    {   
        return (int) LongUtils.uDiv(index, firstOrderArrayLength);
    }
    
    protected int calcIndex2(long index)
    {
        return (int) LongUtils.uMod(LongUtils.uDiv(index, subArrayLength),
                                    listLength);
    }
    
    protected int calcIndex3(long index)
    {
        return (int) LongUtils.uMod(index, subArrayLength);
    }
    
    protected List<List<T>> getData()
    {
        return data;
    }
    
    @Override
    public LongInterval getIndexInterval()
    {
        return indexInterval;
    }
    
    public void swap(long indexA, long indexB)
    {
        for(int arrayCounter = 0;
            arrayCounter < parallelArrays.size();
            arrayCounter++)
        {
            parallelArrays.get(arrayCounter).localSwap(indexA, indexB);
        }
        
        localSwap(indexA, indexB);
    }
    
    protected abstract void localSwap(long indexA, long indexB);
}
