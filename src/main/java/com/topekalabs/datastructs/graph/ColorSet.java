package com.topekalabs.datastructs.graph;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.topekalabs.collection.utils.CollectionUtils;
import com.topekalabs.error.utils.ExceptionUtils;
import com.topekalabs.math.utils.IntUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ColorSet<K>
{
    List<Color<K>> colorList = Lists.newArrayList();
    Map<K, Integer> markerToPriority = Maps.newHashMap();
    Map<K, Color<K>> markerToColor = Maps.newHashMap();
    
    public ColorSet(Color<K>... colors)
    {
        List<Color<K>> colorList = Lists.newArrayList();
        colorList.addAll(Arrays.asList(colors));
        setColors(colorList);
    }
    
    public ColorSet(Collection<Color<K>> colors)
    {
        setColors(colors);
    }
    
    private void setColors(Collection<Color<K>> colors)
    {
        CollectionUtils.isNotPopulatedException(colors, "colors");
        
        Set<Integer> priorities = Sets.newHashSet();
        Set<K> colorMarker = Sets.newHashSet();
        
        for(Color<K> color: colors)
        {
            if(!priorities.add(color.getPriority()))
            {
                throw new IllegalArgumentException("Cannot have multiple colors with the same priority.");
            }
            
            if(!colorMarker.add(color.getColorMarker()))
            {
                throw new IllegalArgumentException("Cannot have multiple colors with the same marker.");
            }
            
            colorList.add(color);
            markerToPriority.put(color.getColorMarker(), color.getPriority());
            markerToColor.put(color.getColorMarker(), color);
        }
        
        Collections.sort(colorList);
    }
    
    public boolean contains(K colorMarker)
    {
        return markerToPriority.containsKey(colorMarker);
    }
    
    public int getMaxPriority()
    {
        return colorList.size() - 1;
    }
    
    public K getColorMarker(int priority)
    {
        IntUtils.isNonNegativeException(priority, "priority");
        
        if(priority > getMaxPriority())
        {
            throw new IllegalArgumentException("The given priority is larger than the maximum priority");
        }
        
        return colorList.get(priority).getColorMarker();
    }
    
    public int getPriority(K colorMarker)
    {
        ExceptionUtils.isNullException(colorMarker, "colorMarker");
        containsException(colorMarker);
        
        return markerToPriority.get(colorMarker);
    }
    
    public Color<K> getColor(K colorMarker)
    {
        ExceptionUtils.isNullException(colorMarker, "colorMarker");
        containsException(colorMarker);
        
        return markerToColor.get(colorMarker);
    }
    
    private void containsException(K colorMarker)
    {
        if(!contains(colorMarker))
        {
            throw new IllegalArgumentException("The given color marker is not in this set.");
        }
    }
}
