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
package com.topekalabs.algos.sort;

import com.topekalabs.big.array.JumboArrayByte;
import com.topekalabs.big.array.JumboArrayDouble;
import com.topekalabs.big.array.JumboArrayFloat;
import com.topekalabs.big.array.JumboArrayInt;
import com.topekalabs.big.array.JumboArrayLong;
import com.topekalabs.big.array.JumboArrayShort;
import com.topekalabs.math.compare.utils.CompareFactoryLong;
import com.topekalabs.math.compare.utils.CompareFactoryLongInterface;
import com.topekalabs.math.compare.utils.CompareFactoryLongU;
import com.topekalabs.math.utils.IntUtils;
import com.topekalabs.math.utils.LongUtils;
import java.util.Arrays;

/**
 *
 * @author Topeka Labs
 */
public class SortUtils
{
    private SortUtils()
    {
        //Do nothing
    }

////////////////////////////////////////////////////////////////////////////////
    // BubbleSort
////////////////////////////////////////////////////////////////////////////////
    
    public static void bubbleSort(JumboArrayLong array,
                                  long startIndex,
                                  long endIndex)
    {
        bubbleSort(array,
                   startIndex,
                   endIndex,
                   CompareFactoryLong.getInstance());
    }

    public static void bubbleSortU(JumboArrayLong array,
                                   long startIndex,
                                   long endIndex)
    {
        bubbleSort(array,
                   startIndex,
                   endIndex,
                   CompareFactoryLongU.getInstance());
    }
    
    private static void bubbleSort(JumboArrayLong array,
                                   long startIndex,
                                   long endIndex,
                                   CompareFactoryLongInterface cfli)
    {
        if(startIndex == endIndex)
        {
            return;
        }
                
        LongUtils.isLTException(endIndex, startIndex, "endIndex", "startIndex");
        
        for(;
            startIndex < endIndex;
            endIndex--)
        {
            for(long index = startIndex;
                index < endIndex;
                index++)
            {
                if(cfli.lte(array.get(index), array.get(index + 1)))
                {
                    continue;
                }
                
                long tempVal = array.get(index);
                array.set(index, array.get(index + 1));
                array.set(index + 1, tempVal);
            }
        }        
    }
    
    private static void bubbleSort(JumboArrayInt array,
                                   long startIndex,
                                   long endIndex)
    {
        if(startIndex == endIndex)
        {
            return;
        }
                
        LongUtils.isLTException(endIndex, startIndex, "endIndex", "startIndex");
        
        for(;
            startIndex < endIndex;
            endIndex--)
        {
            for(long index = startIndex;
                index < endIndex;
                index++)
            {
                if(array.get(index) <= array.get(index + 1))
                {
                    continue;
                }
                
                int tempVal = array.get(index);
                array.set(index, array.get(index + 1));
                array.set(index + 1, tempVal);
            }
        }
    }
    
    public static void bubbleSort(JumboArrayByte array,
                                  long startIndex,
                                  long endIndex)
    {
        if(startIndex == endIndex)
        {
            return;
        }
                
        LongUtils.isLTException(endIndex, startIndex, "endIndex", "startIndex");
        
        for(;
            startIndex < endIndex;
            endIndex--)
        {
            for(long index = startIndex;
                index < endIndex;
                index++)
            {
                if(array.get(index) <= array.get(index + 1))
                {
                    continue;
                }
                
                byte tempVal = array.get(index);
                array.set(index, array.get(index + 1));
                array.set(index + 1, tempVal);
            }
        }
    }
    
    public static void bubbleSort(JumboArrayShort array,
                                  long startIndex,
                                  long endIndex)
    {
        if(startIndex == endIndex)
        {
            return;
        }
                
        LongUtils.isLTException(endIndex, startIndex, "endIndex", "startIndex");
        
        for(;
            startIndex < endIndex;
            endIndex--)
        {
            for(long index = startIndex;
                index < endIndex;
                index++)
            {
                if(array.get(index) <= array.get(index + 1))
                {
                    continue;
                }
                
                short tempVal = array.get(index);
                array.set(index, array.get(index + 1));
                array.set(index + 1, tempVal);
            }
        }
    }
    
