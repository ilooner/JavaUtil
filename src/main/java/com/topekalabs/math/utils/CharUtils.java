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

/**
 *
 * @author Topeka Labs
 */
public final class CharUtils
{
    public static final IntInterval RADIX_10_DIGIT_INTERVAL = new IntInterval(0, 9);
    public static final IntInterval RADIX_INTERVAL = new IntInterval(Character.MIN_RADIX,
                                                                     Character.MAX_RADIX);
    
    private CharUtils()
    {
        //Do nothing
    }
    
    public static final char digit(int digitValue, int radix)
    {
        RADIX_INTERVAL.notInIntervalInclusiveException(radix);
        
        IntInterval digitInterval = new IntInterval(0, radix - 1);
        digitInterval.notInIntervalInclusiveException(digitValue);
        
        if(RADIX_10_DIGIT_INTERVAL.isInIntervalInclusive(digitValue))
        {
            return (char) ('0' + digitValue);
        }
        
        return (char) ('a' + (digitValue - 10));
    }
}
