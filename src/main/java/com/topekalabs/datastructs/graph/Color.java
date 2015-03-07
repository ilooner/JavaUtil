package com.topekalabs.datastructs.graph;

import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.utils.IntUtils;

public class Color<K> implements Comparable<Color>
{
    private K colorMarker;
    private int priority;
    
    public Color(K colorMarker,
                 int priority)
    {
        setColorMarker(colorMarker);
        setPriority(priority);
    }
    
    private void setColorMarker(K colorMarker)
    {
        ExceptionUtils.isNullException(colorMarker, "colorMarker");
        this.colorMarker = colorMarker;
    }
    
    public K getColorMarker()
    {
        return colorMarker;
    }
    
    private void setPriority(int priority)
    {
        IntUtils.isNonNegativeException(priority, "priority");
        this.priority = priority;
    }
    
    public int getPriority()
    {
        return priority;
    }

    public int compareTo(Color o)
    {
        return getPriority() - o.getPriority();
    }
    
    @Override
    public int hashCode()
    {
        return colorMarker.hashCode();
    }
    
    @Override
    public boolean equals(Object object)
    {
        if(!(object instanceof Color))
        {
            return false;
        }
        
        Color color = (Color) object;
        
        if(colorMarker.equals(color.getColorMarker()))
        {
            if(priority != color.getPriority())
            {
                ExceptionUtils.thisShouldNotHappen("Two colors with the same color marker cannot have different priority:\n" +
                                                   "Color Marker 1: " + colorMarker + "\n" +
                                                   "Priority 1: " + priority + "\n" +
                                                   "Color Marker 2: " + color.getColorMarker() + "\n" +
                                                   "Priority 2: " + color.getPriority());
            }
        }
        
        return false;
    }
}
