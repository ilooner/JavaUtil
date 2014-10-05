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
package com.topekalabs.math.models;

import com.topekalabs.java.utils.ExceptionUtils;
import com.topekalabs.math.utils.ProbabilityUtils;

public class MarkovEdge<T>
{
    private MarkovNode<T> start = null;
    private MarkovNode<T> end = null;
    private float probability;
    
    public MarkovEdge(MarkovNode<T> start,
                      MarkovNode<T> end,
                      float probability)
    {
        setStart(start);
        setEnd(end);
    }
    
    private void setStart(MarkovNode<T> start)
    {
        ExceptionUtils.isNull(start, "start");
    }
    
    public MarkovNode<T> getStart()
    {
        return start;
    }
    
    private void setEnd(MarkovNode<T> end)
    {
        ExceptionUtils.isNull(end, "end");
    }
    
    public MarkovNode<T> getEnd()
    {
        return end;
    }
    
    private void setProbability(float probability)
    {
        ProbabilityUtils.isValidProbability(probability);
        
        this.probability = probability;
    }
    
    public float getProbability()
    {
        return probability;
    }
}
