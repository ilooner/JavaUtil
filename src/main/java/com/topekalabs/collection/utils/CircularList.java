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

import com.topekalabs.math.utils.IntUtils;
import java.util.ArrayList;
import java.util.List;

public class CircularList<T>
{
    private int currentIndex;
    private int stepSize;
    private List<T> list;
    
    public CircularList(List<T> list)
    {
        setList(list);
        setCurrentIndex(0);
        setStepSize(1);
    }
    
    public CircularList(int currentIndex,
                        int stepSize,
                        List<T> list)
    {
        setCurrentIndex(currentIndex);
        setStepSize(stepSize);
        setList(list);
    }
    
    public final void setCurrentIndex(int currentIndex)
    {
        IntUtils.isInIntervalInclusive(0,
                                       list.size() - 1,
                                       currentIndex,
                                       "currentIndex");
        
        this.currentIndex = currentIndex;
    }
    
    public final void setStepSize(int stepSize)
    {
        IntUtils.isPositive(stepSize, "stepSize");
        
        this.stepSize = stepSize;
    }
    
    private void setList(List<T> list)
    {
        IntUtils.isGreaterThan(list.size(), 1, "list size");
        
        this.list = new ArrayList<T>();
        
        for(T item: list)
        {
            this.list.add(item);
        }
    }
    
    public T next()
    {
        T value = list.get(currentIndex);
        currentIndex = (currentIndex + stepSize) % list.size();
        
        return value;
    }
}
