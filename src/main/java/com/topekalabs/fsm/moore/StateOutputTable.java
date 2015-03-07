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
package com.topekalabs.fsm.moore;

import com.topekalabs.collection.utils.MapUtils;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Topeka Labs
 */
public class StateOutputTable<OUTPUT_TYPE, ORIGINAL_INPUT, MAPPED_INPUT, STATE_PAYLOAD>
{
    private Map<State<STATE_PAYLOAD>, OutputFunction<OUTPUT_TYPE,
                                                     ORIGINAL_INPUT,
                                                     MAPPED_INPUT,
                                                     STATE_PAYLOAD>> enterFunctions = MapUtils.newNNHashMap();
    private Map<State<STATE_PAYLOAD>, OutputFunction<OUTPUT_TYPE,
                                                     ORIGINAL_INPUT,
                                                     MAPPED_INPUT,
                                                     STATE_PAYLOAD>> exitFunctions = MapUtils.newNNHashMap();
    
    private OutputFunction<OUTPUT_TYPE,
                           ORIGINAL_INPUT,
                           MAPPED_INPUT,
                           STATE_PAYLOAD> globalEnterFunction;
    private OutputFunction<OUTPUT_TYPE,
                           ORIGINAL_INPUT,
                           MAPPED_INPUT,
                           STATE_PAYLOAD> globalExitFunction;
    
    
    public StateOutputTable()
    {
        //Do nothing
    }
    
    public void setGlobalEnterFunction(OutputFunction<OUTPUT_TYPE,
                                                      ORIGINAL_INPUT,
                                                      MAPPED_INPUT,
                                                      STATE_PAYLOAD> globalEnterFunction)
    {
        this.globalEnterFunction = globalEnterFunction;
    }
    
    public OutputFunction<OUTPUT_TYPE,
                          ORIGINAL_INPUT,
                          MAPPED_INPUT,
                          STATE_PAYLOAD> getGlobalEnterFunction()
    {
        return globalEnterFunction;
    }
                          
    
    public void setGlobalExitFunction(OutputFunction<OUTPUT_TYPE,
                                                     ORIGINAL_INPUT,
                                                     MAPPED_INPUT,
                                                     STATE_PAYLOAD> globalExitFunction)
    {
        this.globalExitFunction = globalExitFunction;
    }
    
    public OutputFunction<OUTPUT_TYPE,
                          ORIGINAL_INPUT,
                          MAPPED_INPUT,
                          STATE_PAYLOAD> getGlobalExitFunction()
    {
        return globalExitFunction;
    }
    
    public OutputFunction<OUTPUT_TYPE,
                          ORIGINAL_INPUT,
                          MAPPED_INPUT,
                          STATE_PAYLOAD> getEnterFunction(State<STATE_PAYLOAD> state)
    {
        return enterFunctions.get(state);
    }
                          
    public void setEnterFunction(State<STATE_PAYLOAD> state,
                                 OutputFunction<OUTPUT_TYPE,
                                                ORIGINAL_INPUT,
                                                MAPPED_INPUT,
                                                STATE_PAYLOAD> outputFunction)
    {
        enterFunctions.put(state, outputFunction);
    }
                          
    public OutputFunction<OUTPUT_TYPE,
                          ORIGINAL_INPUT,
                          MAPPED_INPUT,
                          STATE_PAYLOAD> getExitFunction(State<STATE_PAYLOAD> state)
    {
        return exitFunctions.get(state);
    }
                          
    public void setExitFunction(State<STATE_PAYLOAD> state,
                                OutputFunction<OUTPUT_TYPE,
                                               ORIGINAL_INPUT,
                                               MAPPED_INPUT,
                                               STATE_PAYLOAD> outputFunction)
    {
        exitFunctions.put(state, outputFunction);
    }
    
    protected Set<State<STATE_PAYLOAD>> getEnterFunctionsStateSet()
    {
        return enterFunctions.keySet();
    }
    
    protected Set<State<STATE_PAYLOAD>> getExitFunctionsStateSet()
    {
        return exitFunctions.keySet();
    }
}
