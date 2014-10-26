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

import java.lang.Thread.UncaughtExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is an exception handler which prints using logging.
 * @author Topeka Labs
 */
public class DefaultUncaughtExceptionHandler implements UncaughtExceptionHandler
{
    private static final Logger LOG = LoggerFactory.getLogger(DefaultUncaughtExceptionHandler.class);
    
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        if(e instanceof CodingError)
        {
            LOG.error(null, e);
        }
        else if(e instanceof UnrecoverableError)
        {
            LOG.error(null, e);
        }
        else if(e instanceof RecoverableError)
        {
            LOG.error(null, 
                      new CodingError("Uncaught recoverable error.",
                                      e));
        }
        else
        {
            LOG.error("Invalid uncaught exception.",
                      e);
        }
    }
}
