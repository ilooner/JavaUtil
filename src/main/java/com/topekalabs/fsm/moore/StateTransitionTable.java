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
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Topeka Labs
 */
public class StateTransitionTable<STATE_PAYLOAD, MAPPED_INPUT>
{
    private State<STATE_PAYLOAD> initialState;
    private Map<StateInputVector<MAPPED_INPUT,
                                 STATE_PAYLOAD>,
                                 State<STATE_PAYLOAD>> transitionMap = MapUtils.newNNHashMap();
    
    public StateTransitionTable()
    {
        //Do nothing
    }
    
    public State<STATE_PAYLOAD> getInitialState()
    {
        return initialState;
    }
    
    public void setInitialState(State<STATE_PAYLOAD> initialState)
    {
        this.initialState = initialState;
    }
    
    public State<STATE_PAYLOAD> getNextState(StateInputVector<MAPPED_INPUT,
                                                              STATE_PAYLOAD> stateInputVector)
    {
        return transitionMap.get(stateInputVector);
    }
    
    public void addTransition(StateInputVector<MAPPED_INPUT,
                                               STATE_PAYLOAD> stateInputVector,
                              State<STATE_PAYLOAD> state)
    {
        transitionMap.put(stateInputVector, state);
    }
    
    protected Collection<State<STATE_PAYLOAD>> getStates()
    {
        return transitionMap.values();
    }
}
