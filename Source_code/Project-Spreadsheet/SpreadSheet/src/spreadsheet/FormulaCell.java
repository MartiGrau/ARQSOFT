/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author uni
 */
public class FormulaCell extends Cell
{
    // TODO implement listeners https://docs.oracle.com/javase/tutorial/uiswing/events/propertychangelistener.html
    
    public FormulaCell(String content, SpreadSheet spreadsheet)
    {
        super(content);
        this.spreadsheet = spreadsheet;
        setContent(content);        
    }
    @Override
    public String getContent()
    {
        return content;
    }

    private void setContent(String content)
    {
        this.inputString = content;
        String contentWithoutEqual = content.substring(1);
        // TODO calculate content with sums, other cells etc.
        // Separate string in operators, values and cells in the proper order.
        String[] splittedContent = contentWithoutEqual.split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");
        
        int i = 0;
        for (String singleContent : splittedContent) 
        {
            // If it's cell
            if (singleContent.matches("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$"))
            {
                // Get value from cells and TODO:add dependency
                int[] coordinates = inputToCoordinates(singleContent);
                try
                {           
                    splittedContent[i] = spreadsheet.getCellContent(coordinates[0], coordinates[1]);
                }
                catch(EmptyCellException e)
                {
                    for (String singleContent2 : splittedContent) 
                    {
                        // If it's cell
                        if (singleContent2.matches("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$"))
                        {
                            // TODO ADD ALL DEPENDENCIES
                        }
                    }
                    this.content = null;
                    return;
                }                           
            }            
            i++;
        }

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String equation = Arrays.toString(splittedContent).replace(",", "")  //remove the commas
                                                            .replace("[", "")  //remove the right bracket
                                                            .replace("]", "")  //remove the left bracket
                                                            .trim();           //remove trailing spaces from partially initialized arrays;
        try {
            this.value = ((Number)engine.eval(equation)).floatValue();
            this.content = Float.toString(value);
        } catch (ScriptException ex) {
            Logger.getLogger(FormulaCell.class.getName()).log(Level.SEVERE, null, ex);
        }       
 
       // this.value = Float.parseFloat(content);
    }
    
    public float getValue()
    {
        return value;
    }
    
    public String getInputString()
    {
        return inputString;
    }
    
    private static int[] inputToCoordinates(String input)
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
    
    private float value;  
    private String inputString;  
    private final SpreadSheet spreadsheet;
}
