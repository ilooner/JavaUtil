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

import com.topekalabs.datastruct.CircularList;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 *
 * @author Topeka Labs
 */
public class CirclularListTest
{
    public static CircularList<Integer> circularList;
    
    @Rule
    public TestSetup testSetup = new TestSetup();
    
    private class TestSetup extends TestWatcher
    {
        @Override
        protected void starting(Description description)
        {
            List<Integer> list = new ArrayList<Integer>();
        
            list.add(1);
            list.add(2);
            list.add(3);
        
            circularList = new CircularList<Integer>(list);
        }
    }
    
    @Test
    public void stepSize1Test()
    {
        circularList.setStepSize(1);
        circularList.setCurrentIndex(0);
        
        int integer = circularList.next();
        Assert.assertEquals(1, integer);
        
        integer = circularList.next();
        Assert.assertEquals(2, integer);
        
        integer = circularList.next();
        Assert.assertEquals(3, integer);
        
        integer = circularList.next();
        Assert.assertEquals(1, integer);
    }
    
    @Test
    public void setpSize2Test()
    {
        circularList.setStepSize(2);
        circularList.setCurrentIndex(0);
        
        int integer = circularList.next();
        Assert.assertEquals(1, integer);
        
        integer = circularList.next();
        Assert.assertEquals(3, integer);
        
        integer = circularList.next();
        Assert.assertEquals(2, integer);
    }

    @Test
    public void setpSize1CurrentIndex1()
    {
        circularList.setStepSize(1);
        circularList.setCurrentIndex(1);
        
        int integer = circularList.next();
        Assert.assertEquals(2, integer);
        
        integer = circularList.next();
        Assert.assertEquals(3, integer);
        
        integer = circularList.next();
        Assert.assertEquals(1, integer);
    }
    
    @Test
    public void setpSize2CurrentIndex1()
    {
        circularList.setStepSize(2);
        circularList.setCurrentIndex(1);
        
        int integer = circularList.next();
        Assert.assertEquals(2, integer);
        
        integer = circularList.next();
        Assert.assertEquals(1, integer);
        
        integer = circularList.next();
        Assert.assertEquals(3, integer);
    }
}