    public static void bubbleSort(JumboArrayFloat array,
                                  long startIndex,
                                  long endIndex)
    {
        if(startIndex == endIndex)
        {
            return;
        }
                
        LongUtils.isLTException(endIndex, startIndex, "endIndex", "startIndex");
        
        for(;
            startIndex < endIndex;
            endIndex--)
        {
            for(long index = startIndex;
                index < endIndex;
                index++)
            {
                if(array.get(index) <= array.get(index + 1))
                {
                    continue;
                }
                
                float tempVal = array.get(index);
                array.set(index, array.get(index + 1));
                array.set(index + 1, tempVal);
            }
        }
    }
    
    public static void bubbleSort(JumboArrayDouble array,
                                  long startIndex,
                                  long endIndex)
    {
        if(startIndex == endIndex)
        {
            return;
        }
                
        LongUtils.isLTException(endIndex, startIndex, "endIndex", "startIndex");
        
        for(;
            startIndex < endIndex;
            endIndex--)
        {
            for(long index = startIndex;
                index < endIndex;
                index++)
            {
                if(array.get(index) <= array.get(index + 1))
                {
                    continue;
                }
                
                double tempVal = array.get(index);
                array.set(index, array.get(index + 1));
                array.set(index + 1, tempVal);
            }
        }
    }

////////////////////////////////////////////////////////////////////////////////
    // Radix Sort
////////////////////////////////////////////////////////////////////////////////
    
    public static void radixSortPow2(long[] array,
                                     int powerOf2Radix)
    {
        radixSortPow2(array,
                      powerOf2Radix,
                      true);
    }
    
    public static void radixSortPow2U(long[] array,
                                      int powerOf2Radix)
    {
        radixSortPow2(array,
                      powerOf2Radix,
                      false);
    }
    
    public static void radixSortPow2(long[] array,
                                     int powerOf2Radix,
                                     boolean signed)
    {
        IntUtils.isTrivialNonPositivePowerOf2Exception(powerOf2Radix,
                                                       "powerOf2Radix");

        int maskSize = (int) LongUtils.ulog2Floor(powerOf2Radix);
        long mask = LongUtils.maskLSB(maskSize);
        int levels = IntUtils.divCeil(64, maskSize);
        
        int[][] levelBucketSizes = new int[levels][powerOf2Radix];
        int[][] levelBucketStartIndices = new int[levels][powerOf2Radix];
        int[][] levelBucketCurrentIndices = new int[levels][powerOf2Radix];
        
        if(64 % maskSize == 0 || !signed)
        {
            radixSortPow2(array,
                          levelBucketSizes,
                          levelBucketStartIndices,
                          levelBucketCurrentIndices,
                          maskSize,
                          mask,
                          levels,
                          0,
                          array.length - 1);
        }
        else
        {
            radixSortPow2First(array,
                               levelBucketSizes,
                               levelBucketStartIndices,
                               levelBucketCurrentIndices,
                               maskSize,
                               mask,
                               levels,
                               0,
                               array.length - 1);
        }
    }
    
    private static void radixSortPow2First(long[] array,
                                           int[][] levelBucketSizes,
                                           int[][] levelBucketStartIndices,
                                           int[][] levelBucketCurrentIndices,
                                           int maskSize,
                                           long mask,
                                           int level,
                                           int startIndex,
                                           int endIndex)
    {
        level--;
        
        int[] bucketSizes = levelBucketSizes[level];
        int[] bucketStartIndices = levelBucketStartIndices[level];
        int[] bucketCurrentIndices = levelBucketCurrentIndices[level];
        
        //Construct bucket mapping
        int numBits = (64 % maskSize);
        int bucketCount = 1 << numBits;
        int numNeg = 1 << (numBits - 1);
        
        int[] bucketToIndex = new int[bucketCount];
        
        for(int indexCounter = 0,
            index = numNeg;
            indexCounter <= bucketCount;
            indexCounter++,
            index++)
        {
            if(indexCounter == numNeg)
            {
                index = 0;
            }
            
            bucketToIndex[indexCounter] = index;
        }
        
        
    }
    
