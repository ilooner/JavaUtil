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
 * This is a helper class which contains methods to rethrow UnrecoverableErrors
 * appropriately.
 * @author Topeka Labs
 */
public final class ErrorThrower
{
    private ErrorThrower()
    {
        //do nothing
    }
    
    /**
     * This method rethrows the given exception appropriately. If the given
     * exception is a {@link RecoverableError}, {@link UnrecoverableError}, {@link CodingError}, or
     * a {@link RuntimeException} then the exception is not wrapped and is rethrown.
     * If the exception is of another type then it is wrapped as an Unrecoverable
     * exception and rethrown.
     * @param throwable The Throwable to rethrow. 
     */
    public static void rethrowUnrecoverable(Throwable throwable)
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
        
        throw new UnrecoverableError(throwable);
    }

    /**
     * This method rethrows the given exception appropriately. If the given
     * exception is an {@link RecoverableError}, {@link UnrecoverableError}, or
     * a {@link RuntimeException} then the exception is not wrapped and is rethrown.
     * If the exception is of another type then it is wrapped as an Unrecoverable
     * exception and rethrown.
     * @param throwable The Throwable to rethrow. 
     */
    public static void rethrowRecoverable(Throwable throwable)
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
        
        throw new RecoverableError(throwable);
    }
}
