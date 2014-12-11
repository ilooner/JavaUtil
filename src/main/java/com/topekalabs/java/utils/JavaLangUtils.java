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
import java.io.File;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Topeka Labs
 */
public class JavaLangUtils
{
    private static final Logger logger = LoggerFactory.getLogger(JavaLangUtils.class.getName());
    
    public static final String PACKAGE_DELIMETER = ".";
    public static final String PACKAGE_DELIMETER_REGEX = Pattern.quote(PACKAGE_DELIMETER);
    public static final String INNER_CLASS_DELIMETER = "$";
    
    private JavaLangUtils()
    {
        //Do Nothing
    }
    
    public static String convertPackageNameToPath(String packageName)
    {
        ExceptionUtils.thisShouldNotHappen(!isConventionalPackageName(packageName),
                                           packageName);
        
        return packageName.replaceAll(PACKAGE_DELIMETER_REGEX, File.separator);
    }
    
    public static boolean isConventionalPackageName(String packageName)
    {
        if(packageName.isEmpty())
        {
            return false;
        }
        
        if(packageName.startsWith(PACKAGE_DELIMETER))
        {
            return false;
        }
        
        if(packageName.endsWith(PACKAGE_DELIMETER))
        {
            return false;
        }
        
        String[] packageParts = packageName.split(PACKAGE_DELIMETER_REGEX);
        
        logger.debug("package name {} has package parts length {}",
                     packageName,
                     packageParts.length);
        
        if(packageParts.length == 1)
        {
            return false;
        }
        
        for(String packagePart: packageParts)
        {
            if(!isIdentifier(packagePart))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isIdentifier(String identifier)
    {
        ExceptionUtils.isNullException(identifier, "identifier");
        
        if(identifier.isEmpty())
        {
            return false;
        }
        
        if(!Character.isJavaIdentifierStart(identifier.charAt(0)))
        {
            return false;
        }
        
        for(int charIndex = 1;
            charIndex < identifier.length();
            charIndex++)
        {
            if(!Character.isJavaIdentifierPart(identifier.charAt(charIndex)))
            {
                return false;
            }
        }
        
        return true;
    }
}
