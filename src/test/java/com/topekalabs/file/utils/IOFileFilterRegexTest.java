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
package com.topekalabs.file.utils;

import java.io.File;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Topeka Labs
 */
public class IOFileFilterRegexTest
{
    @Test
    public void testAcceptAll()
    {
        IOFileFilterRegexName ff = new IOFileFilterRegexName(".*");
        
        String testName = "aa";
        File testFile = new File(testName);
        
        Assert.assertTrue("Filter should accept everything.",
                          ff.accept(testFile));
        
        Assert.assertTrue("Filter should accept everything.",
                          ff.accept(testFile, testName));
    }
    
    @Test
    public void testRegex()
    {
        IOFileFilterRegexName ff = new IOFileFilterRegexName("bb");
        
        String testName = "bb";
        String testNameFail = "aa";
        File testFile = new File(testName);
        File testFileFail = new File(testNameFail);
        
        Assert.assertTrue("Filter should accept " + testName + " only.",
                          ff.accept(testFile));
        
        Assert.assertTrue("Filter should accept " + testName + " only.",
                          ff.accept(testFile, testName));
        
        Assert.assertFalse("Filter not accept " + testNameFail,
                           ff.accept(testFileFail));
        
        Assert.assertFalse("Filter not accept " + testNameFail,
                           ff.accept(testFileFail, testNameFail));
    }
}
