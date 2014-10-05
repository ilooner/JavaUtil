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

public class FloatInterval 
{
    private float range;
    private float rangeHalf;
    private float center;
    private float startInterval;
    private float endInterval;
    
    public enum FloatIntervalDefinitionType
    {
        StartAndEnd,
        RangeAndCenter;
    }
    
    public FloatInterval(FloatIntervalDefinitionType floatIntervalDefinitionType,
                         float val1,
                         float val2)
    {
        if(floatIntervalDefinitionType == FloatIntervalDefinitionType.StartAndEnd)
        {
            intervalConstructor(val1,
                                val2);
        }
        else if(floatIntervalDefinitionType == FloatIntervalDefinitionType.RangeAndCenter)
        {
            rangeConstructor(val1,
                             val2);
        }
        else
        {
            throw new IllegalArgumentException("You shouldn't get here.");
        }
    }
    
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
    
    private void rangeConstructor(float range,
                                  float center)
    {
        setRange(range);
        setCenter(center);
        setStartInterval(center - rangeHalf);
        setEndInterval(center + rangeHalf);
    }
    
    private void setStartInterval(float startInterval)
    {
        this.startInterval = startInterval;
    }
    
    private void setEndInterval(float endInterval)
    {
        this.endInterval = endInterval;
    }
    
    private void setRange(float range)
    {
        if(Float.isInfinite(range) || Float.isNaN(range))
        {
            throw new IllegalArgumentException("The given float must be a valid number.");
        }
        
        this.range = range;
        this.rangeHalf = range / 2.0f;
    }
    
    private void setCenter(float center)
    {
        if(Float.isInfinite(center) || Float.isNaN(range))
        {
            throw new IllegalArgumentException("The given float must be a valid number.");
        }
        
        this.center = center;
    }
    
    public FloatInterval createScale(float scale)
    {
        FloatUtils.isPositiveFloat(scale, "scale");
        
        return new FloatInterval(FloatIntervalDefinitionType.StartAndEnd,
                                 startInterval * scale,
                                 endInterval * scale);
    }
    
    public float getStartInterval()
    {
        return startInterval;
    }
    
    public float getEndInterval()
    {
        return endInterval;
    }
    
    public float getRange()
    {
        return range;
    }
    
    public float getCenter()
    {
        return center;
    }
    
    public boolean isPositive()
    {
        return startInterval > 0.0f;
    }
    
    public void isPositiveException()
    {
        if(!isPositive())
        {
            throw new IllegalArgumentException("The interval must be positive.");
        }
    }
    
    public boolean isNonNegative()
    {
        return startInterval >= 0.0f;
    }
    
    public void isNonNegativeException()
    {
        if(!isNonNegative())
        {
            throw new IllegalArgumentException("The interval must be nonnegative.");
        }
    }
    
    public boolean isGT(float value)
    {
        FloatUtils.isValidFloat(value, "value");
        
        return value > endInterval;
    }
    
    public boolean isGTE(float value)
    {
        FloatUtils.isValidFloat(value, "value");
        
        return value >= endInterval;
    }
    
    public boolean isLT(float value)
    {
        FloatUtils.isValidFloat(value, "value");
        
        return value < startInterval;
    }
    
    public boolean isLTE(float value)
    {
        FloatUtils.isValidFloat(value, "value");
        
        return value <= startInterval;
    }
    
    public float truncate(float value)
    {
        if(isGT(value))
        {
            return endInterval;
        }
        
        if(isLT(value))
        {
            return startInterval;
        }
            
        return value;
    }
    
    public boolean isInIntervalExclusive(float value)
    {
        if(Float.isInfinite(value) ||
           Float.isNaN(value))
        {
            throw new IllegalArgumentException("The given value must be a valid floating point number.");
        }
        
        return startInterval < value && value < endInterval;
    }
    
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
    
    public boolean isInIntervalInclusive(float value)
    {
        if(Float.isInfinite(value) ||
           Float.isNaN(value))
        {
            throw new IllegalArgumentException("The given value must be a valid floating point number.");
        }
        
        return startInterval <= value && value <= endInterval;
    }
    
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
    
    public boolean intersectsThisIntervalInclusive(FloatInterval floatInterval)
    {
        return (thisStartLTThatStart(floatInterval) &&
                thisEndGTEThatStart(floatInterval)) ||
               thisStartLTEThatEnd(floatInterval);
    }
    
    public boolean intersectsThisIntervalExclusive(FloatInterval floatInterval)
    {
        return (thisStartLTThatStart(floatInterval) &&
                thisEndGTThatStart(floatInterval)) ||
               thisStartLTThatEnd(floatInterval);
    }
    
    public boolean containsThisIntervalInclusive(FloatInterval floatInterval)
    {
        return (startInterval <= floatInterval.getStartInterval() && 
                floatInterval.getStartInterval() <= endInterval) &&
               (startInterval <= floatInterval.getEndInterval() &&
                floatInterval.getEndInterval() <= endInterval);
    }
    
    public void containsThisIntervalInclusiveException(FloatInterval floatInterval)
    {
        if(!containsThisIntervalInclusive(floatInterval))
        {
            throw new IllegalArgumentException("The given interval is not valid");
        }
    }
    
    public boolean containsThisIntervalExclusive(FloatInterval floatInterval)
    {
        return (startInterval < floatInterval.getStartInterval() && 
                floatInterval.getStartInterval() < endInterval) &&
               (startInterval < floatInterval.getEndInterval() &&
                floatInterval.getEndInterval() < endInterval);        
    }
    
    public boolean thisEndEqualsThatStart(FloatInterval floatInterval)
    {
        return endInterval == floatInterval.getStartInterval();
    }
    
    public boolean thisEndGTThatStart(FloatInterval floatInterval)
    {
        return endInterval > floatInterval.getStartInterval();
    }
    
    public boolean thisStartEqualsThatEnd(FloatInterval floatInterval)
    {
        return startInterval == floatInterval.getEndInterval();
    }
    
    public boolean thisStartLTThatEnd(FloatInterval floatInterval)
    {
        return startInterval < floatInterval.getEndInterval();
    }
    
    public boolean thisStartLTEThatEnd(FloatInterval floatInterval)
    {
        return startInterval <= floatInterval.getEndInterval();
    }
    
    public boolean thisStartEqualsThatStart(FloatInterval floatInterval)
    {
        return startInterval == floatInterval.getStartInterval();
    }
    
    public boolean thisStartLTThatStart(FloatInterval floatInterval)
    {
        return startInterval < floatInterval.getStartInterval();
    }
    
    public boolean thisStartLTEThatStart(FloatInterval floatInterval)
    {
        return startInterval <= floatInterval.getStartInterval();
    }
    
    public boolean thisEndGTEThatStart(FloatInterval floatInterval)
    {
        return endInterval >= floatInterval.getStartInterval();
    }
    
    public boolean thisEndEqualsThatEnd(FloatInterval floatInterval)
    {
        return endInterval == floatInterval.getEndInterval();
    }
    
    public boolean thisEndLTEThatStart(FloatInterval floatInterval)
    {
        return endInterval <= floatInterval.getStartInterval();
    }
    
    public float getRandom(Random random)
    {
        return random.nextFloat() * range - rangeHalf + center;
    }
}
