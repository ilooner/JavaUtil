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
    
    public static long divCeil(long value, long divisor)
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
}
