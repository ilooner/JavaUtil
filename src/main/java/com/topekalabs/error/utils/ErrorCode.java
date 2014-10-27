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

import com.topekalabs.math.utils.IntUtils;

/**
 * This class represents an errorCode. Error codes are positive integers.
 * @author Topeka Labs
 */
public class ErrorCode
{
    //Loading errors from properties file
    static
    {
        
    }
    
    /**
     * The value of the error code.
     */
    private int errorCode;
    
    /**
     * This sets the error code to the specified integer.
     * @param errorCode The error code integer.
     */
    public ErrorCode(int errorCode)
    {
        setErrorCode(errorCode);
    }
    
    /**
     * This sets the error code to the specified integer.
     * @param errorCode The integer representing the error code.
     */
    private void setErrorCode(int errorCode)
    {
        IntUtils.isPositiveException(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
    
    /**
     * This method returns the error code integer.
     * @return The error code integer.
     */
    public int getErrorCode()
    {
        return errorCode;
    }
}
