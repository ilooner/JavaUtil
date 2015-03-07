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
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Topeka Labs
 */
public class PermutationsTest
{
    @Test
    public void simpleTest()
    {
        Map<String, Set<Integer>> valuesMap = Maps.newHashMap();
        Set<Integer> numbers = Sets.newHashSet(1, 2);
        
        valuesMap.put("a", numbers);
        valuesMap.put("b", numbers);
        valuesMap.put("c", numbers);
        
        Set<Map<String, Integer>> ps = Sets.newHashSet();
        
        Map<String, Integer> p = Maps.newHashMap();
        p.put("a", 1);
        p.put("b", 1);
        p.put("c", 1);
        ps.add(p);
        
        p = Maps.newHashMap();
        p.put("a", 1);
        p.put("b", 1);
        p.put("c", 2);
        ps.add(p);
        
        p = Maps.newHashMap();
        p.put("a", 1);
        p.put("b", 2);
        p.put("c", 1);
        ps.add(p);
        
        p = Maps.newHashMap();
        p.put("a", 1);
        p.put("b", 2);
        p.put("c", 2);
        ps.add(p);
        
        p = Maps.newHashMap();
        p.put("a", 2);
        p.put("b", 1);
        p.put("c", 1);
        ps.add(p);
        
        p = Maps.newHashMap();
        p.put("a", 2);
        p.put("b", 1);
        p.put("c", 2);
        ps.add(p);
        
        p = Maps.newHashMap();
        p.put("a", 2);
        p.put("b", 2);
        p.put("c", 1);
        ps.add(p);
        
        p = Maps.newHashMap();
        p.put("a", 2);
        p.put("b", 2);
        p.put("c", 2);
        ps.add(p);
        
        Set<Map<String, Integer>> genPermutations = Permutations.labeledPermutations(valuesMap);
        Assert.assertEquals("The permutations should equal.", ps, genPermutations);
    }
}
