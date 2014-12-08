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
public class ReaderWriterLock
{
    private long count;
    private Long threadId;
    private final Mutex enterLock = new Mutex();
    private final Mutex countLock = new Mutex();
    private final ConditionVariable cond = new ConditionVariable();
    
    public enum Type
    {
        READER,
        WRITER
    }
    
    public ReaderWriterLock()
    {
    }
    
    public void lock(Type type)
    {
        enterLock.lock();
        countLock.lock();
        
        if(type == Type.READER)
        {
            count++;
            
            countLock.unlock();
            enterLock.unlock();
        }
        else if(type == Type.WRITER)
        {
            threadId = Thread.currentThread().getId();
            
            if(count > 0)
            {
                cond.wait(countLock);
            }
        }
        else
        {
            ExceptionUtils.thisShouldNotHappen();
        }
    }
    
    public void lockInterruptable(Type type) throws InterruptedException
    {
        enterLock.lockInterruptable();
        countLock.lockInterruptable();
        
        if(type == Type.READER)
        {
            count++;
            
            countLock.unlock();
            enterLock.unlock();
        }
        else if(type == Type.WRITER)
        {
            threadId = Thread.currentThread().getId();
            
            if(count > 0)
            {
                cond.waitInterruptable(countLock);
            }
        }
        else
        {
            ExceptionUtils.thisShouldNotHappen();
        }
    }
    
    public void unlock()
    {
        if(threadId != null &&
           threadId == Thread.currentThread().getId())
        {
            threadId = null;
            
            countLock.unlock();
            enterLock.unlock();
            return;
        }
        
        countLock.lock();
        
        if(count == 0)
        {
            ExceptionUtils.thisShouldNotHappen("Cannot unlock the lock more times than you locked it.");
        }
        
        count--;
        
        if(count == 0)
        {
            cond.signal();
        }
        
        countLock.unlock();
    }
    
    public void downgrade()
    {
        if(threadId != null &&
           threadId == Thread.currentThread().getId())
        {
            threadId = null;
            
            count++;
            
            countLock.unlock();
            enterLock.unlock();
        }
        else
        {
            ExceptionUtils.thisShouldNotHappen("Cannot downgrade the lock when you are not the writer.");
        }
    }
}
