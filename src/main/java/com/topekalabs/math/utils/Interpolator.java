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

import java.util.List;

public abstract class Interpolator<T>
{
    public Interpolator()
    {
    }
    
    public abstract int getInterpCount();
    
    public final void interpLocal(float percent,
                                  T result,
                                  List<T> values)
    {
        ProbabilityUtils.isValidProbability(percent);
        interpCountException(values.size());
        
        interpLocalHelper(percent,
                          result,
                          values);
    }

    public abstract void interpLocalHelper(float percent,
                                           T result,
                                           List<T> values);
    
    public final T interp(float percent,
                          List<T> values)
    {
        ProbabilityUtils.isValidProbability(percent);
        interpCountException(values.size());
        
        return interpHelper(percent,
                            values);
    }
    
    public abstract T interpHelper(float percent,
                                   List<T> values);
    
    private void interpCountException(int values)
    {
        if(values != getInterpCount())
        {
            throw new IllegalArgumentException("The number of given values does not match the interp count.");
        }
    }
}
