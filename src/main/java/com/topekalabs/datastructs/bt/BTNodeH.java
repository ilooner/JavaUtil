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

import com.topekalabs.math.utils.IntUtils;

/**
 *
 * @author Topeka Labs
 */
public class BTNodeH<T> extends AbstractBTNode<T, BTNodeH<T>>
{
    private int height;
    private int minLeafHeight;
    private int maxLeafHeight;

    public BTNodeH(T payload)
    {
        super(payload);
    }
    
    public BTNodeH(T payload,
                   BTNodeH<T> left,
                   BTNodeH<T> right)
    {
        super(payload,
              left,
              right);
    }
    
    @Override
    public void setLeft(BTNodeH<T> left)
    {
        super.setLeft(left);
        updateChildHeights(left);
        updateParentHeights(left);
    }
    
    @Override
    public void setRight(BTNodeH<T> right)
    {
        super.setRight(right);
        updateChildHeights(right);
        updateParentHeights(right);
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getMinLeafHeight()
    {
        return minLeafHeight;
    }
    
    public int getMaxLeafHeight()
    {
        return maxLeafHeight;
    }
    
    private void updateParentHeights(BTNodeH<T> child)
    {
        updateParentMinLeafHeight(child);
        updateParentMaxLeafHeight(child);
    }
    
    private void updateParentMinLeafHeight(BTNodeH<T> child)
    {
                if(child == null)
        {
            return;
        }
        
        /*BTNodeH<T> currentNode = this.;
        
        while(currentNode != null)
        {
            
        }*/
    }
    
    private void updateParentMaxLeafHeight(BTNodeH<T> child)
    {   
    }
    
    private void updateChildHeights(BTNodeH<T> child)
    {
        if(child == null)
        {
            return;
        }
        
        int currentHeight = height + 1;
        child.setHeights(currentHeight);
        
        updateChildHeights(child.getLeft());
        updateChildHeights(child.getRight());
    }
    
    private void setHeight(int height)
    {
        IntUtils.isNegativeException(height, "height");
        this.height = height;
    }
    
    private void setHeights(int height)
    {
        int diff = height - this.height;
        setHeight(height);
        minLeafHeight += diff;
        maxLeafHeight += diff;
    }
}
