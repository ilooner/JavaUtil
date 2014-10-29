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
package com.topekalabs.synchronization;

import com.topekalabs.java.utils.ExceptionUtils;
import com.topekalabs.math.utils.LongUtils;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Topeka Labs
 */
public class SpinWaitLock
{
    public static final long DEFAULT_WAIT_TIME = 1000;
    
    private long waitTime = DEFAULT_WAIT_TIME;
    AtomicReference<Integer> csw = new AtomicReference<Integer>(0);
    private final Object lock = new Object();
    
    public SpinWaitLock()
    {
        //Do Nothing
    }
    
    public SpinWaitLock(long waitTime)
    {
        setWaitTime(waitTime);
    }
    
    private void setWaitTime(long waitTime)
    {
        LongUtils.isNonPositiveException(waitTime, "waitTime");
        this.waitTime = waitTime;
    }
    
    public void lock()
    {
        synchronized(lock)
        {
            while(!csw.compareAndSet(0, 1))
            {
                try
                {
                    lock.wait(waitTime);
                }
                catch(InterruptedException ex)
                {
                    ExceptionUtils.thisShouldNotHappen(ex);
                }
            }
        }
    }
    
    public void unlock()
    {
        ExceptionUtils.thisShouldNotHappen(!csw.compareAndSet(1, 0),
                                           "This spin lock is not locked.");
        synchronized(lock)
        {
            lock.notify();
        }
    }
}
