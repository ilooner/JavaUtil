/*
 * Copyright 2015 Topeka Labs.
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
package com.topekalabs.collection.utils;

import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.OptionConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Topeka Labs
 */
public class ReflectionUtils
{
    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class.getName());
    static final String TSTR = "Caught Exception while in Loader.getResource. This may be innocuous.";

    static private boolean java1 = true;
    static private boolean ignoreTCL = false;

    //From Log4j Source
    static
    {
        String prop = OptionConverter.getSystemProperty("java.version", null);

        if(prop != null)
        {
            int i = prop.indexOf('.');
            if(i != -1)
            {
                if(prop.charAt(i + 1) != '1')
                {
                    java1 = false;
                }
            }
        }
        String ignoreTCLProp = OptionConverter.getSystemProperty("log4j.ignoreTCL", null);
        if(ignoreTCLProp != null)
        {
            ignoreTCL = OptionConverter.toBoolean(ignoreTCLProp, true);
        }
    }
    
    private ReflectionUtils()
    {
        //Do nothing
    }
    
    public static URL getResourceURL(String resource)
    {
        return Loader.getResource(resource);
    }
    
    //From Log4j Source
    static public InputStream getResourceInputStream(String resource)
    {
        ClassLoader classLoader = null;
        InputStream inputStream = null;

        try
        {
            if(!java1 && !ignoreTCL)
            {
                classLoader = getTCL();
                if(classLoader != null)
                {
                    logger.debug("Trying to find [{}] using context classloader {}.",
                                 resource,
                                 classLoader);
                    inputStream = classLoader.getResourceAsStream(resource);
                    if(inputStream != null)
                    {
                        return inputStream;
                    }
                }
            }

            // We could not find resource. Ler us now try with the
            // classloader that loaded this class.
            classLoader = Loader.class.getClassLoader();
            if(classLoader != null)
            {
                logger.debug("Trying to find [{}] using {} class loader.",
                             resource,
                             classLoader);
                inputStream = classLoader.getResourceAsStream(resource);
                if(inputStream != null)
                {
                    return inputStream;
                }
            }
        }
        catch(IllegalAccessException t)
        {
            logger.warn(TSTR, t);
        }
        catch(InvocationTargetException t)
        {
            if(t.getTargetException() instanceof InterruptedException
                    || t.getTargetException() instanceof InterruptedIOException)
            {
                Thread.currentThread().interrupt();
            }
            logger.warn(TSTR, t);
        }
        catch(Throwable t)
        {
            //  can't be InterruptedException or InterruptedIOException
            //    since not declared, must be error or RuntimeError.
            logger.warn(TSTR, t);
        }

        // Last ditch attempt: get the resource from the class path. It
        // may be the case that clazz was loaded by the Extentsion class
        // loader which the parent of the system class loader. Hence the
        // code below.
        logger.debug("Trying to find [{}] using ClassLoader.getSystemResource().", resource);
        return ClassLoader.getSystemResourceAsStream(resource);
    }
    
    //From Log4j Source
    private static ClassLoader getTCL() throws IllegalAccessException,
                                               InvocationTargetException
    {

        // Are we running on a JDK 1.2 or later system?
        Method method = null;
        try
        {
            method = Thread.class.getMethod("getContextClassLoader", null);
        }
        catch(NoSuchMethodException e)
        {
            // We are running on JDK 1.1
            return null;
        }

        return (ClassLoader) method.invoke(Thread.currentThread(), null);
    }
}
