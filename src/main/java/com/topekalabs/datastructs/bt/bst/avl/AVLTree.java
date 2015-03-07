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
package com.topekalabs.datastructs.bt.bst.avl;

import com.topekalabs.datastructs.bt.BTNodeH;
import com.topekalabs.datastructs.bt.bst.AbstractBST;
import com.topekalabs.java.utils.ObjectUtils;
import com.topekalabs.wrapper.utils.WrapperObject;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Topeka Labs
 */
public abstract class AVLTree<OBJECT> extends AbstractBST<OBJECT>
{
    private BTNodeH<OBJECT> root;
    private FirstParentResult firstParentResult;
    
    @Override
    public boolean add(OBJECT object)
    {
        findParent(object);
        
        if(!firstParentResult.valid)
        {
            return false;
        }
        
        //BTNode
        firstParentResult.value.getHeight();
        
        return true;
    }

    @Override
    public boolean addAll(Collection<OBJECT> objects)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(OBJECT object)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<OBJECT> objects)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(OBJECT object)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count(OBJECT object)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OBJECT> getLT(OBJECT object)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OBJECT> getLTE(OBJECT object)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OBJECT> getGT(OBJECT object)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OBJECT> getGTE(OBJECT object)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void findParent(OBJECT object)
    {
        BTNodeH<OBJECT> currentNode = root;
        
        while(!ObjectUtils.isNull(currentNode))
        {
            int cval = cf.compareTo(object, currentNode.getPayload());
            
            if(cval == 0)
            {
                //findParentResult.value = null;
                //findParentResult.valid = false;
                return;
            }
            
            BTNodeH<OBJECT> nextNode;
            
            if(cval < 0)
            {
                nextNode = currentNode.getLeft();
            }
            else
            {
                nextNode = currentNode.getRight();
            }
            
            if(nextNode == null)
            {
                break;
            }
            
            currentNode = nextNode;
        }
        
        //findParentResult.value = currentNode;
        //findParentResult.valid = true;
    }
    
    private class FirstParentResult extends WrapperObject<BTNodeH<OBJECT>>
    {
        public int compVal;
    }
}
