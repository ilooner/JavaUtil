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

/**
 *
 * @author Topeka Labs
 */
public class BTNode<T> extends AbstractBTNode<T, BTNode<T>>
{
    public BTNode(T payload)
    {
        super(payload);
    }
    
    public BTNode(T payload,
                  BTNode<T> left,
                  BTNode<T> right)
    {
        super(payload,
              left,
              right);
    }
}
