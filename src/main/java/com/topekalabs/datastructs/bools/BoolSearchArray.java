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
package com.topekalabs.datastructs.bools;

import com.topekalabs.datastructs.btree.BTreeSimpleBoolean;
import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.compare.utils.MatchCriteria;
import com.topekalabs.math.utils.IntUtils;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author Topeka Labs
 */
public class BoolSearchArray<T>
{
    public static final int DEFAULT_B = 128;
    
    private final T[] array;
    private MatchCriteria mc;
    private BTreeSimpleBoolean boolst;
    
    public BoolSearchArray(Class<T> clazz, int size, MatchCriteria mc)
    {
        this(clazz, size, mc, null, DEFAULT_B);
    }

    public BoolSearchArray(Class<T> clazz, int size, MatchCriteria mc, int b)
    {
        this(clazz, size, mc, null, b);
    }
    
    public BoolSearchArray(Class<T> clazz, int size, MatchCriteria mc, T fill)
    {
        this(clazz, size, mc, fill, DEFAULT_B);
    }
    
    public BoolSearchArray(Class<T> clazz, int size, MatchCriteria mc, T fill, int b)
    {
        IntUtils.isNonPositiveException(size, "size");
        array = (T[]) Array.newInstance(clazz, size);
        setMatchCriteria(mc);
        
        if(fill != null)
        {
            Arrays.fill(array, fill);
        }
        
        ExceptionUtils.illegal(b < 2, "The b tree b size must be atleast 2.");
        boolst = new BTreeSimpleBoolean(BTreeSimpleBoolean.ConstructorType.NUM_LEAVES,
                                        b,
                                        size,
                                        mc.match(fill));
    }
    
    private void setMatchCriteria(MatchCriteria mc)
    {
        ExceptionUtils.isNullException(mc, "mc");
        this.mc = mc;
    }
    
    public T get(int index)
    {
        return array[index];
    }
    
    public void set(int index, T value)
    {
        array[index] = value;
        int leafIndex = index / boolst.getB();
        
        boolean match = mc.match(value);
        int nodeId = boolst.getLeafId(leafIndex);
        
        if(match)
        {
            for(;
                (nodeId >= 0) &&
                !boolst.getNodeValue(nodeId);
                nodeId = boolst.getParentId(nodeId))
            {
                boolst.setNodeValue(nodeId, true);
            }
        }
        else
        {
            if(boolst.getNodeValue(nodeId))
            {
                int arrayIndex = leafIndex * boolst.getB();
                
                int maxIndex =
                com.topekalabs.array.utils.ArrayUtils.truncateIndexOverflow(
                arrayIndex + boolst.getB() - 1,
                arrayIndex);
                
                boolean atleastOneTrue = false;
                
                for(int currentIndex = arrayIndex;
                    currentIndex <= maxIndex;
                    currentIndex++)
                {
                    atleastOneTrue = atleastOneTrue ||
                                     mc.match(array[currentIndex]);
                }
                
                while(!atleastOneTrue)
                {
                    boolst.setNodeValue(nodeId, false);
                    nodeId = boolst.getParentId(nodeId);
                    
                    if(nodeId < 0 ||
                       !boolst.getNodeValue(nodeId))
                    {
                        break;
                    }
                    
                    int numChildren = boolst.getNumChildren(nodeId);
                    atleastOneTrue = false;
                    
                    for(int childCounter = 0;
                        childCounter < numChildren;
                        childCounter++)
                    {
                        int childId = boolst.getChildId(nodeId, childCounter);
                        atleastOneTrue = atleastOneTrue ||
                                         mc.match(array[childId]);
                    }
                }
            }
        }
    }
    
    public int getMatchIndex()
    {
        int currentNodeId = 0;
        
        if(!boolst.getNodeValue(currentNodeId))
        {
            return -1;
        }
        
        {
            int numChildren;

            while((numChildren = boolst.getNumChildren(currentNodeId)) != 0)
            {
                int firstChildId = boolst.getChildId(currentNodeId, 0);
                int childId = 0;

                for(int childCounter = 0;
                    childCounter < numChildren;
                    childCounter++)
                {
                    childId = firstChildId + childCounter;
                    boolean val = boolst.getNodeValue(childId);

                    if(val)
                    {
                        break;
                    }
                }

                currentNodeId = childId;
            }
        }
        
        int leafIndex = currentNodeId - boolst.getFirstLeafId();
        int arrayIndex = leafIndex * boolst.getB();
        
        int maxIndex =
        com.topekalabs.array.utils.ArrayUtils.truncateIndexOverflow(
        arrayIndex + boolst.getB() - 1,
        arrayIndex);
        
        int currentIndex;

        for(currentIndex = arrayIndex;
            (currentIndex <= maxIndex)
            && (!mc.match(array[currentIndex]));
            currentIndex++)
        {
        }
        
        return currentIndex;
    }
}
