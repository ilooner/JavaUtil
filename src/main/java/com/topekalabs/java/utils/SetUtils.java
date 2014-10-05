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
package com.topekalabs.java.utils;

import java.util.HashSet;
import java.util.Set;

public class SetUtils
{
    public static <T> Set<T> unionHashSet(Set<T> setA,
                                          Set<T> setB)
    {
        Set<T> unionSet = new HashSet<T>();
        
        unionSet.addAll(setA);
        unionSet.addAll(setB);
        
        return unionSet;
    }
    
    public static <T> Set<T> intersectHashSet(Set<T> setA,
                                              Set<T> setB)
    {
        Set<T> unionSetTemp = new HashSet<T>();
        
        unionSetTemp.addAll(setA);
        unionSetTemp.removeAll(setB);
        
        Set<T> unionSet = new HashSet<T>();
        unionSet.addAll(setA);
        unionSet.removeAll(unionSetTemp);
        
        return unionSet;
    }
}
