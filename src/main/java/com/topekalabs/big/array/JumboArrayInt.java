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

import com.topekalabs.java.utils.ArrayFactoryInt;
import com.topekalabs.math.utils.IntUtils;
import com.topekalabs.math.utils.LongIntervalU;

/**
 *
 * @author Topeka Labs
 */
public class JumboArrayInt extends JumboArrayAbstract<int[]>
{
    public JumboArrayInt(LongIntervalU longInterval)
    {
        super(new ArrayFactoryInt(),
              longInterval);
        
    }
    
    public JumboArrayInt(LongIntervalU longInterval,
                          int listLength,
                          int subArrayLength)
    {
        super(new ArrayFactoryInt(),
              longInterval,
              listLength,
              subArrayLength);
    }
    
    protected JumboArrayInt(long length,
                             int listLength,
                             int subArrayLength)
    {
        super(new ArrayFactoryInt(),
              length,
              listLength,
              subArrayLength);
    }
    
    public JumboArrayInt(long length)
    {
        super(new ArrayFactoryInt(),
              length);
    }
    
    public int get(long index)
    {
        this.notInIntervalException(index);
        
        int index1 = calcIndex1(index);
        int index2 = calcIndex2(index);
        int index3 = calcIndex3(index);
        
        return data.get(index1).get(index2)[index3];
    }
    
    public void set(long index,
                    int value)
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
        int value = get(index);
        bytes[offset] = IntUtils.getByte0B(value);
        bytes[++offset] = IntUtils.getByte1B(value);
        bytes[++offset] = IntUtils.getByte2B(value);
        bytes[++offset] = IntUtils.getByte3B(value);
    }
}
