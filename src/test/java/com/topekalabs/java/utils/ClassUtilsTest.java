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

import com.topekalabs.error.utils.ErrorThrower;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author Topeka Labs
 */
public class ClassUtilsTest
{
    public static final String PACKAGE1 = "com/topekalabs/package1";
    public static final String PACKAGE1_DOT = "com.topekalabs.package1";
    public static final String PACKAGE1_CLASS1 = "TestClass1";
    public static final String PACKAGE1_FQ_CLASS1 = "com.topekalabs.package1.TestClass1";
    public static final String PACKAGE1_CLASS2 = "TestClass2";
    public static final String PACKAGE1_FQ_CLASS2 = "com.topekalabs.package1.TestClass2";
    public static final String PACKAGE2 = "com/topekalabs/package2";
    public static final String PACKAGE2_DOT = "com.topekalabs.package2";
    public static final String PACKAGE2_CLASS1 = "TestClass3";
    public static final String PACKAGE2_FQ_CLASS1 = "com.topekalabs.package2.TestClass3";
    public static final String PACKAGE2_CLASS2 = "TestClass4";
    public static final String PACKAGE2_FQ_CLASS2 = "com.topekalabs.package2.TestClass4";
    
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();
    
    @Test
    public void testIsFQClassName()
    {
        Assert.assertEquals("Must be a fully qualified class name",
                            true,
                            ClassUtils.isFQClassName(PACKAGE1_FQ_CLASS1));
        
        Assert.assertEquals("Is not a fully qualified class name",
                            false,
                            ClassUtils.isFQClassName(PACKAGE1_CLASS1));
    }
    
    private void createTestStructure(File rootDir)
    {
        //Create package 1 and classes
        File package1 = new File(rootDir, PACKAGE1);
        package1.mkdirs();
        
        try
        {
            File class1 = new File(package1, PACKAGE1_CLASS1 + ClassUtils.CLASS_FILE_SUFFIX);
            class1.createNewFile();
            File class2 = new File(package1, PACKAGE1_CLASS2 + ClassUtils.CLASS_FILE_SUFFIX);
            class2.createNewFile();
        }
        catch(IOException ex)
        {
            ErrorThrower.rethrowUnrecoverable(ex);
        }
        
        //Create package 2 and classes
        File package2 = new File(rootDir, PACKAGE2);
        package2.mkdirs();
        
        try
        {
            File class3 = new File(package2, PACKAGE2_CLASS1 + ClassUtils.CLASS_FILE_SUFFIX);
            class3.createNewFile();
            File class4 = new File(package2, PACKAGE2_CLASS2 + ClassUtils.CLASS_FILE_SUFFIX);
            class4.createNewFile();
        }
        catch(IOException ex)
        {
            ErrorThrower.rethrowUnrecoverable(ex);
        }
    }
}
