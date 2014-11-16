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
package com.topekalabs.math.utils;

import com.topekalabs.big.BigHashCode;
import java.util.Random;

/**
 *
 * @author Topeka Labs
 */
public class ULongLong extends Number implements Comparable<ULongLong>,
                                                 BigHashCode
{
    private long lsbs = 0;
    private long msbs = 0;
    
    public ULongLong(Random random)
    {
        lsbs = random.nextLong();
        msbs = random.nextLong();
    }
    
    public ULongLong(int val)
    {
        lsbs = val;
        lsbs &= 0xFFFFFFFF;
    }
    
    public ULongLong(long val)
    {
        lsbs = val;
    }
    
    public ULongLong(long lsbs, long msbs)
    {
        this.lsbs = lsbs;
        this.msbs = msbs;
    }
    
    public long getLsbs()
    {
        return lsbs;
    }
    
    public long getMsbs()
    {
        return msbs;
    }
    
    /*
    public ULongLong add(ULongLong val)
    {
        
    }
    
    public boolean lt(ULongLong val)
    {
        
    }*/
    
    @Override
    public int compareTo(ULongLong val)
    {
        int compareVal = LongUtils.uCompareTo(msbs, val.getMsbs());
        
        if(compareVal != 0)
        {
            return compareVal;
        }
        
        return LongUtils.uCompareTo(lsbs, val.getLsbs());
    }

    @Override
    public int intValue()
    {
        return (int) lsbs;
    }

    @Override
    public long longValue()
    {
        return lsbs;
    }

    @Override
    public float floatValue()
    {
        return ((float) lsbs) + (((float) msbs) * FloatUtils.POW_2_64);
    }

    @Override
    public double doubleValue()
    {
        return ((double) lsbs) + (((double) msbs) * DoubleUtils.POW_2_64);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null || !(o instanceof ULongLong))
        {
            return false;
        }
        
        ULongLong uLongLong = (ULongLong) o;
        
        return lsbs == uLongLong.getLsbs() &&
               msbs == uLongLong.getMsbs();
    }
    
    @Override
    public int hashCode()
    {
        return (int) ((lsbs ^ msbs) % LongUtils.INTEGER_MAX);
    }
    
    @Override
    public long bigHashCode()
    {
        return lsbs ^ msbs;
    }
}
