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

import com.topekalabs.error.utils.CodingError;

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
     * Convenience method for throwing a CodingError.
     */
    public static void thisShouldNotHappen()
    {
        throw new CodingError("This should not happen.");
    }
    
    public static void thisShouldNotHappen(String message)
    {
        throw new CodingError(message);
    }
    
    /**
     * Convenience method for throwing a Coding error when the given boolean is
     * true.
     * @param throwError When true a coding error is thrown. 
     */
    public static void thisShouldNotHappen(boolean throwError)
    {
        if(throwError)
        {
            thisShouldNotHappen();
        }
    }
    
    public static void thisShouldNotHappen(boolean throwError,
                                           String message)
    {
        if(throwError)
        {
            thisShouldNotHappen(message);
        }
    }
    
    /**
     * Convenience method for throwing a CodingError
     * @param throwable The Throwable to wrap.
     */
    public static void thisShouldNotHappen(Throwable throwable)
    {
        throw new CodingError("This should not happen.", throwable);
    }
    
    /**
     * 
     * @param message
     * @param throwable 
     */
    public static void thisShouldNotHappen(String message,
                                           Throwable throwable)
    {
        throw new CodingError(message, throwable);
    }
    
    /**
     * This is a convenience method for throwing an UnsupportedOperationException.
     * @param message This is a method to include in the unsupported operation exception.
     */
    public static void unsupported(String message)
    {
        throw new UnsupportedOperationException(message);
    }
    
    public static boolean executeAndCatchIllegalArgumentException(FunctionPointer fp)
    {
        boolean caught = false;
        
        try
        {
            fp.execute();
        }
        catch(IllegalArgumentException e)
        {
            caught = true;
        }
        
        return caught;
    }
}
