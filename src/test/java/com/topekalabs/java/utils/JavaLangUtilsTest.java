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

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Topeka Labs
 */
public class JavaLangUtilsTest
{
    @Test
    public void testIsIdentifier()
    {
        Assert.assertEquals(true,
                            JavaLangUtils.isIdentifier("MyTestClass"));
        
        Assert.assertEquals(true,
                            JavaLangUtils.isIdentifier("My$Test"));
        
        Assert.assertEquals(false,
                            JavaLangUtils.isIdentifier("com.topekalabs.test.MyTestClass"));
    }
    
    @Test
    public void testConvertPackageNameToPath()
    {
        Assert.assertEquals(ClassUtilsTest.PACKAGE1,
                            JavaLangUtils.convertPackageNameToPath(ClassUtilsTest.PACKAGE1_DOT));
    }
    
    @Test
    public void testIsConventionalPackageName()
    {
        Assert.assertEquals("Empty package name should return false",
                            false,
                            JavaLangUtils.isConventionalPackageName(""));
        
        Assert.assertEquals("Packages starting with package delimeter should return false",
                            false,
                            JavaLangUtils.isConventionalPackageName(JavaLangUtils.PACKAGE_DELIMETER + "a"));
        
        Assert.assertEquals("Packages ending with package delimeter should return false",
                            false,
                            JavaLangUtils.isConventionalPackageName("a" + JavaLangUtils.PACKAGE_DELIMETER));
        
        Assert.assertEquals("Packages names should return true",
                            true,
                            JavaLangUtils.isConventionalPackageName(ClassUtilsTest.PACKAGE1_DOT));
        
        Assert.assertEquals("Class names should return false",
                            false,
                            JavaLangUtils.isConventionalPackageName(ClassUtilsTest.PACKAGE1_CLASS1));
    }
}
