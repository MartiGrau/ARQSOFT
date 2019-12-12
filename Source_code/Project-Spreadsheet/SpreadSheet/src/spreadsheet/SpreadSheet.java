/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet;

/**
 *
 * @author uni
 */
public class SpreadSheet 
{
    private Cell cells[][]; 
    private int maxRow;
    private int maxCol;

    public SpreadSheet(int numOfRows, int numOfColumns)
    {
        this.cells = new Cell[numOfRows][numOfColumns];
        maxRow =  numOfRows;
        maxCol = numOfColumns;
    } 
    public void addRows(int numOfRowsToAdd)
    {
        Cell temp[][] = new Cell[maxRow+numOfRowsToAdd][maxCol];   
        for (int i = 0; i<maxRow; i++)
        {
            for (int j = 0; j<maxCol; j++)
            {
                temp[i][j] = cells[i][j];
            }
        } 
        cells = temp;
    }
    public void addColumns(int numOfColumnsToAdd)
    {
        Cell temp[][] = new Cell[maxRow][maxCol+numOfColumnsToAdd];   
        for (int i = 0; i<maxRow; i++)
        {
            for (int j = 0; j<maxCol; j++)
            {
                temp[i][j] = cells[i][j];
            }
        } 
        cells = temp;
    }        
    
}
