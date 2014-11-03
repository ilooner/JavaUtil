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
package com.topekalabs.io.cowfs;

import com.topekalabs.java.utils.ExceptionUtils;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *
 * @author Topeka Labs
 */
public class CowTempArray<T>
{
    private FileSystem fs;
    private Path directoryPath;
    private String arrayName;
    private long objectCacheSize;
    private long objectByteSize;
    
    protected CowTempArray(FileSystem fs,
                           Path directoryPath,
                           String arrayName,
                           long objectCacheSize,
                           long objectByteSize)
    {
        setFileSystem(fs);
        setDirectoryPath(directoryPath);
        setArrayName(arrayName);
        
    }
    
    private void setFileSystem(FileSystem fs)
    {
        ExceptionUtils.isNullException(fs);
        this.fs = fs;
    }
    
    private void setDirectoryPath(Path directoryPath)
    {
        ExceptionUtils.isNullException(directoryPath);
        this.directoryPath = directoryPath;
    }
    
    private void setArrayName(String arrayName)
    {
        ExceptionUtils.isNullException(arrayName);
        this.arrayName = arrayName;
    }
    
    private void setObjectCacheSize(long objectCacheSize)
    {
        
    }
}
