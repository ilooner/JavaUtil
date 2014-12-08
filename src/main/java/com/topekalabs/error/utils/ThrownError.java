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

import com.topekalabs.java.utils.ObjectUtils;

/**
 *
 * @author Topeka Labs
 */
public class ThrownError extends RuntimeException
{
    private Error error;

    public ThrownError(Error error)
    {
        setError(error);
    }

    /**
     * This creates a recoverable error which wraps the given throwable.
     *
     * @param throwable The throwable to wrap.
     */
    public ThrownError(Throwable throwable)
    {
        super(throwable);
    }

    /**
     * This creates a recoverable error with the given result value and wraps
     * the given throwable.
     *
     * @param error The error.
     * @param throwable The throwable to wrap.
     */
    public ThrownError(Error error,
                       Throwable throwable)
    {
        super(throwable);
        setError(error);
    }
    
    private void setError(Error error)
    {
        ExceptionUtils.isNullException(error);
        this.error = error;
    }

    /**
     * This gets the result value of the recoverable error.
     *
     * @return The result value of the recoverable error.
     */
    public Error getError()
    {
        return error;
    }
    
    public boolean hasError()
    {
        return !ObjectUtils.isNull(error);
    }
}
