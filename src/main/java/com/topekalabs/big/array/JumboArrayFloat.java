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

import com.topekalabs.array.utils.ArrayFactoryFloat;

/**
 *
 * @author Topeka Labs
 */
public class JumboArrayFloat extends JumboArrayAbstract<float[]>
                             implements JumboArrayFloatInterface
{
    protected JumboArrayFloat(long length,
                             int listLength,
                             int subArrayLength)
    {
        super(new ArrayFactoryFloat(),
              length,
              listLength,
              subArrayLength);
    }
    
    public JumboArrayFloat(long length)
    {
        super(new ArrayFactoryFloat(),
              length);
    }
    
    public float get(long index)
    {
        int index1 = calcIndex1(index);
        int index2 = calcIndex2(index);
        int index3 = calcIndex3(index);
        
        return data.get(index1).get(index2)[index3];
    }
    
    public void set(long index,
                    float value)
    {
        int index1 = calcIndex1(index);
        int index2 = calcIndex2(index);
        int index3 = calcIndex3(index);
        
        data.get(index1).get(index2)[index3] = value;
    }
    
    @Override
    protected void localSwap(long indexA, long indexB)
    {
        float tempVal = get(indexA);
        set(indexA, get(indexB));
        set(indexB, tempVal);
    }
}
