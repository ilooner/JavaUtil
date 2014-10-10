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
package com.topekalabs.datastruct;

import com.topekalabs.collection.utils.CollectionUtils;
import com.topekalabs.math.utils.IntInterval;
import com.topekalabs.math.utils.IntUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a circular list implementation.
 * @author Topeka Labs
 * @param <T> The type of objects in the list.
 */
public class CircularList<T>
{
    /**
     * The default step size.
     */
    private static final int DEFAULT_STEP_SIZE = 1;
    
    /**
     * The current index in the circular list.
     */
    private int currentIndex;
    
    /**
     * The step size when retrieving the next element in the list.
     */
    private int stepSize = DEFAULT_STEP_SIZE;
    
    /**
     * The list of elements in the circular list.
     */
    private List<T> list;
    
    /**
     * This constructor creates an immutable circular list from the given list.
     * @param list The list from which to construct a circular list.
     */
    public CircularList(List<T> list)
    {
        setList(list);
        setCurrentIndex(0);
        setStepSize(1);
    }
    
    /**
     * This constructor creates a circular with the specified list, currentIndex,
     * and step size.
     * @param currentIndex The current index in the circular list.
     * @param stepSize The step size for obtaining the next element in the
     * circular list.
     * @param list The list from which to construct a circular list.
     */
    public CircularList(int currentIndex,
                        int stepSize,
                        List<T> list)
    {
        setCurrentIndex(currentIndex);
        setStepSize(stepSize);
        setList(list);
    }
    
    /**
     * This helper method copies the given list.
     * @param list The list to copy and be used in the circular list.
     */
    private void setList(List<T> list)
    {
        CollectionUtils.isEmptyException(list);
        
        this.list = new ArrayList<T>();
        
        for(T item: list)
        {
            this.list.add(item);
        }
    }
    
    /**
     * This method sets the current index of the circular list.
     * @param currentIndex  The current index of the circular list.
     */
    public final void setCurrentIndex(int currentIndex)
    {
        new IntInterval(0, list.size() - 1).isInIntervalInclusiveException(currentIndex,
                                                                           "currentIndex");
        this.currentIndex = currentIndex;
    }
    
    /**
     * This method sets the step size of the circular list.
     * @param stepSize The step size of the circular list.
     */
    public final void setStepSize(int stepSize)
    {
        IntUtils.isPositiveException(stepSize, "stepSize");
        
        this.stepSize = stepSize;
    }
    
    /**
     * This method obtains the next element in the circular list.
     * @return This is the next element in the circular list.
     */
    public T next()
    {
        T value = list.get(currentIndex);
        currentIndex = (currentIndex + stepSize) % list.size();
        
        return value;
    }
    
    /**
     * This method returns the size of the circular list.
     * @return The size of the circular list.
     */
    public int size()
    {
        return list.size();
    }
}
