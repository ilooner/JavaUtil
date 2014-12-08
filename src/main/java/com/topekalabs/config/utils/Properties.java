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
package com.topekalabs.config.utils;

import com.google.common.collect.Maps;
import com.topekalabs.collection.utils.MapUtils;
import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.java.utils.ObjectUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Topeka Labs
 */
public class Properties implements Cloneable
{
    Map<String, String> map = Maps.newHashMap();
    
    public Properties()
    {
        //Do nothing
    }
    
    private Properties(Map<String, String> map)
    {
        MapUtils.isPopulatedException(map);
        this.map = MapUtils.shallowClone(map);
    }
    
    public Set<String> getProperties()
    {
        return map.keySet();
    }
    
    public void setProperty(String property,
                            String value)
    {
        ExceptionUtils.isNullException(property, "property");
        ExceptionUtils.isNullException(value, "value");
        
        ExceptionUtils.thisShouldNotHappen(map.containsKey(property),
                                           "The given key is already contained in the properties");
    }
    
    public String getProperty(String key)
    {
        ExceptionUtils.isNullException(key, "key");
        
        String value = map.get(key);
        
        ExceptionUtils.thisShouldNotHappen(ObjectUtils.isNull(value),
                                           "The given key is not contained in the properties.");
        
        return value;
    }
    
    @Override
    public Properties clone()
    {
        return new Properties(map);
    }
}
