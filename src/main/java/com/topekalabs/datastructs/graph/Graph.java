package com.topekalabs.datastructs.graph;

public class Graph<T, K>
{
    /*
    Map<T, Node<T, K>> payLoadToNode = Maps.newHashMap();
    
    public Graph()
    {
    }
    
    public boolean contains(T payLoad)
    {
        return payLoadToNode.containsKey(payLoad);
    }
    
    private void containsException(T payLoad)
    {
        if(!contains(payLoad))
        {
            throw new IllegalArgumentException("The given payLoad is not in the graph.");
        }
    }
    
    public boolean add(T payLoad,
                       K colorMarker)
    {
        ExceptionUtils.isNullException(payLoad, "payLoad");
        
        if(contains(payLoad))
        {
           return false; 
        }
        
        payLoadToNode.put(payLoad, new Node(payLoad);
        
        return true;
    }
    
    public K getColor(T payLoad)
    {
        containsException(payLoad);
        
        return payLoadToNode.get(payLoad).getColor().getColorMarker();
    }
    
    public Set<T> matchConnected(T payLoad,
                                 MatchCriteria<T> matchCriteria)
    {
        ExceptionUtils.isNullException(payLoad);
        ExceptionUtils.isNullException(matchCriteria);
        
        containsException(payLoad);
        
        Set<T> traversedSet = Sets.newHashSet();
        Set<T> matchSet = Sets.newHashSet();
        
        matchConnectedHelper(payLoad,
                             matchCriteria,
                             matchSet,
                             traversedSet);
        
        return matchSet;
    }
    
    private void matchConnectedHelper(T payLoad,
                                      MatchCriteria<T> matchCriteria,
                                      Set<T> matchSet,
                                      Set<T> traversedSet)
    {
        if(traversedSet.contains(payLoad))
        {
            return;
        }
        
        traversedSet.add(payLoad);
        
        if(matchCriteria.match(payLoad))
        {
            matchSet.add(payLoad);
        }
        
        Set<T> neighborPayLoads = payLoadToNode.get(payLoad).getNeighborPayloads();
        
        for(T neighborPayLoad: neighborPayLoads)
        {
            matchConnectedHelper(payLoad,
                                 matchCriteria,
                                 matchSet,
                                 traversedSet);
        }
    }
    
    public boolean remove(T payLoad)
    {
        ExceptionUtils.isNullException(payLoad, "payLoad");
        
        Node<T, K> node = payLoadToNode.get(payLoad);
        
        if(node == null)
        {
            return false;
        }
        
        Set<Node<T, K>> neighbors = node.getNeighbors();
        
        for(Node nodeNeighbor: neighbors)
        {
            nodeNeighbor.removeNeighbor(node);
        }
        
        payLoadToNode.remove(payLoad);
        
        return true;
    }
    
    public boolean remove(Set<T> payLoads)
    {
        ExceptionUtils.isNullException(payLoads, "payLoads");
        
        boolean changed = false;
        
        for(T payLoad: payLoads)
        {
            changed |= remove(payLoad);
        }
        
        return changed;
    }
    
    public void removeConnected(T payLoad,
                                MatchCriteria<T> removeCriteria)
    {
        Set<T> payLoads = matchConnected(payLoad,
                                         removeCriteria);
        
        remove(payLoads);
    }
    
    public boolean replace(T original,
                           Collection<T> replacements)
    {
        ExceptionUtils.isNullException(original, "original");
        ExceptionUtils.isNullException(replacements, "replacements");
        
        Node<T, K> originalNode = payLoadToNode.get(original);
        
        if(originalNode == null)
        {
            return false;
        }
        
        Set<T> originalNodeNeighbors = originalNode.getNeighborPayloads();
        
        remove(originalNode.getPayLoad());
        
        connect(replacements);
        connect(replacements, originalNodeNeighbors);
        
        return true;
    }
    
    public Set<T> getConnected(T payLoad)
    {
        ExceptionUtils.isNullException(payLoad, "payLoad");
        
        containsException(payLoad);
        
        Set<T> connected = Sets.newHashSet();
        
        getConnectedHelper(payLoad,
                           connected);
        
        return connected;
    }
    
    private void getConnectedHelper(T payLoad,
                                    Set<T> connected)
    {
        if(connected.contains(payLoad))
        {
            return;
        }
        
        connected.add(payLoad);
        
        Set<T> neighborPayLoads = payLoadToNode.get(payLoad).getNeighborPayloads();
        
        for(T neighborPayLoad: neighborPayLoads)
        {
            getConnectedHelper(neighborPayLoad, connected);
        }
    }
    
    public boolean connect(T payLoad1,
                           T payLoad2)
    {
        ExceptionUtils.isNullException(payLoad1, "payLoad1");
        ExceptionUtils.isNullException(payLoad2, "payLoad2");
        
        containsException(payLoad1);
        containsException(payLoad2);
        
        Node<T, K> node1 = payLoadToNode.get(payLoad1);
        Node<T, K> node2 = payLoadToNode.get(payLoad2);
        
        node2.addNeighbor(node1);
        boolean success = node1.addNeighbor(node2);
        
        int colorCompare = node1.getColor().compareTo(node2.getColor());
        
        if(colorCompare < 0)
        {
            node1.setColor(node2.getColor());
        }
        else if(colorCompare > 0)
        {
            node2.setColor(node1.getColor());
        }
        
        return success;
    }
    
    public void colorConnected(T payLoad,
                               K colorMarker)
    {
        ExceptionUtils.isNullException(payLoad, "payLoad");
        
        containsException(payLoad);
        
        Node<T, K> node = payLoadToNode.get(payLoad);
        Color<K> color = colorSet.getColor(colorMarker);
        
        if(color.compareTo(node.getColor()) <= 0)
        {
            return;
        }
        
        node.setColor(color);
        
        Set<T> neighborPayLoads = node.getNeighborPayloads();
        
        for(T neighborPayLoad: neighborPayLoads)
        {
            colorConnected(neighborPayLoad,
                           colorMarker);
        }
    }
    
    public void connect(T payLoad,
                        Collection<T> newNeighborPayloads)
    {
        ExceptionUtils.isNullException(payLoad, "payLoad");
        ExceptionUtils.isNullException(newNeighborPayloads, "newNeighborPayloads");
        
        for(T newNeighborPayLoad: newNeighborPayloads)
        {
            connect(payLoad, newNeighborPayLoad);
        }
    }
    
    public void connect(Collection<T> payLoads)
    {
        ExceptionUtils.isNullException(payLoads);
        
        List<T> payLoadsList = Lists.newArrayList(payLoads);
        
        for(int listCounter = 0;
            listCounter < payLoadsList.size() - 1;
            listCounter++)
        {
            T payLoad1 = payLoadsList.get(listCounter);
            
            for(int listCounter0 = listCounter + 1;
                listCounter0 < payLoadsList.size();
                listCounter0++)
            {
                T payLoad2 = payLoadsList.get(listCounter0);
                
                connect(payLoad1,
                        payLoad2);
            }
        }
    }
    
    public void connect(Collection<T> payLoads1,
                        Collection<T> payLoads2)
    {
        ExceptionUtils.isNullException(payLoads1, "payLoads1");
        ExceptionUtils.isNullException(payLoads2, "payLoads2");
        
        for(T payLoad1: payLoads1)
        {
            for(T payLoad2: payLoads2)
            {
                connect(payLoad1,
                        payLoad2);
            }
        }
    }
    
    public boolean disconnect(T payLoad1,
                              T payLoad2)
    {
        ExceptionUtils.isNullException(payLoad1, "payLoad1");
        ExceptionUtils.isNullException(payLoad2, "payLoad2");
        
        Node<T, K> node1 = payLoadToNode.get(payLoad1);
        
        if(node1 == null)
        {
            return false;
        }
        
        Node<T, K> node2 = payLoadToNode.get(payLoad2);
        
        if(node2 == null)
        {
            return false;
        }
        
        node2.removeNeighbor(node1);
        return node1.removeNeighbor(node2);
    }
    
    public boolean isConnected(T payLoad1,
                               T payLoad2)
    {
        ExceptionUtils.isNullException(payLoad1, "payLoad1");
        ExceptionUtils.isNullException(payLoad2, "payLoad2");
        
        Node<T, K> node1 = payLoadToNode.get(payLoad1);
        
        if(node1 == null)
        {
            return false;
        }
        
        Node<T, K> node2 = payLoadToNode.get(payLoad1);
        
        if(node2 == null)
        {
            return false;
        }
        
        return node1.isNeighbor(node2);
    }
    
    public Set<T> getPayloads()
    {
        return payLoadToNode.keySet();
    }
    
*/
}
