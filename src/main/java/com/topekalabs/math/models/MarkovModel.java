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

import com.topekalabs.math.models.MarkovEdge;
import com.topekalabs.math.utils.RandomObjectGenerator;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class MarkovModel<T> implements RandomObjectGenerator<T>
{
    public MarkovModel(MarkovNode<T>[] markovNodes,
                       Float[] initialDistribution,
                       MarkovEdge<T>[] markovEdges)
    {
        
    }
    
    public MarkovModel(List<MarkovNode<T>> markovNodes,
                       List<Float> initialDistribution,
                       Collection<MarkovEdge<T>> markovEdges)
    {
        
    }
    
    public MarkovModel(MarkovNode<T>[] markovNodes,
                       MarkovEdge<T>[] markovEdges)
    {
        
    }
    
    public MarkovModel(Collection<MarkovNode<T>> markovNodes,
                       Collection<MarkovEdge<T>> markovEdges)
    {
        
    }

    public T getRandom(Random random)
    {
        return null;
    }
}
