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
 * This is a class which provides common utility methods for dealing with
 * longs.
 * @author Topeka Labs
 */
public final class LongUtils
{
    public static final long INTEGER_MAX = (long) ((int) Integer.MAX_VALUE);
    
    private LongUtils()
    {
        //Do nothing.
    }
    
    public static void isNotInIntervalInclusiveException(long startingIndex,
                                                         long endingIndex,
                                                         long value)
    {
        LongUtils.isGTEException(endingIndex, startingIndex);
        
        LongUtils.isGTException(endingIndex, value, "value");
        LongUtils.isLTException(startingIndex, value, "value");
    }
    
    /**
     * This method throws an IllegalArgumentException if the two given values don't
     * equal.
     * @param value This is compared to equal for equality.
     * @param equal This is compared to value for equality.
     */
    public static void isNotEqualToException(long equal,
                                             long value)
    {
        if(value != equal)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " must be equal to " +
                                               equal +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the two given values don't
     * equal. The name of value is added to the exception message.
     * @param value This is compared to equal for equality.
     * @param equal This is compared to value for equality.
     * @param valueName This is the name of value.
     */
    public static void isNotEqualToException(long equal,
                                             long value,
                                             String valueName)
    {
        if(value != equal)
        {
            throw new IllegalArgumentException("The given value " +
                                               value + " (" + valueName + ")" +
                                               " must be equal to " +
                                               equal +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the two given values don't
     * equal. The name of value is added to the exception message. The name of equals
     * is added to the exception message.
     * @param value This is compared to equal for equality.
     * @param equal This is compared to value for equality.
     * @param valueName This is the name of value.
     * @param equalName This is the name of equal.
     */
    public static void isNotEqualToException(long equal,
                                             long value,
                                             String equalName,
                                             String valueName)
    {
        if(value != equal)
        {
            throw new IllegalArgumentException("The given value " +
                                               value + " (" + valueName + ")" +
                                               " must be equal to " +
                                               equal + " (" + equalName + ")" +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is
     * less than or equal to the threshold.
     * @param value The value to check.
     * @param threshold The threshold to compare against.
     */
    public static void isLTEException(long threshold,
                                      long value)
    {
        if(value <= threshold)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " must be greater than " +
                                               threshold +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is
     * less than or equal to the threshold. The name of value is added to the exception message.
     * @param value The value to check.
     * @param threshold The threshold to compare against.
     * @param valueName The name of the given value.
     */
    public static void isLTEException(long threshold,
                                      long value,
                                      String valueName)
    {
        if(value <= threshold)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " " +
                                               valueName +
                                               " " +
                                               " must be greater than " +
                                               threshold +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is
     * less than the threshold.
     * @param value The value to check.
     * @param threshold The threshold to compare against.
     */
    public static void isLTException(long threshold,
                                     long value)
    {
        if(value >= threshold)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " must be greater than or equal to " +
                                               threshold +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is
     * less than the threshold. The name of value is added to the exception message.
     * @param value The value to check.
     * @param threshold The threshold to compare against.
     * @param valueName The name of the given value.
     */
    public static void isLTException(long threshold,
                                     long value,
                                     String valueName)
    {
        if(value >= threshold)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " " +
                                               valueName +
                                               " " +
                                               " must be greater than or equal to " +
                                               threshold +
                                               ".");
        }
    }

    /**
     * This method throws an IllegalArgumentException if the given value is
     * greater than the threshold.
     * @param value The value to check.
     * @param threshold The threshold to compare against.
     */
    public static void isGTException(long threshold,
                                     long value)
    {
        if(value > threshold)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " must be less or equal to " +
                                               threshold +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is
     * greater than the threshold. The name of value is added to the exception message.
     * @param value The value to check.
     * @param threshold The threshold to compare against.
     * @param valueName The name of the given value.
     */
    public static void isGTException(long threshold,
                                     long value,
                                     String valueName)
    {
        if(value > threshold)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " " +
                                               valueName +
                                               " " +
                                               " must be less than or equal to " +
                                               threshold +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is
     * greater than or equal to the threshold.
     * @param value The value to check.
     * @param threshold The threshold to compare against.
     */
    public static void isGTEException(long threshold,
                                      long value)
    {
        if(value >= threshold)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " must be less than " +
                                               threshold +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is
     * greater than or equal to the threshold. The name of value is added to the exception message.
     * @param value The value to check.
     * @param threshold The threshold to compare against.
     * @param valueName The name of the given value.
     */
    public static void isGTEException(long threshold,
                                      long value,
                                      String valueName)
    {
        if(value >= threshold)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " " +
                                               valueName +
                                               " " +
                                               " must be less than " +
                                               threshold +
                                               ".");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not
     * positive.
     * @param value The value to check. 
     */
    public static void isNonPositiveException(long value)
    {
        if(value <= 0)
        {
            throw new IllegalArgumentException("The given value " + value + " must be positive.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not
     * positive.
     * @param value The value to check.
     * @param valueName The name of the value.
     */
    public static void isNonPositiveException(long value, 
                                              String valueName)
    {
        if(value <= 0)
        {
            throw new IllegalArgumentException("The given value " + valueName + " " + value + " must be positive.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is negative.
     * @param value The value to check.
     */
    public static void isNegativeException(long value)
    {
        if(value < 0)
        {
            throw new IllegalArgumentException("The given value " + value + " must be nonegative.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is negative.
     * @param value The value to check.
     * @param valueName The name of the value.
     */
    public static void isNegativeException(long value, String valueName)
    {
        if(value < 0)
        {
            throw new IllegalArgumentException("The given value " + valueName + " " + value + " must be nonegative.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is non negative.
     * @param value The value to check.
     */
    public static void isNonNegativeException(long value)
    {
        if(value >= 0)
        {
            throw new IllegalArgumentException("The given value " + value + " must be negative.");
        }
    }

    /**
     * This method throws an IllegalArgumentException if the given value is non negative.
     * @param value The value to check.
     * @param valueName The name of the value.
     */
    public static void isNonNegativeException(long value, String valueName)
    {
        if(value >= 0)
        {
            throw new IllegalArgumentException("The given value " + valueName + " " + value + " must be negative.");
        }
    }
    
    /**
     * This method throws and IllegalArgumentException if the given value is positive.
     * @param value The value to check.
     */
    public static void isPositiveException(long value)
    {
        if(value > 0)
        {
            throw new IllegalArgumentException("The given value " + value + " must be nonpositive.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is positive.
     * @param value The value to check.
     * @param valueName The name of the value.
     */
    public static void isPositiveException(long value, String valueName)
    {
        if(value > 0)
        {
            throw new IllegalArgumentException("The given value " + valueName + " " + value + " must be nonpositive.");
        }
    }
    
    /**
     * This method returns the absolute value of the provided value.
     * @param value The value to take the absolute value of.
     * @return The absolute value of the given value.
     */
    public static long abs(long value)
    {
        if(value < 0)
        {
            return -value;
        }
        
        return value;
    }
    
    /**
     * This method throws an IllegalArgumentException if the two provided integers
     * cannot be added without an overflow or underflow occurring.
     * @param a An integer to add.
     * @param b An integer to add.
     */
    public static void safeAddException(long a, long b)
    {
        if(a == 0 || b == 0)
        {
            return;
        }
        
        if((a < 0 && b > 0) ||
           (a > 0 && b < 0))
        {
            return;
        }
        
        if(a < 0)
        {
            if(a + b >= 0)
            {
                throw new IllegalArgumentException("Adding the two numbers " + a +
                                                   " and " + b + " causes an underflow.");
            }
        }
        else
        {
            if(a + b <= 0)
            {
                throw new IllegalArgumentException("Adding the two numbers " + a +
                                                   " and " + b + " causes an overflow.");
            }
        }
    }
    
    /**
     * This method returns true if the two provided integers can be added with an
     * overflow or underflow.
     * @param a An integer to be added.
     * @param b An integer to be added.
     * @return The sum of the two provided integers.
     */
    public static boolean isSafeAdd(long a, long b)
    {
        if(a == 0 || b == 0)
        {
            return true;
        }
        
        if((a < 0 && b > 0) ||
           (a > 0 && b < 0))
        {
            return true;
        }
        
        if(a < 0)
        {
            if(a + b >= 0)
            {
                return false;
            }
        }
        else
        {
            if(a + b <= 0)
            {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * This method safely adds two integers. An IllegalArgumentException is thrown
     * if an underflow or overflow would occur.
     * @param a An integer to add.
     * @param b An integer to add.
     * @return The sum of the two input integers.
     */
    public static long safeAdd(long a, long b)
    {
        safeAddException(a, b);
        return a + b;
    }
    
    public static long uDiv(long value, long divisor)
    {
        if(divisor == 0L)
        {
            throw new IllegalArgumentException("Should not divide by zero.");
        }
        
        if(value == 0L)
        {
            return 0L;
        }
        
        if(LongUtils.ult(value, divisor))
        {
            return 0L;
        }
        
        long maxBitPosValue = maxSetBitPosition(value);
        long maxBitPosDivisor = maxSetBitPosition(divisor);
        long quotient = 0;
        
        for(long diff = maxBitPosValue - maxBitPosDivisor;
            diff >= 0;
            diff--)
        {
            long tempDivisor = divisor << diff;
            
            if(LongUtils.ult(value, tempDivisor))
            {
                continue;
            }
            
            value -= tempDivisor;
            quotient |= 1 << diff;
        }
        
        return quotient;
    }
    
    public static long uMod(long value, long mod)
    {
        long quotient = uDiv(value, mod);
        return value - quotient * mod;
    }
    
    /*
    public static long uDivCeil(long value, long divisor)
    {
        long mod;
        
        if(value % divisor == 0L)
        {
            mod = 0L;
        }
        else
        {
            mod = 1L;
        }
        
        return value / divisor + mod;
    }
    */
    public static long bitReverse(long value)
    {
        long byte0 = getByte0(value);
        long byte1 = getByte1(value);
        long byte2 = getByte2(value);
        long byte3 = getByte3(value);
        long byte4 = getByte4(value);
        long byte5 = getByte5(value);
        long byte6 = getByte6(value);
        long byte7 = getByte7(value);
        
        byte0 = ByteUtils.getReversedByte(byte0);
        byte1 = ByteUtils.getReversedByte(byte1);
        byte2 = ByteUtils.getReversedByte(byte2);
        byte3 = ByteUtils.getReversedByte(byte3);
        byte4 = ByteUtils.getReversedByte(byte4);
        byte5 = ByteUtils.getReversedByte(byte5);
        byte6 = ByteUtils.getReversedByte(byte6);
        byte7 = ByteUtils.getReversedByte(byte7);
        
        long rValue = 0;
        rValue |= byte0 << 56;
        rValue |= byte1 << 48;
        rValue |= byte2 << 40;
        rValue |= byte3 << 32;
        rValue |= byte4 << 24;
        rValue |= byte5 << 16;
        rValue |= byte6 << 8;
        rValue |= byte7;
        
        return rValue;
    }
    
    public static boolean ugt(long a, long b)
    {
        return ult(b, a);
    }
    
    public static boolean ugte(long a, long b)
    {
        return ulte(b, a);
    }
    
    public static boolean ulte(long a, long b)
    {
        return a == b || ult(a, b);
    }
    
    public static boolean ult(long a, long b)
    {
        if(a > 0L)
        {
            if(b > 0L)
            {
                if(a < b)
                {
                    return true;
                }
                
                return false;
            }
            else if(b == 0L)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(a == 0)
        {
            if(b == 0)
            {
                return false;
            }
            
            return true;
        }
        else
        {
            if(b >= 0L)
            {
                return false;
            }
            else
            {
                return a > b;
            }
        }
    }
    
    public static int uCompareTo(long a, long b)
    {
        if(a == b)
        {
            return 0;
        }
        
        if(ult(a, b))
        {
            return -1;
        }
        
        return 1;
    }
    
    public static long urs(long value, long shift)
    {
        if(value >= 0L)
        {
            return value >> shift;
        }
        
        shift %= 64;
        shift += 64;
        shift %= 64;
        
        if(shift == 0)
        {
            return value;
        }
        
        shift--;
        value = (value >> 1L) & 0x7FFFFFFFFFFFFFFFL;
        return value >> shift;
    }
    
    public static long getByte0(long val)
    {
        return val & 0xFF;
    }
    
    public static long getByte1(long val)
    {
        return (val >> 8) & 0xFF;
    }
    
    public static long getByte2(long val)
    {
        return (val >> 16) & 0xFF;
    }
    
    public static long getByte3(long val)
    {
        return (val >> 24) & 0xFF;
    }
    
    public static long getByte4(long val)
    {
        return (val >> 32) & 0xFF;
    }
    
    public static long getByte5(long val)
    {
        return (val >> 40) & 0xFF;
    }
    
    public static long getByte6(long val)
    {
        return (val >> 48) & 0xFF;
    }
    
    public static long getByte7(long val)
    {
        return (val >> 56) & 0xFF;
    }
    
    public static boolean bitSet(long value, long bit)
    {
        return (value & (1L << bit)) > 0L;
    }
    
    public static long maxSetBitPosition(long value)
    {
        if(value == 0L)
        {
            return -1L;
        }
        
        for(int bitCounter = 0;
            bitCounter < 64;
            bitCounter++)
        {
            value = value >> 1L;
            
            if(value == 0L)
            {
                return bitCounter;
            }
        }
        
        return 63;
    }
    
    public String uToOctalString(long value)
    {
        return uToString(value, 8);
    }
    
    public String uToHexString(long value)
    {
        return uToString(value, 16);
    }
    
    public String uToString(long value)
    {
        return uToString(value, 10);
    }
    
    public String uToString(long value, int radix)
    {
        if(value == 0L)
        {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(;
            LongUtils.ugt(value, 0L);
            value = LongUtils.uDiv(value, radix))
        {
            sb.append(LongUtils.uMod(value, radix));
        }
        
        return sb.toString();
    }
}
