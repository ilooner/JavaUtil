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
public class ConditionVariable
{
    private ThreadList threadList = new ThreadList();
    private Mutex listLock = new Mutex();
    
    public ConditionVariable()
    {
    }
    
    public void wait(Mutex mutex)
    {
        listLock.lock();
        ThreadScheduleHandle handle = threadList.enqueue();
        listLock.unlock();
        mutex.unlock();
        
        handle.deschedule();
        
        mutex.lock();
    }
    
    public void signal()
    {
        listLock.lock();
        ThreadScheduleHandle handle = threadList.enqueue();
        listLock.unlock();
        
        handle.reschedule();
    }
    
    public void broadCast()
    {
        listLock.lock();
        
        ThreadList oldThreadList = threadList;
        threadList = new ThreadList();
        
        listLock.unlock();
        
        ThreadScheduleHandle handle;
        
        while((handle = oldThreadList.dequeue()) != null)
        {
            handle.reschedule();
        }
    }
}
