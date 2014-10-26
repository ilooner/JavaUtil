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
 * This Exception is meant to be thrown for Unrecoverable Errors
 * @author Topeka Labs
 */
public class UnrecoverableError extends RuntimeException
{
    private ResultValue resultValue;
    private Throwable throwable;
    
    public UnrecoverableError(ResultValue resultValue)
    {
        setResultValue(resultValue);
    }
    
    public UnrecoverableError(Throwable throwable)
    {
        super(throwable);
        setThrowable(throwable);
    }
    
    public UnrecoverableError(ResultValue resultVlaue,
                              Throwable throwable)
    {
        super(throwable);
        setResultValue(resultValue);
        setThrowable(throwable);
    }

    public boolean hasResultValue()
    {
        return !Utils.isNull(resultValue);
    }
    
    public boolean hasThrowable()
    {
        return !Utils.isNull(throwable);
    }
    
    private void setResultValue(ResultValue resultValue)
    {
        ExceptionUtils.isNullException(resultValue, "resultValue");
        
        this.resultValue = resultValue;
    }
    
    private void setThrowable(Throwable throwable)
    {
        ExceptionUtils.isNullException(throwable, "throwable");
        
        if(throwable instanceof RecoverableError)
        {
            ExceptionUtils.thisShouldNotHappen(throwable);
        }
    }    
}
