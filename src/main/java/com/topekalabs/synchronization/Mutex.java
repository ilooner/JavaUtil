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

import com.topekalabs.error.utils.ExceptionUtils;
import java.util.concurrent.atomic.AtomicReference;


/**
 * @author Topeka Labs
 */
public class Mutex implements Lock
{
    AtomicReference<Integer> csw = new AtomicReference<>(0);
    private final Object lock = new Object();
    
    public Mutex()
    {
        //Do Nothing
    }
    
    @Override
    public void lock()
    {
        synchronized(lock)
        {
            while(!csw.compareAndSet(0, 1))
            {
                try
                {
                    lock.wait();
                }
                catch(InterruptedException ex)
                {
                    //Do nothing
                }
            }
        }
    }
    
    public void lockInterruptable() throws InterruptedException
    {
        synchronized(lock)
        {
            while(!csw.compareAndSet(0, 1))
            {
                lock.wait();
            }
        }        
    }
    
    @Override
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
