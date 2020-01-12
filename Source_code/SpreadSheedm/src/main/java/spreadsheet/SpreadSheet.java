/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet;

import static spreadsheet.CellFactory.*;

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
        maxRow = maxRow+numOfRowsToAdd;
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
        maxCol = maxCol+numOfColumnsToAdd;
    }
    public void editCell(int row, int col, String input)
    {
        cells[row][col] = createCell(input, this);
    } 
    
    public String getCellContent(int row, int col) throws EmptyCellException
    {
        if (cells[row][col].getContent() == null)
        {            
            throw new EmptyCellException();
        }
        return cells[row][col].getContent();
    } 
    
    public String getCellString(int row, int col) throws EmptyCellException
    {
        if (cells[row][col] == null)
        {            
            throw new EmptyCellException();
        }
        if (cells[row][col] instanceof StringCell)
        {
            return cells[row][col].getContent();
        }
        if (cells[row][col] instanceof ValueCell)
        {
            return cells[row][col].getContent(); 
        }
        if (cells[row][col] instanceof FormulaCell)
        {
            FormulaCell fCell = (FormulaCell)cells[row][col];
            return fCell.getInputString();            
        } 
        throw new EmptyCellException();
    } 
    public int getMaxRow()
    {
        return maxRow;
    }
    public int getMaxCol()
    {
        return maxCol;
    }
            
    
}
