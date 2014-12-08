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

import com.topekalabs.math.utils.LongUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Topeka Labs
 */
public class JumboArrayAbstractTest
{
    private static final Logger logger = LoggerFactory.getLogger(JumboArrayAbstractTest.class.getName());
    
    public static long[] lengths = {359, 1560, 4430, 1350, 6293,
                                    3887, 1840, 1556, 1649, 2349,
                                    5*3*2};
    public static int[] listLengths = {83, 57, 11, 77, 26,
                                       63,  6, 10, 67, 93,
                                       3};
    public static int[] subArrayLengths = {40, 62, 16, 47, 53,
                                           57, 38, 93, 81, 9,
                                           2};
    
    @Test
    public void creation()
    {
        for(int counter = 0;
            counter < listLengths.length;
            counter++)
        {
            logger.debug("Test count: {}", counter);
            
            JumboArrayLong jArrayLong = new JumboArrayLong(lengths[counter],
                                                           listLengths[counter],
                                                           subArrayLengths[counter]);
            
            Assert.assertEquals(listLengths[counter],
                                jArrayLong.getListLength());
            
            Assert.assertEquals(subArrayLengths[counter],
                                jArrayLong.getSubArrayLength());
            
            Assert.assertEquals(lengths[counter],
                                jArrayLong.getLength());
            
            //TODO check these
            jArrayLong.getIndex2Count();
            
            jArrayLong = new JumboArrayLong(lengths[counter]);
            
            Assert.assertEquals(1,
                                jArrayLong.getIndex1Count());
            
            Assert.assertEquals(LongUtils.INTEGER_MAX,
                                jArrayLong.getListLength());
            
            Assert.assertEquals(LongUtils.INTEGER_MAX,
                                jArrayLong.getSubArrayLength());
            
            Assert.assertEquals(lengths[counter],
                                jArrayLong.getLength());
            
            //TODO check these
            jArrayLong.getIndex2Count();
        }
    }
    
    @Test
    public void outOfBounds()
    {
        for(int counter = 0;
            counter < listLengths.length;
            counter++)
        {
            JumboArrayLong jArrayLong = new JumboArrayLong(lengths[counter],
                                                           listLengths[counter],
                                                           subArrayLengths[counter]);
            
            logger.debug("counter {}", counter);
            
            jArrayLong.get(lengths[counter] - 1);
            boolean arrayOutOfBounds = false;
            
            try
            {
                jArrayLong.get(lengths[counter]);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                arrayOutOfBounds = true;
            }
            catch(IndexOutOfBoundsException e)
            {
                arrayOutOfBounds = true;
            }
            
            Assert.assertEquals(true, arrayOutOfBounds);
        }
    }
    
    @Test
    public void setGet()
    {
        for(int counter = 0;
            counter < listLengths.length;
            counter++)
        {
            JumboArrayLong jArrayLong = new JumboArrayLong(lengths[counter],
                                            listLengths[counter],
                                            subArrayLengths[counter]);
            
            for(long index = 0;
                index < lengths[counter];
                index++)
            {
                jArrayLong.set(index, index);
                
                Assert.assertEquals(index, jArrayLong.get(index));
            }
        }
    }
}
