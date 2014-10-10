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
 * This class provides utility methods for floats.
 * @author Topeka Labs
 */
public final class FloatUtils
{
    private FloatUtils()
    {
        //Do nothing
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is
     * infinite.
     * @param value The value to check. 
     */
    public static void isInfiniteException(float value)
    {
        if(Float.isInfinite(value))
        {
            throw new IllegalArgumentException("The value cannot be Infinite.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is
     * infinite.
     * @param value The value to check.
     * @param valueName The name of the value.
     */
    public static void isInfiniteException(float value, String valueName)
    {
        if(Float.isInfinite(value))
        {
            throw new IllegalArgumentException("The given value of " + valueName + " cannot be Infinite.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is NaN.
     * @param value The value to check.
     */
    public static void isNaNException(float value)
    {
        if(Float.isNaN(value))
        {
            throw new IllegalArgumentException("The given value cannot be NaN.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is NaN.
     * This method displays the name of the value in the exception message.
     * @param value The value to check.
     * @param valueName The name of the value to check.
     */
    public static void isNaNException(float value, String valueName)
    {
        if(Float.isNaN(value))
        {
            throw new IllegalArgumentException("The given value for " +
                                               valueName +
                                               " cannot be NaN.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not a valid floating
     * point number.
     * @param value The value to test.
     */
    public static void isValidFloatException(float value)
    {
        FloatUtils.isInfiniteException(value);
        FloatUtils.isNaNException(value);
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not a valid floating
     * point number.
     * @param value The value to test.
     * @param valueName The name of the value.
     */
    public static void isValidFloatException(float value, String valueName)
    {
        FloatUtils.isInfiniteException(value, valueName);
        FloatUtils.isNaNException(value, valueName);
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not a valid positive
     * floating point number.
     * @param value The value to test.
     */
    public static void isPositiveFloatException(float value)
    {
        isValidFloatException(value);
        
        if(value <= 0.0f)
        {
            throw new IllegalArgumentException("The given value " + value + " must be positive.");
        }
    }
    
    
    /**
     * This method throws an IllegalArgumentException if the given value is not a valid positive
     * floating point number.
     * @param value The value to test.
     * @param valueName The name of the value.
     */
    public static void isPositiveFloat(float value, String valueName)
    {
        isValidFloatException(value, valueName);
        
        if(value <= 0.0f)
        {
            throw new IllegalArgumentException("The given value for " + valueName + " " + value + " must be positive.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given float value is positive.
     * @param value The value to test.
     */
    public static void isNonNegativeFloatException(float value)
    {
        isValidFloatException(value);
        
        if(value < 0.0f)
        {
            throw new IllegalArgumentException("The given value " + value + " must be nonegative.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given float value is positive.
     * @param value The value to test.
     * @param valueName The name of the value.
     */
    public static void isNonNegativeFloatException(float value, String valueName)
    {
        isValidFloatException(value, valueName);
        
        if(value < 0.0f)
        {
            throw new IllegalArgumentException("The given value for " + valueName + " " + value + " must be nonegative.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given float is non negative.
     * @param value The value to test.
     */
    public static void isNegativeFloat(float value)
    {
        isValidFloatException(value);
        
        if(value >= 0.0f)
        {
            throw new IllegalArgumentException("The given value " + value + " must be negative.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given float is non negative.
     * @param value The value to test.
     * @param valueName The name of the value.
     */
    public static void isNegativeFloat(float value, String valueName)
    {
        isValidFloatException(value, valueName);
        
        if(value < 0.0f)
        {
            throw new IllegalArgumentException("The given value for " + valueName + " " + value + " must be negative.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given float is negative.
     * @param value The value to test.
     */
    public static void isNonPositiveFloatException(float value)
    {
        isValidFloatException(value);
        
        if(value <= 0.0f)
        {
            throw new IllegalArgumentException("The given value " + value + " must be nonpositive.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given float is negative.
     * @param value The value to test.
     * @param valueName The name of the value.
     */
    public static void isNonPositiveFloatException(float value, String valueName)
    {
        isValidFloatException(value, valueName);
        
        if(value <= 0.0f)
        {
            throw new IllegalArgumentException("The given value for " + valueName + " " + value + " must be nonpositive.");
        }
    }
    
    /**
     * This method returns the minimum of the two given values.
     * @param a A value to compare.
     * @param b A value to compare.
     * @return The minimum value.
     */
    public static float min(float a, float b)
    {
        FloatUtils.isValidFloatException(a, "a");
        FloatUtils.isValidFloatException(b, "b");
        
        if(a < b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }

    /**
     * This method adds the given 2D vector to the vector specified in the array.
     * @param array The array which contains vectors.
     * @param vectorIndex The index of the vector to add to.
     * @param x The x component to add to the vector.
     * @param y The y component to add to the vector.
     */
    public static void vectorAdd2D(float[] array,
                                   int vectorIndex,
                                   float x,
                                   float y)
    {
        
        
        int tempIndex = 2 * vectorIndex;
        array[tempIndex] += x;
        array[tempIndex + 1] += y;
    }
    
    /**
     * This method adds the given 3D vector to the vector specified in the array.
     * @param array The array which contains vectors.
     * @param vectorIndex The index of the vector to add to.
     * @param x The x component to add to the vector.
     * @param y The y component to add to the vector.
     * @param z The z component to add to the vector.
     */
    public static void vectorAdd3D(float[] array,
                                   int vectorIndex,
                                   float x,
                                   float y,
                                   float z)
    {
        
        
        int tempIndex = 3 * vectorIndex;
        array[tempIndex] += x;
        array[tempIndex + 1] += y;
        array[tempIndex + 2] += z;
    }

    /**
     * This method multiplies the given 2D vector by the specified scale amount.
     * @param array The array which contains vectors.
     * @param vectorIndex The index of the vector to scale.
     * @param scale The value to scale the vector by.
     */
    public static void vectorMult2D(float[] array,
                                    int vectorIndex,
                                    float scale)
    {
        int tempIndex = 2 * vectorIndex;
        array[tempIndex + 0] *= scale;
        array[tempIndex + 1] *= scale;
    }
    
    /**
     * This method multiplies the given 3D vector by the specified scale amount.
     * @param array The array which contains vectors.
     * @param vectorIndex The index of the vector to scale.
     * @param scale The value to scale the vector by.
     */
    public static void vectorMult3D(float[] array,
                                    int vectorIndex,
                                    float scale)
    {
        int tempIndex = 3 * vectorIndex;
        array[tempIndex + 0] *= scale;
        array[tempIndex + 1] *= scale;
        array[tempIndex + 2] *= scale;
    }
    
    /**
     * This method divides the given 2D vector by the give scale value.
     * @param array The array containing the vector of interest.
     * @param vectorIndex This is the index of the vector in the array.
     * @param scale The scale value to divide the vector by.
     */
    public static void vectorDiv2D(float[] array,
                                   int vectorIndex,
                                   float scale)
    {
        int tempIndex = 2 * vectorIndex;
        array[tempIndex] /= scale;
        array[tempIndex + 1] /= scale;
    }

    /**
     * This method divides the given 3D vector by the give scale value.
     * @param array The array containing the vector of interest.
     * @param vectorIndex This is the index of the vector in the array.
     * @param scale The scale value to divide the vector by.
     */
    public static void vectorDiv3D(float[] array,
                                   int vectorIndex,
                                   float scale)
    {
        int tempIndex = 3 * vectorIndex;
        array[tempIndex] /= scale;
        array[tempIndex + 1] /= scale;
        array[tempIndex + 2] /= scale;
    }
    
    /**
     * This method fills the given array of floats with zeros.
     * @param array The array to zero fill.
     */
    public static void zeroFill(float[] array)
    {
        for(int counter = 0;
            counter < array.length;
            counter++)
        {
            array[counter] = 0.0f;
        }
    }
}
