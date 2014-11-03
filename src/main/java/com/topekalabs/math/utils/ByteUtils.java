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
public class ByteUtils
{
    private static final byte[] BIT_REVERSAL_MAP_BYTE = new byte[256];
    private static final int[] BIT_REVERSAL_MAP_INT = new int[256];
    private static final long[] BIT_REVERSAL_MAP_LONG = new long[256];
    
    static
    {
        buildBitReversalMaps();
    }
    
    private static void buildBitReversalMaps()
    {
        for(int value = 0;
            value <= 0xFF;
            value++)
        {
            int reversedValue = 0;
            
            for(int bitPosition = 0;
                bitPosition < 8;
                bitPosition++)
            {
                int reversedPosition = 7 - bitPosition;
                reversedValue |= ((value & (1 << bitPosition)) >>
                                 bitPosition) << reversedPosition;
            }
            
            BIT_REVERSAL_MAP_BYTE[value] = (byte) reversedValue;
            BIT_REVERSAL_MAP_INT[value] = reversedValue;
            BIT_REVERSAL_MAP_LONG[value] = (long) reversedValue;
        }
    }
    
    public static byte getReversedByte(byte value)
    {
        int valueInt = 0xFF & ((int) value);
        return BIT_REVERSAL_MAP_BYTE[valueInt];
    }
    
    public static int getReversedByte(int value)
    {
        isNotByteException(value);
        return BIT_REVERSAL_MAP_INT[value];
    }

    public static long getReversedByte(long value)
    {
        isNotByteException(value);
        return BIT_REVERSAL_MAP_LONG[(int) value];
    }
    
    public static boolean isByte(int val)
    {
        return val <= 0xFF;
    }
    
    public static boolean isByte(long val)
    {
        return val <= 0xFFL;
    }
    
    public static void isNotByteException(int val)
    {
        if(isByte(val))
        {
            return;
        }
        
        throw new IllegalArgumentException("The given value must be less than or equal to 0xFF");
    }
    
    public static void isNotByteException(long val)
    {
        if(isByte(val))
        {
            return;
        }
        
        throw new IllegalArgumentException("The given value must be less than or equal to 0xFF");
    }
    
    public static void isNotByteException(int val, String name)
    {
        if(isByte(val))
        {
            return;
        }
        
        throw new IllegalArgumentException("The given value for " +
                                           name +
                                           " must be less than or equal to 0xFF");
    }
    
    public static void isNotByteException(long val, String name)
    {
        if(isByte(val))
        {
            return;
        }
        
        throw new IllegalArgumentException("The given value for " +
                                           name +
                                           " must be less than or equal to 0xFF");
    }
    
    
}
