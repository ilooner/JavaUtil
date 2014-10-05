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
package com.topekalabs.java.utils;

import java.util.List;

public class ListUtils
{
    private ListUtils()
    {
    }
    
    public static void isEmpty(List list)
    {
        if(list.isEmpty())
        {
            throw new IllegalArgumentException("The given list cannot be empty.");
        }
    }
    
    public static void isEmpty(List list, String listName)
    {
        if(list.isEmpty())
        {
            throw new IllegalArgumentException("The given list " + listName + " cannot be empty.");
        }
    }
}
