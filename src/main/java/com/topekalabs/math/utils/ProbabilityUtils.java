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

public final class ProbabilityUtils
{
    public static final float PROBABILITY_EPSILON = .0001f;
    public static final FloatInterval VALID_PROBABILITY_SUM_INTERVAL = new FloatInterval(FloatInterval.FloatIntervalDefinitionType.StartAndEnd,
                                                                                         1.0f - PROBABILITY_EPSILON,
                                                                                         1.0f + PROBABILITY_EPSILON);
    public static final FloatInterval VALID_PROBABILITY_INTERVAL = new FloatInterval(FloatInterval.FloatIntervalDefinitionType.StartAndEnd,
                                                                                     0.0f,
                                                                                     1.0f);
            
    private ProbabilityUtils()
    {
    }
    
    public static boolean isValidProbabilitySum(float probabillity)
    {
        return VALID_PROBABILITY_SUM_INTERVAL.isInIntervalInclusive(probabillity);
    }
    
    public static boolean isValidProbability(float probability)
    {
        return VALID_PROBABILITY_INTERVAL.isInIntervalInclusive(probability);
    }
}
