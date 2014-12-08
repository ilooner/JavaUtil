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

import com.topekalabs.error.utils.ExceptionUtils;
import java.util.Random;

/**
 * This class represents a float interval.
 * @author Topeka Labs
 */
public class FloatInterval 
{
    /**
     * The range of the interval.
     */
    private float range;
    
    /**
     * Half the range of the interval.
     */
    private float rangeHalf;
    
    /**
     * The center of the interval.
     */
    private float center;
    
    /**
     * The start of the interval.
     */
    private float startInterval;
    
    /**
     * The end of the interval.
     */
    private float endInterval;
    
    /**
     * An enum representing the constructor to use.
     */
    public enum ConstructorType
    {
        /**
         * A constructor which accepts a start and end.
         */
        START_AND_END,
        /**
         * A constructor which accepts a range and center.
         */
        RANGE_AND_CENTER;
    }
    
    /**
     * This constructor takes a type argument as well as two values to construct
     * the interval.
     * @param constructorType The type of constructor to use either START_AND_END
     * or RANGE_AND_CENTER.
     * @param val1 When the constructor type is START_AND_END then this is the
     * start of the interval. When the constructor type is RANGE_AND_CENTER then
     * this is the range of the interval.
     * @param val2 When the constructor type is START_AND_END then this is the
     * end of the interval. When the constructor type is RANGE_AND_CENTER then
     * this is the center of the interval. 
     */
    public FloatInterval(ConstructorType constructorType,
                         float val1,
                         float val2)
    {
        if(constructorType == ConstructorType.START_AND_END)
        {
            intervalConstructor(val1,
                                val2);
        }
        else if(constructorType == ConstructorType.RANGE_AND_CENTER)
        {
            rangeConstructor(val1,
                             val2);
        }
        else
        {
            ExceptionUtils.thisShouldNotHappen();
        }
    }
    
    /**
     * This constructs the interval from start and end values.
     * @param startInterval The start of the interval.
     * @param endInterval The end of the interval.
     */
    private void intervalConstructor(float startInterval,
                                     float endInterval)
    {
        if(Float.isInfinite(startInterval) ||
           Float.isNaN(startInterval))
        {
            throw new IllegalArgumentException("The given startInterval must be a valid floating point number.");
        }
        
        if(Float.isInfinite(endInterval) ||
           Float.isNaN(endInterval))
        {
            throw new IllegalArgumentException("The given endInterval must be a valid floating point number.");
        }
        
        if(startInterval >= endInterval)
        {
            throw new IllegalArgumentException("The startInterval must be less than the endInterval: (" + startInterval + ", " + endInterval + ")");
        }
        
        setStartInterval(startInterval);
        setEndInterval(endInterval);
        setRange(endInterval - startInterval);
        setCenter((startInterval + endInterval) / 2.0f);
    }
    
    /**
     * This constructs the interval from range and center values.
     * @param range The range of the interval.
     * @param center The center of the interval.
     */
    private void rangeConstructor(float range,
                                  float center)
    {
        setRange(range);
        setCenter(center);
        setStartInterval(center - rangeHalf);
        setEndInterval(center + rangeHalf);
    }
    
    /**
     * This sets the start of the interval.
     * @param startInterval The start of the interval.
     */
    private void setStartInterval(float startInterval)
    {
        FloatUtils.isValidFloatException(startInterval, "startInterval");
        
        this.startInterval = startInterval;
    }
    
    /**
     * This sets the end of the interval.
     * @param endInterval The end of the interval.
     */
    private void setEndInterval(float endInterval)
    {
        FloatUtils.isValidFloatException(endInterval, "endInterval");
        
        this.endInterval = endInterval;
    }
    
    /**
     * This sets the range of the interval.
     * @param range The range of the interval.
     */
    private void setRange(float range)
    {
        FloatUtils.isValidFloatException(range, "range");
        
        this.range = range;
        this.rangeHalf = range / 2.0f;
    }
    
    /**
     * This sets the center of the interval.
     * @param center The center of the interval.
     */
    private void setCenter(float center)
    {
        if(Float.isInfinite(center) || Float.isNaN(range))
        {
            throw new IllegalArgumentException("The given float must be a valid number.");
        }
        
        this.center = center;
    }
    
