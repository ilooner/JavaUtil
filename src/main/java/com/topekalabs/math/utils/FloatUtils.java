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

public final class FloatUtils
{
    private FloatUtils()
    {
    }
    
    public static void isInfinite(float value)
    {
        if(Float.isInfinite(value))
        {
            throw new IllegalArgumentException("The value cannot be Infinite.");
        }
    }
    
    public static void isInfinite(float value, String valueName)
    {
        if(Float.isInfinite(value))
        {
            throw new IllegalArgumentException("The given value of " + valueName + " cannot be Infinite.");
        }
    }
    
    public static void isValidFloat(float value)
    {
        if(Float.isInfinite(value) || Float.isNaN(value))
        {
            throw new IllegalArgumentException("The value cannot be NaN or Infinite.");
        }
    }
    
    public static void isValidFloat(float value, String valueName)
    {
        if(Float.isInfinite(value) || Float.isNaN(value))
        {
            throw new IllegalArgumentException("The given value of " + valueName + " cannot be NaN or Infinite.");
        }
    }
    
    public static void isPositiveFloat(float value)
    {
        isValidFloat(value);
        
        if(value <= 0.0f)
        {
            throw new IllegalArgumentException("The given value " + value + " must be positive.");
        }
    }
    
    public static void isPositiveFloat(float value, String valueName)
    {
        isValidFloat(value, valueName);
        
        if(value <= 0.0f)
        {
            throw new IllegalArgumentException("The given value for " + valueName + " " + value + " must be positive.");
        }
    }
    
    public static void isNonNegativeFloat(float value)
    {
        isValidFloat(value);
        
        if(value < 0.0f)
        {
            throw new IllegalArgumentException("The given value " + value + " must be nonegative.");
        }
    }
    
    public static void isNonNegativeFloat(float value, String valueName)
    {
        isValidFloat(value, valueName);
        
        if(value < 0.0f)
        {
            throw new IllegalArgumentException("The given value for " + valueName + " " + value + " must be nonegative.");
        }
    }
    
    public static void isNegativeFloat(float value)
    {
        isValidFloat(value);
        
        if(value >= 0.0f)
        {
            throw new IllegalArgumentException("The given value " + value + " must be negative.");
        }
    }
    
    public static void isNegativeFloat(float value, String valueName)
    {
        isValidFloat(value, valueName);
        
        if(value < 0.0f)
        {
            throw new IllegalArgumentException("The given value for " + valueName + " " + value + " must be negative.");
        }
    }
    
    public static void isNonPositiveFloat(float value)
    {
        isValidFloat(value);
        
        if(value <= 0.0f)
        {
            throw new IllegalArgumentException("The given value " + value + " must be nonpositive.");
        }
    }
    
    public static void isNonPositiveFloat(float value, String valueName)
    {
        isValidFloat(value, valueName);
        
        if(value <= 0.0f)
        {
            throw new IllegalArgumentException("The given value for " + valueName + " " + value + " must be nonpositive.");
        }
    }
    
    public static float min(float a, float b)
    {
        if(a < b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }
    
    public static float[] uniformArray(int numValues,
                                       FloatInterval floatInterval)
    {
        IntUtils.isGreaterThan(numValues, 1, "numValues");
        
        float[] values = new float[numValues];
        float length = floatInterval.getRange();
        float intervalWidth = length / ((float) (numValues - 1));
        
        values[0] = floatInterval.getStartInterval();
        values[numValues - 1] = floatInterval.getEndInterval();
        
        for(int counter = 1;
            counter < numValues - 1;
            counter++)
        {
            values[counter] = ((float) counter) * intervalWidth;
        }
        
        return values;
    }
}
