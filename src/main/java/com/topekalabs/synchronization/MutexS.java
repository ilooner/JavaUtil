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

/**
 *
 * @author Topeka Labs
 */
public class MutexS extends Mutex
{
    private volatile long threadId;
    
    public MutexS()
    {
    }
    
    @Override
    public void lock()
    {
        super.lock();
        
        threadId = Thread.currentThread().getId();
    }
    
    @Override
    public void lockInterruptable() throws InterruptedException
    {
        super.lockInterruptable();
        
        threadId = Thread.currentThread().getId();
    }
    
    @Override
    public void unlock()
    {
        long unlockId = Thread.currentThread().getId();
        
        if(threadId != unlockId)
        {
            ExceptionUtils.thisShouldNotHappen("The mutex is being unlocked by thread " +
                                               unlockId +
                                               " but it is owned by thread " +
                                               threadId);
        }
        
        super.unlock();
    }
}
