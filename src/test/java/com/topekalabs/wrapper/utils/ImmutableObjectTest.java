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
public class ImmutableObjectTest
{
    @Test
    public void testImmutalbeObjectGet()
    {
        ImmutableObject<Integer> a = new ImmutableObject<>(1);
        
        Assert.assertEquals("", a.getPayload(), (Integer) 1);
    }
    
    @Test
    public void testImmutableObjectEquals()
    {
        ImmutableObject<Integer> a = new ImmutableObject<>(1);
        ImmutableObject<Integer> b = new ImmutableObject<>(2);
        
        Assert.assertTrue("They should be equals", a.equals(a));
        Assert.assertFalse("They should not be equal", a.equals(b));
    }
}
