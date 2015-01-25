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
package com.topekalabs.error.utils;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Topeka Labs
 */
public class ErrorLoaderTest
{
    private static final Logger logger = LoggerFactory.getLogger(ErrorLoaderTest.class.getName());
    
    @Test
    public void testThrowJavaUtilError()
    {
        boolean thrown = false;
        
        try
        {
            ExceptionUtils.ERROR_THROWER.throwUnrecoverableError("MISC_ERROR_KILL_THREAD");
        }
        catch(UnrecoverableError e)
        {
            thrown = true;
            Assert.assertEquals("Error code is not correct.", 0, e.getError().getErrorCode().getErrorCode());
        }
        
        Assert.assertEquals("No error thrown", true, thrown);
    }
}
