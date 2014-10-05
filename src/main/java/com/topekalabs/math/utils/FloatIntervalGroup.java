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

public class FloatIntervalGroup
{
    private float probability;
    private FloatInterval floatInterval = null;
    
    public FloatIntervalGroup(float probability,
                              FloatInterval floatInterval)
    {
        setProbability(probability);
        setFloatInterval(floatInterval);
    }
    
    private void setProbability(float probability)
    {
        if(Float.isInfinite(probability) ||
           Float.isNaN(probability))
        {
            throw new IllegalArgumentException("The given probability must be a valid floating point number.");
        }
        
        if(probability > 1.0f || probability < 0.0f)
        {
            throw new IllegalArgumentException("The given probability must be between 0.0 and 1.0");
        }
        
        this.probability = probability;
    }
    
    private void setFloatInterval(FloatInterval floatInterval)
    {
        if(floatInterval == null)
        {
            throw new NullPointerException("The given floatIntervalGroup cannot be null.");
        }
        
        this.floatInterval = floatInterval;
    }
    
    public float getProbability()
    {
        return probability;
    }
    
    public FloatInterval getFloatInterval()
    {
        return floatInterval;
    }
}
