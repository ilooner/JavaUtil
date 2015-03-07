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
package com.topekalabs.threads;

import com.google.common.base.Stopwatch;
import com.topekalabs.collection.utils.ListUtils;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Topeka Labs
 */
public class ThreadUtils
{
    private static final TimeUnit MILLIS_UNIT = TimeUnit.MILLISECONDS;
    
    private ThreadUtils()
    {
        //Do nothing
    }
    
    public static <T> void done(List<Future<T>> futures,
                                long timeout,
                                TimeUnit timeUnit) throws TimeoutException,
                                                          InterruptedException,
                                                          ExecutionException
    {
        done(ListUtils.listToCollection(futures),
             timeout,
             timeUnit);
    }
    
    public static <T> void done(Collection<Future<T>> futures) throws TimeoutException,
                                                                      InterruptedException,
                                                                      ExecutionException
    {
        for(Future<?> future: futures)
        {
            future.get();
        }
    }
    
    public static <T> void done(Collection<Future<T>> futures,
                                long timeout,
                                TimeUnit timeUnit) throws TimeoutException,
                                                          InterruptedException,
                                                          ExecutionException
    {
        long milliTimeout = MILLIS_UNIT.convert(timeout, timeUnit);
        long currentTimeout = milliTimeout;
        
        Stopwatch sw = Stopwatch.createUnstarted();
        
        for(Future<?> future: futures)
        {
            sw.start();
            future.get(currentTimeout, MILLIS_UNIT);
            sw.stop();
            
            long elapsed = sw.elapsed(MILLIS_UNIT);
            
            if(elapsed > milliTimeout)
            {
                throw new TimeoutException("Exceeded timeout of " +
                                           milliTimeout +
                                           " milliseconds.");
            }
            
            currentTimeout = milliTimeout - elapsed;
        }
    }
}
