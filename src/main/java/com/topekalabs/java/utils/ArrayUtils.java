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

import com.topekalabs.math.utils.IntInterval;
import com.topekalabs.math.utils.IntUtils;

/**
 * This contains utilities for working with java arrays.
 * @author Topeka Labs
 */
public class ArrayUtils
{   
    /**
     * This method throws an IllegalArgumentException if the input array is empty.
     * @param array The array to check.
     */
    public static void isEmptyException(Object[] array)
    {
        if(array.length == 0)
        {
            throw new IllegalArgumentException("The given array is empty.");
        }
    }

    /**
     * This method throws an IllegalArgumentException if the input array is empty.
     * The name of the array is included in the exception message.
     * @param array The array to check.
     * @param arrayName The name of the array to check.
     */
    public static void isEmptyException(Object[] array,
                                        String arrayName)
    {
        if(array.length == 0)
        {
            throw new IllegalArgumentException("The given array is empty.");
        }
    }
    
    /**
     * This method ensures that the input array is not empty and does not contain
     * any null values. If the array is empty an IllegalArgumentException is
     * thrown. If the array contains a null then a NullPointerException is
     * thrown.
     * @param array The input array to check.
     */
    public static void isPopulatedException(Object[] array)
    {
        ArrayUtils.isEmptyException(array);
        
        for(Object object: array)
        {
            ExceptionUtils.isNullException(object);
        }
    }

    /**
     * This method ensures that the input array is not empty and does not contain
     * any null values. If the array is empty an IllegalArgumentException is
     * thrown. If the array contains a null then a NullPointerException is
     * thrown. The exception message contains the name of the array.
     * @param array The input array to check.
     * @param arrayName The name of the input array.
     */
    public static void isPopulatedException(Object[] array,
                                            String arrayName)
    {
        ArrayUtils.isEmptyException(array, arrayName);
        
        for(Object object: array)
        {
            ExceptionUtils.isNullException(object, arrayName);
        }
    }
    
    /**
     * This method computes stride * index.
     * @param stride Stride length of an array element.
     * @param index Index of element in the array.
     * @return stride * index.
     */
    public static int getIndex(int stride,
                               int index)
    {
        IntUtils.isPositiveException(stride, "stride");
        IntUtils.isNonNegativeException(index, "index");
        
        return stride * index;
    }
    
    /**
     * This computes the index of an element in a 2D array.
     * @param columnCount The number of columns in the 2D array.
     * @param rowIndex The row index of the element in the 2D array.
     * @param columnIndex The column index of the element in the 2D array.
     * @return The 2D array index.
     */
    public static int getIndex2D(int columnCount,
                                 int rowIndex,
                                 int columnIndex)
    {
        IntUtils.isNonNegativeException(columnCount, "columnCount");
        IntUtils.isNonNegativeException(rowIndex, "rowIndex");
        IntUtils.isNonNegativeException(columnIndex, "columnIndex");
        
        return columnCount * rowIndex + columnIndex;
    }
    
    /**
     * This computes the index of an element in a 2D array, where elements have
     * a length specified by the stride.
     * @param stride The size of elements in the array (in terms of number of indices).
     * @param columnCount The number of columns in the 2D array.
     * @param rowIndex The row index in the 2D array.
     * @param columnIndex The column index in the 2D array.
     * @return The index of the element in the 2D array.
     */
    public static int getIndex2D(int stride,
                                 int columnCount,
                                 int rowIndex,
                                 int columnIndex)
    {
        IntUtils.isPositiveException(stride, "stride");
        IntUtils.isNonNegativeException(columnCount, "columnCount");
        IntUtils.isNonNegativeException(rowIndex, "rowIndex");
        IntUtils.isNonNegativeException(columnIndex, "columnIndex");
        
        return stride * (rowIndex * columnCount + columnIndex);
    }
    
    /**
     * This computes the index of an element in a 2D array, where elements have
     * a length specified by the stride and component.
     * @param stride The size of elements in the array (in terms of number of indices).
     * @param component A component within a stride.
     * @param columnCount The number of columns in the 2D array.
     * @param rowIndex The row index in the 2D array.
     * @param columnIndex The column index in the 2D array.
     * @return The index of the element in the 2D array.
     */
    public static int getIndex2D(int stride,
                                 int component,
                                 int columnCount,
                                 int rowIndex,
                                 int columnIndex)
    {
        IntUtils.isPositiveException(stride, "stride");
        IntUtils.isNonNegativeException(columnCount, "columnCount");
        new IntInterval(0, stride - 1).isInIntervalExclusiveException(component,
                                                                      "component");
        IntUtils.isNonNegativeException(rowIndex);
        IntUtils.isNonNegativeException(columnIndex);
        
        return stride * (rowIndex * columnCount + columnIndex) + component;
    }
}
