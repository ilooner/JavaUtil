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
package com.topekalabs.math.operation.utils;

/**
 *
 * @author Topeka Labs
 */
public class BooleanOperationAnd implements BooleanOperation
{
    private static final BooleanOperationAnd instance = new BooleanOperationAnd();
    
    private BooleanOperationAnd()
    {
    }
    
    public static BooleanOperationAnd getInstance()
    {
        return instance;
    }
    
    @Override
    public boolean perform(boolean a, boolean b)
    {
        return a && b;
    } 
}
