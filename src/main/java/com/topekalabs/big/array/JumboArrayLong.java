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

import com.topekalabs.java.utils.ArrayFactoryLong;
import com.topekalabs.math.utils.LongIntervalU;
import com.topekalabs.math.utils.LongUtils;

public class JumboArrayLong extends JumboArrayAbstract<long[]>
{
    public JumboArrayLong(LongIntervalU longInterval)
    {
        super(new ArrayFactoryLong(),
              longInterval);
        
    }
    
    public JumboArrayLong(LongIntervalU longInterval,
                          int listLength,
                          int subArrayLength)
    {
        super(new ArrayFactoryLong(),
              longInterval,
              listLength,
              subArrayLength);
    }
    
    protected JumboArrayLong(long length,
                             int listLength,
                             int subArrayLength)
    {
        super(new ArrayFactoryLong(),
              length,
              listLength,
              subArrayLength);
    }
    
    public JumboArrayLong(long length)
    {
        super(new ArrayFactoryLong(),
              length);
    }
    
    public long get(long index)
    {
        this.notInIntervalException(index);
        
        int index1 = calcIndex1(index);
        int index2 = calcIndex2(index);
        int index3 = calcIndex3(index);
        
        return data.get(index1).get(index2)[index3];
    }
    
    public void set(long index,
                    long value)
    {
        this.notInIntervalException(index);
        
        int index1 = calcIndex1(index);
        int index2 = calcIndex2(index);
        int index3 = calcIndex3(index);
        
        data.get(index1).get(index2)[index3] = value;
    }

    @Override
    public void setBytes(long index,
                         int offset,
                         byte[] bytes)
    {
        long value = get(index);
        bytes[offset] = LongUtils.getByte0B(value);
        bytes[++offset] = LongUtils.getByte1B(value);
        bytes[++offset] = LongUtils.getByte2B(value);
        bytes[++offset] = LongUtils.getByte3B(value);
        bytes[++offset] = LongUtils.getByte4B(value);
        bytes[++offset] = LongUtils.getByte5B(value);
        bytes[++offset] = LongUtils.getByte6B(value);
        bytes[++offset] = LongUtils.getByte7B(value);
    }
}
