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
public class DiscreteMathInt
{
    private DiscreteMathInt()
    {
    }
    
    public static int logCeil(int value, int base)
    {
        IntUtils.isNonPositiveException(value, "value");
        ExceptionUtils.illegal(base <= 1, "The given base must be greater than 1.");
        
        int result = 0;
        
        while(value > 1)
        {
            value = IntUtils.divCeil(value, base);
            result++;
        }
        
        return result;
    }
    
    public static int treeSumInclusive(int value, int base)
    {
        int result = treeSumExclusive(value, base);
        return result + value;
    }
    
    public static int treeSumExclusive(int value, int base)
    {
        IntUtils.isNonPositiveException(value, "value");
        ExceptionUtils.illegal(base <= 1, "The given base must be greater than 1.");
        
        int result = 0;
        
        while(value > 1)
        {
            value = IntUtils.divCeil(value, base);
            result += value;
        }
        
        return result;
    }
    
    public static int powerSum(int base, int maxPow)
    {
        IntUtils.isNegativeException(maxPow, "maxPow");
        
        int sum = 1;
        int currentPow = 1;
        
        for(int pow = 1;
            pow < maxPow;
            pow++)
        {
            currentPow *= base;
            sum += currentPow;
        }
        
        return sum;
    }
}
