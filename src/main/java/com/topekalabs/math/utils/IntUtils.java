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
    }
    
    public static void isEqualTo(int value,
                                 int equal,
                                 String valueName)
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
    
    public static void isGreaterThan(int value,
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
    
    public static void isGreaterThan(int value,
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
    
    public static void isPositive(int value)
    {
        if(value <= 0)
        {
            throw new IllegalArgumentException("The given value " + value + " must be positive.");
        }
    }
    
    public static void isPositive(int value, String valueName)
    {
        if(value <= 0)
        {
            throw new IllegalArgumentException("The given value " + valueName + " " + value + " must be positive.");
        }
    }
    
    public static void isNonNegative(int value)
    {
        if(value < 0)
        {
            throw new IllegalArgumentException("The given value " + value + " must be nonegative.");
        }
    }
    
    public static void isNonNegative(int value, String valueName)
    {
        if(value < 0)
        {
            throw new IllegalArgumentException("The given value " + valueName + " " + value + " must be nonegative.");
        }
    }
    
    public static void isNegative(int value)
    {
        if(value >= 0)
        {
            throw new IllegalArgumentException("The given value " + value + " must be negative.");
        }
    }
    
    public static void isNegative(int value, String valueName)
    {
        if(value >= 0)
        {
            throw new IllegalArgumentException("The given value " + valueName + " " + value + " must be negative.");
        }
    }
    
    public static void isNonPositive(int value)
    {
        if(value > 0)
        {
            throw new IllegalArgumentException("The given value " + value + " must be nonpositive.");
        }
    }
    
    public static void isNonPositive(int value, String valueName)
    {
        if(value > 0)
        {
            throw new IllegalArgumentException("The given value " + valueName + " " + value + " must be nonpositive.");
        }
    }
    
    public static void isInIntervalInclusive(int start,
                                             int end,
                                             int value,
                                             String valueName)
    {
        if(start <= value && value <= end)
        {
            throw new IllegalArgumentException("The given value " +
                                               valueName +
                                               " " +
                                               value +
                                               " must be between " +
                                               start +
                                               " and " +
                                               end +
                                               " inclusive.");
        }
    }
    
    public static int abs(int value)
    {
        if(value < 0)
        {
            return -value;
        }
        
        return value;
    }
    
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
    
    /*
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
    }*/
    
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
    
    public static int safeAdd(int a, int b)
    {
        safeAddException(a, b);
        return a + b;
    }
    
    public static void safeMultiplyException(int a, int b)
    {
        if(a == 0 || b == 0)
        {
            return;
        }
        
        int greatest = a;
        
        if(a < b)
        {
            greatest = b;
        }
        
        if(a * b < greatest)
        {
            throw new IllegalArgumentException("It is not safe to multiple " + a +
                                               " and " + b);
        }
    }
    
    public static boolean isSafeMultiply(int a, int b)
    {
        if(a == 0 || b == 0)
        {
            return true;
        }
        
        int greatest = a;
        
        if(a < b)
        {
            greatest = b;
        }
        
        if(a * b < greatest)
        {
            return false;
        }
        
        return true;
    }
    
    public static void safeMultiply(int a, int b)
    {
        safeMultiplyException(a, b);
    }
}
