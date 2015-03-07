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
import com.topekalabs.wrapper.utils.Mapper;

/**
 *
 * @author Topeka Labs
 */
public class FSM<OUTPUT_TYPE,
                 ORIGINAL_INPUT,
                 MAPPED_INPUT,
                 STATE_PAYLOAD>
{
    private State<STATE_PAYLOAD> currentState;
    private FSMDefinition<OUTPUT_TYPE,
                                 ORIGINAL_INPUT,
                                 MAPPED_INPUT,
                                 STATE_PAYLOAD> stateTransitionTable;
    private StateInputVector<MAPPED_INPUT,
                             STATE_PAYLOAD> tempStateInputVector = new StateInputVector<>();
    private Mapper<ORIGINAL_INPUT,
                   MAPPED_INPUT> inputMapper;
    
    public FSM(FSMDefinition<OUTPUT_TYPE,
                                    ORIGINAL_INPUT,
                                    MAPPED_INPUT,
                                    STATE_PAYLOAD> stateTransitionTable,
               Mapper<ORIGINAL_INPUT,
                      MAPPED_INPUT> inputMapper)
    {
        setStateTransitionTable(stateTransitionTable);
        setInputMapper(inputMapper);
        
        currentState = stateTransitionTable.getInitialState();
        entered(currentState,
                null,
                null,
                null);
    }
    
    private void setStateTransitionTable(FSMDefinition<OUTPUT_TYPE,
                                                              ORIGINAL_INPUT,
                                                              MAPPED_INPUT,
                                                              STATE_PAYLOAD> stateTransitionTable)
    {
        ExceptionUtils.isNullException(stateTransitionTable, "transitionTable");
        this.stateTransitionTable = stateTransitionTable;
    }
    
    private void setInputMapper(Mapper<ORIGINAL_INPUT,
                                       MAPPED_INPUT> inputMapper)
    {
        ExceptionUtils.isNullException(inputMapper, "inputMapper");
        this.inputMapper = inputMapper;
    }
    
    private void entered(State<STATE_PAYLOAD> state,
                         State<STATE_PAYLOAD> prevState,
                         ORIGINAL_INPUT originalInput,
                         MAPPED_INPUT mappedInput)
    {
        OutputFunction<OUTPUT_TYPE,
                       ORIGINAL_INPUT,
                       MAPPED_INPUT,
                       STATE_PAYLOAD> outputFunction = stateTransitionTable.getEnterFunction(state);
        
        if(outputFunction == null)
        {
            return;
        }
        
        outputFunction.output(state,
                              prevState,
                              originalInput,
                              mappedInput);
    }
    
    private void exited(State<STATE_PAYLOAD> state,
                        State<STATE_PAYLOAD> nextState,
                         ORIGINAL_INPUT originalInput,
                         MAPPED_INPUT mappedInput)
    {
        OutputFunction<OUTPUT_TYPE,
                       ORIGINAL_INPUT,
                       MAPPED_INPUT,
                       STATE_PAYLOAD> outputFunction = stateTransitionTable.getEnterFunction(state);
        
        if(outputFunction == null)
        {
            return;
        }
        
        outputFunction.output(state,
                              nextState,
                              originalInput,
                              mappedInput);
    }
            
    public void input(ORIGINAL_INPUT input)
    {
        MAPPED_INPUT mappedInput = inputMapper.map(input);
        tempStateInputVector.setVector(currentState, mappedInput);
        State<STATE_PAYLOAD> nextState = stateTransitionTable.getNextState(tempStateInputVector);
        
        exited(currentState,
               nextState,
               input,
               mappedInput);
        
        entered(nextState,
                currentState,
                input,
                mappedInput);
    }
}
