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

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.topekalabs.error.utils.CodingError;
import com.topekalabs.error.utils.ErrorThrower;
import com.topekalabs.file.utils.IOFileFilterRegexName;
import com.topekalabs.string.utils.StringUtils;
import com.topekalabs.testutils.FileTestWatcher;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Topeka Labs
 */
public class ClassUtilsTest
{
    private static final Logger logger = LoggerFactory.getLogger(ClassUtilsTest.class.getName());
    
    public static final String PACKAGE1 = "com/topekalabs/package1";
    public static final String PACKAGE1_DOT = "com.topekalabs.package1";
    public static final String PACKAGE1_CLASS1 = "TestClass1";
    public static final String PACKAGE1_CLASS1_INNER1 = "TestClass1$Inner1";
    public static final String PACKAGE1_CLASS1_INNER2 = "TestClass1$Inner2";
    public static final String[] PACKAGE1_CLASS1S = {PACKAGE1_CLASS1,
                                                     PACKAGE1_CLASS1_INNER1,
                                                     PACKAGE1_CLASS1_INNER2};
    public static final String PACKAGE1_FQ_CLASS1 = "com.topekalabs.package1.TestClass1";
    public static final String PACKAGE1_CLASS2 = "TestClass2";
    public static final String PACKAGE1_CLASS2_INNER1 = "TestClass2$Inner1";
    public static final String PACKAGE1_CLASS2_INNER2 = "TestClass2$Inner2";
    public static final String[] PACKAGE1_CLASS2S = {PACKAGE1_CLASS2,
                                                     PACKAGE1_CLASS2_INNER1,
                                                     PACKAGE1_CLASS2_INNER2};
    public static final String[] PACKAGE1_CLASSES = {PACKAGE1_CLASS1,
                                                     PACKAGE1_CLASS1_INNER1,
                                                     PACKAGE1_CLASS1_INNER2,
                                                     PACKAGE1_CLASS2,
                                                     PACKAGE1_CLASS2_INNER1,
                                                     PACKAGE1_CLASS2_INNER2};
    public static final String PACKAGE1_FQ_CLASS2 = "com.topekalabs.package1.TestClass2";
    public static final String PACKAGE2 = "com/topekalabs/package2";
    public static final String PACKAGE2_DOT = "com.topekalabs.package2";
    public static final String PACKAGE2_CLASS1 = "TestClass3";
    public static final String PACKAGE2_CLASS1_INNER1 = "TestClass3$Inner1";
    public static final String PACKAGE2_CLASS1_INNER2 = "TestClass3$Inner2";
    public static final String[] PACKAGE2_CLASS1S = {PACKAGE2_CLASS1,
                                                     PACKAGE2_CLASS1_INNER1,
                                                     PACKAGE2_CLASS1_INNER2};
    public static final String PACKAGE2_FQ_CLASS1 = "com.topekalabs.package2.TestClass3";
    public static final String PACKAGE2_CLASS2 = "TestClass1";
    public static final String PACKAGE2_CLASS2_INNER1 = "TestClass1$Inner1";
    public static final String PACKAGE2_CLASS2_INNER2 = "TestClass1$Inner2";
    public static final String[] PACKAGE2_CLASS2S = {PACKAGE2_CLASS2,
                                                     PACKAGE2_CLASS2_INNER1,
                                                     PACKAGE2_CLASS2_INNER2};
    public static final String PACKAGE2_FQ_CLASS2 = "com.topekalabs.package2.TestClass1";
    public static final String[] PACKAGE2_CLASSES = {PACKAGE2_CLASS1,
                                                     PACKAGE2_CLASS1_INNER1,
                                                     PACKAGE2_CLASS1_INNER2,
                                                     PACKAGE2_CLASS2,
                                                     PACKAGE2_CLASS2_INNER1,
                                                     PACKAGE2_CLASS2_INNER2};
    
    public static final String[] PACKAGES = {PACKAGE1,
                                             PACKAGE2};
    public static final String[][] PACKAGE_CLASSES = {PACKAGE1_CLASSES,
                                                      PACKAGE2_CLASSES};
    
    @Rule
    public FileTestWatcher watcher = new FileTestWatcher(false);
    
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
    
    @Test
    public void testIsClassName()
    {
        Assert.assertEquals("Must be a non fully qualified class name",
                            false,
                            ClassUtils.isClassName(PACKAGE1_FQ_CLASS1));
        
        Assert.assertEquals("Is not a non fully qualified class name",
                            true,
                            ClassUtils.isClassName(PACKAGE1_CLASS1));
    }
    
    @Test
    public void testIsAnyClassName()
    {
        Assert.assertEquals(true,
                            ClassUtils.isAnyClassName(PACKAGE1_FQ_CLASS1));
        
        Assert.assertEquals(true,
                            ClassUtils.isAnyClassName(PACKAGE1_CLASS1));
        
        Assert.assertEquals(false,
                            ClassUtils.isAnyClassName("-"));
    }
    
    @Test
    public void testGetFQClassNamePackage()
    {
        Assert.assertEquals("The package of the fully qualified class name " +
                            "was not correctly extracted.",
                            PACKAGE1_DOT,
                            ClassUtils.getFQClassNamePackage(PACKAGE1_FQ_CLASS1));
        
        boolean codingError = false;
        
        try
        {
            ClassUtils.getFQClassNamePackage(PACKAGE1_CLASS1);
        }
        catch(CodingError ex)
        {
            codingError = true;
        }
        
        Assert.assertTrue("A coding error should be thrown " +
                          "when the given string is not a " +
                          "fully qualified class name.",
                          codingError);
    }
    
