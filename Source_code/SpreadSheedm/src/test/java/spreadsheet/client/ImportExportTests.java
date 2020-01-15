/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet.client;

import spreadsheet.SpreadSheet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author mgrau
 */
@RunWith(MockitoJUnitRunner.class)
public class ImportExportTests {
    
    private Client clientInstance;
    private String path;
    public ImportExportTests() {
    }
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting Test Import and Export an Spreadsheet");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Ending Test Import and Export an Spreadsheet");
    }
    
    @Before
    public void setUp() {
       initMocks(this);
       clientInstance = new Client();
       path = "/Users/mgrau/Desktop/Test.txt";
    }
    
    @After
    public void tearDown() {
    }   
    
    //Create an Spreadsheet and check if exports correctly
    @Test
    public void testExport() {
        System.out.println("Test Import");
        //First create spreadSheet
        clientInstance.createSpreadSheet(2, 2);
        //Edit cell
        clientInstance.editCell(0, 0, "5");
        // Export it
        clientInstance.exportSpreadSheet(path);
    }
    
    //Check if imports correctly
    @Test
    public void testImport() {
        System.out.println("Test Import");
        clientInstance.importSpreadSheet(path);
        String value = clientInstance.getCellContent(0, 0);
        String expectedValue = "5";
        Assert.assertEquals(expectedValue, value);
    }

}
