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
package com.topekalabs.error.utils;

import com.topekalabs.java.utils.ExceptionUtils;
import com.topekalabs.java.utils.Utils;

/**
 * This class is used to wrap a result, and provide additional fields for
 * flagging errors and providing error codes.
 * 
 * @author Topeka Labs
 * @param <T> The type of the payload object.
 */
public class ResultValue<T>
{
    /**
     * True if a result value was generated.
     */
    private boolean hasResult = false;
    /**
     * The actual result.
     */
    private T object;
    /**
     * An error associated with the result.
     */
    private Error error;
    
    public ResultValue()
    {
        //Do nothing
    }
    
    public ResultValue(T object)
    {
        setObject(object);
        hasResult = true;
    }
    
    public ResultValue(T object,
                       Error error)
    {
        setObject(object);
        setError(error);
    }
    
    private void setObject(T object)
    {
        this.object = object;
    }
    
    private void setError(Error error)
    {
        ExceptionUtils.isNullException(error, "error");
        
        this.error = error;
    }
    
    public T getObject()
    {
        return object;
    }
    
    public Error getError()
    {
        noErrorException();
        return error;
    }
    
    public boolean hasResult()
    {
        return hasResult;
    }
    
    public void noResultException()
    {
        if(!hasResult())
        {
            ExceptionUtils.thisShouldNotHappen();
        }
    }
    
    public boolean hasError()
    {
        return !Utils.isNull(error);
    }
    
    public void noErrorException()
    {
        if(!hasError())
        {
            ExceptionUtils.thisShouldNotHappen("This result value has no error.");
        }
    }
}
