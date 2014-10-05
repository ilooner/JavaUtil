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

import java.util.Collection;

public final class ExceptionUtils
{
    private ExceptionUtils()
    {
    }
    
    public static void isNull(Object object)
    {
        if(object == null)
        {
            throw new NullPointerException("The given object cannot be null.");
        }
    }
    
    public static void isNull(Object object, String objectName)
    {
        if(object == null)
        {
            throw new NullPointerException("The give object " + objectName + " cannot be null.");
        }
    }
    
    public static void arrayIsEmpty(Object[] objects)
    {
        if(objects.length == 0)
        {
            throw new IllegalArgumentException("The given array cannot be empty.");
        }
    }
    
    public static void arrayIsEmpty(Object[] objects, String objectsName)
    {
        if(objects.length == 0)
        {
            throw new IllegalArgumentException("The given " + objectsName + " cannot be empty.");
        }
    }
    
    public static void collectionIsEmpty(Collection objects)
    {
        if(objects.isEmpty())
        {
            throw new IllegalArgumentException("The given collection cannot be empty.");
        }
    }
    
    public static void collectionIsEmpty(Collection objects, String objectsName)
    {
        if(objects.isEmpty())
        {
            throw new IllegalArgumentException("The given " + objectsName + " cannot be empty.");
        }
    }
    
    public static void thisShouldNotHappen()
    {
        throw new UnsupportedOperationException("This should not happen.");
    }
}