    /**
     * This creates a new interval with twice the range and the same center.
     * @param scale The amount by which to scale the interval.
     * @return A new scaled interval.
     */
    public FloatInterval createScale(float scale)
    {
        FloatUtils.isPositiveFloat(scale, "scale");
        
        return new FloatInterval(FloatInterval.ConstructorType.RANGE_AND_CENTER,
                                 range * scale,
                                 center);
    }
    
    /**
     * This method returns the start of the interval.
     * @return The start of the interval.
     */
    public float getStartInterval()
    {
        return startInterval;
    }
    
    /**
     * This method returns the end of the interval.
     * @return The end of the interval.
     */
    public float getEndInterval()
    {
        return endInterval;
    }
    
    /**
     * This method returns the range of the interval.
     * @return The range of the interval.
     */
    public float getRange()
    {
        return range;
    }
    
    /**
     * This method returns the center of the interval.
     * @return The center of the interval.
     */
    public float getCenter()
    {
        return center;
    }
    
    /**
     * This returns true if all the numbers in the interval are positive.
     * @return True if all the numbers in the interval are positive.
     */
    public boolean isPositive()
    {
        return startInterval > 0.0f;
    }
    
    /**
     * This method throws an IllegalArgumentException if the interval is not
     * positive.
     */
    public void isPositiveException()
    {
        if(!isPositive())
        {
            throw new IllegalArgumentException("The interval must be positive.");
        }
    }
    
    /**
     * This method returns true if all the numbers in the interval are non negative.
     * @return True if all the numbers in the interval are non negative.
     */
    public boolean isNonNegative()
    {
        return startInterval >= 0.0f;
    }
    
    /**
     * This method throws an IllegalArgumentException if all the numbers in the
     * interval are not non negative.
     */
    public void isNonNegativeException()
    {
        if(!isNonNegative())
        {
            throw new IllegalArgumentException("The interval must be nonnegative.");
        }
    }
    
    /**
     * Returns true if this interval is less than the given value.
     * @param value The value to test against.
     * @return True if this interval is less than the given value.
     */
    public boolean isLT(float value)
    {
        FloatUtils.isValidFloatException(value, "value");
        
        return value > endInterval;
    }
    
    /**
     * Returns true if this interval is less than or equal to the given value.
     * @param value The value to test against.
     * @return True if this interval is less than or equal to the given value.
     */
    public boolean isLTE(float value)
    {
        FloatUtils.isValidFloatException(value, "value");
        
        return value >= endInterval;
    }
    
    /**
     * Returns true if this interval is greater than the given value.
     * @param value The value to test against.
     * @return True if this interval is greater than the given value.
     */
    public boolean isGT(float value)
    {
        FloatUtils.isValidFloatException(value, "value");
        
        return value < startInterval;
    }
    
    /**
     * Returns true if this interval is greater than or equal to the given value.
     * @param value The value to test against.
     * @return True if this interval is greater than or equal to the given value.
     */
    public boolean isGTE(float value)
    {
        FloatUtils.isValidFloatException(value, "value");
        
        return value <= startInterval;
    }
    
    /**
     * Truncates the given value into a value that is within the interval.
     * For example if the given value is greater than the interval, then the
     * end of the interval is returned. If the given value is less than the
     * interval then the start of the interval is returned.
     * @param value The value to truncate.
     * @return The truncated value.
     */
    public float truncate(float value)
    {
        if(isLT(value))
        {
            return endInterval;
        }
        
        if(isGT(value))
        {
            return startInterval;
        }
            
        return value;
    }
    
