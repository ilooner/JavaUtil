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
import java.util.Random;

public class RandomBoolean implements RandomObjectGenerator<Boolean>
{
    private float trueProbability;
    
    public RandomBoolean(float trueProbability)
    {
        setTrueProbability(trueProbability);
    }
    
    private void setTrueProbability(float trueProbability)
    {
        ProbabilityUtils.isValidProbability(trueProbability);
        
        this.trueProbability = trueProbability;
    }
    
    public Boolean getRandom(Random random) 
    {
        return random.nextFloat() <= trueProbability;
    }
}
