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

/**
 *
 * @author Topeka Labs
 */
public class Semaphore
{
    private final Mutex mutex = new Mutex();
    private final ConditionVariable cond = new ConditionVariable();
    private long count = 0;
    
    public Semaphore(long count)
    {
        this.count = count;
    }
    
    public void acquire()
    {
        mutex.lock();
        
        if(count == 0)
        {
            cond.wait(mutex);
        }
        
        count--;
        
        mutex.unlock();
    }
    
    public void acquireInterruptable() throws InterruptedException
    {
        mutex.lockInterruptable();
        
        if(count == 0)
        {
            cond.waitInterruptable(mutex);
        }
        
        count--;
        
        mutex.unlock();
    }
    
    public void release()
    {
        mutex.lock();
        count++;
        mutex.unlock();
        
        cond.signal();
    }
    
    public void releaseInterruptable() throws InterruptedException
    {
        mutex.lockInterruptable();
        count++;
        mutex.unlock();
        
        cond.signalInterruptable();
    }
}
