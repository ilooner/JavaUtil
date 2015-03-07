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
package com.topekalabs.math.utils;

import com.topekalabs.error.utils.ExceptionUtils;

/**
 *
 * @author Topeka Labs
 */
public class DiscreteMathLong
{
    public static long logCeil(long value, long base)
    {
        LongUtils.isNonPositiveException(value, "value");
        ExceptionUtils.illegal(base <= 1, "The given base must be greater than 1.");
        
        long result = 0;
        
        while(value > 1)
        {
            value = LongUtils.divCeil(value, base);
            result++;
        }
        
        return result;
    }
    
    public static long treeSumInclusive(long value, long base)
    {
        long result = treeSumExclusive(value, base);
        return result + value;
    }
    
    public static long treeSumExclusive(long value, long base)
    {
        LongUtils.isNonPositiveException(value, "value");
        ExceptionUtils.illegal(base <= 1, "The given base must be greater than 1.");
        
        int result = 0;
        
        while(value > 1)
        {
            value = LongUtils.divCeil(value, base);
            result += value;
        }
        
        return result;
    }
}
