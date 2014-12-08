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

import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.operation.utils.BooleanOperation;
import java.io.File;
import java.util.Collection;
import org.apache.commons.io.filefilter.IOFileFilter;

/**
 *
 * @author Topeka Labs
 */
public class IOFileFilterCombinedBoolean extends IOFileFilterCombinedAbstract
{
    private BooleanOperation booleanOperation;
    
    public IOFileFilterCombinedBoolean(BooleanOperation booleanOperation,
                                       IOFileFilter... filters)
    {
        super(filters);
        setBooleanOperation(booleanOperation);
    }
    
    public IOFileFilterCombinedBoolean(BooleanOperation booleanOperation,
                                       Collection<IOFileFilter> filters)
    {
        super(filters);
        setBooleanOperation(booleanOperation);
    }
    
    private void setBooleanOperation(BooleanOperation booleanOperation)
    {
        ExceptionUtils.isNullException(booleanOperation, "booleanOperation");
        this.booleanOperation = booleanOperation;
    }
    
    @Override
    public boolean accept(File file)
    {
        if(filters.size() == 1)
        {
            return filters.get(0).accept(file);
        }
        
        boolean first = filters.get(0).accept(file);
        boolean second = filters.get(1).accept(file);
        
        boolean combined = booleanOperation.perform(first, second);
        
        for(int filterCounter = 2;
            filterCounter < filters.size();
            filterCounter++)
        {
            combined = booleanOperation.perform(combined,
                                                filters.get(filterCounter).accept(file));
        }
        
        return combined;
    }

    @Override
    public boolean accept(File file, String string)
    {
        if(filters.size() == 1)
        {
            return filters.get(0).accept(file, string);
        }
        
        boolean first = filters.get(0).accept(file, string);
        boolean second = filters.get(1).accept(file, string);
        
        boolean combined = booleanOperation.perform(first, second);
        
        for(int filterCounter = 2;
            filterCounter < filters.size();
            filterCounter++)
        {
            combined = booleanOperation.perform(combined,
                                                filters.get(filterCounter).accept(file,
                                                                                  string));
        }
        
        return combined;
    }
}
