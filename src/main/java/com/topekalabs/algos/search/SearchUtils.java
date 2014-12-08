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
package com.topekalabs.algos.search;

import com.topekalabs.big.array.JumboArrayLongInterface;
import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.compare.utils.CompareFactoryInt;
import com.topekalabs.math.compare.utils.CompareFactoryIntInterface;
import com.topekalabs.math.compare.utils.CompareFactoryIntU;
import com.topekalabs.math.compare.utils.CompareFactoryLong;
import com.topekalabs.math.compare.utils.CompareFactoryLongInterface;
import com.topekalabs.math.compare.utils.CompareFactoryLongU;
import com.topekalabs.math.utils.LongInterval;
import com.topekalabs.math.utils.LongUtils;
import com.topekalabs.wrapper.utils.WrapperInt;
import com.topekalabs.wrapper.utils.WrapperLong;
import com.topekalabs.wrapper.utils.WrapperLongInterval;

/**
 *
 * @author Topeka Labs
 */
public class SearchUtils
{
    /**
     * This binary search finds a value in an array of values.
     * @param array
     * @param value
     * @param result 
     */
    public static void binarySearch(JumboArrayLongInterface array,
                                    long value,
                                    WrapperLong result)
    {
        binarySearch(array,
                     value,
                     result,
                     CompareFactoryLong.getInstance());
    }
    
    public static void binarySearchU(JumboArrayLongInterface array,
                                     long value,
                                     WrapperLong result)
    {
        binarySearch(array,
                     value,
                     result,
                     CompareFactoryLongU.getInstance());
    }
    
    private static void binarySearch(JumboArrayLongInterface array,
                                     long value,
                                     WrapperLong result,
                                     CompareFactoryLongInterface cfli)
    {
        long startIndex = array.getIndexInterval().getStartInterval();
        long endIndex = array.getIndexInterval().getEndInterval();
        
        while(startIndex <= endIndex)
        {
            long currentIndex = startIndex + 
                                ((endIndex - startIndex) / 2);
            
            long tempValue = array.get(currentIndex);
            
            if(tempValue == value)
            {
                result.valid = true;
                result.value = currentIndex;
                return;
            }
            
            if(LongUtils.ult(value, tempValue))
            {
                endIndex = currentIndex - 1;
                continue;
            }
            
            startIndex = currentIndex + 1;
        }
        
        result.valid = false;
    }

    /** TODO
     * This binary search finds the last value in the array less then the given value.
     * @param array
     * @param value
     * @param result 
     */
    public static void binarySearchLL(JumboArrayLongInterface array,
                                      long value,
                                      WrapperLong result)
    {
        binarySearchLL(array,
                       value,
                       result,
                       CompareFactoryLong.getInstance());
    }
    
    public static void binarySearchLLU(JumboArrayLongInterface array,
                                       long value,
                                       WrapperLong result)
    {
        binarySearchLL(array,
                       value,
                       result,
                       CompareFactoryLongU.getInstance());
    }
    
    private static void binarySearchLL(JumboArrayLongInterface array,
                                       long value,
                                       WrapperLong result,
                                       CompareFactoryLongInterface cfli)
    {
        long startIndex = array.getIndexInterval().getStartInterval();
        long endIndex = array.getIndexInterval().getEndInterval();
        
        while(startIndex <= endIndex)
        {
            long currentIndex = startIndex + 
                                ((endIndex - startIndex) / 2);
            
            long tempValue = array.get(currentIndex);
            
            if(tempValue == value)
            {
                if(currentIndex ==
                   array.getIndexInterval().getStartInterval())
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex - 1;
                    return;
                }
                else
                {
                    endIndex = currentIndex - 1;
                }
            }
            else if(cfli.lt(tempValue, value))
            {
                if(currentIndex ==
                   array.getIndexInterval().getEndInterval())
                {
                    result.valid = true;
                    result.value = currentIndex;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex;
                    return;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
            //tempValue > value
            else
            {
                if(currentIndex ==
                   array.getIndexInterval().getStartInterval())
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex - 1;
                }
                else
                {
                    endIndex = currentIndex - 1;   
                }
            }
        }
        
        ExceptionUtils.thisShouldNotHappen();
    }
    
