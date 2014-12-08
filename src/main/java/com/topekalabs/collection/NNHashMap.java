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
package com.topekalabs.collection;

import com.topekalabs.error.utils.ExceptionUtils;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Topeka Labs
 */
public class NNHashMap<K, V> extends HashMap<K, V>
{
    public NNHashMap(int initialCapacity, float loadFactor)
    {
        super(initialCapacity, loadFactor);
    }

    public NNHashMap(int initialCapacity)
    {
        super(initialCapacity);
    }

    public NNHashMap()
    {
        super();
    }

    public NNHashMap(Map<? extends K, ? extends V> m)
    {
        super(m);
    }
    
    @Override
    public V put(K key, V value)
    {
        ExceptionUtils.isNullException(key, "key");
        ExceptionUtils.isNullException(value, "value");
        
        return super.put(key, value);
    }
    
    @Override
    public V remove(Object key)
    {
        ExceptionUtils.isNullException(key, "key");
        
        return super.remove(key);
    }
    
    @Override
    public V get(Object key)
    {
        ExceptionUtils.isNullException(key, "key");
        
        return super.get(key);
    }
    
    @Override
    public boolean containsKey(Object key)
    {
        ExceptionUtils.isNullException(key, "key");
        return super.containsKey(key);
    }
}
