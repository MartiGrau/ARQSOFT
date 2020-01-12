/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import spreadsheet.EmptyCellException;
import spreadsheet.FileUtils;
import spreadsheet.SpreadSheet;

/**
 *
 * @author uni
 */
public class Client 
{
    private SpreadSheet spreadsheet;
    private boolean exit = false;
    
    public Client()
    {   
    }
    public boolean isExit()
    {
        return exit;
    } 
    public void setExit(boolean shouldExit)
    {
        exit = shouldExit;
    } 
    public void createSpreadSheet(int numRows, int numCols)
    {
        spreadsheet = new SpreadSheet(numRows, numCols);
    } 
    public void addRow(int numOfRows)
    {
        spreadsheet.addRows(numOfRows);
    }
    public void addCol(int numOfCols)
    {
        spreadsheet.addRows(numOfCols);
    }
    public void editCell(int row, int col, String input)
    {
        spreadsheet.editCell(row, col, input);
    } 
    public String getCellContent(int row, int col) 
    {
        try
        {
            return spreadsheet.getCellContent(row, col);    
        }
        catch(EmptyCellException e)
        {
            return "";
        }        
    }
    public boolean exportSpreadSheet(String path) 
    {
       return FileUtils.exportSpreadSheet(path, spreadsheet);
    }
    
    public boolean importSpreadSheet(String path) 
    {
        return FileUtils.importSpreadSheet(path, this);
    }
    
    public static void createSpreadSheetOption(Client client)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("To start, enter size of your spreadsheet #rows #columns: <int> <int>");      
        int x = scn.nextInt();
        int y = scn.nextInt(); 
        client.createSpreadSheet(x, y);
        System.out.println("Spreadsheet created!");
    }
    
    public static void addRowOption(Client client)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of rows to add: <int>");      
        int x = scn.nextInt();
        client.addRow(x);
        System.out.println("Row added!");  
    }
    
    
    public static void addColOption(Client client)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of columns to add: <int>");      
        int x = scn.nextInt();
        client.addCol(x);
        System.out.println("Col added!"); 
    }
    
    public static void editCellOption(Client client)
    {
        // TODO check it works
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter position of the cell to edit: <Letter><Number>");    
        String positionInput = scn.next();
        int coordinates[] = inputToCoordinates(positionInput);
        scn.nextLine(); // consume \n for next usage
        System.out.println("Enter the content of the cell");
        String input = scn.nextLine();        
        client.editCell(coordinates[0], coordinates[1], input);
        System.out.println("Cell edited!");         
    }
    
    public static void getCellValueOption(Client client)
    {
        // TODO check this works
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter position of the cell you want to view: <Letter><Number>");      
        String positionInput = scn.next();
        int coordinates[] = inputToCoordinates(positionInput);
        scn.nextLine(); // consume \n for next usage
        String cellContent = client.getCellContent(coordinates[0], coordinates[1]);
        System.out.println("The value of the cell is: ");
        System.out.println(cellContent);          
    }
    
    public static void exportSpreadSheetOption(Client client)
    { 
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the path with filename. Ex: /Users/Documents/myfile.txt");      
        String path = scn.next();
        boolean res = client.exportSpreadSheet(path);
        if (res)
        {
            System.out.println("File saved as: ");
            System.out.println(path);         
        }
        else
        {
            System.out.println("Error while saving file");
        }
    }
    
    public static void importSpreadSheetOption(Client client)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the path Ex: /Users/Documents/myfile.txt");      
        String path = scn.next();
        boolean res = client.importSpreadSheet(path);
        if (res)
        {
            System.out.println("File imported");
            System.out.println(path);         
        }
        else
        {
            System.out.println("Malformed file");
        }
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
    
    
    public static void main(String[] args) 
    {
        Client client = new Client();
        Scanner scn = new Scanner(System.in);
        while (!client.isExit())
        {
            System.out.println("Choose an option of below by entering the option number: ");
            System.out.println("1 Create an spreadsheet (will overwrite any unsaved changes)");
            System.out.println("2 Add columns to spreadsheet");
            System.out.println("3 Add rows to spreadsheet");
            System.out.println("4 Edit cell of spreadsheet");
            System.out.println("5 Get content of cell in spreadsheet");
            System.out.println("6 Load (import) an spreadsheet (will overwrite any unsaved changes)");
            System.out.println("7 Save (export) current spreadsheet");
            int option = scn.nextInt();
            switch(option)
            {
                case 1:
                    createSpreadSheetOption(client);
                    break;
                case 2:
                    addColOption(client);
                    break;
                case 3:
                    addRowOption(client);
                    break;
                case 4:
                    editCellOption(client);
                    break;
                case 5:
                    getCellValueOption(client);
                    break;
                case 6:
                    importSpreadSheetOption(client);
                    break;
                case 7:
                    exportSpreadSheetOption(client);
                    break;
                default:
                    System.out.println("Unrecognized option!");                   
                    
            }            
        }   
    }    
}
