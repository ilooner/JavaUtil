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

import com.topekalabs.java.utils.ExceptionUtils;
import java.util.Collection;

public final class CollectionUtils
{
    private CollectionUtils()
    {
    }
    
    public static void isEmpty(Collection collection)
    {
        if(collection.isEmpty())
        {
            throw new IllegalArgumentException("The given collection cannot be empty.");
        }
    }
    
    public static void isEmpty(Collection collection, String collectionName)
    {
        if(collection.isEmpty())
        {
            throw new IllegalArgumentException("The given collection " + collectionName + " cannot be empty.");
        }
    }
    
    public static void isPopulated(Collection collection)
    {
        isEmpty(collection);
        
        for(Object object: collection)
        {
            ExceptionUtils.isNull(object);
        }
    }
    
    public static void isPopulated(Collection collection,
                                   String collectionName)
    {
        isEmpty(collection, collectionName);
        
        for(Object object: collection)
        {
            ExceptionUtils.isNull(object, "object in " + collectionName);
        }
    }
}
