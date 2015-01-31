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

/**
 * This Exception is meant to be thrown for Unrecoverable Errors
 * @author Topeka Labs
 */
public class UnrecoverableError extends ThrownError
{
    protected UnrecoverableError(String namespace,
                                 ErrorCode errorCode,
                                 Object... errorData)
    {
        super(new Error(namespace,
                        errorCode,
                        ErrorType.UNRECOVERABLE_ERROR,
                        errorData));
    }

    protected UnrecoverableError(String namespace,
                                 ErrorCode errorCode)
    {
        this(namespace,
             errorCode,
             new Object[0]);
    }
    
    protected UnrecoverableError(String namespace,
                                 String alias,
                                 Object... errorData)
    {
        super(new Error(namespace,
                        alias,
                        ErrorType.UNRECOVERABLE_ERROR,
                        errorData));
    }
    
    protected UnrecoverableError(String namespace,
                                 String alias)
    {
        this(namespace,
             alias,
             new Object[0]);
    }
    
    protected UnrecoverableError(String namespace,
                                 ErrorCode errorCode,
                                 Throwable throwable,
                                 Object... errorData)
    {
        this(new Error(namespace,
                       errorCode,
                       ErrorType.UNRECOVERABLE_ERROR,
                       errorData),
             throwable);
    }

    protected UnrecoverableError(String namespace,
                                 ErrorCode errorCode,
                                 Throwable throwable)
    {
        this(namespace,
             errorCode,
             throwable,
             new Object[0]);
    }
    
    protected UnrecoverableError(String namespace,
                                 String alias,
                                 Throwable throwable,
                                 Object... errorData)
    {
        this(new Error(namespace,
                       alias,
                       ErrorType.UNRECOVERABLE_ERROR,
                       errorData),
             throwable);
    }

    protected UnrecoverableError(String namespace,
                                 String alias,
                                 Throwable throwable)
    {
        this(new Error(namespace,
                       alias,
                       ErrorType.UNRECOVERABLE_ERROR,
                       new Object[0]),
             throwable);
    }
    
    protected UnrecoverableError(Error error,
                                 Throwable throwable)
    {
        super(error,
              throwable);
        
        error.notUnrecoverableException();
    }
    
    protected UnrecoverableError(Error error)
    {
        super(error);
    }
}
