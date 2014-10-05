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
package com.topekalabs.math.utils;

import com.topekalabs.java.utils.ExceptionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FloatIntervalGroups
{
    private FloatIntervalGroup[] floatIntervalGroups = null;
    private List<FloatInterval> floatIntervalProbabilityGroups = new ArrayList<FloatInterval>();
    
    public FloatIntervalGroups(FloatIntervalGroup... floatIntervalGroups)
    {
        setFloatIntervalGroups(floatIntervalGroups);
    }
    
    private void setFloatIntervalGroups(FloatIntervalGroup[] floatIntervalGroups)
    {
        ExceptionUtils.isNull(floatIntervalGroups, "terrainGeneratorObstacles");
        ExceptionUtils.arrayIsEmpty(floatIntervalGroups, "terrainGeneratorObstacles");
        
        Arrays.sort(floatIntervalGroups, FloatIntervalGroupProbabilityComparator.getInstance());
        
        float sum = 0.0f;
        float startInterval = 0.0f;
        
        for(int groupCounter = 0;
            groupCounter < floatIntervalGroups.length;
            groupCounter++)
        {
            startInterval = sum;
            FloatIntervalGroup floatIntervalGroup = floatIntervalGroups[groupCounter];
            
            ExceptionUtils.isNull(floatIntervalGroup, "floatIntervalGroup");
            
            sum += floatIntervalGroup.getProbability();
            float tempSum = sum;
            
            if(groupCounter == floatIntervalGroups.length - 1)
            {
                tempSum = 1.0f;
            }
            
            floatIntervalProbabilityGroups.add(new FloatInterval(FloatInterval.FloatIntervalDefinitionType.StartAndEnd,
                                                                 startInterval,
                                                                 tempSum));
        }
        
        if(!ProbabilityUtils.isValidProbabilitySum(sum))
        {
            throw new IllegalArgumentException("The probabilities must sum to 1.0 not: " + sum);
        }
        
        this.floatIntervalGroups = floatIntervalGroups;
    }
    
    public float generateRandomFloat(Random random)
    {
        float value = random.nextFloat();
        int intervalCounter;
        
        for(intervalCounter = 0;
            intervalCounter < floatIntervalGroups.length;
            intervalCounter++)
        {
            FloatInterval floatInterval = floatIntervalProbabilityGroups.get(intervalCounter);
            
            if(floatInterval.isInIntervalInclusive(value))
            {
                break;
            }
        }
        
        FloatIntervalGroup floatIntervalGroup = floatIntervalGroups[intervalCounter];
        
        return floatIntervalGroup.getFloatInterval().getRandom(random);
    }
}
