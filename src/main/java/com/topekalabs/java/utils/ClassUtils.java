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

import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.file.utils.IOFileFilterRegexName;
import java.io.File;
import java.util.Collection;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Topeka Labs
 */
public class ClassUtils
{
    private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class.getName());
    
    public static final Pattern ANONYMOUS_CLASS_NAME_REGEX = Pattern.compile("\\d+");
    public static final String CLASS_FILE_SUFFIX = ".class";
    public static final String CLASS_FILE_SUFFIX_REGEX = "\\.class";
    
    private ClassUtils()
    {
        //Do Nothing
    }
    
    public static boolean isFQClassName(String className)
    {
        return JavaLangUtils.isConventionalPackageName(className);
    }
    
    public static boolean isClassName(String className)
    {
        return JavaLangUtils.isIdentifier(className);
    }
    
    public static boolean isAnyClassName(String className)
    {
        return isClassName(className) || isFQClassName(className);
    }
    
    public static String getFQClassNamePackage(String className)
    {
        notFQClassNameException(className);
        
        int index = className.lastIndexOf(JavaLangUtils.PACKAGE_DELIMETER);
        String packageName = className.substring(0, index);
        return packageName;
    }
    
    public static String getFQClassNameName(String className)
    {
        notFQClassNameException(className);
        
        int index = className.lastIndexOf(JavaLangUtils.PACKAGE_DELIMETER);
        index++;
        return className.substring(index);
    }
    
    public static File getFQClassFile(File srcDirectory, String className)
    {
        return new File(getFQClassPackageDirectory(srcDirectory,
                                                   className),
                        getFQClassNameName(className) + CLASS_FILE_SUFFIX);
    }
    
    public static File getFQClassPackageDirectory(File srcDirectory,
                                                  String className)
    {
        ExceptionUtils.fileDoesNotExistException(srcDirectory);
        String packageName = getFQClassNamePackage(className);
        
        File file = new File(srcDirectory,
                             JavaLangUtils.convertPackageNameToPath(packageName));
        ExceptionUtils.fileDoesNotExistException(file);
        
        return file;
    }
    
    public static Collection<File> getFQClassAndInnerClassFiles(File srcDirectory,
                                                                String className)
    {
        notFQClassNameException(className);
        
        return FileUtils.listFiles(getFQClassPackageDirectory(srcDirectory,
                                                              className),
                                   new IOFileFilterRegexName(getFQClassNameName(className) +
                                                             ".*" + CLASS_FILE_SUFFIX_REGEX),
                                   null);
    }
    
    public static Collection<File> getClassFiles(File srcDirectory,
                                                 String className)
    {
        notClassNameException(className);
        
        return FileUtils.listFiles(srcDirectory,
                                   new IOFileFilterRegexName(Pattern.quote(className +
                                                                           CLASS_FILE_SUFFIX)),
                                   TrueFileFilter.INSTANCE);
    }
    
    public static Collection<File> getClassAndInnerClassFiles(File srcDirectory,
                                                              String className)
    {
        notClassNameException(className);
        
        return FileUtils.listFiles(srcDirectory,
                                   new IOFileFilterRegexName(Pattern.quote(className) +
                                                             "(\\$.+)?" +
                                                             CLASS_FILE_SUFFIX_REGEX),
                                   TrueFileFilter.INSTANCE);
    }
    
    public static void notClassNameException(String className)
    {
        ExceptionUtils.thisShouldNotHappen(!isClassName(className),
                                           "This is not a class name.");
    }
    
    public static void notFQClassNameException(String className)
    {
        ExceptionUtils.thisShouldNotHappen(!isFQClassName(className),
                                           "This is not a fully qualified class name.");
    }
}
