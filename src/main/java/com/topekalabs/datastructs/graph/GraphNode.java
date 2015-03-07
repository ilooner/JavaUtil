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
package com.topekalabs.datastructs.graph;

/**
 *
 * @author Topeka Labs
 */
public class GraphNode<PAYLOAD, COLOR_MARKER>
{
/*
    private T payLoad;
    private TreeSet<PriorityObject<COLOR_MARKER>>

    private Set<GraphNode<T, K>> neighbors = Sets.newHashSet();

    public Node(T payLoad,
                Color<K> color)
    {
        setPayLoad(payLoad);
        setColor(color);
    }

    private void setPayLoad(T payLoad)
    {
        ExceptionUtils.isNullException(payLoad, "payLoad");

        this.payLoad = payLoad;
    }

    public T getPayLoad()
    {
        return payLoad;
    }

    public void setColor(Color<K> color)
    {
        ExceptionUtils.isNullException(color, "color");

        this.color = color;
    }

    public Color<K> getColor()
    {
        return color;
    }

    public Set<Node<T, K>> getNeighbors()
    {
        return Sets.newHashSet(neighbors);
    }

    public Set<T> getNeighborPayloads()
    {
        Set<T> neighborPayloads = Sets.newHashSet();

        for(Node<T, K> node : neighbors)
        {
            neighborPayloads.add(node.getPayLoad());
        }

        return neighborPayloads;
    }

    public boolean isNeighbor(Node<T, K> node)
    {
        return neighbors.contains(node);
    }

    public boolean addNeighbor(Node<T, K> node)
    {
        return neighbors.add(node);
    }

    public boolean removeNeighbor(Node<T, K> node)
    {
        return neighbors.remove(node);
    }

    @Override
    public int hashCode()
    {
        return payLoad.hashCode();
    }

    @Override
    public boolean equals(Object object)
    {
        if(object == null)
        {
            return false;
        }

        if(!(object instanceof Node))
        {
            return false;
        }

        Node node = (Node) object;

        return payLoad.equals(node.getPayLoad());
    }*/
}
