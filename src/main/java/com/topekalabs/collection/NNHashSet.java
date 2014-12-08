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
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Topeka Labs
 */
public class NNHashSet<T> extends HashSet<T>
{
    public NNHashSet()
    {
        super();
    }

    public NNHashSet(Collection<? extends T> c) 
    {
        super(c);
    }
    
    public NNHashSet(int initialCapacity, float loadFactor) 
    {
        super(initialCapacity, loadFactor);
    }

    public NNHashSet(int initialCapacity)
    {
        super(initialCapacity);
    }
    
    @Override
    public boolean add(T value)
    {
        ExceptionUtils.isNullException(value);
        return super.add(value);
    }
    
    @Override
    public boolean contains(Object o)
    {
        ExceptionUtils.isNullException(o);
        return super.contains(o);
    }
    
    @Override
    public boolean remove(Object o)
    {
        ExceptionUtils.isNullException(o);
        return super.remove(o);
    }
}
