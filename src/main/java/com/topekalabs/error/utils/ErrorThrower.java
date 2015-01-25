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
 *
 * @author Topeka Labs
 */
public class ErrorThrower
{
    private String namespace;
    
    protected ErrorThrower(String namespace)
    {
        setNamespace(namespace);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Setters and Getters
    ////////////////////////////////////////////////////////////////////////////
    
    private void setNamespace(String namespace)
    {
        ExceptionUtils.isNullException(namespace, "namespace");
        this.namespace = namespace;
    }
    
    public String getNamespace()
    {
        return namespace;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Setters and Getters
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Fixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public void throwRecoverableError(ErrorCode errorCode,
                                      Throwable throwable,
                                      Object... errorData)
    {
        throw new RecoverableError(namespace,
                                   errorCode,
                                   throwable,
                                   errorData);
    }
    
    public void throwRecoverableError(int errorCode,
                                      Throwable throwable,
                                      Object... errorData)
    {
        throwRecoverableError(new ErrorCode(errorCode),
                              throwable,
                              errorData);
    }    
    
    public void throwRecoverableError(ErrorCode errorCode,
                                      Object... errorData)
    {
        throw new RecoverableError(namespace,
                                   errorCode,
                                   errorData);
    }
    
    public void throwRecoverableError(int errorCode,
                                      Object... errorData)
    {
        throwRecoverableError(new ErrorCode(errorCode),
                              errorData);
    }
    
    public void throwRecoverableError(String alias,
                                      Throwable throwable,
                                      Object... errorData)
    {
        throw new RecoverableError(namespace,
                                   alias,
                                   throwable,
                                   errorData);
    }
    
    public void throwRecoverableError(String alias,
                                      Object... errorData)
    {
        throw new RecoverableError(namespace,
                                   alias,
                                   errorData);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Fixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Fixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public void throwUnrecoverableError(ErrorCode errorCode,
                                        Throwable throwable,
                                        Object... errorData)
    {
        throw new UnrecoverableError(namespace,
                                     errorCode,
                                     throwable,
                                     errorData);
    }
    
    public void throwUnrecoverableError(int errorCode,
                                        Throwable throwable,
                                        Object... errorData)
    {
        throwUnrecoverableError(new ErrorCode(errorCode),
                                throwable,
                                errorData);
    }
    
    public void throwUnrecoverableError(ErrorCode errorCode,
                                        Object... errorData)
    {
        throw new UnrecoverableError(namespace,
                                     errorCode,
                                     errorData);
    }
    
    public void throwUnrecoverableError(int errorCode,
                                        Object... errorData)
    {
        throwUnrecoverableError(new ErrorCode(errorCode),
                                errorData);
    }

    public void throwUnrecoverableError(String alias,
                                        Throwable throwable,
                                        Object... errorData)
    {
        throw new UnrecoverableError(namespace,
                                     alias,
                                     throwable,
                                     errorData);
    }
    
    public void throwUnrecoverableError(String alias,
                                        Object... errorData)
    {
        throw new UnrecoverableError(namespace,
                                     alias,
                                     errorData);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Fixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Nonfixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public static void throwUnrecoverableError(String namespace,
                                               ErrorCode errorCode,
                                               Object... errorData)
    {
        throw new UnrecoverableError(namespace,
                                     errorCode,
                                     errorData);
    }
    
    public static void throwUnrecoverableError(String namespace,
                                               int errorCode,
                                               Object... errorData)
    {
        throwUnrecoverableError(namespace,
                                new ErrorCode(errorCode),
                                errorData);
    }
    
    public static void throwUnrecoverableError(String namespace,
                                               ErrorCode errorCode,
                                               Throwable throwable,
                                               Object... errorData)
    {
        throw new UnrecoverableError(namespace,
                                     errorCode,
                                     throwable,
                                     errorData);
    }
    
    public static void throwUnrecoverableError(String namespace,
                                               int errorCode,
                                               Throwable throwable,
                                               Object... errorData)
    {
        throwUnrecoverableError(namespace,
                                new ErrorCode(errorCode),
                                throwable,
                                errorData);
    }
    
    public static void throwUnrecoverableError(Error error,
                                               Throwable throwable)
    {
        throw new UnrecoverableError(error,
                                     throwable);
    }

    public static void throwUnrecoverableError(Error error)
    {
        throw new UnrecoverableError(error);
    }
    
    public static void throwUnrecoverableError(String namespace,
                                               String alias,
                                               Object... errorData)
    {
        throw new UnrecoverableError(namespace,
                                     alias,
                                     errorData);
    }
    
    public static void throwUnrecoverableError(String namespace,
                                               String alias,
                                               Throwable throwable,
                                               Object... errorData)
    {
        throw new UnrecoverableError(namespace,
                                     alias,
                                     throwable,
                                     errorData);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Nonfixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Nonfixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public static void throwRecoverableError(String namespace,
                                             ErrorCode errorCode,
                                             Object... errorData)
    {
        throw new RecoverableError(namespace,
                                   errorCode,
                                   errorData);
    }
    
    public static void throwRecoverableError(String namespace,
                                             int errorCode,
                                             Object... errorData)
    {
        throwRecoverableError(namespace,
                              new ErrorCode(errorCode),
                              errorData);
    }
    
    public static void throwRecoverableError(String namespace,
                                             ErrorCode errorCode,
                                             Throwable throwable,
                                             Object... errorData)
    {
        throw new RecoverableError(namespace,
                                   errorCode,
                                   throwable,
                                   errorData);
    }
    
    public static void throwRecoverableError(String namespace,
                                             int errorCode,
                                             Throwable throwable,
                                             Object... errorData)
    {
        throwRecoverableError(namespace,
                              new ErrorCode(errorCode),
                              throwable,
                              errorData);
    }
    
    public static void throwRecoverableError(Error error,
                                             Throwable throwable)
    {
        throw new UnrecoverableError(error,
                                     throwable);
    }
    
    public static void throwRecoverableError(Error error)
    {
        throw new UnrecoverableError(error);
    }
    
    public static void throwRecoverableError(String namespace,
                                             String alias,
                                             Object... errorData)
    {
        throw new RecoverableError(namespace,
                                   alias,
                                   errorData);
    }
    
    public static void throwRecoverableError(String namespace,
                                             String alias,
                                             Throwable throwable,
                                             Object... errorData)
    {
        throw new RecoverableError(namespace,
                                   alias,
                                   throwable,
                                   errorData);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Nonfixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Fixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public void rethrowUnrecoverable(ErrorCode errorCode,
                                     Throwable throwable,
                                     Object... errorData)
    {
        if(throwable instanceof RecoverableError)
        {
            ExceptionUtils.thisShouldNotHappen(throwable);
        }
        
        if(throwable instanceof UnrecoverableError)
        {
            throw (UnrecoverableError) throwable;
        }
        
        if(throwable instanceof CodingError)
        {
            throw (CodingError) throwable;
        }
        
        if(throwable instanceof RuntimeException)
        {
            throw (RuntimeException) throwable;
        }
        
        throw new UnrecoverableError(namespace,
                                     errorCode,
                                     throwable,
                                     errorData);
    }
    
    public void rethrowUnrecoverable(int errorCode,
                                     Throwable throwable,
                                     Object... errorData)
    {
        rethrowUnrecoverable(new ErrorCode(errorCode),
                             throwable,
                             errorData);
    }

    public void rethrowUnrecoverable(String alias,
                                     Throwable throwable,
                                     Object... errorData)
    {
        rethrowUnrecoverable(ErrorLoader.getErrorCode(namespace,
                                                      alias),
                             throwable,
                             errorData);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Fixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Fixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public void rethrowRecoverable(ErrorCode errorCode,
                                   Throwable throwable,
                                   Object... errorData)
    {
        if(throwable instanceof RecoverableError)
        {
            ExceptionUtils.thisShouldNotHappen(throwable);
        }
        
        if(throwable instanceof UnrecoverableError)
        {
            throw (UnrecoverableError) throwable;
        }
        
        if(throwable instanceof CodingError)
        {
            throw (CodingError) throwable;
        }
        
        if(throwable instanceof RuntimeException)
        {
            throw (RuntimeException) throwable;
        }
        
        throw new RecoverableError(namespace,
                                   errorCode,
                                   throwable,
                                   errorData);
    }

    public void rethrowRecoverable(int errorCode,
                                   Throwable throwable,
                                   Object... errorData)
    {
        rethrowRecoverable(new ErrorCode(errorCode),
                           throwable,
                           errorData);
    }

    public void rethrowRecoverable(String alias,
                                   Throwable throwable,
                                   Object... errorData)
    {
        rethrowRecoverable(ErrorLoader.getErrorCode(namespace,
                                                    alias),
                           throwable,
                           errorData);
    }
    ////////////////////////////////////////////////////////////////////////////
    /// End - Fixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Nonfixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * This method rethrows the given exception appropriately. If the given
     * exception is a {@link RecoverableError}, {@link UnrecoverableError}, {@link CodingError}, or
     * a {@link RuntimeException} then the exception is not wrapped and is rethrown.
     * If the exception is of another type then it is wrapped as an Unrecoverable
     * exception and rethrown.
     * @param throwable The Throwable to rethrow. 
     */
    public static void rethrowUnrecoverable(String namespace,
                                            ErrorCode errorCode,
                                            Throwable throwable,
                                            Object... errorData)
    {
        if(throwable instanceof RecoverableError)
        {
            ExceptionUtils.thisShouldNotHappen(throwable);
        }
        
        if(throwable instanceof UnrecoverableError)
        {
            throw (UnrecoverableError) throwable;
        }
        
        if(throwable instanceof CodingError)
        {
            throw (CodingError) throwable;
        }
        
        if(throwable instanceof RuntimeException)
        {
            throw (RuntimeException) throwable;
        }
        
        throw new UnrecoverableError(namespace,
                                     errorCode,
                                     throwable,
                                     errorData);
    }

    public static void rethrowUnrecoverable(String namespace,
                                            int errorCode,
                                            Throwable throwable,
                                            Object... errorData)
    {
        rethrowUnrecoverable(namespace,
                             new ErrorCode(errorCode),
                             throwable,
                             errorData);
    }
    

    public static void rethrowUnrecoverable(String namespace,
                                            String alias,
                                            Throwable throwable,
                                            Object... errorData)
    {
        rethrowUnrecoverable(namespace,
                             ErrorLoader.getErrorCode(namespace,
                                                      alias),
                             throwable,
                             errorData);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Nonfixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Nonfixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * This method rethrows the given exception appropriately. If the given
     * exception is a {@link RecoverableError}, {@link UnrecoverableError}, or
     * a {@link RuntimeException} then the exception is not wrapped and is rethrown.
     * If the exception is of another type then it is wrapped as an {@link RecoverableError}
     * exception and rethrown.
     * @param throwable The Throwable to rethrow. 
     */
    public static void rethrowRecoverable(String namespace,
                                          ErrorCode errorCode,
                                          Throwable throwable,
                                          Object... errorData)
    {
        if(throwable instanceof RecoverableError)
        {
            ExceptionUtils.thisShouldNotHappen(throwable);
        }
        
        if(throwable instanceof UnrecoverableError)
        {
            throw (UnrecoverableError) throwable;
        }
        
        if(throwable instanceof CodingError)
        {
            throw (CodingError) throwable;
        }
        
        if(throwable instanceof RuntimeException)
        {
            throw (RuntimeException) throwable;
        }
        
        throw new RecoverableError(namespace,
                                   errorCode,
                                   throwable,
                                   errorData);
    }

    public static void rethrowRecoverable(String namespace,
                                          int errorCode,
                                          Throwable throwable,
                                          Object... errorData)
    {
        rethrowRecoverable(namespace,
                           new ErrorCode(errorCode),
                           throwable,
                           errorData);
    }
    
    public static void rethrowRecoverable(String namespace,
                                          String alias,
                                          Throwable throwable,
                                          Object... errorData)
    {
        rethrowRecoverable(namespace,
                           ErrorLoader.getErrorCode(namespace,
                                                    alias),
                           throwable,
                           errorData);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Nonfixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public static void kill()
    {
        ExceptionUtils.ERROR_THROWER.throwUnrecoverableError("MISC_ERROR_KILL_THREAD");
    }
    
    public static void kill(Exception ex)
    {
        ExceptionUtils.ERROR_THROWER.rethrowUnrecoverable("MISC_ERROR_KILL_THREAD",
                                                          ex);
    }
}
