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

/**
 * This class contains utility methods for throwing exceptions.
 * @author Topeka Labs
 */
public final class ExceptionUtils
{
    private ExceptionUtils()
    {
        //Do nothing
    }
    
    /**
     * This method throws a NullPointerException if the given object is null.
     * @param object The object to check.
     */
    public static void isNullException(Object object)
    {
        if(object == null)
        {
            throw new NullPointerException("The given object cannot be null.");
        }
    }
    
    /**
     * This method throws a NullPointerException if the given object is null.
     * The name of the object is included in the exception message.
     * @param object The object to check.
     * @param objectName The name of the object.
     */
    public static void isNullException(Object object, String objectName)
    {
        if(object == null)
        {
            throw new NullPointerException("The give object " + objectName + " cannot be null.");
        }
    }
    
    /**
     * Convenience method for throwing an UnsupportedOperationException.
     */
    public static void thisShouldNotHappen()
    {
        throw new UnsupportedOperationException("This should not happen.");
    }
}
