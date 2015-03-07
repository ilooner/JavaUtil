/*
 * Copyright 2015 Topeka Labs.
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

import com.topekalabs.error.utils.ExceptionUtils;
import java.util.Comparator;

/**
 *
 * @author Topeka Labs
 */
public class CompareFactoryObjectComparator<OBJECT> implements CompareFactoryObjectInterface<OBJECT>
{
    private Comparator<OBJECT> comparator;
    
    public CompareFactoryObjectComparator(Comparator<OBJECT> comparator)
    {
        setComparator(comparator);
    }
    
    private void setComparator(Comparator<OBJECT> comparator)
    {
        ExceptionUtils.isNullException(comparator, "comparator");
        this.comparator = comparator;
    }

    @Override
    public boolean lt(OBJECT a, OBJECT b)
    {
        return comparator.compare(a, b) < 0;
    }

    @Override
    public boolean lte(OBJECT a, OBJECT b)
    {
        return comparator.compare(a, b) <= 0;
    }

    @Override
    public boolean gt(OBJECT a, OBJECT b)
    {
        return comparator.compare(a, b) > 0;
    }

    @Override
    public boolean gte(OBJECT a, OBJECT b)
    {
        return comparator.compare(a, b) >= 0;
    }

    @Override
    public boolean eq(OBJECT a, OBJECT b)
    {
        return comparator.compare(a, b) == 0;
    }

    @Override
    public int compareTo(OBJECT a, OBJECT b)
    {
        return comparator.compare(a, b);
    }
}
