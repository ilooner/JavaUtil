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

import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.utils.IntUtils;
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
    
    public static void isNotEmptyException(Collection collection)
    {
        if(!collection.isEmpty())
        {
            throw new IllegalArgumentException("The given collection cannot be non-empty.");
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
            throw new IllegalArgumentException("The given collection " +
                                               collectionName +
                                               " cannot be empty.");
        }
    }

    public static void isNotEmptyException(Collection collection,
                                            String collectionName)
    {
        if(!collection.isEmpty())
        {
            throw new IllegalArgumentException("The given collection " +
                                               collectionName +
                                               " cannot be non-empty.");
        }
    }
    
    /**
     * This method throws an IllegalArgumentException if the given collection is
     * empty, and a NullPointerException if any of the elements are null.
     * @param collection The collection to check.
     */
    public static void isNotPopulatedException(Collection collection)
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
    public static void isNotPopulatedException(Collection collection,
                                            String collectionName)
    {
        isEmptyException(collection, collectionName);
        
        for(Object object: collection)
        {
            ExceptionUtils.isNullException(object, "object in " + collectionName);
        }
    }
    
    public static int sizeM1(Collection<?> collection)
    {
        isEmptyException(collection);
        return collection.size() - 1;
    }
    
    public static void isNotSize1Exception(Collection collection,
                                           String collectionName)
    {
        if(collection.size() != 1)
        {
            throw new IllegalArgumentException("The size of " + collectionName +
                                               " is " + collection.size() +
                                               " when it should be 1");
        }
    }
    
    public static void isNotSize1Exception(Collection collection)
    {
        isNotSize1Exception(collection,
                            "the collection");
    }
    
    public static <T> T getSingleElement(Collection<T> collection)
    {
        isEmptyException(collection);
        return collection.iterator().next();
    }
    
    public static <T> T getElementFromSize1(Collection<T> collection)
    {
        isNotSize1Exception(collection);
        return getSingleElement(collection);
    }
    
    public static <DT, CT extends Collection<DT>> CT fillEmptyCollection(CT collection,
                                                                         DT fillerObject,
                                                                         int size)
    {
        CollectionUtils.isNotEmptyException(collection, "collection");
        IntUtils.isNonPositiveException(size);
        
        for(int counter = 0;
            counter < size;
            counter++)
        {
            collection.add(fillerObject);
        }
        
        return collection;
    }
}
