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
package com.topekalabs.datastructs.bt;

import com.topekalabs.error.utils.ExceptionUtils;

/**
 *
 * @author Topeka Labs
 */
public abstract class AbstractBTNode<T, NODE_TYPE extends AbstractBTNode>
{
    private T payload;
    private NODE_TYPE parent;
    private NODE_TYPE left;
    private NODE_TYPE right;

    public AbstractBTNode(T payload)
    {
        setPayloadPri(payload);
    }
    
    public AbstractBTNode(T payload,
                          NODE_TYPE left,
                          NODE_TYPE right)
    {
        setPayloadPri(payload);
        setLeft(left);
        setRight(right);
    }
    
    private void setPayloadPri(T payload)
    {
        ExceptionUtils.isNullException(payload, "payload");
        this.payload = payload;
    }
    
    public void setPayload(T payload)
    {
        setPayloadPri(payload);
    }
    
    public T getPayload()
    {
        return payload;
    }
    
    private void setParentPri(NODE_TYPE parent)
    {
        ExceptionUtils.isNullException(parent, "parent");
        this.parent = parent;
    }
    
    public void setParent(NODE_TYPE parent)
    {
        setParentPri(parent);
    }
    
    public NODE_TYPE getParent()
    {
        return parent;
    }
    
    public void setLeft(NODE_TYPE left)
    {
        if(left == null)
        {
            this.left = null;
            return;
        }
        
        if(left.getParent() != null)
        {
            left.getParent().setLeft(null);
        }
        
        left.setParent(this);
        this.left = left;
    }
    
    public NODE_TYPE getLeft()
    {
        return left;
    }
    
    public void setRight(NODE_TYPE right)
    {
        if(right == null)
        {
            this.right = null;
            return;
        }
        
        if(right.getParent() != null)
        {
            right.getParent().setRight(null);
        }
        
        right.setParent(this);
        this.right = right;
    }
    
    public NODE_TYPE getRight()
    {
        return right;
    }
}
