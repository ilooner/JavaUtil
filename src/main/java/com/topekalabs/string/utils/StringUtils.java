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

import com.google.common.collect.Lists;
import com.topekalabs.collection.utils.CollectionUtils;
import com.topekalabs.math.utils.IntUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Topeka Labs
 */
public class StringUtils
{
    public static final String COMMA_SEPERATOR = ", ";
    
    private StringUtils()
    {
    }
    
    public static void clear(StringBuilder sb)
    {
        sb.delete(0, sb.length());
    }
    
    public static void appendToAll(String suffix, String... strings)
    {
        StringBuilder sb = new StringBuilder();
        
        for(int stringCounter = 0;
            stringCounter < strings.length;
            stringCounter++)
        {
            sb.append(strings[stringCounter]);
            sb.append(suffix);
            
            strings[stringCounter] = sb.toString();
            clear(sb);
        }
    }
    
    public static String[] appendToAllIm(String suffix, String... strings)
    {
        String[] newStrings = new String[strings.length];
        StringBuilder sb = new StringBuilder();
        
        for(int stringCounter = 0;
            stringCounter < strings.length;
            stringCounter++)
        {
            sb.append(strings[stringCounter]);
            sb.append(suffix);
            
            newStrings[stringCounter] = sb.toString();
            clear(sb);
        }
        
        return newStrings;
    }
    
    public static void appendToAll(String suffix, List<String> strings)
    {
        StringBuilder sb = new StringBuilder();
        
        for(int stringCounter = 0;
            stringCounter < strings.size();
            stringCounter++)
        {
            sb.append(strings.get(stringCounter));
            sb.append(suffix);
            
            strings.set(stringCounter, sb.toString());
            clear(sb);
        }
    }
    
    public static List<String> appendToAllIm(String suffix, List<String> strings)
    {
        List<String> newStrings = new ArrayList<>(strings.size());
        StringBuilder sb = new StringBuilder();
        
        for(int stringCounter = 0;
            stringCounter < strings.size();
            stringCounter++)
        {
            sb.append(strings.get(stringCounter));
            sb.append(suffix);
            
            newStrings.add(sb.toString());
            clear(sb);
        }
        
        return newStrings;
    }
    
    public static String toCommaSeperatedString(String... strings)
    {
        return toSeperatedString(COMMA_SEPERATOR, strings);
    }
    
    public static String toCommaSeperatedString(List<String> strings)
    {
        return toSeperatedString(COMMA_SEPERATOR, strings);
    }
    
    public static String toSeperatedString(String seperator, String... strings)
    {
        return toSeperatedString(seperator, Arrays.asList(strings));
    }
    
    public static String toSeperatedString(String seperator, Collection<String> strings)
    {
        CollectionUtils.isNotPopulatedException(strings, "strings");
        
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = strings.iterator();
        
        for(int counter = 0;
            counter < strings.size() - 1;
            counter++)
        {
            sb.append(iterator.next());
            sb.append(seperator);
        }
        
        sb.append(iterator.next());
        
        return sb.toString();
    }
    
    public static List<Integer> subStringIndices(String parentString,
                                                 String substring)
    {
        List<Integer> indices = Lists.newArrayList();
        
        for(int nextIndex = 0;
            (nextIndex = parentString.indexOf(substring, nextIndex)) >= 0;
            nextIndex++)
        {
            indices.add(nextIndex);
        }
        
        return indices;
    }
    
    public static boolean subStringAtIndex(String parentString,
                                           String substring,
                                           int index)
    {
        IntUtils.isGTEException(parentString.length(),
                                substring.length(),
                                "parentString",
                                "substring");
        IntUtils.isGTEException(parentString.length() - 1,
                                index + substring.length() - 1,
                                "last index of parent string",
                                "last index of substring");
        
        String pSubString = parentString.substring(index,
                                                   index + substring.length());
        
        return pSubString.equals(substring);
    }
}
