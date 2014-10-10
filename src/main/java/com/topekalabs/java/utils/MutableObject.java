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
 * This is a simple wrapper object allows its payload object to be mutable.
 * @author Topeka Labs
 * @param <T> The type of the payload object.
 */
public final class MutableObject<T>
{
    /**
     * The payload object.
     */
    private T object;
    
    /**
     * This constructor creates a mutable object with the given payload object.
     * @param object The payload object.
     */
    public MutableObject(T object)
    {
        setObject(object);
    }
    
    /**
     * This method sets the payload object. A NullPointerException is thrown if
     * the object is null.
     * @param object The payload object.
     */
    public void setObject(T object)
    {
        ExceptionUtils.isNullException(object);
        
        this.object = object;
    }
    
    /**
     * This method gets the payload object.
     * @return The payload object.
     */
    public T getObject()
    {
        return object;
    }
}