    /**
     * This method returns true if the given value is in this interval exclusively.
     * @param value The value to check.
     * @return True if the given value is in this interval inclusively.
     */
    public boolean isInIntervalExclusive(float value)
    {
        FloatUtils.isValidFloatException(value, "value");
        
        return startInterval < value && value < endInterval;
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not
     * in this interval exclusively.
     * @param value The value to check.
     */
    public void isInIntervalExclusiveException(float value)
    {
        if(!isInIntervalExclusive(value))
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " must lie in the interval " +
                                               startInterval +
                                               " to " +
                                               endInterval +
                                               " exclusive.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not
     * in this interval exclusively. The name of the value is included in the
     * exception message.
     * @param value The value to check.
     * @param valueName The name of the value.
     */
    public void isInIntervalExclusiveException(float value, String valueName)
    {
        if(!isInIntervalExclusive(value))
        {
            throw new IllegalArgumentException("The given value " +
                                               valueName +
                                               " " +
                                               value +
                                               " must lie in the interval " +
                                               startInterval +
                                               " to " +
                                               endInterval +
                                               " exclusive.");
        }
    }
    
    /**
     * This method returns true if the the given value is inclusively in the
     * interval.
     * @param value The value to check.
     * @return true if the the given value is inclusively in the
     * interval.
     */
    public boolean isInIntervalInclusive(float value)
    {
        FloatUtils.isValidFloatException(value, "value");
        
        return startInterval <= value && value <= endInterval;
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not
     * in the interval inclusively.
     * @param value The value to check.
     */
    public void isInIntervalInclusiveException(float value)
    {
        if(!isInIntervalInclusive(value))
        {
            throw new IllegalArgumentException("The given value " +
                                               value +
                                               " must lie in the interval " +
                                               startInterval +
                                               " to " +
                                               endInterval +
                                               " inclusive.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not
     * in the interval inclusively. The name of the value is included in the
     * exception message.
     * @param value The value to check.
     * @param valueName The name of the value.
     */
    public void isInIntervalInclusiveException(float value, String valueName)
    {
        if(!isInIntervalInclusive(value))
        {
            throw new IllegalArgumentException("The given value " +
                                               valueName +
                                               " " +
                                               value +
                                               " must lie in the interval " +
                                               startInterval +
                                               " to " +
                                               endInterval +
                                               " inclusive.");
        }
    }
    
    /**
     * This method returns true if this interval inclusively intersects the given interval.
     * @param floatInterval The float interval to compare against.
     * @return True if this interval inclusively intersects the given interval.
     */
    public boolean intersectsThisIntervalInclusive(FloatInterval floatInterval)
    {
        return (thisStartLTThatStart(floatInterval) &&
                thisEndGTEThatStart(floatInterval)) ||
               thisStartLTEThatEnd(floatInterval);
    }
    
    /**
     * This method returns true if this interval intersects the given interval
     * exclusively.
     * @param floatInterval The interval to compare against.
     * @return True if this interval intersects the given interval
     * exclusively.
     */
    public boolean intersectsThisIntervalExclusive(FloatInterval floatInterval)
    {
        return (thisStartLTThatStart(floatInterval) &&
                thisEndGTThatStart(floatInterval)) ||
               thisStartLTThatEnd(floatInterval);
    }
    
    /**
     * This method returns true if this interval contains the given interval
     * inclusively.
     * @param floatInterval The interval to compare against.
     * @return True if this interval contains the given interval
     * inclusively.
     */
    public boolean containsThisIntervalInclusive(FloatInterval floatInterval)
    {
        return (startInterval <= floatInterval.getStartInterval() && 
                floatInterval.getStartInterval() <= endInterval) &&
               (startInterval <= floatInterval.getEndInterval() &&
                floatInterval.getEndInterval() <= endInterval);
    }
    
    /**
     * This method throws an IllegalArgumentException if this interval does not
     * contain the given interval inclusively.
     * @param floatInterval The interval to compare against.
     */
    public void containsThisIntervalInclusiveException(FloatInterval floatInterval)
    {
        if(!containsThisIntervalInclusive(floatInterval))
        {
            throw new IllegalArgumentException("The given interval is not valid");
        }
    }
    
    /**
     * This method returns true if this interval contains the given
     * interval exclusively.
     * @param floatInterval The interval to check.
     * @return True if this interval contains the given
     * interval exclusively.
     */
    public boolean containsThisIntervalExclusive(FloatInterval floatInterval)
    {
        return (startInterval < floatInterval.getStartInterval() && 
                floatInterval.getStartInterval() < endInterval) &&
               (startInterval < floatInterval.getEndInterval() &&
                floatInterval.getEndInterval() < endInterval);        
    }
    
    /**
     * This method returns true if the end of this interval equals the start of
     * the other interval.
     * @param floatInterval The interval to compare against.
     * @return True if the end of this interval equals the start of
     * the other interval.
     */
    public boolean thisEndEqualsThatStart(FloatInterval floatInterval)
    {
        return endInterval == floatInterval.getStartInterval();
    }
    
    /**
     * This method returns true if the end of this interval is greater than the
     * start of the other interval.
     * @param floatInterval The other interval to compare against.
     * @return True if the end of this interval is greater than the
     * start of the other interval.
     */
    public boolean thisEndGTThatStart(FloatInterval floatInterval)
    {
        return endInterval > floatInterval.getStartInterval();
    }
    
    /**
     * This method returns true if the start of this interval equals the end of
     * the other interval.
     * @param floatInterval The other interval to compare against.
     * @return True if the start of this interval equals the end of the other
     * interval.
     */
    public boolean thisStartEqualsThatEnd(FloatInterval floatInterval)
    {
        return startInterval == floatInterval.getEndInterval();
    }
    
    /**
     * This method returns true if the start of this interval is less than the
     * end of the other interval.
     * @param floatInterval The other interval to compare against.
     * @return True if the start of this interval is less than the
     * end of the other interval.
     */
    public boolean thisStartLTThatEnd(FloatInterval floatInterval)
    {
        return startInterval < floatInterval.getEndInterval();
    }
    
    /**
     * This method returns true if the start of this interval is less than or
     * equal to the end of the other interval.
     * @param floatInterval The other interval to compare against.
     * @return True if the start of this interval is less than or
     * equal to the end of the other interval.
     */
    public boolean thisStartLTEThatEnd(FloatInterval floatInterval)
    {
        return startInterval <= floatInterval.getEndInterval();
    }
    
    /**
     * This method returns true if the start of this interval is equal to the
     * start of the other interval.
     * @param floatInterval The other interval to compare against.
     * @return True if the start of this interval is equal to the
     * start of the other interval.
     */
    public boolean thisStartEqualsThatStart(FloatInterval floatInterval)
    {
        return startInterval == floatInterval.getStartInterval();
    }
    
    /**
     * This method returns true if the start of this interval is less than the
     * start of the other interval.
     * @param floatInterval The other interval to compare against.
     * @return True if the start of this interval is less than the
     * start of the other interval.
     */
    public boolean thisStartLTThatStart(FloatInterval floatInterval)
    {
        return startInterval < floatInterval.getStartInterval();
    }
    
    /**
     * This method returns true if the start of this interval is less than or
     * equal to the start of the other interval.
     * @param floatInterval the other interval to compare against.
     * @return True if the start of this interval is less than or
     * equal to the start of the other interval.
     */
    public boolean thisStartLTEThatStart(FloatInterval floatInterval)
    {
        return startInterval <= floatInterval.getStartInterval();
    }
    
    /**
     * This method returns true if the end of this interval is greater than or
     * equal to the start of the other interval.
     * @param floatInterval The other interval to compare against.
     * @return True if the end of this interval is greater than or
     * equal to the start of the other interval.
     */
    public boolean thisEndGTEThatStart(FloatInterval floatInterval)
    {
        return endInterval >= floatInterval.getStartInterval();
    }
    
    /**
     * This method returns true if the end of this interval equals the end of
     * the other interval.
     * @param floatInterval The other interval to compare against.
     * @return True if the end of this interval equals the end of
     * the other interval.
     */
    public boolean thisEndEqualsThatEnd(FloatInterval floatInterval)
    {
        return endInterval == floatInterval.getEndInterval();
    }
    
    /**
     * This method returns true if the end of this interval is less than or
     * equal to the start of the other interval.
     * @param floatInterval The other interval to compare against.
     * @return True if the end of this interval is less than or
     * equal to the start of the other interval.
     */
    public boolean thisEndLTEThatStart(FloatInterval floatInterval)
    {
        return endInterval <= floatInterval.getStartInterval();
    }
    
    /**
     * This method build an array out of uniformly sampled values from this
     * interval.
     * @param numValues The number of values in the resulting array. This must
     * be greater than 1.
     * @return An array of uniformly sampled values from this interval.
     */
    public float[] uniformArray(int numValues)
    {
        IntUtils.isLTEException(numValues, 1, "numValues");
        
        float[] values = new float[numValues];
        float length = getRange();
        float intervalWidth = length / ((float) (numValues - 1));
        
        values[0] = getStartInterval();
        values[numValues - 1] = getEndInterval();
        
        for(int counter = 1;
            counter < numValues - 1;
            counter++)
        {
            values[counter] = ((float) counter) * intervalWidth;
        }
        
        return values;
    }
    
    /**
     * This generates a uniformly random number within the interval.
     * @param random The random object to use for generation.
     * @return A uniformly random number within the interval.
     */
    public float getRandom(Random random)
    {
        return random.nextFloat() * range - rangeHalf + center;
    }
}