    public void testGetFQClassNameName(String className)
    {
        Assert.assertEquals("The class name of the fully qualified class name " +
                            "was not correctly extracted.",
                            PACKAGE1_CLASS1,
                            ClassUtils.getFQClassNameName(PACKAGE1_FQ_CLASS1));
        
        boolean codingError = false;
        
        try
        {
            ClassUtils.getFQClassNameName(PACKAGE1_CLASS1);
        }
        catch(CodingError ex)
        {
            codingError = true;
        }
        
        Assert.assertTrue("A coding error should be thrown " +
                          "when the given string is not a " +
                          "fully qualified class name.",
                          codingError);
    }
    
    @Test
    public void testGetFQClassPackageDirectory()
    {
        File srcDir = watcher.getTempDir();
        createTestStructure(srcDir);
        
        File packageDir = ClassUtils.getFQClassPackageDirectory(srcDir,
                                                                PACKAGE1_FQ_CLASS1);
        
        Assert.assertTrue("Check the directory exists",
                          packageDir.exists());
        
        Assert.assertTrue("Checking file path",
                          packageDir.getAbsolutePath().endsWith(PACKAGE1));
    }
    
    @Test
    public void testGetFQClassFile()
    {
        File srcDir = watcher.getTempDir();
        createTestStructure(srcDir);
        
        File fqClassFile = ClassUtils.getFQClassFile(srcDir, PACKAGE1_FQ_CLASS1);
        
        Assert.assertTrue("Check that the class file exists",
                          fqClassFile.exists());
        
        Assert.assertTrue("Checking class file path",
                          fqClassFile.getAbsolutePath().endsWith(
                          PACKAGE1_FQ_CLASS1.replaceAll(JavaLangUtils.PACKAGE_DELIMETER_REGEX,
                                                        File.separator) +
                          ClassUtils.CLASS_FILE_SUFFIX));
    }
    
    @Test
    public void testGetFQClassAndInnerClassFiles()
    {
        File srcDir = watcher.getTempDir();
        createTestStructure(srcDir);
        
        Collection<File> classFiles = ClassUtils.getFQClassAndInnerClassFiles(srcDir,
                                                                              PACKAGE1_FQ_CLASS1);
        
        Assert.assertEquals("The number of class files found is incorrect",
                            PACKAGE1_CLASS1S.length,
                            classFiles.size());
        
        Set<String> correctClassNames = Sets.newHashSet(
                                        StringUtils.appendToAllIm(ClassUtils.CLASS_FILE_SUFFIX,
                                                                  PACKAGE1_CLASS1S));
        logger.debug("The following classes should be found: {}",
                     StringUtils.toCommaSeperatedString(PACKAGE1_CLASS1S));
        
        for(File classFile: classFiles)
        {
            Assert.assertTrue(classFile.getName() + " is not a correct class",
                              correctClassNames.contains(classFile.getName()));
        }
    }
    
    @Test
    public void testGetClassFiles()
    {
        File srcDir = watcher.getTempDir();
        createTestStructure(srcDir);
        
        Collection<File> classFiles = ClassUtils.getClassFiles(srcDir,
                                                               PACKAGE1_CLASS1);
        
        Assert.assertEquals("The number of class files found is incorrect",
                            2,
                            classFiles.size());
    }
    
    @Test
    public void testGetClassAndInnerClassFiles()
    {
        File srcDir = watcher.getTempDir();
        createTestStructure(srcDir);
        
        Collection<File> classFiles = ClassUtils.getClassAndInnerClassFiles(srcDir,
                                                                            PACKAGE1_CLASS1);
        
        List<String> correctPackage1ClassNames = Lists.newArrayList(PACKAGE1_CLASS1S);
        List<String> correctPackage2ClassNames = Lists.newArrayList(PACKAGE2_CLASS1S);
        
        List<String> correctClassNamesList = Lists.newArrayList();
        correctClassNamesList.addAll(StringUtils.appendToAllIm(ClassUtils.CLASS_FILE_SUFFIX,
                                                               correctPackage1ClassNames));
        correctClassNamesList.addAll(StringUtils.appendToAllIm(ClassUtils.CLASS_FILE_SUFFIX,
                                                               correctPackage2ClassNames));
        
        Set<String> correctClassNames = Sets.newHashSet();
        correctClassNames.addAll(correctClassNamesList);
        
        Assert.assertEquals("The number of class files found is incorrect",
                            6,
                            classFiles.size());
        
        logger.debug("The following classes should be found: {}",
                     StringUtils.toCommaSeperatedString(correctClassNamesList));
        
        for(File classFile: classFiles)
        {
            Assert.assertTrue(classFile.getName() + " is not a correct class",
                              correctClassNames.contains(classFile.getName()));
        }
    }
    
    private void createTestStructure(File rootDir)
    {
        for(int packageCounter = 0;
            packageCounter < PACKAGES.length;
            packageCounter++)
        {
            File packageDir = new File(rootDir,
                                       PACKAGES[packageCounter]);
            packageDir.mkdirs();
            
            String[] classNames = PACKAGE_CLASSES[packageCounter];
            
            for(int classCounter = 0;
                classCounter < classNames.length;
                classCounter++)
            {
                File classFile = new File(packageDir,
                                          classNames[classCounter] +
                                          ClassUtils.CLASS_FILE_SUFFIX);
                
                IOFileFilterRegexName ff = new IOFileFilterRegexName(PACKAGE1_CLASS1 +
                                                             ".*" + ClassUtils.CLASS_FILE_SUFFIX_REGEX);
                        
                try
                {
                    classFile.createNewFile();
                }
                catch(IOException ex)
                {
                    ErrorThrower.kill(ex);
                }
            }
        }
    }
}
