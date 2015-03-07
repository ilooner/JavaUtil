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
import java.util.Objects;

/**
 *
 * @author Topeka Labs
 */
public class StateInputVector<MAPPED_INPUT,
                              STATE_PAYLOAD>
{
    private State<STATE_PAYLOAD> state;
    private MAPPED_INPUT mappedInput;
    
    public StateInputVector()
    {
        //Do nothing
    }
    
    public StateInputVector(State<STATE_PAYLOAD> state,
                            MAPPED_INPUT mappedInput)
    {
        setVectorPri(state,
                     mappedInput);
    }
    
    private void setVectorPri(State<STATE_PAYLOAD> state,
                              MAPPED_INPUT mappedInput)
    {
        ExceptionUtils.isNullException(state, "state");
        ExceptionUtils.isNullException(mappedInput, "mappedInput");
        
        this.state = state;
        this.mappedInput = mappedInput;
    }
    
    public void setVector(State<STATE_PAYLOAD> state,
                          MAPPED_INPUT mappedInput)
    {
        setVectorPri(state,
                     mappedInput);
    }
    
    public State<STATE_PAYLOAD> getState()
    {
        return state;
    }
    
    public MAPPED_INPUT getMappedInput()
    {
        return mappedInput;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.state);
        hash = 79 * hash + Objects.hashCode(this.mappedInput);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(getClass() != obj.getClass())
        {
            return false;
        }
        final StateInputVector<?, ?> other = (StateInputVector<?, ?>) obj;
        if(!Objects.equals(this.state, other.state))
        {
            return false;
        }
        if(!Objects.equals(this.mappedInput, other.mappedInput))
        {
            return false;
        }
        return true;
    }
}
