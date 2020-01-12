/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import spreadsheet.client.Client;

/**
 *
 * @author uni
 */
public class FileUtils 
{
    public static boolean importSpreadSheet(String path, Client client)
    {
        try
        {            
            FileReader input = new FileReader(path);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = null;
            
            // read nextLine
            boolean firstLine = true;
            int row = 0;
            while ( (myLine = bufRead.readLine()) != null)
            {
                if (firstLine)
                {
                    int count =  myLine.length() - myLine.replace(";", "").length() + 1; // +1 for cell after last token
                    client.createSpreadSheet(1, count);
                    firstLine = false;  
                }
                else 
                {
                    client.addRow(1);
                }
                String[] tokens = myLine.split(";", -1);
                
                int column = 0;
                for (String token : tokens)
                {
                    if (!"".equals(token))
                    {
                        client.editCell(row, column, token);
                    }
                    column++;
                }
                row++;  
            }
            bufRead.close();
            return true;
        } 
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
     public static boolean exportSpreadSheet(String path, SpreadSheet spreadsheet)
     {
          try
        {
            List<String> lines = new ArrayList<>();
            for (int i = 0; i < spreadsheet.getMaxRow(); i++)
            {
                String newline = "";
                for (int j = 0; j < spreadsheet.getMaxCol(); j++)
                {
                    try 
                    {
                       newline += spreadsheet.getCellString(i, j);
                    } 
                    catch (EmptyCellException ex) 
                    {
                        // Do nothing if empty
                    }
                    // don't add ; after last cell in row
                    if (j+1 != spreadsheet.getMaxCol())
                    {
                        newline += ";";
                    }
                }
                lines.add(newline);
            }
            Path file = Paths.get(path);
            Files.write(file, lines, StandardCharsets.UTF_8);
            return true;
        }
        catch(IOException e)
        {
            return false;
        }  
     }
}
