/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet.client;

import java.util.Scanner;
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
        return spreadsheet.getCellContent(row, col);
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
        System.out.println("Enter position of the cell to edit: <int> <int>");      
        int x = scn.nextInt();
        int y = scn.nextInt();
        scn.nextLine(); // consume \n for next usage
        System.out.println("Enter the content of the cell");
        String input = scn.nextLine();
        client.editCell(x, y, input);
        System.out.println("Cell edited!");         
    }
    
    public static void getCellValueOption(Client client)
    {
        // TODO check this works
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter position of the cell you want to view: <int> <int>");      
        int x = scn.nextInt();
        int y = scn.nextInt();
        String cellContent = client.getCellContent(x, y);
        System.out.println("The value of the cell is: ");
        System.out.println(cellContent);          
    }
    
    public static void exportSpreadSheet(Client client)
    {
        // TODO  
    }
    
    public static void importSpreadSheet(Client client)
    {
        // TODO
    } 
    
    
    public static void main(String[] args) 
    {
        // TODO change rows to a letter. 
        // TODO change position to index when accessing and consulting cells! (position A1 is index 00)
        Client client = new Client();
        Scanner scn = new Scanner(System.in);
        while (!client.isExit())
        {
            System.out.println("Choose an option of below by entering the option number: ");
            System.out.println("1 Create an spreadsheet");
            System.out.println("2 Add columns to spreadsheet");
            System.out.println("3 Add rows to spreadsheet");
            System.out.println("4 Edit or add cell to spreadsheet");
            System.out.println("5 Get content of cell in spreadsheet");
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
                default:
                    System.out.println("Unrecognized option!");                   
                    
            }            
        }   
    }    
}
