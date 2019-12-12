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
    
    public static void createSpreadSheetOption(Client client)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("To start, enter size of your spreadsheet #rows #columns: <int> <int>");      
        int x = scn.nextInt();
        int y = scn.nextInt(); 
        client.createSpreadSheet(x, y);
        System.out.println("Spreadsheet created!");
    }
    
    public static void main(String[] args) 
    {
        Client client = new Client();
        Scanner scn = new Scanner(System.in);
        while (!client.isExit())
        {
            System.out.println("Choose an option of below by entering the option number: ");
            System.out.println("1 Create an spreadsheet");
            int option = scn.nextInt();
            switch(option)
            {
                case 1:
                    createSpreadSheetOption(client);
                    break;
                default:
                    System.out.println("Unrecognized option!");                   
                    
            }            
        }   
    }    
}
