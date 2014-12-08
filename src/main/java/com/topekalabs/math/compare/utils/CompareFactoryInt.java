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
package com.topekalabs.math.compare.utils;

/**
 *
 * @author Topeka Labs
 */
public class CompareFactoryInt implements CompareFactoryIntInterface
{
    private static final CompareFactoryInt instance = new CompareFactoryInt();
            
    private CompareFactoryInt()
    {
        //Do nothing
    }
    
    public static CompareFactoryInt getInstance()
    {
        return instance;
    }
    
    @Override
    public boolean lt(int a, int b)
    {
        return a < b;
    }
    
    @Override
    public boolean lte(int a, int b)
    {
        return a <= b;
    }
    
    @Override
    public boolean gt(int a, int b)
    {
        return a > b;
    }
    
    @Override
    public boolean gte(int a, int b)
    {
        return a >= b;
    }
    
    @Override
    public boolean eq(int a, int b)
    {
        return a == b;
    }
}
