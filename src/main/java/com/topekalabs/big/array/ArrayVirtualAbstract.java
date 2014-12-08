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
package com.topekalabs.big.array;

import com.topekalabs.array.utils.ArrayUtils;
import com.topekalabs.collection.utils.CollectionUtils;
import com.topekalabs.collection.utils.ListUtils;
import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.utils.LongInterval;
import java.lang.reflect.Array;
import java.util.List;

/**
 *
 * @author Topeka Labs
 */
public abstract class ArrayVirtualAbstract<T> implements JumboArray
{
    private long length;
    private LongInterval indexInterval;
    private T[] arrays;
    
    public ArrayVirtualAbstract(T... arrays)
    {
        setArrays(arrays);
    }
    
    public ArrayVirtualAbstract(List<T> arrays)
    {
        setArrays(arrays);
    }
    
    public ArrayVirtualAbstract(LongInterval indexInterval,
                                T... arrays)
    {
        setArrays(arrays);
    }
    
    public ArrayVirtualAbstract(LongInterval indexInterval,
                                List<T> arrays)
    {
        setArrays(arrays);
    }
    
    private void setArrays(T[] arrays)
    {
        ExceptionUtils.isNullException(arrays, "arrays");
        ArrayUtils.isNotPopulatedException(arrays, "arrays");
        ArrayUtils.listContainsDuplicateReferencesException(arrays, "arrays");
        
        this.arrays = arrays;
    }
    
    private void setArrays(List<T> arrays)
    {
        ExceptionUtils.isNullException(arrays, "arrays");
        CollectionUtils.isNotPopulatedException(arrays, "arrays");
        ListUtils.listContainsDuplicateReferencesException(arrays, "arrays");
        
        this.arrays = (T[]) Array.newInstance(arrays.get(0).getClass(),
                                              arrays.size());
        
        for(int indexCounter = 0;
            indexCounter < arrays.size();
            indexCounter++)
        {
            this.arrays[indexCounter] = arrays.get(indexCounter);
        }
    }

    @Override
    public LongInterval getIndexInterval()
    {
        return indexInterval;
    }

    @Override
    public long getLength()
    {
        return length;
    }
}
