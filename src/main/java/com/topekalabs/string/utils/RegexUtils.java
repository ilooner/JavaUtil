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
package com.topekalabs.string.utils;

import com.topekalabs.error.utils.ExceptionUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Topeka Labs
 */
public class RegexUtils
{
    public static final String FILE_PATH_SEPERATOR_CHARACTER_CLASS = "[\\\\/]";
    public static final String FILE_PATH_SEPERATOR_NOT_CHARACTER_CLASS = "[^\\\\/]";
    
    private RegexUtils()
    {
        //Do nothing
    }
    
    public static boolean matches(String regex, String string)
    {
        ExceptionUtils.isNullException(regex, "regex");
        ExceptionUtils.isNullException(regex, "string");
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        
        return matcher.matches();
    }
    
    public static boolean matches(Pattern pattern,
                                  String string)
    {
        return pattern.matcher(string).matches();
    }
    
    public static String getGroup(Pattern pattern,
                                  int group,
                                  String string)
    {
        Matcher matcher = pattern.matcher(string);
        
        if(!matcher.matches())
        {
            throw new IllegalArgumentException("The given string must match the given pattern.");
        }
        
        return matcher.group(group);
    }
}
