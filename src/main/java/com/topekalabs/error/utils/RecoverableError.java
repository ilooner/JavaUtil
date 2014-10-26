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

/**
 * This exception represents a recoverable error.
 * @author Topeka Labs
 */
public class RecoverableError extends RuntimeException
{
    /**
     * The value of the recoverable error.
     */
    private ResultValue resultValue;
    
    /**
     * Creates a recoverable error with the given value.
     * @param resultValue The result value.
     */
    public RecoverableError(ResultValue resultValue)
    {
        setResultValue(resultValue);
    }
    
    /**
     * This creates a recoverable error which wraps the given throwable.
     * @param throwable The throwable to wrap.
     */
    public RecoverableError(Throwable throwable)
    {
        super(throwable);
    }
    
    /**
     * This creates a recoverable error with the given result value and wraps
     * the given throwable.
     * @param resultValue The result value.
     * @param throwable The throwable to wrap.
     */
    public RecoverableError(ResultValue resultValue,
                            Throwable throwable)
    {
        super(throwable);
        setResultValue(resultValue);
    }
    
    /**
     * This sets the result value of the recoverable error.
     * @param resultValue The result value of the recoverable error.
     */
    private void setResultValue(ResultValue resultValue)
    {
        ExceptionUtils.isNullException(resultValue);
        this.resultValue = resultValue;
    }
    
    /**
     * This gets the result value of the recoverable error.
     * @return The result value of the recoverable error.
     */
    public ResultValue getResultValue()
    {
        return resultValue;
    }
}
