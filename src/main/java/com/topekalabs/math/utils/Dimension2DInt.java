/* 
 * Copyright 2014 Topeka Labs.
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
package com.topekalabs.math.utils;

public class Dimension2DInt
{
    private int xCount;
    private float xCountFloat;
    private int xCountM1;
    private float xCountM1Float;
    private int xCountP1;
    private float xCountP1Float;
    private int yCount;
    private float yCountFloat;
    private int yCountM1;
    private float yCountM1Float;
    private int yCountP1;
    private float yCountP1Float;
    private int totalSize;
    private float totalSizeFloat;
    private int totalSizeM1;
    private float totalSizeM1Float;
    private int totalSizeP1;
    private float totalSizeP1Float;
    
    public Dimension2DInt(int xCount,
                          int yCount)
    {
        setXCount(xCount);
        setYCount(yCount);
        
        initialize();
    }
    
    private void initialize()
    {
        totalSize = xCount * yCount;
        totalSizeFloat = (float) totalSize;
        totalSizeM1 = xCountM1 * yCountM1;
        totalSizeM1Float = (float) totalSizeM1;
        totalSizeP1 = xCountP1 * yCountP1;
        totalSizeP1Float = (float) totalSizeP1;
    }
    
    private void setXCount(int xCount)
    {
        IntUtils.isPositive(xCount, "xCount");
        
        this.xCount = xCount;
        this.xCountFloat = (float) xCount;
        this.xCountM1 = xCount - 1;
        this.xCountM1Float = (float) xCountM1;
        this.xCountP1 = xCount + 1;
        this.xCountP1Float = (float) xCountP1Float;
    }
    
    public int getXCount()
    {
        return xCount;
    }
    
    public float getXCountFloat()
    {
        return xCountFloat;
    }
    
    public int getXCountM1()
    {
        return xCountM1;
    }
    
    public float getXCountM1Float()
    {
        return xCountM1Float;
    }
    
    public int getXCountP1()
    {
        return xCountP1;
    }
    
    public float getXCountP1Float()
    {
        return xCountP1Float;
    }
    
    private void setYCount(int yCount)
    {
        IntUtils.isPositive(yCount, "yCount");
        
        this.yCount = yCount;
        this.yCountFloat = (float) yCount;
        this.yCountM1 = yCount - 1;
        this.yCountM1Float = (float) yCountM1;
        this.yCountP1 = yCount + 1;
        this.yCountP1Float = (float) yCountP1;
    }
    
    public int getYCount()
    {
        return yCount;
    }
    
    public float getYCountFloat()
    {
        return yCountFloat;
    }
    
    public int getYCountM1()
    {
        return yCountM1;
    }
    
    public float getYCountM1Float()
    {
        return yCountM1Float;
    }
    
    public int getYCountP1()
    {
        return yCountP1;
    }
    
    public float getYCountP1Float()
    {
        return yCountP1Float;
    }
    
    public int getTotalSize()
    {
        return totalSize;
    }
    
    public float getTotalSizeFloat()
    {
        return totalSizeFloat;
    }
    
    public int getTotalSizeM1()
    {
        return totalSizeM1;
    }
    
    public float getTotalSizeM1Float()
    {
        return totalSizeM1Float;
    }
    
    public int getTotalSizeP1()
    {
        return totalSizeP1;
    }
    
    public float getTotalSizeP1Float()
    {
        return totalSizeP1Float;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if(object == null)
        {
            return false;
        }
        
        if(!(object instanceof Dimension2DInt))
        {
            return false;
        }
        
        Dimension2DInt dimension = (Dimension2DInt) object;
        
        return getXCount() == dimension.getXCount() &&
               getYCount() == dimension.getYCount();
    }
}
