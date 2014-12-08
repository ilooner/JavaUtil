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
package com.topekalabs.threads;

import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.utils.IntUtils;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Topeka Labs
 */
public class ThreadPoolSynchronousBatchFixed
{
    private int numThreads = Runtime.getRuntime().availableProcessors();
    
    private ThreadFactory threadFactory;
    private ExecutorService fixedThreadPool;
    
    private ThreadPoolSynchronousBatchFixed()
    {
        initialize();
    }
    
    private ThreadPoolSynchronousBatchFixed(int numThreads)
    {
        setNumThreads(numThreads);
        initialize();
    }
    
    private ThreadPoolSynchronousBatchFixed(ThreadFactory threadFactory)
    {
        setThreadFactory(threadFactory);
        initialize();
    }
    
    private ThreadPoolSynchronousBatchFixed(int numThreads,
                                            ThreadFactory threadFactory)
    {
        setNumThreads(numThreads);
        setThreadFactory(threadFactory);
        initialize();
    }
    
    private void initialize()
    {
        fixedThreadPool = Executors.newFixedThreadPool(numThreads,
                                                       threadFactory);
    }
    
    private void setNumThreads(int numThreads)
    {
        IntUtils.isNonPositiveException(numThreads, "numThreads");
        this.numThreads = numThreads;
    }
    
    private void setThreadFactory(ThreadFactory threadFactory)
    {
        ExceptionUtils.isNullException(threadFactory, "threadFactory");
        this.threadFactory = threadFactory;
    }
    
    public int getNumThreads()
    {
        return numThreads;
    }
    
    public <T> List<Future<T>> runBatchSync(Collection<? extends Callable<T>> tasks)
                               throws InterruptedException
    {
        return fixedThreadPool.invokeAll(tasks);
    }
}
