/*
 * Copyright 2015 Topeka Labs.
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
package com.topekalabs.wrapper.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Topeka Labs
 */
public class PriorityObjectTest
{
    @Test
    public void testGetters()
    {
        PriorityObject<Integer> priority = new PriorityObject<Integer>(1,
                                                                       1);
        
        Assert.assertEquals("Correct object was not set",
                            new Integer(1),
                            priority.getObject());
        
        Assert.assertEquals("Correct priority was not set",
                            1L,
                            priority.getPriority());
    }
    
    @Test
    public void testEquals()
    {
        PriorityObject<Integer> a = new PriorityObject<>(1,
                                                         1);
        PriorityObject<Integer> b = new PriorityObject<>(2,
                                                         1);
        PriorityObject<Integer> c = new PriorityObject<>(1,
                                                         2);
        
        Assert.assertTrue("a should equal a.", a.equals(a));
        Assert.assertFalse("a should not equal b.", a.equals(b));
        Assert.assertFalse("a should not equal c.", a.equals(c));
    }
}
