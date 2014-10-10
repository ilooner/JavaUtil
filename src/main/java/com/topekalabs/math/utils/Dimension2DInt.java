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

/**
 * This class represents the dimensions of a 2D array.
 * @author Topeka Labs
 */
public class Dimension2DInt
{
    /**
     * The number of columns as an int.
     */
    private int columnCount;
    /**
     * The number of columns as a float.
     */
    private float columnCountFloat;
    /**
     * The number of columns minus one.
     */
    private int columnCountM1;
    /**
     * The number of columns minus one as a float.
     */
    private float columnCountM1Float;
    /**
     * The number of columns plus one.
     */
    private int columnCountP1;
    /**
     * The number of columns plus one as float.
     */
    private float columnCountP1Float;
    /**
     * The number of rows.
     */
    private int rowCount;
    /**
     * The number of rows as a float.
     */
    private float rowCountFloat;
    /**
     * The number of rows minus one.
     */
    private int rowCountM1;
    /**
     * The number of rows minus one as a float.
     */
    private float rowCountM1Float;
    /**
     * The number of rows plus one.
     */
    private int rowCountP1;
    /**
     * The number of rows plus one as a float.
     */
    private float rowCountP1Float;
    /**
     * The total number of elements rowCount * columnCount.
     */
    private int totalSize;
    /**
     * The total number of elements as a float.
     */
    private float totalSizeFloat;
    /**
     * The total size minus 1.
     */
    private int totalSizeM1;
    /**
     * The total size minus 1 as a float.
     */
    private float totalSizeM1Float;
    /**
     * The total size plus 1.
     */    
    private int totalSizeP1;
    /**
     * The total size plus 1 as a float.
     */    
    private float totalSizeP1Float;
    
    /**
     * This creates a dimension object with the given column and row counts.
     * @param columnCount The column count of the dimension object.
     * @param rowCount The row count of the dimension object.
     */
    public Dimension2DInt(int columnCount,
                          int rowCount)
    {
        setColumnCount(columnCount);
        setRowCount(rowCount);
        
        initialize();
    }
    
    /**
     * This initializes the dimension object.
     */
    private void initialize()
    {
        totalSize = columnCount * rowCount;
        totalSizeFloat = (float) totalSize;
        totalSizeM1 = columnCountM1 * rowCountM1;
        totalSizeM1Float = (float) totalSizeM1;
        totalSizeP1 = columnCountP1 * rowCountP1;
        totalSizeP1Float = (float) totalSizeP1;
    }
    
    /**
     * This sets the column count for the dimension object.
     * @param columnCount The column count for the dimension object.
     */
    private void setColumnCount(int columnCount)
    {
        IntUtils.isPositiveException(columnCount, "columnCount");
        
        this.columnCount = columnCount;
        this.columnCountFloat = (float) columnCount;
        this.columnCountM1 = columnCount - 1;
        this.columnCountM1Float = (float) columnCountM1;
        this.columnCountP1 = columnCount + 1;
        this.columnCountP1Float = (float) columnCountP1Float;
    }
    
    /**
     * This gets the column count for the dimension object.
     * @return The column count for the dimension object.
     */
    public int getColumnCount()
    {
        return columnCount;
    }
    
    /**
     * This gets the column count for the dimension object as a float.
     * @return The column count for the dimension object as a float.
     */
    public float getColumnCountFloat()
    {
        return columnCountFloat;
    }
    
    /**
     * This gets the column count for the dimension object minus 1.
     * @return The column count for the dimension object minus 1.
     */
    public int getColumnCountM1()
    {
        return columnCountM1;
    }
    
    /**
     * This gets the column count for the dimension object minus 1 as a float.
     * @return The column count for the dimension object minus 1 as a float.
     */
    public float getColumnCountM1Float()
    {
        return columnCountM1Float;
    }
    
    /**
     * This gets the column count for the dimension object plus 1.
     * @return The column count for the dimension object plus 1.
     */
    public int getColumnCountP1()
    {
        return columnCountP1;
    }
    
    /**
     * This gets the column count for the dimension object plus 1 as a float.
     * @return The column count for the dimension object plus 1 as a float.
     */
    public float getColumnCountP1Float()
    {
        return columnCountP1Float;
    }
    
    /**
     * This sets the row count for the dimension object.
     * @param rowCount The row count for the dimension object.
     */
    private void setRowCount(int rowCount)
    {
        IntUtils.isPositiveException(rowCount, "rowCount");
        
        this.rowCount = rowCount;
        this.rowCountFloat = (float) rowCount;
        this.rowCountM1 = rowCount - 1;
        this.rowCountM1Float = (float) rowCountM1;
        this.rowCountP1 = rowCount + 1;
        this.rowCountP1Float = (float) rowCountP1;
    }
    
    /**
     * This gets the row count for the dimension object.
     * @return The row count for the dimension object.
     */
    public int getRowCount()
    {
        return rowCount;
    }
    
    /**
     * This gets the row count for the dimension object as a float.
     * @return The row count for the dimension object as a float.
     */
    public float getRowCountFloat()
    {
        return rowCountFloat;
    }
    
    /**
     * This gets the row count for the dimension object minus 1.
     * @return The row count for the dimension object minus 1.
     */
    public int getRowCountM1()
    {
        return rowCountM1;
    }
    
    /**
     * This gets the row count for the dimension object minus 1 as a float.
     * @return The row count for the dimension object minus 1 as a float.
     */
    public float getRowCountM1Float()
    {
        return rowCountM1Float;
    }
    
    /**
     * This gets the row count of the dimension object plus 1 as a float.
     * @return The row count of the dimension object plus 1 as a float.
     */
    public int getRowCountP1()
    {
        return rowCountP1;
    }
    
    /**
     * This gets the row count of the dimension object plus 1 as a float.
     * @return The row count of the dimension object plus 1 as a float.
     */
    public float getRowCountP1Float()
    {
        return rowCountP1Float;
    }
    
    /**
     * This gets the total size of the dimension object.
     * @return The total size of the dimension object.
     */
    public int getTotalSize()
    {
        return totalSize;
    }
    
    /**
     * This gets the total size of the dimension object as a float.
     * @return The total size of the dimension object as a float.
     */
    public float getTotalSizeFloat()
    {
        return totalSizeFloat;
    }
    
    /**
     * The total size of the dimension object minus 1.
     * @return The total size of the dimension object minus 1.
     */
    public int getTotalSizeM1()
    {
        return totalSizeM1;
    }
    
    /**
     * This gets the total size of the dimension object minus 1 as a float.
     * @return The total size of the dimension object minus 1 as a float.
     */
    public float getTotalSizeM1Float()
    {
        return totalSizeM1Float;
    }
    
    /**
     * The total size of the dimension object plus 1.
     * @return The total size of the dimension object plus 1.
     */
    public int getTotalSizeP1()
    {
        return totalSizeP1;
    }
    
    /**
     * This gets the total size of the dimension object plus 1 as a float.
     * @return The total size of the dimension object plus 1 as a float.
     */
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
        
        return getColumnCount() == dimension.getColumnCount() &&
               getRowCount() == dimension.getRowCount();
    }
}
