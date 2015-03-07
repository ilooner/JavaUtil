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
package com.topekalabs.fsm.moore;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Topeka Labs
 */
public class StateInputVectorTest
{
    @Test
    public void testGetter()
    {
        StateInputVector<Integer, Integer> a =
        new StateInputVector<Integer, Integer>(new State<Integer>(1), 1);
       
        Assert.assertEquals("States should be equal.",
                            a.getState(),
                            new State<Integer>(1));
        
        Assert.assertEquals("Inputs should be equal.",
                            a.getMappedInput(),
                            (Integer) 1);
    }
    
    @Test
    public void testEquals()
    {
        StateInputVector<Integer, Integer> a =
        new StateInputVector<Integer, Integer>(new State<Integer>(1), 1);
        
        StateInputVector<Integer, Integer> b =
        new StateInputVector<Integer, Integer>(new State<Integer>(2), 2);
        
        Assert.assertTrue("They should be equal.", a.equals(a));
        Assert.assertFalse("They should not be equal.", a.equals(b));
    }
}
