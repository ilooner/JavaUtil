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
 * This exception represents a recoverable error.
 * @author Topeka Labs
 */
public class RecoverableError extends ThrownError
{
    protected RecoverableError(String namespace,
                               ErrorCode errorCode)
    {
        super(new Error(namespace,
                        errorCode,
                        ErrorType.UNRECOVERABLE_ERROR));
    }

    protected RecoverableError(String namespace,
                               String alias)
    {
        super(new Error(namespace,
                        alias,
                        ErrorType.UNRECOVERABLE_ERROR));
    }
    
    protected RecoverableError(String namespace,
                               ErrorCode errorCode,
                               Throwable throwable)
    {
        this(new Error(namespace,
                       errorCode,
                       ErrorType.UNRECOVERABLE_ERROR),
             throwable);
    }
    
    protected RecoverableError(String namespace,
                               String alias,
                               Throwable throwable)
    {
        this(new Error(namespace,
                       alias,
                       ErrorType.UNRECOVERABLE_ERROR),
             throwable);
    }
    
    protected RecoverableError(Error error,
                               Throwable throwable)
    {
        super(error,
              throwable);
        
        error.notUnrecoverableException();
    }
    
    protected RecoverableError(Error error)
    {
        super(error);
    }
}
