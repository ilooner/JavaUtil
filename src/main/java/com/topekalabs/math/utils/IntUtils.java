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
 * integers.
 * @author Topeka Labs
 */
public final class IntUtils
{
    private IntUtils()
    {
        //Do nothing.
    }
    
    /**
     * This method throws an IllegalArgumentException if the two given values don't
     * equal.
     * @param value This is compared to equal for equality.
     * @param equal This is compared to value for equality.
     */
    public static void isEqualToException(int value,
                                          int equal)
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
    public static void isEqualToException(int value,
                                          int equal,
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
    public static void isEqualToException(int value,
                                          int equal,
                                          String valueName,
                                          String equalName)
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
    public static void isGreaterThanException(int value,
                                              int threshold)
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
    public static void isGreaterThanException(int value,
                                              int threshold,
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
     * This method throws an IllegalArgumentException if the given value is not
     * positive.
     * @param value The value to check. 
     */
    public static void isPositiveException(int value)
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
    public static void isPositiveException(int value, String valueName)
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
    public static void isNonNegativeException(int value)
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
    public static void isNonNegativeException(int value, String valueName)
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
    public static void isNegativeException(int value)
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
    public static void isNegativeException(int value, String valueName)
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
    public static void isNonPositiveException(int value)
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
    public static void isNonPositiveException(int value, String valueName)
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
    public static int abs(int value)
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
    public static void safeAddException(int a, int b)
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
    public static boolean isSafeAdd(int a, int b)
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
    public static int safeAdd(int a, int b)
    {
        safeAddException(a, b);
        return a + b;
    }
}