    /**
     * TODO
     * This binary search finds the first value in the array more than the given value.
     * @param array
     * @param value
     * @param result 
     */
    public static void binarySearchFM(JumboArrayLongInterface array,
                                      long value,
                                      WrapperLong result)
    {
        binarySearchFM(array,
                       value,
                       result,
                       CompareFactoryLong.getInstance());
    }
    
    public static void binarySearchFMU(JumboArrayLongInterface array,
                                       long value,
                                       WrapperLong result)
    {
        binarySearchFM(array,
                       value,
                       result,
                       CompareFactoryLongU.getInstance());
    }
    
    private static void binarySearchFM(JumboArrayLongInterface array,
                                       long value,
                                       WrapperLong result,
                                       CompareFactoryLongInterface cfli)
    {
        long startIndex = array.getIndexInterval().getStartInterval();
        long endIndex = array.getIndexInterval().getEndInterval();
        
        while(startIndex <= endIndex)
        {
            long currentIndex = startIndex + 
                                ((endIndex - startIndex) / 2);
            
            long tempValue = array.get(currentIndex);
            
            if(tempValue == value)
            {
                if(currentIndex ==
                   array.getIndexInterval().getEndInterval())
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex + 1;
                    return;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
            else if(cfli.lt(tempValue, value))
            {
                if(currentIndex ==
                   array.getIndexInterval().getEndInterval())
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex + 1;
                    return;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
            //tempValue > value
            else
            {
                if(currentIndex ==
                   array.getIndexInterval().getStartInterval())
                {
                    result.valid = true;
                    result.value = array.getIndexInterval().getStartInterval();
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex;
                }
                else
                {
                    endIndex = currentIndex - 1;   
                }
            }
        }
        
        ExceptionUtils.thisShouldNotHappen();
    }
    
    ////
    
    /** TODO
     * This binary search finds the last value in the array less then the given value.
     * @param array
     * @param value
     * @param result 
     */
    public static void binarySearchLL(long[] array,
                                      long value,
                                      WrapperLong result)
    {
        binarySearchLL(array,
                       value,
                       result,
                       CompareFactoryLong.getInstance());
    }
    
    public static void binarySearchLLU(long[] array,
                                       long value,
                                       WrapperLong result)
    {
        binarySearchLL(array,
                       value,
                       result,
                       CompareFactoryLongU.getInstance());
    }
    
    private static void binarySearchLL(long[] array,
                                       long value,
                                       WrapperLong result,
                                       CompareFactoryLongInterface cfli)
    {
        int startIndex = 0;
        int endIndex = array.length - 1;
        
        while(startIndex <= endIndex)
        {
            int currentIndex = startIndex + 
                               ((endIndex - startIndex) / 2);
            
            long tempValue = array[currentIndex];
            
            if(tempValue == value)
            {
                if(currentIndex == 0)
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex - 1;
                    return;
                }
                else
                {
                    endIndex = currentIndex - 1;
                }
            }
            else if(cfli.lt(tempValue, value))
            {
                if(currentIndex == array.length - 1)
                {
                    result.valid = true;
                    result.value = currentIndex;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex;
                    return;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
            //tempValue > value
            else
            {
                if(currentIndex == 0)
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex - 1;
                }
                else
                {
                    endIndex = currentIndex - 1;   
                }
            }
        }
        
        ExceptionUtils.thisShouldNotHappen();
    }
    
    /**
     * TODO
     * This binary search finds the first value in the array more than the given value.
     * @param array
     * @param value
     * @param result 
     */
    public static void binarySearchFM(long[] array,
                                      long value,
                                      WrapperLong result)
    {
        binarySearchFM(array,
                       value,
                       result,
                       CompareFactoryLong.getInstance());
    }
    
    public static void binarySearchFMU(long[] array,
                                       long value,
                                       WrapperLong result)
    {
        binarySearchFM(array,
                       value,
                       result,
                       CompareFactoryLongU.getInstance());
    }
    
    private static void binarySearchFM(long[] array,
                                       long value,
                                       WrapperLong result,
                                       CompareFactoryLongInterface cfli)
    {
        int startIndex = 0;
        int endIndex = array.length - 1;
        
        while(startIndex <= endIndex)
        {
            int currentIndex = startIndex + 
                               ((endIndex - startIndex) / 2);
            
            long tempValue = array[currentIndex];
            
            if(tempValue == value)
            {
                if(currentIndex == array.length - 1)
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex + 1;
                    return;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
            else if(cfli.lt(tempValue, value))
            {
                if(currentIndex == array.length - 1)
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex + 1;
                    return;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
            //tempValue > value
            else
            {
                if(currentIndex == 0)
                {
                    result.valid = true;
                    result.value = 0;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex;
                }
                else
                {
                    endIndex = currentIndex - 1;   
                }
            }
        }
        
        ExceptionUtils.thisShouldNotHappen();
    }
    
    ////
    
    /** TODO
     * This binary search finds the last value in the array less then the given value.
     * @param array
     * @param value
     * @param result 
     */
    public static void binarySearchLL(int[] array,
                                      int value,
                                      WrapperLong result)
    {
        binarySearchLL(array,
                       value,
                       result,
                       CompareFactoryInt.getInstance());
    }
    
    public static void binarySearchLLU(int[] array,
                                       int value,
                                       WrapperLong result)
    {
        binarySearchLL(array,
                       value,
                       result,
                       CompareFactoryIntU.getInstance());
    }
    
    private static void binarySearchLL(int[] array,
                                       int value,
                                       WrapperLong result,
                                       CompareFactoryIntInterface cfii)
    {
        int startIndex = 0;
        int endIndex = array.length - 1;
        
        while(startIndex <= endIndex)
        {
            int currentIndex = startIndex + 
                               ((endIndex - startIndex) / 2);
            
            int tempValue = array[currentIndex];
            
            if(tempValue == value)
            {
                if(currentIndex == 0)
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex - 1;
                    return;
                }
                else
                {
                    endIndex = currentIndex - 1;
                }
            }
            else if(cfii.lt(tempValue, value))
            {
                if(currentIndex == array.length - 1)
                {
                    result.valid = true;
                    result.value = currentIndex;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex;
                    return;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
            //tempValue > value
            else
            {
                if(currentIndex == 0)
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex - 1;
                }
                else
                {
                    endIndex = currentIndex - 1;   
                }
            }
        }
        
        ExceptionUtils.thisShouldNotHappen();
    }
    
    /**
     * TODO
     * This binary search finds the first value in the array more than the given value.
     * @param array
     * @param value
     * @param result 
     */
    public static void binarySearchFM(int[] array,
                                      int value,
                                      WrapperLong result)
    {
        binarySearchFM(array,
                       value,
                       result,
                       CompareFactoryInt.getInstance());
    }
    
    public static void binarySearchFMU(int[] array,
                                       int value,
                                       WrapperLong result)
    {
        binarySearchFM(array,
                       value,
                       result,
                       CompareFactoryIntU.getInstance());
    }
    
    private static void binarySearchFM(int[] array,
                                       int value,
                                       WrapperLong result,
                                       CompareFactoryIntInterface cfii)
    {
        int startIndex = 0;
        int endIndex = array.length - 1;
        
        while(startIndex <= endIndex)
        {
            int currentIndex = startIndex + 
                               ((endIndex - startIndex) / 2);
            
            int tempValue = array[currentIndex];
            
            if(tempValue == value)
            {
                if(currentIndex == array.length - 1)
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex + 1;
                    return;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
            else if(cfii.lt(tempValue, value))
            {
                if(currentIndex == array.length - 1)
                {
                    result.valid = false;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex + 1;
                    return;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
            //tempValue > value
            else
            {
                if(currentIndex == 0)
                {
                    result.valid = true;
                    result.value = 0;
                    return;
                }
                else if(startIndex == endIndex)
                {
                    result.valid = true;
                    result.value = currentIndex;
                }
                else
                {
                    endIndex = currentIndex - 1;   
                }
            }
        }
        
        ExceptionUtils.thisShouldNotHappen();
    }
    
    ////
    
    public static void binarySearchInterval(JumboArrayLongInterface array,
                                            long start,
                                            long end,
                                            WrapperLongInterval result)
    {
        binarySearchLL(array,
                       end,
                       result);
        
        if(!result.valid)
        {
            return;
        }
        
        if(array.get(result.value) < start)
        {
            result.valid = false;
            return;
        }
        
        long lastLess = result.value;
        
        binarySearchFM(array,
                       start,
                       result);
        
        if(!result.valid)
        {
            return;
        }
        
        if(array.get(result.value) > end)
        {
            result.valid = false;
            return;
        }
        
        long firstMore = result.value;
        
        result.valid = true;
        result.start = firstMore;
        result.end = lastLess;
    }
    
    /**
     * Disjoint intervals.
     * @param intervals
     * @param value
     * @param result 
     */
    public static void binarySearch(LongInterval[] intervals,
                                    long value,
                                    WrapperInt result)
    {
        int startIndex = 0;
        int endIndex = intervals.length - 1;
        
        int lastIntervalStartLess = -1;
        
        while(startIndex <= endIndex)
        {
            int currentIndex = startIndex + 
                               ((endIndex - startIndex) / 2);
            
            long tempValue = intervals[currentIndex].getStartInterval();
            
            if(tempValue == value)
            {
                result.valid = true;
                result.value = currentIndex;
                return;
            }
            
            if(value < tempValue)
            {
                if(startIndex == endIndex)
                {
                    if(startIndex == 0)
                    {
                        result.valid = false;
                        return;
                    }
                    
                    lastIntervalStartLess = currentIndex - 1;
                    break;
                }
                else
                {
                    endIndex = currentIndex - 1;
                }
            }
            else
            {
                if(startIndex == endIndex)
                {
                    if(endIndex == intervals.length - 1)
                    {
                        lastIntervalStartLess = intervals.length - 1;
                    }
                    else
                    {
                        lastIntervalStartLess = currentIndex + 1;
                    }
                    
                    break;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
        }
        
        startIndex = 0;
        endIndex = intervals.length - 1;
        int firstIntervalEndMore = -1;
        
        while(startIndex <= endIndex)
        {
            int currentIndex = startIndex + 
                               ((endIndex - startIndex) / 2);
            
            long tempValue = intervals[currentIndex].getEndInterval();
            
            if(tempValue == value)
            {
                result.valid = true;
                result.value = currentIndex;
                return;
            }
            
            if(value > tempValue)
            {
                if(startIndex == endIndex)
                {
                    if(startIndex == 0)
                    {
                        result.valid = false;
                        return;
                    }
                    
                    lastIntervalStartLess = currentIndex - 1;
                    break;
                }
                else
                {
                    endIndex = currentIndex - 1;
                }
            }
            else
            {
                if(startIndex == endIndex)
                {
                    if(endIndex == intervals.length - 1)
                    {
                        lastIntervalStartLess = intervals.length - 1;
                    }
                    else
                    {
                        lastIntervalStartLess = currentIndex + 1;
                    }
                    
                    break;
                }
                else
                {
                    startIndex = currentIndex + 1;
                }
            }
        }
        
        if(firstIntervalEndMore <= lastIntervalStartLess)
        {
            result.value = firstIntervalEndMore;
            result.valid = true;
        }
        else
        {
            result.valid = false;
        }
    }
    
    //Search for interval among points
}
