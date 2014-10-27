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
package com.topekalabs.config.utils;

import com.topekalabs.java.utils.ExceptionUtils;
import com.topekalabs.java.utils.RegexUtils;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Topeka Labs
 */
public class PropertyLoader
{
    public static final String PROPERTIES_FILE_NAME_PATTERN = "^.+\\.properties$";
    
    private PropertyLoader()
    {
    }
    
    public static Properties loadPropertiesFromJar(String fileName)
    {
        ExceptionUtils.thisShouldNotHappen(!RegexUtils.match(PROPERTIES_FILE_NAME_PATTERN, fileName),
                                           "The given file name does not satisfy the property file name format.");
        
        InputStream propertyStream = PropertyLoader.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(propertyStream);
        
        while(scanner.hasNextLine())
        {
            
        }
        
        return null;
    }
}
