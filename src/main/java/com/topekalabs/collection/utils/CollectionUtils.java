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

/**
 * This class has utility methods for dealing with collections.
 * @author Topeka Labs
 */
public final class CollectionUtils
{
    private CollectionUtils()
    {
        //Do nothing
    }
    
    /**
     * This method throws an IllegalArgumentException if the given collection
     * is empty.
     * @param collection The collection to check.
     */
    public static void isEmptyException(Collection collection)
    {
        if(collection.isEmpty())
        {
            throw new IllegalArgumentException("The given collection cannot be empty.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given collection is
     * empty. The name of the collection is included in the exception message.
     * @param collection The collection to check.
     * @param collectionName The name of the collection.
     */
    public static void isEmptyException(Collection collection,
                                        String collectionName)
    {
        if(collection.isEmpty())
        {
            throw new IllegalArgumentException("The given collection " + collectionName + " cannot be empty.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given collection is
     * empty, and a NullPointerException if any of the elements are null.
     * @param collection The collection to check.
     */
    public static void isPopulatedException(Collection collection)
    {
        isEmptyException(collection);
        
        for(Object object: collection)
        {
            ExceptionUtils.isNullException(object);
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given collection is
     * empty, and a NullPointerException if any of the elements are null. The
     * name of the collection is included in the exception messages.
     * @param collection The collection to check.
     * @param collectionName The name of the collection.
     */
    public static void isPopulatedException(Collection collection,
                                            String collectionName)
    {
        isEmptyException(collection, collectionName);
        
        for(Object object: collection)
        {
            ExceptionUtils.isNullException(object, "object in " + collectionName);
        }
    }
}
