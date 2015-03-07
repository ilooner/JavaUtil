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
package com.topekalabs.datastructs.btree;

import com.topekalabs.collection.utils.CollectionUtils;
import com.topekalabs.collection.utils.ListUtils;
import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.utils.DiscreteMathInt;
import com.topekalabs.math.utils.IntUtils;
import it.unimi.dsi.fastutil.booleans.BooleanArrayList;
import java.util.Collections;

/**
 *
 * @author Topeka Labs
 */
public class BTreeSimpleBoolean
{
    private final BooleanArrayList dataList;
    private int b;
    
    private int firstLeafId = -1;
    
    public enum ConstructorType
    {
        SIZE,
        NUM_LEAVES;
    }
    
    public BTreeSimpleBoolean(int b)
    {
        dataList = new BooleanArrayList();
    }
    
    public BTreeSimpleBoolean(ConstructorType ct, int b, int num)
    {
        this(ct, b, num, false);
    }
    
    public BTreeSimpleBoolean(ConstructorType ct, int b, int num, boolean fill)
    {
        if(ct != ConstructorType.SIZE &&
           ct != ConstructorType.NUM_LEAVES)
        {
            ExceptionUtils.thisShouldNotHappen();
        }
        
        if(ct == ConstructorType.NUM_LEAVES)
        {
            num = DiscreteMathInt.treeSumInclusive(num, b);
        }
        
        dataList = new BooleanArrayList(num);
        setB(b);
        
        if(!fill)
        {
            CollectionUtils.fillEmptyCollection(dataList, fill, num);
        }
        
        change();
    }
    
    private void setB(int b)
    {
        IntUtils.isNonPositiveException(b, "b");
        this.b = b;
    }
    
    public int getB()
    {
        return b;
    }
    
    public boolean isEmpty()
    {
        return dataList.isEmpty();
    }
    
    public int size()
    {
        return dataList.size();
    }
    
    public int append(boolean value)
    {
        int nodeId = dataList.size();
        dataList.add(value);
        change();
        return nodeId;
    }
    
    public void remove()
    {
        ListUtils.removeLast(dataList);
        change();
    }
    
    public boolean getNodeValue(int nodeId)
    {
        return dataList.get(nodeId);
    }
    
    public void setNodeValue(int nodeId, boolean value)
    {
        dataList.set(nodeId, value);
    }
    
    public void swap(int nodeIdA, int nodeIdB)
    {
        Collections.swap(dataList, nodeIdA, nodeIdB);
    }
    
    public int getChildId(int nodeId, int childNumber)
    {
        invalidNodeIdException(nodeId);
        invalidChildNumberException(getNumChildren(nodeId),
                                    childNumber);
        
        return nodeId * b + childNumber + 1;
    }
    
    public int getNumChildren(int nodeId)
    {
        invalidNodeIdException(nodeId);
        
        int lastChildId = nodeId + b;
        int diff = (dataList.size() - 1) - lastChildId;
        
        if(diff > 0)
        {
            return b - diff;
        }
        else
        {
            return 0;
        }
    }
    
    public int getParentId(int nodeId)
    {
        invalidNodeIdException(nodeId);
        
        if(nodeId == 0)
        {
            return -1;
        }
        
        return (nodeId - 1) / b;
    }
    
    private void invalidNodeIdException(int nodeId)
    {
        ExceptionUtils.illegal(nodeId >= dataList.size(),
                               "The nodeId " + nodeId +
                               " must be less than the size of the tree" +
                               dataList.size() + ".");
    }
    
    private void invalidChildNumberException(int numChildren,
                                             int childNumber)
    {
        ExceptionUtils.illegal(childNumber >= numChildren,
                               "The child number " + childNumber +
                               " must be less than the " + numChildren);
    }
    
    public int getFirstLeafId()
    {
        return firstLeafId;
    }
    
    public int getNumLeaves()
    {
        return dataList.size() - firstLeafId;
    }
    
    public boolean getLeafValue(int leafIndex)
    {
        IntUtils.isNegativeException(leafIndex, "leafIndex");
        return dataList.get(firstLeafId + leafIndex);
    }
    
    public int getLeafId(int leafIndex)
    {
        return firstLeafId + leafIndex;
    }
    
    public void setLeafValue(int leafIndex, boolean val)
    {
        dataList.set(firstLeafId + leafIndex, val);
    }
    
    private void change()
    {
        if(dataList.isEmpty())
        {
            firstLeafId = -1;
        }
        
        if(dataList.size() == 1)
        {
            firstLeafId = 0;
        }
        
        int pow = DiscreteMathInt.logCeil(dataList.size(), b) - 1;
        firstLeafId = DiscreteMathInt.powerSum(b, pow);
    }
}