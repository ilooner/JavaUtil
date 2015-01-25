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
                                      Throwable throwable)
    {
        throw new RecoverableError(namespace,
                                   errorCode,
                                   throwable);
    }
    
    public void throwRecoverableError(int errorCode,
                                      Throwable throwable)
    {
        throwRecoverableError(new ErrorCode(errorCode),
                              throwable);
    }    
    
    public void throwRecoverableError(ErrorCode errorCode)
    {
        throw new RecoverableError(namespace,
                                   errorCode);
    }
    
    public void throwRecoverableError(int errorCode)
    {
        throwRecoverableError(new ErrorCode(errorCode));
    }
    
    public void throwRecoverableError(String alias,
                                      Throwable throwable)
    {
        throw new RecoverableError(namespace,
                                   alias,
                                   throwable);
    }
    
    public void throwRecoverableError(String alias)
    {
        throw new RecoverableError(namespace,
                                   alias);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Fixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Fixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public void throwUnrecoverableError(ErrorCode errorCode,
                                        Throwable throwable)
    {
        throw new UnrecoverableError(namespace,
                                     errorCode,
                                     throwable);
    }
    
    public void throwUnrecoverableError(int errorCode,
                                        Throwable throwable)
    {
        throwUnrecoverableError(new ErrorCode(errorCode),
                                throwable);
    }
    
    public void throwUnrecoverableError(ErrorCode errorCode)
    {
        throw new UnrecoverableError(namespace,
                                     errorCode);
    }
    
    public void throwUnrecoverableError(int errorCode)
    {
        throwUnrecoverableError(new ErrorCode(errorCode));
    }

    public void throwUnrecoverableError(String alias,
                                        Throwable throwable)
    {
        throw new UnrecoverableError(namespace,
                                     alias,
                                     throwable);
    }
    
    public void throwUnrecoverableError(String alias)
    {
        throw new UnrecoverableError(namespace,
                                     alias);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Fixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Nonfixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public static void throwUnrecoverableError(String namespace,
                                               ErrorCode errorCode)
    {
        throw new UnrecoverableError(namespace,
                                     errorCode);
    }
    
    public static void throwUnrecoverableError(String namespace,
                                               int errorCode)
    {
        throwUnrecoverableError(namespace,
                                new ErrorCode(errorCode));
    }
    
    public static void throwUnrecoverableError(String namespace,
                                               ErrorCode errorCode,
                                               Throwable throwable)
    {
        throw new UnrecoverableError(namespace,
                                     errorCode,
                                     throwable);
    }
    
    public static void throwUnrecoverableError(String namespace,
                                               int errorCode,
                                               Throwable throwable)
    {
        throwUnrecoverableError(namespace,
                                new ErrorCode(errorCode),
                                throwable);
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
                                               String alias)
    {
        throw new UnrecoverableError(namespace,
                                     alias);
    }
    
    public static void throwUnrecoverableError(String namespace,
                                               String alias,
                                               Throwable throwable)
    {
        throw new UnrecoverableError(namespace,
                                     alias,
                                     throwable);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Nonfixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Nonfixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public static void throwRecoverableError(String namespace,
                                             ErrorCode errorCode)
    {
        throw new RecoverableError(namespace,
                                   errorCode);
    }
    
    public static void throwRecoverableError(String namespace,
                                             int errorCode)
    {
        throwRecoverableError(namespace,
                              new ErrorCode(errorCode));
    }
    
    public static void throwRecoverableError(String namespace,
                                             ErrorCode errorCode,
                                             Throwable throwable)
    {
        throw new RecoverableError(namespace,
                                   errorCode,
                                   throwable);
    }
    
    public static void throwRecoverableError(String namespace,
                                             int errorCode,
                                             Throwable throwable)
    {
        throwRecoverableError(namespace,
                              new ErrorCode(errorCode),
                              throwable);
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
                                             String alias)
    {
        throw new RecoverableError(namespace,
                                   alias);
    }
    
    public static void throwRecoverableError(String namespace,
                                             String alias,
                                             Throwable throwable)
    {
        throw new RecoverableError(namespace,
                                   alias,
                                   throwable);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Nonfixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Fixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public void rethrowUnrecoverable(ErrorCode errorCode,
                                     Throwable throwable)
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
                                     throwable);
    }
    
    public void rethrowUnrecoverable(int errorCode,
                                     Throwable throwable)
    {
        rethrowUnrecoverable(new ErrorCode(errorCode),
                             throwable);
    }

    public void rethrowUnrecoverable(String alias,
                                     Throwable throwable)
    {
        rethrowUnrecoverable(ErrorLoader.getErrorCode(namespace,
                                                      alias),
                             throwable);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /// End - Fixed Names Space Unrecoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    /// Start - Fixed Names Space Recoverable Throwing Functions
    ////////////////////////////////////////////////////////////////////////////
    
    public void rethrowRecoverable(ErrorCode errorCode,
                                   Throwable throwable)
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
                                   throwable);
    }

    public void rethrowRecoverable(int errorCode,
                                   Throwable throwable)
    {
        rethrowRecoverable(new ErrorCode(errorCode),
                           throwable);
    }

    public void rethrowRecoverable(String alias,
                                   Throwable throwable)
    {
        rethrowRecoverable(ErrorLoader.getErrorCode(namespace,
                                                    alias),
                           throwable);
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
                                            Throwable throwable)
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
                                     throwable);
    }

    public static void rethrowUnrecoverable(String namespace,
                                            int errorCode,
                                            Throwable throwable)
    {
        rethrowUnrecoverable(namespace,
                             new ErrorCode(errorCode),
                             throwable);
    }
    

    public static void rethrowUnrecoverable(String namespace,
                                            String alias,
                                            Throwable throwable)
    {
        rethrowUnrecoverable(namespace,
                             ErrorLoader.getErrorCode(namespace,
                                                      alias),
                             throwable);
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
                                          Throwable throwable)
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
                                   throwable);
    }

    public static void rethrowRecoverable(String namespace,
                                          int errorCode,
                                          Throwable throwable)
    {
        rethrowRecoverable(namespace,
                           new ErrorCode(errorCode),
                           throwable);
    }
    
    public static void rethrowRecoverable(String namespace,
                                          String alias,
                                          Throwable throwable)
    {
        rethrowRecoverable(namespace,
                           ErrorLoader.getErrorCode(namespace,
                                                    alias),
                           throwable);
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
