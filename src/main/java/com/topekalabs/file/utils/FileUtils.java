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
package com.topekalabs.file.utils;

import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author Topeka Labs
 */
public class FileUtils
{
    private FileUtils()
    {
    }
    
    public static File rebase(File oldParent, File newParent, File child)
    {
        Path relativeChildPath = oldParent.toPath().relativize(child.toPath());
        return newParent.toPath().resolve(relativeChildPath).toFile();
    }
}
