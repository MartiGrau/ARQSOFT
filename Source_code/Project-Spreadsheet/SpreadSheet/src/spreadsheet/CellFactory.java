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
public class CellFactory 
{
    public static Cell createCell(String input, SpreadSheet spreadSheet) 
    {
        String firstFormulaChar;
        firstFormulaChar = "=";
        if(isNumeric(input))
        {
            return new ValueCell(input);    
        }
        else if (input.charAt(0) == firstFormulaChar.charAt(0))
        {
            return new FormulaCell(input, spreadSheet);
        }
        else
        {
            return new StringCell(input);
        }        
    }
    
    private static boolean isNumeric(String strNum) 
    {        
        try 
        {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) 
        {
            return false;
        }    
        return true;
    }     
}
