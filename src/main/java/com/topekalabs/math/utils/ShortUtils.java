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
public class ShortUtils
{
    public static final short POW_2_0 = 1;
    public static final short POW_2_8 = 256;
    
    public static final short POW_2_10 = 1024;
    public static final short KB = POW_2_10;
    
    public static final IntInterval BIT_INTERVAL = new IntInterval(0, 31);
    
    private ShortUtils()
    {
        //Do nothing.
    }
    
    public static void isNotInIntervalInclusiveException(short startingIndex,
                                                         short endingIndex,
                                                         short value)
    {
        ShortUtils.isGTEException(endingIndex, startingIndex);
        
        ShortUtils.isGTException(endingIndex, value, "value");
        ShortUtils.isLTException(startingIndex, value, "value");
    }
    
    /**
     * This method throws an IllegalArgumentException if the two given values don't
     * equal.
     * @param value This is compared to equal for equality.
     * @param equal This is compared to value for equality.
     */
    public static void isNotEqualToException(short equal,
                                             short value)
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
    public static void isNotEqualToException(short equal,
                                             short value,
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
    public static void isNotEqualToException(short equal,
                                             short value,
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
    public static void isLTEException(short threshold,
                                      short value)
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
    public static void isLTEException(short threshold,
                                      short value,
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
    public static void isLTException(short threshold,
                                     short value)
    {
        if(value < threshold)
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
    public static void isLTException(short threshold,
                                     short value,
                                     String valueName)
    {
        if(value < threshold)
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " " +
                                               valueName +
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
    public static void isGTException(short threshold,
                                     short value)
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
    public static void isGTException(short threshold,
                                     short value,
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
    public static void isGTEException(short threshold,
                                      short value)
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
    public static void isGTEException(short threshold,
                                      short value,
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
    public static void isNonPositiveException(short value)
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
    public static void isNonPositiveException(short value, 
                                              String valueName)
    {
        if(value <= 0)
        {
            throw new IllegalArgumentException("The given value " + valueName + " " + value + " must be positive.");
        }
    }
    
    public static void isZeroException(short value)
    {
        if(value == 0)
        {
            throw new IllegalArgumentException("The given value " + value + " cannot be zero.");
        }
    }
    
    public static void isZeroException(short value,
                                       String valueName)
    {
        if(value == 0)
        {
            throw new IllegalArgumentException("The given value " +
                                               valueName + " " + value +
                                               " cannot be zero.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is negative.
     * @param value The value to check.
     */
    public static void isNegativeException(short value)
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
    public static void isNegativeException(short value, String valueName)
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
    public static void isNonNegativeException(short value)
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
    public static void isNonNegativeException(short value, String valueName)
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
    public static void isPositiveException(short value)
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
    public static void isPositiveException(short value, String valueName)
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
    public static int abs(short value)
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
    public static void safeAddException(short a, short b)
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
    public static boolean isSafeAdd(short a, short b)
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
    public static int safeAdd(short a, short b)
    {
        safeAddException(a, b);
        return a + b;
    }
    
    public static boolean ugt(short a, short b)
    {
        return ult(b, a);
    }
    
    public static boolean ugte(short a, short b)
    {
        return ulte(b, a);
    }
    
    public static boolean ulte(short a, short b)
    {
        return a == b || ult(a, b);
    }
    
    public static boolean ult(short a, short b)
    {
        if(a > 0)
        {
            if(b > 0)
            {
                if(a < b)
                {
                    return true;
                }
                
                return false;
            }
            else if(b == 0)
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
            if(b >= 0)
            {
                return false;
            }
            else
            {
                return a > b;
            }
        }
    }
    
    public static int uCompareTo(short a, short b)
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
    
    public static int urs(short value, int shift)
    {
        if(value >= 0)
        {
            return value >> shift;
        }
        
        shift %= 16;
        shift += 16;
        shift %= 16;
        
        if(shift == 0)
        {
            return value;
        }
        
        shift--;
        value = (short) (((int) (value >> 1)) & ((int) 0x7FFF));
        return value >> shift;
    }
    
    public static short uDiv(short value, short divisor)
    {
        if(divisor == 0)
        {
            throw new IllegalArgumentException("Should not divide by zero.");
        }
        
        if(value == 0)
        {
            return 0;
        }
        
        if(ShortUtils.ult(value, divisor))
        {
            return 0;
        }
        
        short maxBitPosValue = (short) maxSetBitPosition(value);
        short maxBitPosDivisor = (short) maxSetBitPosition(divisor);
        short quotient = 0;
        
        for(short diff = (short) (maxBitPosValue - maxBitPosDivisor);
            diff >= 0;
            diff--)
        {
            short tempDivisor = (short) (divisor << diff);
            
            if(ShortUtils.ult(value, tempDivisor))
            {
                continue;
            }
            
            value -= tempDivisor;
            quotient |= 1 << diff;
        }
        
        return quotient;
    }
    
    public static short uMod(short value, short mod)
    {
        int quotient = uDiv(value, mod);
        return (short) (value - quotient * mod);
    }
    
    public static short bitReverse(short value)
    {
        int byte1 = getByte0(value);
        int byte2 = getByte1(value);
        
        byte1 = ByteUtils.getReversedByte(byte1);
        byte2 = ByteUtils.getReversedByte(byte2);
        
        int rValue = 0;
        rValue |= byte1 << 8;
        rValue |= byte2;
        
        return (short) rValue;
    }
    
    public static int getByte0(short val)
    {
        return val & 0xFF;
    }
    
    public static byte getByte0B(short val)
    {
        return (byte) getByte0(val);
    }
    
    public static int getByte1(short val)
    {
        return (val >> 8) & 0xFF;
    }
    
    public static byte getByte1B(short val)
    {
        return (byte) getByte1(val);
    }
    
    public static void setBytes(short value,
                                int offset,
                                byte[] bytes)
    {
        bytes[offset] = getByte0B(value);
        bytes[++offset] = getByte1B(value);
    }
    
    public static boolean bitSet(short value, int bit)
    {
        return (value & (1 << bit)) > 0;
    }
    
    public static int maxSetBitPosition(short value)
    {
        if(value == 0)
        {
            return -1;
        }
        
        for(int bitCounter = 0;
            bitCounter < 16;
            bitCounter++)
        {
            value = (short) (value >> 1);
            
            if(value == 0)
            {
                return bitCounter;
            }
        }
        
        return 15;
    }
    
    public String uToOctalString(short value)
    {
        return uToString(value, (short) 8);
    }
    
    public String uToHexString(short value)
    {
        return uToString(value, (short) 16);
    }
    
    public String uToString(short value)
    {
        return uToString(value, (short) 10);
    }
    
    public String uToString(short value, short radix)
    {
        if(value == 0)
        {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(;
            ShortUtils.ugt(value, (short) 0);
            value = ShortUtils.uDiv(value, radix))
        {
            sb.append(ShortUtils.uMod(value, radix));
        }
        
        return sb.toString();
    }
}
