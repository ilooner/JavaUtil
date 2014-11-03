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

import java.util.Random;

/**
 * This class represents a float interval.
 * @author Topeka Labs
 */
public class ULongInterval 
{   
    /**
     * The start of the interval.
     */
    private long startInterval;
    
    /**
     * The end of the interval.
     */
    private long endInterval;
    
    /**
     * The range of the interval.
     */
    private long range;
    
    /**
     * The number of integers in the interval.
     */
    private long numVals;
    
    public ULongInterval(long numVals)
    {
        this(0, numVals - 1);
    }
    
    /**
     * This constructor creates an interval with the given start and end values.
     * @param startInterval The beginning of the interval.
     * @param endInterval The end of the interval.
     */
    public ULongInterval(long startInterval,
                        long endInterval)
    {
        if(startInterval >= endInterval)
        {
            throw new IllegalArgumentException("The startInterval must be less than the endInterval: (" + startInterval + ", " + endInterval + ")");
        }
        
        setStartInterval(startInterval);
        setEndInterval(endInterval);
        initialize();
    }
    
    /**
     * This method initializes the interval.
     */
    private void initialize()
    {
        range = endInterval - startInterval;
        numVals = range + 1;
    }
    
    /**
     * This sets the start of the interval.
     * @param startInterval The start of the interval.
     */
    private void setStartInterval(long startInterval)
    {
        this.startInterval = startInterval;
    }
    
    /**
     * This sets the end of the interval.
     * @param endInterval The end of the interval.
     */
    private void setEndInterval(long endInterval)
    {
        this.endInterval = endInterval;
    }
    
    /**
     * This method returns the start of the interval.
     * @return The start of the interval.
     */
    public long getStartInterval()
    {
        return startInterval;
    }
    
    /**
     * This method returns the end of the interval.
     * @return The end of the interval.
     */
    public long getEndInterval()
    {
        return endInterval;
    }
    
    /**
     * Returns true if this interval is less than the given value.
     * @param value The value to test against.
     * @return True if this interval is less than the given value.
     */
    public boolean isLT(long value)
    {
        return value > endInterval;
    }
    
    /**
     * Returns true if this interval is less than or equal to the given value.
     * @param value The value to test against.
     * @return True if this interval is less than or equal to the given value.
     */
    public boolean isLTE(long value)
    {
        return value >= endInterval;
    }
    
    /**
     * Returns true if this interval is greater than the given value.
     * @param value The value to test against.
     * @return True if this interval is greater than the given value.
     */
    public boolean isGT(long value)
    {
        return value < startInterval;
    }
    
    /**
     * Returns true if this interval is greater than or equal to the given value.
     * @param value The value to test against.
     * @return True if this interval is greater than or equal to the given value.
     */
    public boolean isGTE(long value)
    {
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
    public float truncate(long value)
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
    public boolean isInIntervalExclusive(long value)
    {
        return startInterval < value && value < endInterval;
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not
     * in this interval exclusively.
     * @param value The value to check.
     */
    public void isInIntervalExclusiveException(long value)
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
    public void isInIntervalExclusiveException(long value, String valueName)
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
    public boolean isInIntervalInclusive(long value)
    {
        return startInterval <= value && value <= endInterval;
    }
    
    /**
     * This method throws an IllegalArgumentException if the given value is not
     * in the interval inclusively.
     * @param value The value to check.
     */
    public void isInIntervalInclusiveException(long value)
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
    public void isInIntervalInclusiveException(long value, String valueName)
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
    public boolean intersectsThisIntervalInclusive(ULongInterval floatInterval)
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
    public boolean intersectsThisIntervalExclusive(ULongInterval floatInterval)
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
    public boolean containsThisIntervalInclusive(ULongInterval floatInterval)
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
    public void containsThisIntervalInclusiveException(ULongInterval floatInterval)
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
    public boolean containsThisIntervalExclusive(ULongInterval floatInterval)
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
    public boolean thisEndEqualsThatStart(ULongInterval floatInterval)
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
    public boolean thisEndGTThatStart(ULongInterval floatInterval)
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
    public boolean thisStartEqualsThatEnd(ULongInterval floatInterval)
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
    public boolean thisStartLTThatEnd(ULongInterval floatInterval)
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
    public boolean thisStartLTEThatEnd(ULongInterval floatInterval)
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
    public boolean thisStartEqualsThatStart(ULongInterval floatInterval)
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
    public boolean thisStartLTThatStart(ULongInterval floatInterval)
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
    public boolean thisStartLTEThatStart(ULongInterval floatInterval)
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
    public boolean thisEndGTEThatStart(ULongInterval floatInterval)
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
    public boolean thisEndEqualsThatEnd(ULongInterval floatInterval)
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
    public boolean thisEndLTEThatStart(ULongInterval floatInterval)
    {
        return endInterval <= floatInterval.getStartInterval();
    }
    
    /**
     * Returns the number of values in the interval inclusive.
     * @return The number of values in the interval inclusive.
     */
    public long getNumVals()
    {
        return numVals;
    }
    
    /**
     * This generates a uniformly random number within the interval.
     * @param random The random object to use for generation.
     * @return A uniformly random number within the interval.
     */
    public long getRandom(Random random)
    {
        return startInterval + random.nextLong() % numVals;
    }
}
