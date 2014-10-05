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
package com.topekalabs.math.utils;

import com.topekalabs.java.utils.ExceptionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This contains utilities for working with java arrays.
 * @author Topeka Labs
 */
public class ArrayUtils
{   
    /**
     * This method throws an IllegalArgumentException if the input array is empty.
     * @param array The array whose status must be checked.
     */
    public static void isEmptyException(Object[] array)
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
            ExceptionUtils.isNull(object);
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
        IntUtils.isPositive(stride, "stride");
        IntUtils.isNonNegative(index, "index");
        
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
        IntUtils.isNonNegative(columnCount, "columnCount");
        IntUtils.isNonNegative(rowIndex, "rowIndex");
        IntUtils.isNonNegative(columnIndex, "columnIndex");
        
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
        IntUtils.isPositive(stride, "stride");
        IntUtils.isNonNegative(columnCount, "columnCount");
        IntUtils.isNonNegative(rowIndex, "rowIndex");
        IntUtils.isNonNegative(columnCount, "columnCount");
        
        return stride * (rowIndex * columnCount + columnIndex);
    }
    
    public static int getIndex2D(int stride,
                                 int component,
                                 int yCount,
                                 int xIndex,
                                 int yIndex)
    {
        IntUtils.isPositive(stride, "stride");
        //IntUtils.is
        IntUtils.isInIntervalInclusive(0, yIndex, yIndex, null);
        return stride * (xIndex * yCount + xIndex) + component;
    }
    
    public static void vectorAdd(float[] array,
                                 int vectorIndex,
                                 float x,
                                 float y,
                                 float z)
    {
        int tempIndex = 3 * vectorIndex;
        array[tempIndex] += x;
        array[tempIndex + 1] += y;
        array[tempIndex + 2] += z;
    }
    
    public static void vectorMult(float[] array,
                                  int vectorIndex,
                                  float scale)
    {
        int tempIndex = 3 * vectorIndex;
        array[tempIndex] *= scale;
        array[tempIndex] *= scale;
        array[tempIndex] *= scale;
    }
    
    public static void vectorDiv(float[] array,
                                 int vectorIndex,
                                 float scale)
    {
        int tempIndex = 3 * vectorIndex;
        array[tempIndex] /= scale;
        array[tempIndex] /= scale;
        array[tempIndex] /= scale;
    }
    
    public static void zeroFill(float[] array)
    {
        for(int counter = 0;
            counter < array.length;
            counter++)
        {
            array[counter] = 0.0f;
        }
    }
}
