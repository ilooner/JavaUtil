/*
 * Copyright 2015 Topeka Labs.
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
package com.topekalabs.algos.discrete;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.topekalabs.collection.utils.CollectionUtils;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Topeka Labs
 */
public final class Permutations
{
    private Permutations()
    {
    }
    
    public static <L, V> Set<Map<L, V>> labeledPermutations(Map<L, Set<V>> valuesMap)
    {
        Set<Map<L, V>> permutations = Sets.newHashSet();
        
        if(valuesMap.isEmpty()) {
            return permutations;
        }
        
        Map.Entry<L, Set<V>> mapEntry = CollectionUtils.getSingleElement(valuesMap.entrySet());
        L label = mapEntry.getKey();
        Set<V> values = mapEntry.getValue();
        
        if(valuesMap.size() == 1) {
           for(V value: values) {
               Map<L, V> permutation = Maps.newHashMap();
               permutation.put(label, value);
               permutations.add(permutation);
           }
           
           return permutations;
        }
        
        Map<L, Set<V>> reducedValuesMap = Maps.newHashMap(valuesMap);
        reducedValuesMap.remove(label);
        
        Set<Map<L, V>> reducedPermutations = labeledPermutations(reducedValuesMap);
        
        for(Map<L, V> reducedPermutation: reducedPermutations) {
            for(V value: values) {
                Map<L, V> permutation = Maps.newHashMap(reducedPermutation);
                permutation.put(label, value);
                permutations.add(permutation);
            }
        }
        
        return permutations;
    }
}
