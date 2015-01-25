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
 * This class represents an error.
 * @author Topeka Labs
 */
public class Error
{
    private String namespace;
    /**
     * This is an error code.
     */
    private ErrorCode errorCode;
    /**
     * This is an error type.
     */
    private ErrorType errorType;
    
    private String message;
    private String alias;
    
    /**
     * This creates an error from the given error code and error type.
     * @param namespace The class in which the error occurred.
     * @param errorCode The error code of the error.
     * @param errorType The type of the error.
     */
    public Error(String namespace,
                 ErrorCode errorCode,
                 ErrorType errorType)
    {
        setNamespace(namespace);
        setErrorCode(errorCode);
        setErrorType(errorType);
        
        setMessage(namespace,
                   errorCode);
        setAlias(namespace,
                 errorCode);
    }
    
    public Error(String namespace,
                 String alias,
                 ErrorType errorType)
    {
        this(namespace,
             ErrorLoader.getErrorCode(namespace,
                                      alias),
             errorType);
    }
    
    private void setAlias(String namespace,
                          ErrorCode errorCode)
    {
        alias = ErrorLoader.getAlias(namespace, errorCode);
    }
    
    public String getAlias()
    {
        return alias;
    }
    
    private void setMessage(String namespace,
                            ErrorCode errorCode)
    {
        message = ErrorLoader.getErrorMessage(namespace,
                                              errorCode);
    }
    
    public String getMessage()
    {
        return message;
    }
    
    private void setNamespace(String namespace)
    {
        ExceptionUtils.isNullException(namespace, "namespace");
        this.namespace = namespace;
    }
    
    public String getNamespace()
    {
        return namespace;
    }
    
    /**
     * This method sets the error code.
     * @param errorCode The error code of the error.
     */
    private void setErrorCode(ErrorCode errorCode)
    {
        ExceptionUtils.isNullException(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
    
    /**
     * This method gets the error code of the error.
     * @return The error code of the error.
     */
    public ErrorCode getErrorCode()
    {
        return errorCode;
    }
    
    /**
     * This sets the type of the error.
     * @param errorType The type of the error.
     */
    private void setErrorType(ErrorType errorType)
    {
        ExceptionUtils.isNullException(errorType, "errorType");
        this.errorType = errorType;
    }
    
    /**
     * This gets the error type of the error.
     * @return The error type of the error.
     */
    public ErrorType getErrorType()
    {
        return errorType;
    }
    
    /**
     * This method throws a {@link CodingError} if this error is Recoverable.
     */
    public void recoverableException()
    {
        if(errorType == ErrorType.RECOVERABLE_ERROR)
        {
            ExceptionUtils.thisShouldNotHappen();
        }
    }
    
    /**
     * This method throws a {@link CodingError} if this error is Unrecoverable.
     */
    public void unrecoverableException()
    {
        if(errorType == ErrorType.UNRECOVERABLE_ERROR)
        {
            ExceptionUtils.thisShouldNotHappen();
        }
    }
    
    public void notRecoverableException()
    {
        if(errorType != ErrorType.RECOVERABLE_ERROR)
        {
            ExceptionUtils.thisShouldNotHappen();
        }
    }
    
    public void notUnrecoverableException()
    {
        if(errorType != ErrorType.UNRECOVERABLE_ERROR)
        {
            ExceptionUtils.thisShouldNotHappen();
        }
    }
}
