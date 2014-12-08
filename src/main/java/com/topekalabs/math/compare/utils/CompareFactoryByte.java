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
public class CompareFactoryByte implements CompareFactoryByteInterface
{
    private static final CompareFactoryByte instance = new CompareFactoryByte();
    
    private CompareFactoryByte()
    {
        //Do nothing
    }
    
    public static CompareFactoryByte getInstance()
    {
        return instance;
    }
    
    @Override
    public boolean lt(byte a, byte b)
    {
        return a < b;
    }

    @Override
    public boolean lte(byte a, byte b)
    {
        return a <= b;
    }

    @Override
    public boolean gt(byte a, byte b)
    {
        return a > b;
    }

    @Override
    public boolean gte(byte a, byte b)
    {
        return a >= b;
    }

    @Override
    public boolean eq(byte a, byte b)
    {
        return a == b;
    }
}