    private static void radixSortPow2(long[] array,
                                      int[][] levelBucketSizes,
                                      int[][] levelBucketStartIndices,
                                      int[][] levelBucketCurrentIndices,
                                      int maskSize,
                                      long mask,
                                      int level,
                                      int startIndex,
                                      int endIndex)
    {
        level--;
        
        int[] bucketSizes = levelBucketSizes[level];
        int[] bucketStartIndices = levelBucketStartIndices[level];
        int[] bucketCurrentIndices = levelBucketCurrentIndices[level];
        
        Arrays.fill(bucketSizes,
                    0,
                    bucketSizes.length,
                    0);
        
        int shiftSize = maskSize * level;
        
        //Initial pass to determine bucket sizes
        for(int indexCounter = startIndex;
            indexCounter <= endIndex;
            endIndex++)
        {
            int bucket = (int) ((array[indexCounter] >>> shiftSize) & mask);
            bucketSizes[bucket]++;
        }
        
        //Compute bucket indices
        for(int bucketCounter = 0,
            indexAccumulator = 0;
            bucketCounter < bucketStartIndices.length;
            bucketCounter++)
        {
            bucketCurrentIndices[bucketCounter] = indexAccumulator;
            bucketStartIndices[bucketCounter] = indexAccumulator;
            indexAccumulator += bucketStartIndices[bucketCounter];
        }
        
        //Complete each bucket
        for(int bucketCounter = 0;
            bucketCounter < bucketStartIndices.length;
            bucketCounter++)
        {
            if(bucketSizes[bucketCounter] == 0)
            {
                continue;
            }
            
            int bucketEndIndex = bucketStartIndices[bucketCounter] +
                                 bucketSizes[bucketCounter];
            
            //Make sure all the unbucketed elements in the bucket are put into
            //the appropriate bucket.
            for(int currentBucketIndex = bucketStartIndices[bucketCounter];
                currentBucketIndex < bucketEndIndex;
                currentBucketIndex++)
            {
                int bucket;
                long val = array[currentBucketIndex];
                
                while((bucket = (int) ((val >>> shiftSize) & mask)) !=
                      bucketCounter)
                {
                    long tempVal = val;
                    int currentSwapIndex = bucketCurrentIndices[bucket];
                    val = array[currentSwapIndex];
                    array[currentSwapIndex] = tempVal;
                    bucketCurrentIndices[bucket]++;
                }
                
                array[currentBucketIndex] = val;
                currentBucketIndex++;
            }
        }
        
        if(level == 0)
        {
            return;
        }
        
        for(int bucketCounter = 0;
            bucketCounter < bucketSizes.length;
            bucketCounter++)
        {
            int bucketSize = bucketSizes[bucketCounter];
            
            if(bucketSize == 0)
            {
                continue;
            }
            
            int bucketStartIndex = bucketStartIndices[bucketCounter];
            int bucketEndIndex = bucketStartIndex + bucketSize - 1;
            
            radixSortPow2(array,
                          levelBucketSizes,
                          levelBucketStartIndices,
                          levelBucketCurrentIndices,
                          maskSize,
                          mask,
                          level,
                          bucketStartIndex,
                          bucketEndIndex);
        }
    }
    
////////////////////////////////////////////////////////////////////////////////
    // Special Case Radix 2 Sort
////////////////////////////////////////////////////////////////////////////////
    
    public static void jumboRadix2Sort(JumboArrayLong array)
    {
        jumboRadix2Sort(array,
                        array.getIndexInterval().getStartInterval(),
                        array.getIndexInterval().getEndInterval(),
                        63,
                        CompareFactoryLong.getInstance());
    }

    public static void jumboRadix2SortU(JumboArrayLong array)
    {
        jumboRadix2Sort(array,
                        array.getIndexInterval().getStartInterval(),
                        array.getIndexInterval().getEndInterval(),
                        63,
                        CompareFactoryLongU.getInstance());
    }
    
    private static void jumboRadix2Sort(JumboArrayLong array,
                                        long startIndex,
                                        long endIndex,
                                        int bit,
                                        CompareFactoryLongInterface cfli)
    {
        if(endIndex - startIndex <= 15L)
        {
            bubbleSort(array,
                       startIndex,
                       endIndex);
            return;
        }
        
        long zeroIndex = startIndex;
        
        for(long index = startIndex;
            cfli.lte(index, endIndex);
            index++)
        {
            long val = array.get(index);
            
            if(!LongUtils.isBitSet(val, bit))
            {
                long tempVal = array.get(zeroIndex);
                array.set(zeroIndex, val);
                array.set(index, tempVal);
                zeroIndex++;
            }
            
            if(index == endIndex)
            {
                break;
            }
        }
        
        if(bit == 0)
        {
            return;
        }
        
        if(zeroIndex != startIndex)
        {
            jumboRadix2Sort(array,
                            startIndex,
                            zeroIndex - 1,
                            bit - 1,
                            cfli);
        }
        
        jumboRadix2Sort(array,
                        zeroIndex,
                        endIndex,
                        bit - 1,
                        cfli);
    }
}
