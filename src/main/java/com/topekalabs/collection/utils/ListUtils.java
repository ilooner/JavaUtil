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
package com.topekalabs.collection.utils;

import com.google.common.collect.Sets;
import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.wrapper.utils.ReferenceWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Topeka Labs
 */
public class ListUtils
{
    public static <T> void listContainsDuplicateReferencesException(List<T> list)
    {
        Set<ReferenceWrapper<T>> elementSet = Sets.newHashSet();
        
        for(T element: list)
        {
            elementSet.add(new ReferenceWrapper<>(element));
        }
        
        if(elementSet.size() != list.size())
        {
            throw new IllegalArgumentException("The given list contains duplicate references.");
        }
    }
    
    public static <T> void listContainsDuplicateReferencesException(List<T> list,
                                                                    String listName)
    {
        Set<ReferenceWrapper<T>> elementSet = Sets.newHashSet();
        
        for(T element: list)
        {
            elementSet.add(new ReferenceWrapper<>(element));
        }
        
        if(elementSet.size() != list.size())
        {
            throw new IllegalArgumentException("The given list " +
                                               listName + 
                                               " contains duplicate references.");
        }
    }
    
    public static <T> Collection<T> listToCollection(List<T> list)
    {
        return new ArrayList<>(list);
    }
    
    public static <T> void listEmptyUnsupportedException(List<T> list)
    {
        ExceptionUtils.unsupported(list.isEmpty(),
                                   "The given list cannot be empty.");
    }
    
    public static <T> void listEmptyUnsupportedException(List<T> list,
                                                         String name)
    {
        ExceptionUtils.unsupported(list.isEmpty(),
                                   "The given list " + name + " cannot be empty.");
    }
    
    public static <T> void listEmptyIllegalArgException(List<T> list)
    {
        ExceptionUtils.illegal(list.isEmpty(),
                               "The given list cannot be empty.");
    }
    
    public static <T> void listEmptyIllegalArgException(List<T> list,
                                                         String name)
    {
        ExceptionUtils.illegal(list.isEmpty(),
                               "The given list " + name + " cannot be empty.");
    }
    
    public static <T> void removeLast(List<T> list)
    {
        ListUtils.listEmptyUnsupportedException(list, "list");
        list.remove(list.size() - 1);
    }
}
