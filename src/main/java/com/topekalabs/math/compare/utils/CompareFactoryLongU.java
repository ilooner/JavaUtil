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

import com.topekalabs.math.utils.LongUtils;

/**
 *
 * @author Topeka Labs
 */
public class CompareFactoryLongU implements CompareFactoryLongInterface
{
    private static final CompareFactoryLongU instance = new CompareFactoryLongU();
    
    private CompareFactoryLongU()
    {
        //Do nothing
    }
    
    public static final CompareFactoryLongU getInstance()
    {
        return instance;
    }
    
    @Override
    public boolean lt(long a, long b)
    {
        return LongUtils.ult(a, b);
    }

    @Override
    public boolean lte(long a, long b)
    {
        return LongUtils.ulte(a, b);
    }

    @Override
    public boolean gt(long a, long b)
    {
        return LongUtils.ugt(a, b);
    }

    @Override
    public boolean gte(long a, long b)
    {
        return LongUtils.ugte(a, b);
    }

    @Override
    public boolean eq(long a, long b)
    {
        return a == b;
    }
}
