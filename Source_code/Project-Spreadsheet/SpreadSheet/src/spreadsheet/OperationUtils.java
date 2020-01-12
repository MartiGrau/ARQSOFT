/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet;

import java.util.ArrayList;

/**
 *
 * @author uni
 */
public class OperationUtils
{
    public static int[] inputToCoordinates(String input)
    {
        String[] inputDivided = input.split("(?<=\\D)(?=\\d)");
        int numberOfLetters = inputDivided[0].length();
        char xChar = inputDivided[0].charAt(0);
        int x_index = Character.toLowerCase(xChar) - 'a';
        // Deal with the case there is more than 1 letter ex: AA1
        x_index = x_index + (Character.toLowerCase('z') - 'a')*(numberOfLetters-1);
        // Substract 1 because we want to deal with index
        int y_index = Integer.parseInt(inputDivided[1]) - 1;
        return new int[]{x_index,y_index};
    }
    
    public static String toAlphabetic(int i) {
    if( i<0 ) {
        return "-"+toAlphabetic(-i-1);
    }

    int quot = i/26;
    int rem = i%26;
    char letter = (char)((int)'A' + rem);
    if( quot == 0 ) {
        return ""+letter;
    } else {
        return toAlphabetic(quot-1) + letter;
    }
}
    
    public static String coordinatesToInput(int x, int y)
    {
        y++;
        return toAlphabetic(x)+y;
    }
    
    private static String[] returnCellsInRange(String input)
    {
        String[] tokens = input.split(":");
        int[] initialCoordinates = inputToCoordinates(tokens[0]);
        int[] finalCoordinates = inputToCoordinates(tokens[1]);
        ArrayList<String> cellsInRange = new ArrayList<String>();
       
        for (int i=initialCoordinates[0]; i < finalCoordinates[0]+1; i++)
        {
            for (int j=initialCoordinates[1]; j < finalCoordinates[1]+1; j++)
            {
                cellsInRange.add(coordinatesToInput(i, j));
            }
        }
        return cellsInRange.toArray(new String[0]);
    }
    public static String performSum(String inputString)
    {        
        inputString = inputString.substring(5).replaceAll("[()]", "");
        String[] cells = inputString.split(",");
        ArrayList<String> finalCells = new ArrayList<String>();

        for(String cell:cells)
        {
            if (cell.contains(":"))
            {
                String[] cellsInRange = returnCellsInRange(cell);
                for (String cellInRange:cellsInRange)
                {
                    finalCells.add(cellInRange);
                }
            }
            else{
                finalCells.add(cell);
            }
        }
        String result = "";
        for (String cellToSum:finalCells)
        {
            result = result + cellToSum + "+";
        }
        result = result + "0";
        return result;
    }
    
}
