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

import com.topekalabs.error.utils.ExceptionUtils;
import java.util.Collection;

/**
 *
 * @author Topeka Labs
 */
public class FSMDefinition<OUTPUT_TYPE,
                           ORIGINAL_INPUT,
                           MAPPED_INPUT,
                           STATE_PAYLOAD>
{
    private StateTransitionTable<STATE_PAYLOAD, MAPPED_INPUT> stateTransitionTable;
    private StateOutputTable<OUTPUT_TYPE,
                             ORIGINAL_INPUT,
                             MAPPED_INPUT,
                             STATE_PAYLOAD> stateOutputTable;
    
    
    public FSMDefinition(StateTransitionTable<STATE_PAYLOAD, MAPPED_INPUT> stateTransitionTable,
                         StateOutputTable<OUTPUT_TYPE,
                                          ORIGINAL_INPUT,
                                          MAPPED_INPUT,
                                          STATE_PAYLOAD> stateOutputTable)
    {
        setStateTransitionTable(stateTransitionTable);
        setStateOutputTable(stateOutputTable);
        
        initialize();
    }
    
    private void initialize()
    {
        Collection<State<STATE_PAYLOAD>> states = stateTransitionTable.getStates();
        
        if(!states.contains(stateTransitionTable.getInitialState()))
        {
            ExceptionUtils.illegal("Transition table doesn't contain the initial state");
        }
        
        if(!states.containsAll(stateOutputTable.getEnterFunctionsStateSet()))
        {
            ExceptionUtils.illegal("Transition table doesn't contain all the states that have an enter function assigned.");
        }
        
        if(!states.containsAll(stateOutputTable.getExitFunctionsStateSet()))
        {
            ExceptionUtils.illegal("Transition table doesn't contain all the states that have an exit function assigned.");
        }
    }
    
    private void setStateTransitionTable(StateTransitionTable<STATE_PAYLOAD, MAPPED_INPUT> stateTransitionTable)
    {
        ExceptionUtils.isNullException(stateTransitionTable, "stateTransitionTable");
        this.stateTransitionTable = stateTransitionTable;
    }
    
    private void setStateOutputTable(StateOutputTable<OUTPUT_TYPE,
                                                      ORIGINAL_INPUT,
                                                      MAPPED_INPUT,
                                                      STATE_PAYLOAD> stateOutputTable)
    {
        ExceptionUtils.isNullException(stateOutputTable, "stateOutputTable");
        this.stateOutputTable = stateOutputTable;
    }

    public OutputFunction<OUTPUT_TYPE,
                          ORIGINAL_INPUT,
                          MAPPED_INPUT,
                          STATE_PAYLOAD> getGlobalEnterFunction()
    {
        return stateOutputTable.getGlobalEnterFunction();
    }
    
    public OutputFunction<OUTPUT_TYPE,
                          ORIGINAL_INPUT,
                          MAPPED_INPUT,
                          STATE_PAYLOAD> getGlobalExitFunction()
    {
        return stateOutputTable.getGlobalExitFunction();
    }
    
    public OutputFunction<OUTPUT_TYPE,
                          ORIGINAL_INPUT,
                          MAPPED_INPUT,
                          STATE_PAYLOAD> getEnterFunction(State<STATE_PAYLOAD> state)
    {
        return stateOutputTable.getEnterFunction(state);
    }
    
    public OutputFunction<OUTPUT_TYPE,
                          ORIGINAL_INPUT,
                          MAPPED_INPUT,
                          STATE_PAYLOAD> getExitFunction(State<STATE_PAYLOAD> state)
    {
        return stateOutputTable.getExitFunction(state);
    }
     
    public State<STATE_PAYLOAD> getInitialState()
    {
        return stateTransitionTable.getInitialState();
    }
    
    public State<STATE_PAYLOAD> getNextState(StateInputVector<MAPPED_INPUT,
                                                              STATE_PAYLOAD> stateInputVector)
    {
        return stateTransitionTable.getNextState(stateInputVector);
    }
}
