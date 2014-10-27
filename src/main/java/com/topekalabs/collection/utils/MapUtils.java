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
package com.topekalabs.collection.utils;

import com.topekalabs.java.utils.ExceptionUtils;
import java.util.Map;

/**
 *
 * @author Topeka Labs
 */
public class MapUtils
{
    private MapUtils()
    {
        //Do nothing
    }
    
    public static <K, V> Map<K, V> shallowClone(Map<K, V> map)
    {
        Map<K, V> clonedMap = null;
        
        try
        {
            clonedMap = map.getClass().newInstance();
        }
        catch(InstantiationException | IllegalAccessException ex)
        {
            ExceptionUtils.thisShouldNotHappen("The map implementation needs a no arg constructor.",
                                               ex);
        }
        
        for(K key: map.keySet())
        {
            clonedMap.put(key, map.get(key));
        }
        
        return clonedMap;
    }
    
    public static <K, V> void isEmptyException(Map<K, V> map)
    {
        if(map.isEmpty())
        {
            throw new IllegalArgumentException("The given map cannot be empty.");
        }
    }
    
    public static <K, V> void isEmptyException(Map<K, V> map, String mapName)
    {
        if(map.isEmpty())
        {
            throw new IllegalArgumentException("The given map " +
                                               mapName +
                                               " cannot be empty.");
        }
    }
    
    public static <K, V> void isPopulatedException(Map<K, V> map)
    {
        isEmptyException(map);
        
        for(K key: map.keySet())
        {
            ExceptionUtils.isNullException(key, "key");
            ExceptionUtils.isNullException(map.get(key), "value");
        }
    }
}
