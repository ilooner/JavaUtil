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

import com.google.common.collect.Maps;
import com.topekalabs.java.utils.ObjectUtils;
import java.util.Map;

/**
 *
 * @author Topeka Labs
 */
public class ErrorThrowerFactory
{
    /**
     * There should be one ErrorThrower per namespace.
     */
    private static final Map<String, ErrorThrower> ERROR_THROWERS = Maps.newHashMap();
    
    private ErrorThrowerFactory()
    {
    }
    
    public static ErrorThrower createThrower(String namespace)
    {
        ErrorThrower errorThrower = ERROR_THROWERS.get(namespace);
        
        if(ObjectUtils.isNull(errorThrower))
        {
            errorThrower = new ErrorThrower(namespace);
            ERROR_THROWERS.put(namespace, errorThrower);
        }
        
        return errorThrower;
    }
}
