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
package com.topekalabs.synchronization;

import com.topekalabs.collection.utils.CollectionUtils;
import com.topekalabs.error.utils.ErrorThrower;
import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.threads.ThreadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.lang.mutable.MutableInt;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Topeka Labs
 */
public class LockTest
{
    private Class<? extends Lock> lockClass;
    
    public LockTest(Class<? extends Lock> lockClass)
    {
        setLockClass(lockClass);
    }
    
    private void setLockClass(Class<? extends Lock> lockClass)
    {
        ExceptionUtils.isNullException(lockClass, "lockClass");
        this.lockClass = lockClass;
    }
    
    public Class<? extends Lock> getLockClass()
    {
        return lockClass;
    }
    
    @Test
    public void testLockAndUnlock()
    {
        final long timeout = 500;
        
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> future = es.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception
            {
                Lock lock = lockClass.newInstance();
                lock.lock();
                lock.unlock();
                return 1;
            }
        });
        
        try
        {
            future.get(timeout, TimeUnit.MILLISECONDS);
        }
        catch(InterruptedException | ExecutionException | TimeoutException ex)
        {
            ErrorThrower.kill(ex);
        }
        
        es.shutdown();
    }
    
    @Test
    public void testWithContention()
    {
        final int numThreads = 4;
        ExecutorService es = Executors.newFixedThreadPool(numThreads);
        
        //Warmup thread pool
        testWithContentionHelper(numThreads,
                                 es);
        testWithContentionHelper(numThreads,
                                 es);
        
        es.shutdown();
    }
    
    private void testWithContentionHelper(int numThreads,
                                          ExecutorService es)
    {
        final long timeout = 4000;
        final int numIncs = 500;
        final int expectedIncs = numIncs * numThreads;
        
        final MutableInt a = new MutableInt();
        final MutableInt b = new MutableInt();
        final Lock lock;
        
        try
        {
            lock = lockClass.newInstance();
        }
        catch(InstantiationException | IllegalAccessException ex)
        {
            throw new RuntimeException(ex);
        }
        
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception
            {
                for(int incCount = 0;
                    incCount < numIncs;
                    incCount++)
                {
                    lock.lock();
                    int tempB = b.intValue();
                    a.increment();
                    Thread.sleep(1);
                    a.add(b.intValue() - tempB);
                    b.increment();
                    lock.unlock();
                }
                
                return 1;
            }
        };
        
        List<Callable<Integer>> callables =
        CollectionUtils.fillEmptyCollection(new ArrayList<Callable<Integer>>(),
                                            callable,
                                            numThreads);
        
        try
        {
            List<Future<Integer>> futures = es.invokeAll(callables);
            ThreadUtils.done(futures, timeout, TimeUnit.MINUTES);
        }
        catch(InterruptedException | TimeoutException | ExecutionException ex)
        {
            ErrorThrower.kill(ex);
        }
        
        Assert.assertEquals("Incorrect number of increments.", expectedIncs, a.intValue());
        Assert.assertEquals("Incorrect number of increments.", expectedIncs, b.intValue());
    }
}
