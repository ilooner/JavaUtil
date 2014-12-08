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
package com.topekalabs.file.utils;

import com.google.common.collect.Lists;
import com.topekalabs.collection.utils.CollectionUtils;
import com.topekalabs.collection.utils.ListUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.filefilter.IOFileFilter;

/**
 *
 * @author Topeka Labs
 */
public abstract class IOFileFilterCombinedAbstract implements IOFileFilter
{
    protected List<IOFileFilter> filters;
    
    public IOFileFilterCombinedAbstract(IOFileFilter... filters)
    {
        List<IOFileFilter> tempFilters = Arrays.asList(filters);
        setFilters(tempFilters);
    }
    
    public IOFileFilterCombinedAbstract(Collection<IOFileFilter> filters)
    {
        List<IOFileFilter> tempFilters = Lists.newArrayList();
        tempFilters.addAll(filters);
        setFilters(tempFilters);
    }
    
    private void setFilters(List<IOFileFilter> filters)
    {
        CollectionUtils.isNotPopulatedException(filters, "filters");
        ListUtils.listContainsDuplicateReferencesException(filters, "filters");
        
        this.filters = filters;
    }
}
